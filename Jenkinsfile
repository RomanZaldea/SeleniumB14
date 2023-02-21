pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
               // echo 'Hello World'
                git credentialsId: 'roman-github-cred', url: 'https://github.com/RomanZaldea/SeleniumB14.git'
            }
        }
    }
}
