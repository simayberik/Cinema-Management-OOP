package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewSeat extends JFrame implements ActionListener{

	private SeatListener listener;
	private HallInfo hall;
	
	public SeatListener getSeatListener() {
		return listener;
	}
	public void setSeatListener(SeatListener listener) {
		this.listener = listener;
	}
	
	// MOVIE 
	public ViewSeat(HallInfo hall) {
		setLayout(new BorderLayout());
		this.hall=hall;
		

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		JPanel panel = new JPanel();
		add(panel);
		
		int[] size = hall.getHall().getSize();
		
		panel.setLayout(new GridLayout(size[0],size[1]));
		
		Random rand = new Random();
		
		for(int y=0;y<size[1];y++) {
			for(int x=0;x<size[0];x++) {
				String s=getIntToChar(y)+""+x;
				JButton button=new JButton(s);
				button.addActionListener(this);
				boolean available=isSeatAvailable(s);
				
				button.setBackground(available?seatAvailable():seatTaken());
				button.setEnabled(available);
				panel.add(button);
				
			}
		}
		
		setSize(100*size[1]	, 100*size[0]);
	}
	private boolean isSeatAvailable(String seat) {
		for(Ticket t : hall.getTickets()) {
			if(t.getSeat().equalsIgnoreCase(seat))return false;
		}
		return true;
	}
	private static Color seatAvailable() {
		return new Color(100, 250, 110);
	}
	private static Color seatTaken() {
		return new Color(255,110,100);
	}
	
	public static char getIntToChar(int a) {
		return (char)(a+97);
	}
	public static int getCharToInt(int a) {
		return (a-97);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(listener!=null)
			listener.onSeatSelected(((JButton)e.getSource()).getText());
		setVisible(false);
		dispose();
	}
	
	public interface SeatListener{
		void onSeatSelected(String seat);
	}
	
}
