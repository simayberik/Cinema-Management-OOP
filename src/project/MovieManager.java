package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MovieManager  extends Manager<Movie>{

	public MovieManager() {
		super("movies.txt");
		load();
	}
	
	public Movie add(String name, int[] lenght, int genreID, int ageLimit,double price) {
		Movie u =new Movie(name, lenght, MovieGenre.getGenreById(genreID), ageLimit, ageLimit);
		super.add(u);
		save();
		return u;
	}
	public void add(String name, int[] lenght, MovieGenre genre, int ageLimit,double price) {
		Movie u =new Movie(name, lenght, genre, ageLimit, ageLimit);
		save();
		super.add(u);
	}
	@Override
	public void save() {
		super.save();
	}
	@Override
	public  void load() {
		//if(list.size()!=0)return;
		File movieText=new File(fileName);
		checkFolder(movieText);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(movieText));
			
			String str = br.readLine();
			while(str!=null) {
				Movie m = new Movie(str);
				
				list.add(m);
				str = br.readLine();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Movie get(String movie) {
		for(Movie all : list)
			if(all.getName().equalsIgnoreCase(movie))
				return all;
		return null;
	}
	public MyQueue<Ticket> getAllTicket(){
		MyQueue<Ticket> list=new MyQueue<Ticket>();
		for(Movie m : this.list) {							//Vizyondaki her bir film
			for(HallInfo h : m.getHallList().values()) {	//Gösterildiði her bir salon
				for(Ticket t : h.getTickets())				//Bu salona satýlmýþ her bir biletler
					list.add(t);
			}
		}
		return list;
	}
	public MyQueue<HallInfo> getAllMovieHalls(){
		MyQueue<HallInfo> list=new MyQueue<HallInfo>();
		for(Movie m : this.list) {							//Vizyondaki her bir film
			for(HallInfo h : m.getHallList().values()) {	//Bu salona satýlmýþ her bir biletler
					list.add(h);
			}
		}
		return list;
	}
}
