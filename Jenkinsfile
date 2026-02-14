pipeline {
    agent {
        label 'DAMS' 
    }
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
         PROJECT_NAME = 'dams-integration-test'
         PROJECT_URL = 'https://github.com/karan8205/KaranForCICD.git'
         DISABLE = 'true'
         SYNOPSYS_DETECT_LOCATION= 'C:/tools'
         EMAIL_TO = 'karan.mkdm2002@gmail.com'
    }
    /* for Shared T3 Jenkins
    tools {
       jdk 'JDK 17.0.2'
    }*/
    stages {
        stage('Initialize'){
           steps{
                 bat 'echo Project Name=$PROJECT_NAME'
                 bat 'echo Project URL =$PROJECT_URL'
                 bat 'java -version'
                 bat 'echo Environment: ${params.env}'
                 bat 'echo Class Name: ${params.className}'
                 bat 'echo Method Name: ${params.methodName}'
           }
        }
	    stage('Build'){
            steps{
               configFileProvider([configFile(fileId: 'c57ce599-7a28-4b77-95f5-3caca08d0037', variable: 'MAVEN_SETTINGS')]) {
                    bat 'mvn -U  clean install -Dmaven.test.skip=true -Dmaven.javadoc.skip=true'
               }
            }
        }
        stage('Integration Test'){
             steps{
                configFileProvider([configFile(fileId: 'c57ce599-7a28-4b77-95f5-3caca08d0037', variable: 'MAVEN_SETTINGS')]) {
                  script {
                      def testCmd = "-Denv=${params.env}"
                      if (params.className && params.className.trim() != '') {
                          if (params.methodName && params.methodName.trim() != '') {
                              testCmd = "${testCmd} -Dtest=${params.className}#${params.methodName}"
                          } else {
                              testCmd = "${testCmd} -Dtest=${params.className}"
                          }
                      } else {
                          // Default behavior if no class specified - run default suite or error out?
                          // Falling back to existing profile or default suite if className is empty
                          // Assuming user usually provides className as requested. 
                          // If empty, we can run a default suite or just parameterize regression.
                          // Preserving old behavior if empty? The old one ran -PRegression.
                          // Let's assume if empty, run -PRegression or similar.
                          // But user asked to "pass parameter", implying they will use it.
                          // I will add a check.
                          testCmd = "${testCmd} -PRegression"
                      }
                      
                      // Using the logic: mvn test -Denv=... -Dtest=...
                      // Note: -PRegression is kept as fallback or if user wants full suite.
                      // If user provides className, we typically don't need -PRegression unless it sets config.
                       
                      if (params.className && params.className.trim() != '') {
                          bat "mvn test ${testCmd}"
                      } else {
                          bat "mvn test -Dsurefire.suiteXmlFiles=testSuites/RegressionSuite_TestNG.xml -Denv=${params.env}"
                      }
                  }
                }
             }
             post{
                  always { 
                     testNG(reportFilenamePattern: 'target/surefire-reports/*.xml')
                  }
             }
        }
	}
    post{
    	always{
    	   script{
    	     if ("${env.BRANCH_NAME}" == 'master' || "${env.BRANCH_NAME}" == 'development' || "${env.BRANCH_NAME}" == 'main') {
    	         emailext body: 'Check console output at $BUILD_URL \n\n to view the results. \n\n ${CHANGES} \n\n ', 
                                   to: "${EMAIL_TO}",
                                   subject: """${currentBuild.currentResult} DAMS IntegrationTest in T3 Jenkins: ${env.JOB_NAME} - #$BUILD_NUMBER"""
    	     }
    	   }
    	}
    }
}