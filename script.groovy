def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-id', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t abdullahhafeez/test-repo:jma-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push abdullahhafeez/test-repo:jma-1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
