package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class ViewLogin extends JFrame implements WindowListener   {

	//private JFrame frame;
	private JTextField field_mail;
	private JTextField field_pass;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ViewLogin() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		getContentPane().setBackground(new Color(255, 160, 122));
		getContentPane().setLayout(null);
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		final WindowListener listener = this;
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calibri", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
		comboBox.setBounds(458, 125, 177, 26);
		getContentPane().add(comboBox);
		setVisible(true);
		
		
		
		field_mail = new JTextField();
		field_mail.setBackground(new Color(255, 228, 196));
		field_mail.setBounds(458, 176, 177, 35);
		getContentPane().add(field_mail);
		field_mail.setColumns(10);
		
		field_pass = new JTextField();
		field_pass.setBackground(new Color(255, 228, 196));
		field_pass.setBounds(458, 232, 177, 35);
		getContentPane().add(field_pass);
		field_pass.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.BOLD, 54));
		lblNewLabel.setBounds(410, 33, 155, 45);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 308, 431);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 160, 122));
		panel_1.setBounds(0, 0, 308, 431);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel icon = new JLabel("�con");
		int i_width=285;
		int i_height=190;
		try {
			InputStream is = ViewLogin.class.getResourceAsStream("/cine.png");
			BufferedImage img = ImageIO.read(is);
			
			icon.setIcon(new ImageIcon(cropImage( img,i_width,i_height)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		icon.setBounds(52, 94, i_width, i_height);
		panel_1.add(icon);
		
		JLabel lblNewLabel_1 = new JLabel("ROLE :");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setBackground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblNewLabel_1.setBounds(353, 125, 70, 26);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("USER ID :");
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setBounds(353, 183, 70, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD :");
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblNewLabel_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_3.setBounds(339, 241, 109, 26);
		getContentPane().add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnNewRadioButton.setBackground(new Color(255, 160, 122));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		rdbtnNewRadioButton.setBounds(458, 273, 103, 21);
		getContentPane().add(rdbtnNewRadioButton);
		
		/////////////////////////
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(field_mail.getText()+"/"+field_pass.getText()+"/"+Main.ifLoginned(field_mail.getText(), field_pass.getText()));
				if( Main.ifLoginned(field_mail.getText(), field_pass.getText())) {
					
					new ViewMenu(Main.userManager.get(field_mail.getText()));
					setVisible(false);
					dispose();
				}
				
				
			}
		});
		btnNewButton.setBounds(550, 316, 85, 21);
		getContentPane().add(btnNewButton);
		//////////////////////////////
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				if(comboBox.getSelectedIndex()==0) {
					ViewAdminBoard board =new ViewAdminBoard();
					board.addWindowListener(listener);
				}
				else if(comboBox.getSelectedIndex()==1) {
					ViewUserBoard board =new ViewUserBoard();
					board.addWindowListener(listener);
				}
			}
			
			
		});
		btnNewButton_1.setBounds(469, 316, 71, 21);
		getContentPane().add(btnNewButton_1);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		setVisible(true);
	}
	public static Image cropImage(Image bufferedImage,int width, int height){
		 return bufferedImage.getScaledInstance(width, height,Image.SCALE_DEFAULT);
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
