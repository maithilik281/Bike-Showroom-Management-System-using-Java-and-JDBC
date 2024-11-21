import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;
import java.lang.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class bikes extends Frame implements ActionListener,ItemListener
{
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement ps;
	Label l1,l2,l3,l4,l5,l6,l8,l9,l10,l11;
	TextField t1,t2,t3,t4,t5;
	Choice c;
	Button b1,b2,b3,b4,b5;
	int k,amno,aqty,aprize;
	String amname,acolor;
	Font f1;
	public bikes()
	{
	super("Bikes  Form");
	
	f1=new Font("Arial",Font.BOLD,18);
    setFont(f1);
      setBackground(Color.orange);
    setForeground(Color.black);
	
		setSize(800,700);
	
		setLayout(null);
		setVisible(true);
		c=new Choice();
		l1=new Label("Enter Bikes Number");
		l2=new Label("Enter Bikes Number");
		l3=new Label("Enter Bikes Name");
		l4=new Label("Enter Bikes Color");
		l5=new Label("Enter Bikes quanty");
		l6=new Label("Enter Bikes Prize");
		
		l8=new Label("Bikes Details Form");
		l9=new Label("_____________________");
		l11=new Label("Today's :-");
		
		t1=new TextField();
		t2=new TextField();
	    t3=new TextField();
		t4=new TextField();
	
		t5=new TextField();
		
		
	
		b1=new Button("Save");
		b2=new Button("Update");
		b3=new Button("Delete");
		b4=new Button("Clear");
		b5=new Button("Exit");
		
		l1.setBounds(80,180,250,30);
		l2.setBounds(80,230,250,30);
		l3.setBounds(80,280,250,30);
		l4.setBounds(80,330,250,30);
		l5.setBounds(80,380,250,30);
		l6.setBounds(80,430,250,30);
		
		l8.setBounds(250,50,340,50);
		l9.setBounds(250,64,300,50);
		l8.setForeground(new Color(255, 00, 10));
		l8.setFont(new Font("Comic Sans MS",Font.ITALIC ,28));
		l9.setFont(new Font("Comic Sans MS",Font.ITALIC ,25));
		l9.setForeground(new Color(255, 00, 10));
		l11.setBounds(600,40,80,50);
		
		c.setBounds(340,180,200,30);
		t1.setBounds(340,230,200,30);
		t2.setBounds(340,280,200,30);
		t3.setBounds(340,330,200,30);
		t4.setBounds(340,380,200,30);
	    t5.setBounds(340,430,200,30);
		
		
	
		
		b1.setBounds(80,550,80,50);
		b1.setBackground(Color.white);
		b2.setBounds(200,550,80,50);
		b2.setBackground(Color.white);
		b3.setBounds(320,550,80,50);
		b3.setBackground(Color.white);
		b4.setBounds(440,550,80,50);
		b4.setBackground(Color.white);
	    b5.setBounds(560,550,80,50);
		b5.setBackground(Color.white);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		
		add(l8);
        add(l9);
        add(l11);
		
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(c);
		add(t5);
		
	
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		
		
		c.addItemListener(this);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		String strdate;
	    Date date;
	    GregorianCalendar cal;
	    date=new Date();
	    cal=new GregorianCalendar();
	    strdate=cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+(cal.get(Calendar.YEAR));
	    l10=new Label(strdate);
	    add(l10);
	    l10.setBounds(680,40,80,50);
	      try
        {
        		
	   				Class.forName("com.mysql.cj.jdbc.Driver");
			        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RR","root","root");
			        st=con.createStatement();
			        rs=st.executeQuery("select * from bikes");
			        
			       while( rs.next())
			       {
			        c.add(rs.getString("mno"));
			       }
			       con.close();
	    }
	    catch(Exception obj)
	    {
	    	System.out.println(obj);
	    }
	
	}
	
	
	public void itemStateChanged(ItemEvent e)
	{
      		String str=c.getSelectedItem();
         	int n=Integer.parseInt(str);
    		try
    		{
    			Class.forName("com.mysql.cj.jdbc.Driver");
			    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RR","root","root");
			    st=con.createStatement();
    			rs=st.executeQuery("select * from bikes where mno="+n);
    			rs.next();
    			t1.setText(rs.getString("mno"));
			    t2.setText(rs.getString("mname"));
			    t3.setText(rs.getString("color"));
			    t4.setText(rs.getString("qty"));
			    t5.setText(rs.getString("prize"));
			
			}
			catch(Exception en)
			{
			}
}
	
	
	public void actionPerformed(ActionEvent e)
	{
	
		String str=e.getActionCommand();
		if(str.equals("Exit"))
		{
			setVisible(false);
			main m=new main();
		}
		if(str.equals("Clear"))
			{
				t1.setText(" ");
				t2.setText(" ");
				t3.setText(" ");
				t4.setText(" ");
				t5.setText(" ");
				
			}
		        
		try
		{
			    Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RR","root","root");
				st=con.createStatement();
			if(str.equals("Save"))
			{
				
			    //String strr=" ";
			    //strr=" "+c.getSelectedItem();
			    amno=Integer.parseInt(t1.getText());
	            amname=t2.getText();
	            acolor=t3.getText();
	            aqty=Integer.parseInt(t4.getText());
	            aprize=Integer.parseInt(t5.getText());
	            
				String str1="insert into bikes values("+amno+",'"+amname+"',"+acolor+","+aqty+","+aprize+")";
				int k=st.executeUpdate(str1);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null,"Record is added Successfuly ");
				}
				con.close();
			}
			if(str.equals("Update"))
			{  
					
			    //String strr=" ";
			    //strr=" "+c.getSelectedItem();
			    //mno=Integer.parseInt(t1.getText());
	            amname=t2.getText();
	            //color=t3.getText();
	            aqty=Integer.parseInt(t4.getText());
	            //prize=Integer.parseInt(t5.getText());
				String str2="Update bikes set qty="+aqty+" where mname='"+amname+"'";
				int k=st.executeUpdate(str2);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null,"Record Updated Successfuly ");
				}
				con.close();
			}
			if(str.equals("Delete"))
			{
				
				amno=Integer.parseInt(t1.getText());
				String str3="Delete from bikes where mno="+amno+"";
				int k=st.executeUpdate(str3);
				if(k>0)
				{
				   JOptionPane.showMessageDialog(null,"Record Deleted Successfuly ");
				}
				con.close();
			}
		}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			
				
			
		}
		public static void main(String args[])
		{
			bikes b=new bikes();
			b.show();
		}
	}
			
				
				
			
		
	
		