#!/usr/bin/env groovy

def version(String path) {
    def contents = readFile(path)
    def project = new XmlSlurper().parseText(contents)
    def version = project.version.text().trim()
    PomVersion pomVersion = new PomVersion()
    pomVersion.setVersion(version)
    return pomVersion
}

def majorVersion(PomVersion pomVersion) {
    return pomVersion.getMajor()
}

def minorVersion(PomVersion pomVersion) {
    return pomVersion.getMinor()
}

def patchVersion(PomVersion pomVersion) {
    return pomVersion.getPatch()
}

def buildVersion(PomVersion pomVersion) {
    return pomVersion.getBuild()
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
