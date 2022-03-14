package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewUserBoard extends JFrame {

	private JTextField textField_name;
	private JTextField textField_mail;
	private JPasswordField passwordField;
	private JPasswordField passwordField_control;
	private JTextField textfield_age;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ViewUserBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(500, 400);
        setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(0, 0, 486, 363);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField_name = new JTextField();
		textField_name.setBackground(new Color(255, 228, 181));
		textField_name.setBounds(135, 104, 111, 19);
		panel.add(textField_name);
		textField_name.setColumns(10);
		
		textField_mail = new JTextField();
		textField_mail.setBackground(new Color(255, 228, 181));
		textField_mail.setBounds(135, 160, 111, 19);
		panel.add(textField_mail);
		textField_mail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 228, 181));
		passwordField.setBounds(135, 212, 111, 19);
		panel.add(passwordField);
		
		passwordField_control = new JPasswordField();
		passwordField_control.setBackground(new Color(255, 222, 173));
		passwordField_control.setBounds(135, 266, 111, 19);
		panel.add(passwordField_control);
		
		textfield_age = new JTextField();
		textfield_age.setBackground(new Color(255, 228, 181));
		textfield_age.setBounds(310, 165, 111, 19);
		panel.add(textfield_age);
		textfield_age.setColumns(10);
		JLabel lblNewLabel = new JLabel("REGISTER    NOW");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 27));
		lblNewLabel.setBounds(141, 21, 247, 58);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 106, 80, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 162, 64, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(20, 214, 64, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(20, 268, 115, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Age :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(270, 170, 115, 13);
		panel.add(lblNewLabel_5);
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getText().equals(passwordField_control.getText())) {

					if(!(Main.ifRegistered(textField_mail.getText(), passwordField.getText()))) {
						Main.registerUser(textField_name.getText(),textField_mail.getText(),passwordField.getText(),Integer.parseInt(textfield_age.getText()),(25<Integer.parseInt(textfield_age.getText())),false);
						Main.userManager.save();
						new ViewMenu(Main.userManager.get(textField_mail.getText()));
						setVisible(false); 
						dispose();
						
					}
				}
			}
		});
		btnNewButton.setBounds(150, 309, 85, 21);
		panel.add(btnNewButton);
		
		
	}

	public void addWindowListener(WindowListener listener) {
		// TODO Auto-generated method stub
		
	}

}
