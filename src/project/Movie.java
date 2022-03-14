package project;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Movie {
	
	
	public Movie() {
	}
	public Movie(String name,int[] lenght,MovieGenre genre,int age_limit,double price) {
		this.name=name;
		this.lenght=lenght;
		this.genre=genre;
		this.age_limit=age_limit;
		this.price=price;
	}
	// helper constructor existing movies from text file with parsing data
	
	//movie data also is kept with total tickets created for that movie
	public Movie(String data) {
		if(data==null)return;
    	
    	int count=0;
    	int ticketSize=0;
    	int ticketCurrent=0;
    	String temp="";

		int hID=0;
    	for(int i=0;i<data.length();i++) {
    		
    		
    		if(data.charAt(i)==':') {
    			
    			if(count==0)name=temp;
    			else if(count==1)lenght[0]=Integer.parseInt(temp);
    			else if(count==2)lenght[1]=Integer.parseInt(temp);
    			else if(count==3)genre=MovieGenre.getGenreById(Integer.parseInt(temp));
    			else if(count==4)age_limit=Integer.parseInt(temp);
    			else if(count==5)price=Double.parseDouble(temp);
    			else if(count==6){hID=Integer.parseInt(temp);}
    			else if(count==7){
    				long time=Long.parseLong(temp);
    				hallList.put(hID, new HallInfo(new Date(time), this, hID));
    			}else if(count==8)ticketSize=Integer.parseInt(temp);
    			else if(ticketCurrent<ticketSize){
    				Ticket t = new Ticket(temp);
    				t.setHallID(hID);
    				t.setMovie(this);
    				getHall(hID).addTicket(t);
    				ticketCurrent++;
    				if(ticketCurrent==ticketSize)count=5;
    			}
    			
    			temp="";
    			count++;
    		}
    		else temp+=data.charAt(i);
    		
    	}
	}
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


	private String name="";
	private int[] lenght=new int[2];
	private MovieGenre genre=MovieGenre.action;
	private int age_limit=0;
	private HashMap<Integer,HallInfo> hallList = new HashMap<Integer,HallInfo>();
	private double price=0.0;

	public void removeHall(int hallID) {
		if(hallList.containsKey(hallID))
			hallList.remove(hallID);
	}
	public void addHall(int hallID,Date date) {
		HallInfo h = new HallInfo(date,this,hallID);
		if(!hallList.containsKey(hallID))
			hallList.put(hallID, h);
		else 
			hallList.get(hallID).setDate(date);
	}
	public HashMap<Integer, HallInfo> getHallList() {
		return hallList;
	}
	public HallInfo getHall(int hallID) {
		if(hallList.containsKey(hallID)) {
			return hallList.get(hallID);
		}
		return null;
	}
	// if a same movie is wanted to be created, it is changed with its new date
	public void changeDate(int hallID,Date date) {
		if(hallList.containsKey(hallID))
			hallList.get(hallID).setDate(date);;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getLenght() {
		return lenght;
	}
	public void setLenght(int[] lenght) {
		this.lenght = lenght;
	}
	public MovieGenre getGenre() {
		return genre;
	}
	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}
	public int getAge_limit() {
		return age_limit;
	}
	public void setAge_limit(int age_limit) {
		this.age_limit = age_limit;
	}
	
	
	@Override
	public String toString() {
		String str=name+":"+lenght[0]+":"+lenght[1]+":"+genre.getGenreID()+":"+age_limit+":"+price+":";
		for(int key: hallList.keySet()) {
			str+=hallList.get(key);
		}
		return str;
		
	}
	
}


class HallInfo{
	private Movie m;
	private int hallID=0;
	public HallInfo(Date date,Movie m,int hallID) {
		this.date=date;
		this.m=m;
		this.hallID=hallID;
	}
	private Date date;
	public Movie getMovie() {
		return m;
	}
	public void setMovie(Movie m) {
		this.m = m;
	}
	public int getHallID() {
		return hallID;
	}
	public void setHallID(int hallID) {
		this.hallID = hallID;
	}
	public Hall getHall() {
		return Main.hallManager.get(hallID);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public MyQueue<Ticket> getTickets() {
		return tickets;
	}
	
	private MyQueue<Ticket> tickets=new MyQueue<Ticket>();
	

	//TODO bilet / Bos yer 
	public void buyTicket(User u,String seat) {
		Ticket t = new Ticket(u,m,hallID,seat);
		addTicket(t);
	}public void buyTicket(String mail,String seat) {
		User u =Main.userManager.get(mail);
		Ticket t = new Ticket(u,m,hallID,seat);
		addTicket(t);
	}
	public void addTicket(Ticket t) {
		t.getUser().addTicketToList(t);
		tickets.add(t);
	}
	///////////////////////////// REMOVE
	public void returnTicket(Ticket t) {
		t.getUser().removeTicketFromList(t);
		tickets.remove(t);
	}
	public void returnTicket(User t,String seat) {
		for(Ticket all:t.getUserTickets()) {
			if(all.getMovie()==m) {
				if(all.getSeat()==seat) {
					returnTicket(all);
				}
			}
		}
	}
	/////////////////////////////
	
	@Override
	public String toString() {
		
		String str=hallID+":"+date.getTime()+":"+tickets.size()+":";
		for(int i=0;i<tickets.size();i++)
			str+=tickets.get(i).toString();
		return str;
	}
}



enum MovieGenre{
	comedy(0),
	horror(1),
	action(2),
	sci_fi(3),
	drama(4);
	
	
	private int selectedID=0;
	MovieGenre(int selectedID){
		this.selectedID=selectedID;
	}
	public int getGenreID() {
		return selectedID;
	}
	
	public static MovieGenre getGenreById(int genreID) {
		return MovieGenre.values()[genreID];
	}
	public static MovieGenre getGenreByName(String name) {
		for(MovieGenre m : MovieGenre.values()) {
			if(name.equalsIgnoreCase(name))return m;
		}
		return MovieGenre.action;
	}
}
