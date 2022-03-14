package project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewMenu extends JFrame {


                    
    private JButton button_hall;
    private JButton button_ticket;
    private JButton button_movie;
    private JButton button_profile;
    private JButton button_king;
    private JScrollPane jScrollPane1;
    private JTable jTable1;         
	
    public static User client;
    
    private int menu_current=2; // 0=hall / 1=ticket / 2=movie / 3=profile
    
    private static final int menu_hall=0;
    private static final int menu_ticket=1;
    private static final int menu_movie=2;
    private static final int menu_profile=3;
    
    
    
    public ViewMenu(User client) {
        this.client=client;
        initComponents();
        //ShowData();
        loadMenu();
    }
    
    private void loadMenu() {
    	
    	if(menu_current == menu_hall) {
    		ShowData(new String[] {"Hall ID","Capacity"}, getHallData());
			//if(client.isAdmin())button_king.setText("Add Hall");
    		button_king.setText("add hall");
    	}else if(menu_current == menu_ticket) {
    		if(client.isAdmin())ShowData(new String[] {"Mail","Movie Name","Hall ID","Price","Seat"}, getTicketData_Admin());
    		else ShowData(new String[] {"Mail","Movie Name","Hall ID","Price","Seat"}, getTicketData_User(client.getMail()));
			button_king.setText("Cancel");
    	}else if(menu_current == menu_movie) {
    		ShowData(new String[] {"Movie Name","Genre","Lenght","Hall ID","Date","Price"}, getMoviesData());
    		if(client.isAdmin())
    			button_king.setText("Add Movie");
    		else 
    			button_king.setText("Buy Ticket");
    	}
    }
    private String[][] getTicketData_Admin(){ // ALL TICKETS
    	MyQueue<Ticket> list = Main.movieManager.getAllTicket();
    	String[][] data = new String[list.size()][5];
    	for(int i=0;i<data.length;i++) {
    		Ticket t = list.get(i);
    		data[i][0]=t.getUser().getName();
    		data[i][1]=t.getMovie().getName();
    		data[i][2]=t.getHallID()+"";
    		data[i][3]=t.getPrice(t.getUser().getAge())+"";
    		data[i][4]=t.getSeat();
    	}
    	return data;
    }
    private String[][] getTicketData_User(String user_mail){
    	String[][] data = new String[Main.userManager.get(user_mail).getUserTickets().size()][5];
    	//System.out.println(data.length);
    	for(int i=0;i<data.length;i++) {
    		Ticket t = Main.userManager.get(user_mail).getUserTickets().get(i);
    		data[i][0]=t.getUser().getName();
    		data[i][1]=t.getMovie().getName();
    		data[i][2]=t.getHallID()+"";
    		data[i][3]=t.getPrice(t.getUser().getAge())+"";
    		data[i][4]=t.getSeat();
    	}
    	return data;
    
    }
    private String[][] getHallData(){
    	String[][] data = new String[Main.hallManager.getList().size()][2]; // [SALON SAYISI][ID VE KAPASITE]
    	for(int i=0;i<data.length;i++) {
    		Hall targetHall=Main.hallManager.getList().get(i);
    		data[i][0]=targetHall.getID()+"";
    		data[i][1]=(targetHall.getSize()[0]*targetHall.getSize()[1])+"";// X ve Y �arp�l�r
    	}
    	//System.out.println(Main.hallManager.getHallList().size());
    	return data;
    }
    private String[][] getMoviesData(){
    	MyQueue<HallInfo> list = Main.movieManager.getAllMovieHalls();
    	String[][] data = new String[list.size()][6];
    	for(int i=0;i<data.length;i++) {
    		HallInfo h = list.get(i);
    		data[i][0]=h.getMovie().getName();
    		data[i][1]=h.getMovie().getGenre().toString();
    		data[i][2]=h.getMovie().getLenght()[0]+":"+h.getMovie().getLenght()[1];
    		data[i][3]=h.getHallID()+"";
    		data[i][4]=h.getDate().toString();
    		data[i][5]=h.getMovie().getPrice()+"";
    	}
    	return data;
    	
    }
    
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        button_ticket = new JButton();
        button_hall = new JButton();
        button_movie = new JButton();
        button_profile = new JButton();
        
        if(!client.isAdmin()) {
        	button_hall.setVisible(false);
        }
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        button_ticket.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        button_ticket.setText("Tickets");

        button_hall.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        button_hall.setText("Halls");

        button_movie.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        button_movie.setText("Movies");

        button_profile.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        button_profile.setText("Profile");
        
        
        
        getContentPane().setLayout(new BorderLayout());
        
        JPanel button_panel= new JPanel();
        button_panel.setLayout(new GridLayout(4,1));
        
        button_panel.add(button_hall);
        button_panel.add(button_ticket);
        button_panel.add(button_movie);
        button_panel.add(button_profile);
        
        
        add(button_panel,BorderLayout.WEST);
        
        JPanel table_panel = new JPanel();
        table_panel.setLayout(new BorderLayout());
        add(table_panel);
        
        
        button_king=new JButton("");
        button_king.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(menu_current==menu_movie) {
					if(!client.isAdmin()) {
						new ViewBuyTicket();
					}else {
						new ViewAddMovie();
					}
				}else if(menu_current==menu_ticket) {
					new ViewCancelTicket();
				}else if(menu_current==menu_hall) {
					new ViewAddHall();
				}
				
			}
		});
        
        table_panel.add(jScrollPane1,BorderLayout.CENTER);
        table_panel.add(button_king,BorderLayout.SOUTH);
        // part that makes transactions between different menus
        ActionListener menu_buttons_listener= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equalsIgnoreCase("halls")) {
					if(menu_current!=menu_hall) {
						menu_current=menu_hall;
						loadMenu();
					}
				}else if(b.getText().equalsIgnoreCase("movies")) {
					if(menu_current!=menu_movie) {
						menu_current=menu_movie;
						loadMenu();
						//button_king.setText("Add Movie");
					}
				}else if(b.getText().equalsIgnoreCase("tickets")) {
					if(menu_current!=menu_ticket) {
						menu_current=menu_ticket;
						loadMenu();
					}
				}else if(b.getText().equalsIgnoreCase("profile")) {
					//TODO
				}
			}
		};
        
		button_hall.addActionListener(menu_buttons_listener);
		button_movie.addActionListener(menu_buttons_listener);
		button_ticket.addActionListener(menu_buttons_listener);
		button_profile.addActionListener(menu_buttons_listener);
		

        pack();
    }                       

    public void ShowData(String[] cols,String[][] data)
    {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        model.setDataVector(data, cols);
        jTable1.setEnabled(false);
        
    }
                                     

    private void clearTable() {                                             
        jTable1.setModel(new DefaultTableModel(null,new String[]{"Id","First Name","Last Name","Age"}));

    }                                            

   
}