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
                        url : 'https://github.com/marouenkaroui/Spring.git';
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
        /*stage('Code Quality Check via SonarQube') {
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
        }*/
        
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
         stage('Docker compose ') {
              steps {
                  sh "docker compose -f docker-compose.yml up -d  "
              }
        }
       
        
        stage ('Docker push'){
        	steps {
        	sh 'docker push $DOCKERHUB_CREDENTIALS_USR/achat:latest'
        	}
        }
        
        /*stage('mailling'){
	           steps {
		            mail bcc: '', body: '''Hello from Jenkins,
		            Devops Pipeline returned success.
		            Best Regards''', cc: '', from: 'louatisahar23@gamil.com', replyTo: '', subject: 'Devops Pipeline', to: 'sahar.louati@esprit.tn'
	            }
	       }
       */
    }
    /*post {
      	always {
      		sh 'docker logout'
      		emailext attachLog: true, body: "${env.BUILD_URL} has result ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'marouen.karoui@esprit.tn'
          	emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
  		
      	}
      }
      */
}