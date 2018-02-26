#!/usr/bin/env groovy

def version(String path) {
    def contents = readFile(path)
    def project = new XmlSlurper().parseText(contents)
    def version = project.version.text().trim()
    echo "parsed Version $version"
    return version
}

def majorVersion(String path) {
    def version = version(path)
    if(version.count(".") >= 1){
        def major = version.trim().split("\\.")[0]
        echo "parsed Version $major"        
        return major
    }
    echo "version count <2"
    return ""
}

def minorVersion(String path) {
    def version = version(path)
    if(version.count(".") >= 1){
        def minor = version.trim().split("\\.")[1]
        echo "parsed Version $minor"        
        return minor
    }
    echo "version count <2"
    return ""
}

def patchVersion(String path) {
    def version = version(path)
    if(version.count(".") >= 2){
        def patch = version.trim().split("\\.")[2]
        echo "parsed Version $patch"        
        return patch
    }
    echo "version count <2"    
    return ""
}

def buildVersion(String path) {
    def version = version(path)
    if(version.count(".") >= 3){
        def build = version.trim().split("\\.")[3]
        echo "parsed Version $build"        
        return build
    }
    echo "version count <3"    
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
