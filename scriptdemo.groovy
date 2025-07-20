def buildJar(){
     echo "building the jar file"
                    sh "mvn package"

}
def buildImage(){
      echo "building the docker image"
                    withCredentials([usernamePassword(credentialsId:"dockerhub-cred",usernameVariable:"USER",passwordVariable:"PASS")]){
                    sh "docker build -t srvwin/dockerinitial:javamapp-2.0 ."

                    sh "echo $PASS | docker login -u $USER --password-stdin"
                

                    sh "docker push  srvwin/dockerinitial:javamapp-2.0"
}}
def deployApp(){
    echo "deploying the code"

}
return this
