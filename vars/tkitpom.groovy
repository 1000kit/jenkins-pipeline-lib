#!/usr/bin/env groovy

def version(String path) {
    def contents = readFile(path)
    def project = new XmlSlurper().parseText(contents)
    def version = project.version.text().trim()
    echo "parsed POM Version $version"
    return version
}

def majorVersion(String path) {
    def version = version(path)
    if(version.count(".") >= 1){
        def major = version.trim().tokenize("\\.-")[0]
        echo "parsed major $major"        
        return major
    }
    echo "version count <2"
    return ""
}

def minorVersion(String path) {
    def version = version(path)
    if(version.count(".") >= 1){
        def minor = version.trim().tokenize("\\.-")[1]
        echo "parsed minor $minor"        
        return minor
    }
    echo "version count <2"
    return ""
}

def patchVersion(String path) {
    def version = version(path)
    if(version.count(".") >= 2){
        def patch = version.trim().tokenize("\\.-")[2]
        echo "parsed patch $patch"        
        return patch
    }
    echo "version count <2"    
    return ""
}

def buildVersion(String path) {
    def version = version(path)
    if(version.count(".") >= 3){
        def build = version.trim().tokenize("\\.-")[3]
        echo "parsed build $build"        
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
