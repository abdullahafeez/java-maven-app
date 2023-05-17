def gv

pipeline {
    agent any
    tools{
     maven 'Maven'   
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    //echo "building jar"
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    //echo "building image"
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                    //make sure docker login credentials are stored in your ec2 server
                    // use docker login command to save them
                    def dockerCmd = 'docker run -p 8080:8080 -p 50000:50000 -d -v jenkins_home:/var/jenkins_home jenkins/jenkins'
                    sshagent(['ec2-server-key']) {
                        // some block
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@18.217.187.55 ${dockerCmd}"
                    }
                    //gv.deployApp()
                }
            }
        }
    }   
}
