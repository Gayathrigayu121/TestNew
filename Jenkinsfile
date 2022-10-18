pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
                echo "Building the Project"
		bat "mvn clean"
            }
        }
        stage('Test'){
            steps{
                echo "Testing the Project"
            }
        }
        stage('relase'){
            steps{
                echo "Release the project"
            }
        }
    }
}