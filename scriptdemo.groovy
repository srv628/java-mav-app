def buildJar(){
     echo "building the jar file"
                    sh "mvn package"

}
def buildImage(){
      echo "building the docker image"
                    withCredentials([usernamePassword(credentialsId:"dockerHub",usernameVariable:"USER",passwordVariable:"PASS")]){
                    sh "docker build -t srvwin/jenkinsdocker:javamapp-2.0 ."
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                

                    sh "docker push srvwin/jenkinsdocker:javamapp-2.0"
}
def deployApp(){
    echo "deploying the code"
    echo " deploying versio ${params.VERSION}"
}
return this