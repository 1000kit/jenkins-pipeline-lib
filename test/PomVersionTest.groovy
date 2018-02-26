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
        assert build == "SNAPSHOT"     
    }


    @Test
    void getBuildVersion() {
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
    }

}