pipeline {
    agent {
        label 'DAMS'
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timestamps()
        timeout(time: 800, unit: 'MINUTES')
    }
    environment {
         PROJECT_NAME = 'dams-integration-test'
         PROJECT_URL = 'https://git.t3.daimlertruck.com/DAM/ui-automation-testing.git'
         DISABLE = 'true'
         SYNOPSYS_DETECT_LOCATION= 'C:/tools'
         EMAIL_TO = 'munisekhar.valasa_reddy@daimlertruck.com;nilesh.mittal@daimlertruck.com;vikash.mohan@daimlertruck.com;akash.bhattacharjee@daimlertruck.com;pargavi.m@daimlertruck.com;imran_khan.pathan@daimlertruck.com'
    }
    /* for Shared T3 Jenkins
    tools {
       jdk 'JDK 17.0.2'
    }*/
    stages {
        stage('Initialize'){
           steps{
                 sh 'echo Project Name=$PROJECT_NAME'
                 sh 'echo Project URL =$PROJECT_URL'
                 sh 'java -version'
           }
        }
	    stage('Build'){
            steps{
               configFileProvider([configFile(fileId: 'c57ce599-7a28-4b77-95f5-3caca08d0037', variable: 'MAVEN_SETTINGS')]) {
                    sh 'mvn -U  clean install -Dmaven.test.skip=true -Dmaven.javadoc.skip=true'
               }
            }
        }
        stage('Integration Test'){
             when {
                 anyOf {
                   branch 'main';
                   branch 'development';
                   branch 'master'
                 }
             }
             steps{
                configFileProvider([configFile(fileId: 'c57ce599-7a28-4b77-95f5-3caca08d0037', variable: 'MAVEN_SETTINGS')]) {
                  sh 'mvn  test -PRegression'
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