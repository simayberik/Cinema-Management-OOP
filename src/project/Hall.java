package project;

public class Hall {
	public Hall() {
	}
	public Hall(int ID,int[] size) {
		this.ID=ID;
		this.size=size;
	}
	public Hall(String data) {
		if(data==null)return;
    	
    	int count=0;
    	String temp="";
    	for(int i=0;i<data.length();i++) {
    		
    		
    		if(data.charAt(i)==':') {
    			if(count==0)ID=Integer.parseInt(temp);
    			else if(count==1)size[0]=Integer.parseInt(temp);
    			else if(count==2)size[1]=Integer.parseInt(temp);
    			temp="";
    			count++;
    		}
    		else temp+=data.charAt(i);
    		
    	}
	}
	
	private int ID = 0;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int[] getSize() {
		return size;
	}
	public void setSize(int[] size) {
		this.size = size;
	}

	private int[] size = new int[2]; // X , Y
	
	
	
	@Override
	public String toString() {
		return ID+":"+size[0]+":"+size[1]+":";
	}
	
	
}
