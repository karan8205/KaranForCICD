pipeline {
    agent { label 'DAMS' }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timestamps()
        timeout(time: 20, unit: 'HOURS')
    }

    parameters {
        choice(name: 'env', choices: ['STG', 'DEV', 'QA'], description: 'Select the Environment')
        string(name: 'className', defaultValue: '', description: 'Enter Test Class Name (e.g., TC01_Login)')
        string(name: 'methodName', defaultValue: '', description: 'Enter Method Name (Optional)')
    }

    environment {
        PROJECT_NAME = 'KaranForCICD'
        PROJECT_URL = 'https://github.com/karan8205/KaranForCICD.git'
        EMAIL_TO = 'karan.mkdm2002@gmail.com'
    }

    stages {

        stage('Initialize') {
            steps {
                bat 'echo Project Name: %PROJECT_NAME%'
                bat 'echo Project URL: %PROJECT_URL%'
                bat 'java -version'
                bat 'echo Environment: %env%'
                bat 'echo Class Name: %className%'
                bat 'echo Method Name: %methodName%'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -version'
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                script {

                    def testCmd = "-Denv=${params.env}"

                    if (params.className?.trim()) {
                        if (params.methodName?.trim()) {
                            testCmd = "${testCmd} -Dtest=${params.className}#${params.methodName}"
                        } else {
                            testCmd = "${testCmd} -Dtest=${params.className}"
                        }

                        bat "mvn test ${testCmd}"

                    } else {
                        bat "mvn test -Dsurefire.suiteXmlFiles=testSuites/RegressionSuite_TestNG.xml -Denv=${params.env}"
                    }
                }
            }

            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        always {
            emailext(
                subject: "${currentBuild.currentResult} - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build URL: ${env.BUILD_URL}",
                to: "${EMAIL_TO}"
            )
        }
    }
}
