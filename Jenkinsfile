pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }

    stages {
        stage('lkstage') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/ershad101/seleniumpractice-sept2023.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                always {
                    emailext body: 'result on the multiple builds ', recipientProviders: [buildUser()], subject: 'Check the pipeline status ', to: 'dwadodakar@gmail.com'
                }
            }
        }
    }
}
