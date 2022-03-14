package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main {
	
	public static UserManager 	userManager = new UserManager();
	public static HallManager 	hallManager = new HallManager();
	public static MovieManager 	movieManager = new MovieManager();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					new ViewLogin();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void registerAdmin(String name,String mail,String password,int age,boolean isStudent,boolean isAdmin) {
		userManager.add(name, mail,password, age, isStudent, isAdmin);
	}
	public static void registerUser(String name,String mail,String password,int age,boolean isStudent,boolean isAdmin) {
		userManager.add(name, mail,password, age, isStudent, isAdmin);
	}
	public static boolean ifLoginned(String mail,String password) {
		User u = userManager.get(mail); // user yoksa null gelir
		if(u!=null) {
			if(u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean ifRegistered(String mail,String password) {
		User u = userManager.get(mail);
		if(u==null) {
			return false;
		}
		return true;
	}

}
