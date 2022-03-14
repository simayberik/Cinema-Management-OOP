package project;

import java.util.Date;
//
public class Ticket {
	
	public Ticket(User u,Movie m,int hallID,String seatNumber) {
		user=u;
		movie=m;
		this.hallID=hallID;
		this.seat=seatNumber;
	}
	public Ticket(String data) {
		if(data==null)return;
    	
		String mail="";
		
    	int count=0;
    	String temp="";
    	for(int i=0;i<data.length();i++) {
    		if(data.charAt(i)=='-'||data.charAt(i)==':') {
    			if(count==0)mail=temp;
    			else if(count==1)seat=temp;
    			temp="";
    			count++;
    		}
    		else temp+=data.charAt(i);
    		
    	}
    	if(temp!="")
    		seat=temp;
    	user=Main.userManager.get(mail);
    	
    	
	}
	
	
	private User user;
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getHallID() {
		return hallID;
	}
	public void setHallID(int hallID) {
		this.hallID = hallID;
	}
	public HallInfo getHall() {
		return movie.getHall(hallID);
	}
	public double getPrice(int age) {
		return movie.getPrice()*(user.getStudent(age)?0.5:1);
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int[][] getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int[][] ticketNo) {
		this.ticketNo = ticketNo;
	}
	private Movie movie;
    private int hallID;
    private String seat;
    private int[][] ticketNo;
    
    
    @Override
    public String toString() {
    	return user.getMail()+"-"+getSeat()+":";
    }
}
