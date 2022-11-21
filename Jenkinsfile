pipeline {
    agent any
	environment {
    		DOCKERHUB_CREDENTIALS=credentials('dockerhub')
    		}
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling... ';
                    git branch: 'marouen',
                        url : 'https://github.com/oumaimabenjammour/DevOps.git';
            }
        }

        stage('Cleaning the project') {
             
             steps {
                echo 'cleaning project ...'
                sh 'mvn -version'
                sh 'mvn clean'
            }
        }
        
        stage('Compiling the artifact') {
             
            steps {
                echo "compiling"
                sh 'mvn compile'
               
            }
        } 
        stage('Nexus') {
            steps {
                sh 'mvn deploy'
            }
        } 
        stage('Code Quality Check via SonarQube') {
            steps {
                script {
                        sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
						}
               
            }
        }
           
     stage ('Mockito/Junit') {
             steps {
            sh 'mvn test -Dtest="ReglementServiceImpTest" '
            }
        }
        
        stage('Docker build')
        {
            steps {
                 sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/achat:latest .'
            }
        }
         stage ('Docker login'){
        	steps {
        	sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
        	}
        }
        stage ('Docker push'){
        	steps {
        	sh 'docker push $DOCKERHUB_CREDENTIALS_USR/achat:latest'
        	}
        }
         stage('Docker compose ') {
              steps {
                  sh 'docker-compose up -d'
              }
        }
       
    }
    post {
      	always {
      		sh 'docker logout'
      	}
      }
      
}