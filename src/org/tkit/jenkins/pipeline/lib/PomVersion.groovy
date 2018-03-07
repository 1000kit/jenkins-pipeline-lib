package org.tkit.jenkins.pipeline.lib

public class PomVersion {
	public int MAJOR=1;
	public int MINOR=2;
	public int PATCH=3;
	public int BUILD=4;
	
    def originalVersion = ""
    def releaseVersion = ""
    
    def tokens;
    def boolean isSnapshot=false
	def String[] versArray=["","","",""]
	
    public void setVersion(String version) {
    	if ( version == null ) {
    	     return;                    
    	}
		this.isSnapshot=version.contains("-SNAPSHOT")
    	this.originalVersion = version
    	this.releaseVersion=version.replace("-SNAPSHOT","")
     	tokens = this.releaseVersion.trim().tokenize("\\.")
     	if (tokens.size() > versArray.size() ) {
    		versArray = new String[tokens.size()]();
    	}
    	for ( int i; i< tokens.size(); i++) {
    		versArray[i] = tokens[i]
    	}
    }

    public String get(int pos) {
    	String res="";
    	if(pos > 0 && versArray.size() >= pos){   
         	res = versArray[pos-1]
         }          
         return res
    }
    public String getMajor() {
         return get(MAJOR)
    }

    public String getMinor() {
         return get(MINOR)
    }

    public String getPatch() {
         return get(PATCH)
    }
 
     public String getBuild() {
         return get(BUILD)
    }
    
    public String getRelease() {
    	String v="";
    	for(int i; i< versArray.size(); i++ ) {
    	   if(i != 0 && versArray[i].length() > 0) {
    	   	  v+="."
    	   }
    	   v+=versArray[i];                        
    	}
    	return v
    }
    public String getCurrent() {
    	String v = getRelease();
    	if (this.isSnapshot) {
    	  v +="-SNAPSHOT"
    	}
    	return v
    }
    
    public PomVersion increment(int pos) {
    	if ( pos > 0 && pos <= versArray.size() ) {  		
    		String v = versArray[pos-1]
    		int vi = 0;
    		if ( v.length() > 0 ) {
    		  vi = toInt(v)
    		  vi = vi + 1
    		}
    		if (vi >=0) {
    			versArray[pos-1] = "" + vi
    		}
    	}
    	return this
    }
    
	public boolean isSnapshot() {
		return this.isSnapshot;
	}
	
	private int toInt(String intStr) {
		int result=-1;
		if (intStr.isInteger()) {
  			result = intStr as Integer
		}
		return result;
	}
}
