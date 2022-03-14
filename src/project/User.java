package project;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Calendar;
import java.util.Date;
//
public class User {
	 private String name;
	    private String mail;
	    private String password;
	    private int age;
	    private boolean isStudent;
	    private boolean isAdmin;
	    public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
	    
	    public Boolean isAdmin() {
			return isAdmin;
		}

		private MyQueue<Ticket> tickets=new MyQueue<Ticket>();

	    public User(){
	        this.name = null;
	    }

	    public User(String dataStr) {
	        //return name+":"+mail+":"+age+":"+isStudent+":";
	    	if(dataStr==null)return;
	    	
	    	int count=0;
	    	String temp="";
	    	for(int i=0;i<dataStr.length();i++) {
	    		
	    		
	    		if(dataStr.charAt(i)==':') {
	    			//System.out.println(temp);
	    			if(count==0)name=temp;
	    			else if(count==1)mail=temp;
	    			else if(count==2)password=temp;
	    			else if(count==3)age=Integer.parseInt(temp);
	    			else if(count==4)isStudent=temp.equalsIgnoreCase("true");
	    			else if(count==5)isAdmin=temp.equalsIgnoreCase("true");
	    			temp="";
	    			count++;
	    		}
	    		else temp+=dataStr.charAt(i);
	    		
	    	}
	    	
	    	
	    }
	    public User(String name, String mail,String password, Integer age, boolean isStudent,boolean isAdmin) {
	        this.name = name;
	        this.age = age;
	        this.isStudent = isStudent;
		     this.mail=mail;
		    this.isAdmin=isAdmin;
		    this.password=password;
		    
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getMail() {
	        return mail;
	    }

	    public void setMail(String Mail) {
	        this.mail = Mail;
	    }

	    public Integer getAge() {
	        return age;
	    }

	    public void setAge(Integer age) {
	        this.age = age;
	    }
      
	    public static boolean getStudent(int age) {
	    	if(age<25) {
	    		return true;
	    	}
	        return false;
	    }

	    public void setStudent(Boolean student) {
	    	
	        isStudent = student;
	    }
	   
	    public void addTicketToList(Ticket t) {
	    	tickets.add(t);
	    }
	    public void removeTicketFromList(Ticket t) {
	    	tickets.remove(t);
	    }
	    public MyQueue<Ticket> getUserTickets() {
	    	return tickets;
	    }
	    @Override
	    public String toString() {
	    	return name+":"+mail+":"+password+":"+age+":"+isStudent+":"+isAdmin+":";
	    }
}
