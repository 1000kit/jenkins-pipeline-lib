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



def incrementRelease(String version, int pos = 4) {
      def pomVersion = new PomVersion() 
      pomVersion.setVersion(version)
      pomVersion.increment(pos)
      def newVers = pomVersion.getRelease()    
      return newVers                           
}
def setRelease(String value, int pos = 4) {
      def pomVersion = new PomVersion() 
      pomVersion.setVersion(version)
      pomVersion.set(pos, value)
      def newVers = pomVersion.getRelease()    
      return newVers                           
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
