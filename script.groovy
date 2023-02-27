def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    sh 'pwd'
    sh 'ls'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-id', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t abdullahhafeez/test-repo:jvm1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        //sh 'docker push abdullahhafeez/myalpine:2 '
        sh 'docker push abdullahhafeez/test-repo:jvm1.1 '
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
