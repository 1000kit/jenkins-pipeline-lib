#!groovy
import org.tkit.jenkins.pipeline.lib.PomVersion


def readVersion(path) {
    echo "reading pom file $path"
    def pomVersion = new PomVersion()
    try {
    	def contents = readFile(path)
    	def project = new XmlSlurper().parseText(contents)
    	def version = project.version.text().trim()
    	pomVersion.setVersion(version)
    } catch (Exception ex) {
    	echo "caught exception $ex"
    }
    return pomVersion
}

def majorVersion(pomVersion) {
    return pomVersion.getMajor()
}

def minorVersion(pomVersion) {
    return pomVersion.getMinor()
}

def patchVersion(pomVersion) {
    return pomVersion.getPatch()
}

def buildVersion(pomVersion) {
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
