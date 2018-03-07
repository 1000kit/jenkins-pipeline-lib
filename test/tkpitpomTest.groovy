import org.junit.BeforeClass
import org.junit.Test
import org.tkit.jenkins.pipeline.lib.PomVersion
import tkitpom

class tkpitpomTest {


    //@BeforeClass
    static void setup() {
        tkitpom.metaClass.echo {
            println it
            return it
        }
    }

    //@Test
    void getMajorVersion() {
    	def tkp = new tkitpom()
    	def pf = 'pomTest.xml'
    	def pomVersion = tkp.readVersion(pf)
  
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

}