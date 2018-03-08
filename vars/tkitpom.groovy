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
	  echo "increment: $version  -- $pos" 
      def pomVersion = new PomVersion()
      echo "2" 
      pomVersion.setVersion(version)
      echo "3"
      pomVersion.increment(pos)
      echo "4"
	  def versArray = pomVersion.getVersArray()
	  echo "versArray: $versArray"
      def newVers = pomVersion.getRelease()
      echo "new Version: $newVers"    
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
