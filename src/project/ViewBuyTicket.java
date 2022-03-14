package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ViewBuyTicket extends JFrame{

	
	private JComboBox comboBox;
	
	public ViewBuyTicket() {
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
		
		JLabel lblNewLabel = new JLabel("BOOK TICKET");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 23));
		lblNewLabel.setBounds(165, 10, 185, 51);
		panel.add(lblNewLabel);
		
		final JFrame frame = this;
		final JButton buttonBook = new JButton("Book Ticket");
		buttonBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final HallInfo hall =Main.movieManager.getAllMovieHalls().get(comboBox.getSelectedIndex());
				hall.buyTicket(ViewMenu.client, seatNo);
				frame.setVisible(false);
				frame.dispose();
				Main.movieManager.save();
			}
		});
		buttonBook.setEnabled(false);
		buttonBook.setBounds(209, 304, 85, 21);
		panel.add(buttonBook);
		
		 JButton buttonSeat = new JButton("Select Seat");
		buttonSeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				final HallInfo hall =Main.movieManager.getAllMovieHalls().get(comboBox.getSelectedIndex());
				
				ViewSeat seat=new ViewSeat(hall);
				
				seat.setSeatListener(new ViewSeat.SeatListener() {
					
					@Override
					public void onSeatSelected(String seat) {
						seatNo=seat;
						buttonBook.setEnabled(true);
					}
				});
			}
		});
		buttonSeat.setEnabled(true);
		buttonSeat.setBounds(209, 150, 85, 21);
		panel.add(buttonSeat);
		
		comboBox = new JComboBox();
		comboBox.setBounds(25, 56, 459, 21);
		setComboBox(getMovieData());
		
		panel.add(comboBox);
	}
	
	
	private String[] getMovieData() {
		MyQueue<HallInfo> list =Main.movieManager.getAllMovieHalls();
		String[] data = new String[list.size()];
		for(int i=0;i<data.length;i++) {
			HallInfo h = list.get(i);
			data[i]=h.getMovie().getName()+" / "+h.getHallID()+" / "+h.getDate().toString();
		}
		return data;
	}
	
	private void setComboBox(String[] str) {
		comboBox.setModel(new DefaultComboBoxModel(str));
	}
}
