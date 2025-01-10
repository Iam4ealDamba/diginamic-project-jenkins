pipeline {
  agent any
  stages {
    stage ('Initialize') {
      steps {
        git 'https://github.com/Iam4ealDamba/diginamic-project-jenkins.git'
      }
    }
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
        sh 'mvn install'
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
