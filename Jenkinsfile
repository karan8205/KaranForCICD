pipeline {
    agent { label 'DAMS' }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timestamps()
        timeout(time: 20, unit: 'HOURS')
    }

    parameters {
        choice(name: 'env', choices: ['STG', 'DEV', 'QA'], description: 'Select the Environment')

        string(name: 'packageName', defaultValue: '', description: 'Optional: Run all tests in a package (e.g., DAMS.Supplier)')

        string(name: 'className', defaultValue: '', description: 'Optional: Enter Test Class Name (e.g., TC014_Supplier_OverAll_Run)')

        string(name: 'methodName', defaultValue: '', description: 'Optional: Enter Method Name (e.g., Overall_Global_ATG_Regression_E2E_Supplier)')
    }

    environment {
        PROJECT_NAME = 'KaranForCICD'
        PROJECT_URL = 'https://github.com/karan8205/KaranForCICD.git'
        EMAIL_TO = 'karan.mkdm2002@gmail.com'
    }

    stages {

        stage('Initialize') {
            steps {
                bat 'echo ================================'
                bat 'echo Project Name: %PROJECT_NAME%'
                bat 'echo Project URL: %PROJECT_URL%'
                bat 'java -version'

                script {
                    echo "Environment: ${params.env}"
                    echo "Package Name: ${params.packageName}"
                    echo "Class Name: ${params.className}"
                    echo "Method Name: ${params.methodName}"
                }
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

                    def baseCmd = "mvn test -Denv=${params.env}"

                    // ===============================
                    // 1️⃣ PACKAGE EXECUTION (Highest Priority)
                    // ===============================
                    if (params.packageName?.trim()) {

                        echo "Running ALL tests inside package: ${params.packageName}"

                        def packagePath = params.packageName.replace('.', '/')

                        bat """
                        mvn test -Denv=${params.env} ^
                        -Dsurefire.includes=**/${packagePath}/**/*.java
                        """
                    }

                    // ===============================
                    // 2️⃣ CLASS + METHOD EXECUTION
                    // ===============================
                    else if (params.className?.trim() && params.methodName?.trim()) {

                        echo "Running specific method"

                        bat "${baseCmd} -Dtest=${params.className}#${params.methodName}"
                    }

                    // ===============================
                    // 3️⃣ CLASS ONLY
                    // ===============================
                    else if (params.className?.trim()) {

                        echo "Running entire class"

                        bat "${baseCmd} -Dtest=${params.className}"
                    }

                    // ===============================
                    // 4️⃣ DEFAULT SUITE EXECUTION
                    // ===============================
                    else {

                        echo "Running full regression suite"

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
                body: """
                Job: ${env.JOB_NAME}
                Build Number: ${env.BUILD_NUMBER}
                Result: ${currentBuild.currentResult}

                Build URL:
                ${env.BUILD_URL}
                """,
                to: "${EMAIL_TO}"
            )
        }
    }
}
