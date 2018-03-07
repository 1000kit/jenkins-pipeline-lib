import org.junit.BeforeClass
import org.junit.Test
import org.tkit.jenkins.pipeline.lib.PomVersion

class PomVersionTest {


    @BeforeClass
    static void setup() {

    }

    @Test
    void getMajorVersion() {
        PomVersion pomVersion = new PomVersion()
        String expectedArg = "2"
        pomVersion.setVersion("1.2.3-SNAPSHOT")

		def major = pomVersion.getMajor() 
		println "major: $major"
        assert major != null
        assert major == "1"
        
       	def minor = pomVersion.getMinor() 
       	println "minor: $minor"
        assert minor != null
        assert minor == "2"
        
        def patch = pomVersion.getPatch()
        println "patch: $patch" 
        assert patch != null
        assert patch == "3" 
        
        def build = pomVersion.getBuild() 
        println "build: $build"
        assert build != null
        assert build == ""     
        
        def releaseVers=pomVersion.getRelease();
        println "releaseVersion: $releaseVers"
    }


    @Test
    void getVersion() {
        PomVersion pomVersion = new PomVersion()
        String expectedArg = '2'
        pomVersion.setVersion("1.2.3.4-SNAPSHOT")

		def major = pomVersion.getMajor() 
        assert major != null
        assert major == "1"
        
       	def minor = pomVersion.getMinor() 
        assert minor != null
        assert minor == "2"
        
        def patch = pomVersion.getPatch() 
        assert patch != null
        assert patch == "3"  
        
        def build = pomVersion.getBuild() 
        assert build != null
        assert build == "4"  
        
        def releaseVers=pomVersion.getRelease();
        println "releaseVersion: $releaseVers"
    }
    
    @Test
    void getIncrement() {
    	PomVersion pomVersion = new PomVersion()
        pomVersion.setVersion("1.2.3-SNAPSHOT")
    	
    	println "check increment"
    	def release = pomVersion.increment(pomVersion.MAJOR).getRelease()
    	println "passed:  $release"
    	assert release == "2.2.3"
    	
    	
    	release = pomVersion.increment(pomVersion.MINOR).getRelease()
    	println "passed:  $release"
    	assert release == "2.3.3"
    	
     	release = pomVersion.increment(pomVersion.PATCH).getRelease()
     	println "passed:  $release"
    	assert release == "2.3.4"
     	
     	release = pomVersion.increment(pomVersion.BUILD).getRelease()
     	println "passed:  $release"
    	assert release == "2.3.4.0"
      	
      	release = pomVersion.increment(pomVersion.BUILD).getRelease()
      	println "passed:  $release"
    	assert release == "2.3.4.1"
    	
    	def curVers = pomVersion.getCurrent()
    	println "passed:  $curVers"
    	assert curVers == "2.3.4.1-SNAPSHOT"
    }
}