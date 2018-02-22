#!/usr/bin/env groovy

def pipe(command){
    sh(script: command, returnStdout: true)
}

return this

