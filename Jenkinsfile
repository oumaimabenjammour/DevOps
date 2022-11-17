pipeline {
    agent any
    
    environment {
    		DOCKERHUB_CREDENTIALS=credentials('dockerhub')
    		}
   
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling... ';
                    git branch: 'syrine',
                        url : 'https://github.com/oumaimabenjammour/DevOps.git';
                       
                        
            }
        }

        stage('Cleaning the project') {     
            steps {
                echo 'cleaning project ...'
                sh 'mvn clean'
            }
        }
       
     
       
       stage('Compiling the artifact') {             
            steps {
                echo "compiling"
                sh 'mvn compile'
            }
        }
   
         stage('Code Quality Check via SonarQube') {
            steps {
                script {
                       sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                }
               
            }
        } 
        /*
        stage('Nexus') {      
            steps {
                sh 'mvn deploy'
            }
        }            
      
       */
                
        
      stage ('Mockito/Junit') {
             steps {
            sh 'mvn test -Dtest="SecteurActiviteServiceImplMock" '
            sh 'mvn test -Dtest="FournisseurServiceImplTest" '
            }
        }
        
      
         stage ('Docker build') {
             steps {
            sh 'docker build -t syrineslimeni/tpAchatProject-1.0:latest .'
            }
        }
        
   
         stage ('Docker login'){
        	steps {
        	sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
        	}
        }
        
   
        
        stage ('Docker push'){
        	steps {
        	sh 'docker push syrineslimeni/tpAchatProject-1.0:latest'
        	}
        }
        
        stage('docker compose ') {
              steps {
                  sh "docker compose -f docker-compose.yml up -d  "
              }
        }
        
        
        stage("Send Email"){
           steps{
               emailext attachLog: true, body: "${env.BUILD_URL} has result ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'syrine.slimeni@esprit.tn'
           }
       }
        
     
      }
      
      post {
      	always {
      		sh 'docker logout'
      		emailext attachLog: true, body: "${env.BUILD_URL} has result ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'syrine.slimeni@esprit.tn'
          	emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
  		
      	}
      	
      }
}
