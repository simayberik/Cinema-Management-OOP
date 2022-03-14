package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ViewAddMovie extends JFrame{

	private JTextField field_movie;
	private JTextField field_genre;
	private JTextField field_lenght;
	private JTextField field_hallID;
	private JTextField field_date_day;
	private JTextField field_date_month;
	private JTextField field_date_year;

	/**
	 * Launch the application.
	 */
	
	
	/**
	 * Create the application.
	 */
	public ViewAddMovie() {
		initialize();
		//setSize(500, 500);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 300, 484);
		getContentPane().setLayout(null);
		setTitle("Add Movie");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(0, 0, 578, 447);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		field_movie = new JTextField();
		field_movie.setBounds(111, 108, 96, 19);
		panel.add(field_movie);
		field_movie.setColumns(10);
		
		field_genre = new JTextField();
		field_genre.setBounds(111, 161, 96, 19);
		panel.add(field_genre);
		field_genre.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Movie Name :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(23, 110, 91, 13);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Genre :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(32, 163, 45, 13);
		panel.add(lblNewLabel_6);
		
		field_lenght = new JTextField();
		field_lenght.setBounds(111, 256, 96, 19);
		panel.add(field_lenght);
		field_lenght.setColumns(10);
		
		JLabel lbl_lenght = new JLabel("Lenght :");
		lbl_lenght.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_lenght.setBounds(32, 258, 45, 13);
		panel.add(lbl_lenght);
		
		JLabel lbl_date = new JLabel("Select Date :");
		lbl_date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_date.setBounds(23, 298, 69, 33);
		panel.add(lbl_date);
		
		JLabel lbl_movie = new JLabel("ADD MOVIE");
		lbl_movie.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 23));
		lbl_movie.setForeground(new Color(139, 0, 0));
		lbl_movie.setBounds(69, 10, 184, 81);
		panel.add(lbl_movie);
		
		
		JButton btnNewButton = new JButton("Add Movie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int h=0;
				int m=0;
				int genre=-1;
				int ageLimit=0;
				double price=50.0;
				String lng=field_lenght.getText();
				try {
					
					
					h=Integer.parseInt(lng.substring(0,lng.indexOf(":")));
					m=Integer.parseInt(lng.substring(lng.indexOf(":")+1,lng.length()));

					genre=Integer.parseInt(field_genre.getText());
					
				}catch (Exception exception) {
					
					//exception.printStackTrace();
				}
				
				if(genre==-1) {
					try {
						genre=MovieGenre.getGenreByName(field_genre.getText()).getGenreID();
					}catch (Exception ee) {}
				}
				
				Movie movie=Main.movieManager.add(field_movie.getText(), new int[] {h,m}, genre, ageLimit, price); 
				
				try {
					
					int day=Integer.parseInt(field_date_day.getText());
					int month=Integer.parseInt(field_date_month.getText());
					int year=Integer.parseInt(field_date_year.getText());
					int hallID = Integer.parseInt(field_hallID.getText());
					movie.addHall(hallID, new Date(year, month, day));
					
				}catch (Exception eee) {
					
				}
				
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(111, 353, 85, 21);
		panel.add(btnNewButton);
		
		
		JLabel lblNewLabel_2 = new JLabel("Hall Id :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(32, 208, 45, 13);
		panel.add(lblNewLabel_2);
		
		field_hallID = new JTextField();
		field_hallID.setBounds(111, 202, 96, 19);
		panel.add(field_hallID);
		field_hallID.setColumns(10);
		
		
		field_date_day = new JTextField();
		field_date_day.setBounds(111, 306, 29, 19);
		panel.add(field_date_day);
		field_date_day.setColumns(10);
		
		field_date_month = new JTextField();
		field_date_month.setBounds(161, 306, 35, 19);
		panel.add(field_date_month);
		field_date_month.setColumns(10);
		
		field_date_year = new JTextField();
		field_date_year.setBounds(217, 306, 40, 19);
		panel.add(field_date_year);
		field_date_year.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("/");
		lblNewLabel_3.setBounds(151, 309, 45, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("/");
		lblNewLabel_4.setBounds(207, 309, 45, 13);
		panel.add(lblNewLabel_4);
		
		
		 
		
	}
}
