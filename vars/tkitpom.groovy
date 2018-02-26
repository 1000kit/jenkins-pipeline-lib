#!/usr/bin/env groovy

def version(String path) {
    def contents = readFile(path)
    def project = new XmlSlurper().parseText(contents)
    def version = project.version.text().trim()
    return version
}

def majorVersion(String path) {
    def version = version(path)
    if(version.count(".") >= 1){
        def major = version.trim().tokenize("\\.-")[0]
        return major
    }
    return ""
}

def minorVersion(String path) {
    def version = version(path)
    if(version.count(".") >= 1){
        def minor = version.trim().tokenize("\\.-")[1]
        return minor
    }
    return ""
}

def patchVersion(String path) {
    def version = version(path)
    if(version.count(".") >= 2){
        def patch = version.trim().tokenize("\\.-")[2]
        return patch
    }
    return ""
}

def buildVersion(String path) {
    def version = version(path)
    if(version.count(".") >= 3){
        def build = version.trim().tokenize("\\.-")[3]
        return build
    }
    return ""
}



def artifactId(String path) {
    def contents = readFile(path)
    def project = new XmlSlurper().parseText(contents)
    return project.artifactId.text().trim()
}

def groupId(String path) {
    def contents = readFile(path)
    def project = new XmlSlurper().parseText(contents)
    return project.groupId.text().trim()
}

return this
