package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HallManager extends Manager<Hall>{

	
	
	
	public HallManager() {
		super("Hall.txt");
		load();
		// TODO Auto-generated constructor stub
	}
	
	public  void add(int ID,int[] size) {
		for(Hall h : list) {
			if(h.getID()==ID) {
				h.setSize(size);
				save();
				return;
			}
		}
		Hall h = new Hall(ID,size);
		super.add(h);
		save();
	}
	
	public Hall get(int ID) {
		for(Hall all : list)
			if(all.getID()==ID)
				return all;
		return null;
		
	}
	@Override
	public void load() {
		File userText=new File(fileName);
		checkFolder(userText);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(userText));
			
			String str = br.readLine();
			while(str!=null) {
				Hall u = new Hall(str);
				list.add(u);
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
	@Override
	public  void save() {
		super.save();
	}
	
}

