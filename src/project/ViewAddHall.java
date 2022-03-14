package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewAddHall extends JFrame{

	private JTextField field_hall_ID;
	private JTextField field_seat_x;
	private JTextField field_seat_y;
	
	
	
	public ViewAddHall() {
		setVisible(true);
		setBounds(100, 100, 370, 320);
		getContentPane().setLayout(null);
		setTitle("Add Hall");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		/////////////////////////////////////////////
		
		JLabel lbl_hall = new JLabel("Hall Id :");
		lbl_hall.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_hall.setBounds(57, 40, 59, 13);
		add(lbl_hall);
		
		JLabel lblNewLabel = new JLabel("Create Seats :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(57, 104, 78, 13);
		add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("   X");
		lblNewLabel_1.setBounds(193, 104, 22, 13);
		add(lblNewLabel_1);
		
		field_hall_ID = new JTextField();
		field_hall_ID.setBounds(145, 38, 96, 19);
		add(field_hall_ID);
		field_hall_ID.setColumns(10);
		
		
		field_seat_x = new JTextField();
		field_seat_x.setBounds(165, 102, 29, 19);
		add(field_seat_x);
		field_seat_x.setColumns(10);
		
		field_seat_y = new JTextField();
		field_seat_y.setBounds(225, 102, 29, 19);
		add(field_seat_y);
		field_seat_y.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add Hall");
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			int x=0;
			int y=0;
			int id=0;
			try {
				x=Integer.parseInt(field_seat_x.getText());
				y=Integer.parseInt(field_seat_y.getText());
				id=Integer.parseInt(field_hall_ID.getText());
			}catch (Exception exception) {
				
				exception.printStackTrace();
			}
			
			Main.hallManager.add(id,new int[]{x,y});
			setVisible(false);
			dispose();
			
		}
		});
		btnNewButton_1.setBounds(145, 200, 85, 21);
		add(btnNewButton_1);

		///////////////////////////////////
		
		
	}
}
