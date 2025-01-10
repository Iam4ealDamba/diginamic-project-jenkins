pipeline {
  agent any
  tools {
    maven 'Maven 3.9.9'
  }
  stages {
    stage('Build') {
      steps {
        echo 'Building..'
        sh 'mvn clean compile'
      }
    }
    stage('Test') {
      steps {
        echo 'Testing..'
        sh 'mvn test'
      }
    }
    stage('Create Package') {
      steps {
        echo 'Create Package..'
        sh 'mvn package'
      }
    }
    stage('SonarQube Analysis') {
      steps {
        script {
          def mvnHome = tool 'Maven 3.9.9' // Assuming Maven is configured in Jenkins
          withSonarQubeEnv('Sonarqube') { // Use the 'SonarDocker' SonarQube server name from Jenkins
            sh "${mvnHome}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Digi-Sonar-Project -Dsonar.projectName='Digi-Sonar-Project'"
            // -Dsonar.projectKey=Digi-Sonar-Project -Dsonar.projectName='Digi-Sonar-Project' must be the same as created from Sonarqube UI
          }
        }
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploying..'
        // Add your deploy steps here
      }
    }
  }
}
