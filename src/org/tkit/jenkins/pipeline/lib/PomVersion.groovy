package org.tkit.jenkins.pipeline.lib

public class PomVersion {

    public String currentVersion = ""
    def tokens;
    public void setVersion(String version) {
    	this.currentVersion = version
    	tokens = this.currentVersion.trim().tokenize("\\.-")
    }

    public String getVersionString() {
    	return currentVersion
    }
    
    public String getMajor() {
         String major = ""
         if(tokens.size >= 1){   
         	major = tokens[0]
         }          
         return major
    }

    public String getMinor() {
         String minor = ""
         if(tokens.size  >= 2){   
         	minor = tokens[1]
         }        
         return minor
    }

    public String getPatch() {
         String patch = ""
         if(tokens.size >= 3){   
         	patch = tokens[2]        	
         }          
         return patch
    }
 
     public String getBuild() {
         String build = ""
         if(tokens.size >= 4){   
         	build = tokens[3]
         }          
         return build
    }
    
    


}
