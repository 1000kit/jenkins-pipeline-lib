#!groovy
import org.tkit.jenkins.pipeline.lib.PomVersion


def readVersion(path) {
    echo "reading pom file $path"
    def pomVersion = new PomVersion()
    try {
    	def contents = readFile(path)
    	def project = new XmlSlurper().parseText(contents)
    	def version = project.version.text().trim()
    	echo "version read: $version"
    	pomVersion.setVersion(version)
    	echo "set pom Version"
    } catch (Exception ex) {
    	echo "caught exception $ex"
    }
    echo "return pomVersion"
    return pomVersion
}

def setVersion(version) {
	echo "createVersion"
	def pomVersion = new PomVersion()
	echo "set pom Version"
	pomVersion.setVersion(version)
	echo "return pomVersion"
    return pomVersion
	
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
