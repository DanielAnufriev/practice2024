pipeline {
    agent any
    
    stages {
        stage("Compilation") {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage("Tests run") {
            when {
                branch 'feature/*'
            }
            steps {
                bat 'mvn test'
            }
        }
        stage("Chechstyle analys") {
            when {
                branch 'develop'
            }
            steps {
                bat 'mvn checkstyle:check'
            }
        }
        stage("Test report") {
            when {
                branch 'feature/*'
            }
            steps {
                junit testResults: '**/surefire-reports/*.xml'
                jacoco()
            }
        }
        stage("Install jar") {
            steps {
                bat 'mvn install'
            }
        }
        stage("Copy jar") {
            steps {
                bat 'copy "MainModule\\target\\practice2024-1.0-SNAPSHOT-jar-with-dependencies.jar" "C:\\artefactTest\\practice2024-1.0.jar"'
            }
        }
    }
}
