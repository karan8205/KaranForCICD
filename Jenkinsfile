
pipeline {

    agent { label 'DAMS' }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timestamps()
        timeout(time: 20, unit: 'HOURS')
    }

    parameters {
        choice(name: 'env', choices: ['STG', 'DEV', 'QA'], description: 'Select the Environment')
        string(name: 'className', defaultValue: '', description: 'Enter Fully Qualified Class Name (e.g., com.automation.tests.LoginTest)')
        string(name: 'methodName', defaultValue: '', description: 'Enter Method Name (Optional)')
    }

    environment {
        PROJECT_NAME = 'KaranForCICD'
        PROJECT_URL = 'https://github.com/karan8205/KaranForCICD.git'
        EMAIL_TO = 'karan.mkdm2002@gmail.com'
    }

    stages {

        stage('Checkout') {
            steps {
                git url: "${PROJECT_URL}", branch: 'main'
            }
        }

        stage('Initialize') {
            steps {
                bat 'echo Project Name: %PROJECT_NAME%'
                bat 'echo Project URL: %PROJECT_URL%'
                bat 'echo Environment: %env%'
                bat 'echo Class Name: %className%'
                bat 'echo Method Name: %methodName%'
                bat 'java -version'
            }
        }

        stage('Prepare Report Folder') {
            steps {
                bat 'if not exist reports mkdir reports'
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

                    def cmd = "mvn clean test -Denv=${params.env}"

                    // If class provided
                    if (params.className?.trim()) {

                        if (params.methodName?.trim()) {
                            cmd = "${cmd} -Dtest=${params.className}#${params.methodName}"
                        } else {
                            cmd = "${cmd} -Dtest=${params.className}"
                        }

                    }

                    bat "${cmd}"
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

            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports',
                reportFiles: 'ExtentReport.html',
                reportName: 'DAMS Automation Report'
            ])

            emailext(
                subject: "${currentBuild.currentResult} - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build URL: ${env.BUILD_URL}",
                to: "${EMAIL_TO}"
            )
        }
    }
}

