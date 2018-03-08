import org.junit.BeforeClass
import org.junit.Test
import org.tkit.jenkins.pipeline.lib.PomVersion
import tkitpom

class tkpitpomTest {


    @BeforeClass
    static void setup() {
        tkitpom.metaClass.echo {
            println it
            return it
        }
    }

    @Test
    void getIncrementVersion() {
    	def tkp = new tkitpom()
    	def pf = 'pomTest.xml'
    	def pomVersion = tkp.incrementRelease("1.2.3-SNAPSHOT",4)
  
		
        assert pomVersion != null
        println "pomVersion: $pomVersion"
        assert pomVersion == "1.2.3.0"
             
    }

}