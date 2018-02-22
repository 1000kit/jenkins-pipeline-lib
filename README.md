Jenkins Pipeline Shared Library Template for 1000kit
=====================================================

This project is intended for use with [Jenkins](https://jenkins.io/) and Global Pipeline Libraries through the
[Pipeline Shared Groovy Libraries Plugin](https://wiki.jenkins.io/display/JENKINS/Pipeline+Shared+Groovy+Libraries+Plugin).

Requirements
---
[Apache Groovy](http://groovy-lang.org/)

Install
---
    git clone https://github.com/1000kit/jenkins-pipeline-lib.git
    cd jenkins-pipeline-lib
    ./gradlew build test

Install the shared library as described in the Jenkins [shared library documentation](https://jenkins.io/doc/book/pipeline/shared-libraries/#using-libraries).


Example usage in a Jenkins declarative pipeline:
```
/**
 * Library name should match the name configured in Jenkins > Configure system > Global Pipeline Libraries.
 * Annotation can be omitted if configured to be loaded implicitly.
 */
@Library('jenkins-pipeline-lib') _
pipeline {
    agent any
    stages {
        stage('maintainer') {
            steps {
                maintainer '1000kit'
            }
        }
    }
}
