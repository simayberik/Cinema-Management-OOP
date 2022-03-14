package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserManager extends Manager<User>{
	
	
	public UserManager() {
		super("user.txt");
		load();
	}
	public void add(String name, String mail,String password, Integer age, Boolean isStudent,boolean isAdmin) {
		User u =new User( name,  mail,password,  age,  isStudent,isAdmin);
		super.add(u);
	}
	@Override
	public void save() {
		super.save();
	}
	@Override
	public  void load() {
		File userText=new File(fileName);
		checkFolder(userText);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(userText));
			
			String str = br.readLine();
			while(str!=null) {
				User u = new User(str);
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
	public User get(String mail) {
		for(User all : list)
			if(all.getMail().equalsIgnoreCase(mail))
				return all;
		return null;
	}
	
	
	
}
