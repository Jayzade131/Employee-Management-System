import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Pro1 {
		static void tableUi()
		{
			String[] columnNames = {"roll", "name", "city"};
	       JTable table;
			JFrame	frame1 = new JFrame("Database Search Result");

	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame1.setLayout(new BorderLayout());
	 DefaultTableModel model = new DefaultTableModel();

	        model.setColumnIdentifiers(columnNames);
	       table = new JTable();

	        table.setModel(model);

	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

	        table.setFillsViewportHeight(true);

	        JScrollPane scroll = new JScrollPane(table);

	        scroll.setHorizontalScrollBarPolicy(

	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	        scroll.setVerticalScrollBarPolicy(

	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

	        String rollno="" ;       
	        String name = "";
	        String city = "";
	        
	        try {
	  Connection con=Connnect.BuildConnection();
	          PreparedStatement  pst = con.prepareStatement("SELECT * FROM Schooldb.info");

	            ResultSet rs = pst.executeQuery();

	            int i = 0;

	            while (rs.next()) 
	            {
	            	rollno = rs.getString(1);
	                
	            	name = rs.getString(2);

	                city = rs.getString(3);

	                model.addRow(new Object[]{rollno, name,  city});

	                i++;

	            }

	            if (i < 1) {

	                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

	            }

	            if (i == 1) {

	                System.out.println(i + " Record Found");

	            } 

	        } catch (Exception ex) {

	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

	        }

	        frame1.add(scroll);

	        frame1.setVisible(true);

	        frame1.setSize(500, 500);

	}
			   
	       
	
	
	public static void main(String[] args) {
		JFrame f=new JFrame("STUDENT MANAGEMENT SYSTEM");
		f.setSize(1000,1000);

		JLabel l1=new JLabel("ROLL NO :");
		l1.setBounds(100,100,100,45);
		f.add(l1);
		JTextField t1=new JTextField();
		t1.setBounds(200,100,100,45);
		f.add(t1);

		JLabel l2=new JLabel("NAME :");
		l2.setBounds(100,180,100,45);
		f.add(l2);
		JTextField t2=new JTextField();
		t2.setBounds(200,180,100,45);
		f.add(t2);

		JLabel l3=new JLabel("CITY :");
		l3.setBounds(100,250,100,45);
		f.add(l3);
		JTextField t3=new JTextField();
		t3.setBounds(200,250,100,45);
		f.add(t3);

		JButton b1=new JButton("INSERT");
		b1.setBounds(190,350,100,40);
		b1.setBackground(Color.green);
		f.add(b1); 

		JButton b2=new JButton("SEARCH");
		b2.setBounds(310,350,100,40);
		b2.setBackground(Color.orange);
		f.add(b2);

		JButton b3=new JButton("UPDATE");
		b3.setBounds(430,350,100,40);
		b3.setBackground(Color.yellow);
		f.add(b3);

		JButton b4=new JButton("DELETE");
		b4.setBounds(550,350,100,40);
		b4.setBackground(Color.pink);
		f.add(b4);
		JButton b5=new JButton("SHOW");
		b5.setBounds(670 ,350,100,40);
		b5.setBackground(Color.red);
		f.add(b5);
		f.setLayout(null);
		f.setVisible(true);
        
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				int x1=Integer.parseInt(t1.getText());
				String x2=t2.getText();
				String x3=t3.getText();
				int b=Insert.insertdata(x1,x2,x3);
				if(b>0)
				{
					JOptionPane.showMessageDialog(f,"Data Insert Successfully");
				}
			}
			catch(ClassNotFoundException | SQLException e1){
				e1.printStackTrace();	
			}	
			}	
		});
		
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try{
					int x4=Integer.parseInt(t1.getText());
					 Search se=Search.searchData(x4);
					 t2.setText(se.getName());
					 t3.setText(se.getCity());
					
				}
				catch(ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
			}
		});
		b3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
              try{
            	  int y1=Integer.parseInt(t1.getText()); //roll
            	  String y2=t2.getText();  //name
            	  String y3=t3.getText();   //city
            	  int z=Updatee.updateData(y1, y2, y3);
            	  if(z>0)
  				{
  					JOptionPane.showMessageDialog(f,"Data updated Successfully");
  				}
            	  }
              catch(ClassNotFoundException | SQLException e)
              {
            	  e.printStackTrace();
              }
              
			}
		});
		b4.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				try{
				     int y4=Integer.parseInt(t1.getText());
				 int z1=Delete.deleteData(y4);
				 if(z1>0)
	  				{
	  					JOptionPane.showMessageDialog(f,"Data Deleted Successfully");
	  				}
				}
				catch(ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
			}
		});
		b5.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				Pro1.tableUi();
				
			
				
			}
		});
		 
	

	}

}
