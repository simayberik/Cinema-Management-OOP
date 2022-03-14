package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Manager <T>{
	
	protected String fileName;
	public Manager(String fileName) {
			this.fileName=fileName;
	}
	
	protected MyQueue<T> list = new MyQueue<T>();
	
	public MyQueue<T> getList() {
		return list;
	}


	public void add(T item) {
		list.add(item);
	}
	
	public void load() {}
	
	public void save() {
		File userText=new File(fileName);
		checkFolder(userText);
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(userText));
			for(T u : list) {
				bw.write(u.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    // checks folder if not exist, creates
	protected static void checkFolder(File userText) {
		
		try {
			userText.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
