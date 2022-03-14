package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewCancelTicket extends JFrame{

	private JComboBox comboBox;
	
	public ViewCancelTicket() {
		initialize();
	}

	private String seatNo;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 532, 392);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(0, 0, 518, 355);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CANCEL TICKET");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 23));
		lblNewLabel.setBounds(165, 10, 185, 51);
		panel.add(lblNewLabel);
		
		final JFrame frame = this;
		final JButton buttonBook = new JButton("cancel Ticket");
		buttonBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ticket t;
				if(!ViewMenu.client.isAdmin())t=ViewMenu.client.getUserTickets().get(comboBox.getSelectedIndex());
				else t=Main.movieManager.getAllTicket().get(comboBox.getSelectedIndex());
				t.getHall().returnTicket(t);
				setVisible(false);
				dispose();
				Main.movieManager.save();
			}
		});
		buttonBook.setBounds(209, 304, 85, 21);
		panel.add(buttonBook);
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(25, 56, 459, 21);
		setComboBox(getTicketData());
		
		panel.add(comboBox);
	}
	
	
	private String[] getTicketData() {
		MyQueue<Ticket> list ;
		if(!ViewMenu.client.isAdmin()) {
			list =ViewMenu.client.getUserTickets();
			
		}else {
			list = Main.movieManager.getAllTicket();
		}
		String[] data = new String[list.size()];
		for(int i=0;i<data.length;i++) {
			Ticket h = list.get(i);
			data[i]=(ViewMenu.client.isAdmin()?h.getUser().getName()+" / ":"")+h.getMovie().getName()+" / "+h.getHallID()+" / "+h.getSeat()+" / "+h.getPrice(h.getUser().getAge())+" / "+h.getHall().getDate().toString();
		}
		return data;
	}
	
	private void setComboBox(String[] str) {
		comboBox.setModel(new DefaultComboBoxModel(str));
	}
}
