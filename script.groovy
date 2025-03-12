def buildApp(){
    echo "building the code"
}
def testApp(){
    echo "testing the code"
}
def deployApp(){
    echo "deploying the code"
    echo " deploying versio ${params.VERSION}"
}
return this