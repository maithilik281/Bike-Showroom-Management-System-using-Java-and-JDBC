import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class customer extends Frame implements ItemListener,ActionListener
{
	
	static Connection cn;
	
	static Statement st;
	static ResultSet rs;
	
	
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
	TextField t1,t2,t3,t4;
	Button b1,b2,b3,b4,b5;
    Choice c;
	
	int k,cno,cmob;
	
	String cname,cadd;
     
	public customer()
	{
		super("Customer  Form");
		setSize(800,700);
		setLayout(null);
		setVisible(true);
		c=new Choice();
		l1=new Label("Enter Customer Number");
		l2=new Label("Enter Customer Name");
		l3=new Label("Enter Customer Address");
		l4=new Label("Enter Mobile Number");
		
		l5=new Label("Customer Details Form");
		l7=new Label("_______");
		l8=new Label("Today's Date:-");
		l9=new Label("Customer No.");
		
		t1=new TextField();
		t2=new TextField();
	    t3=new TextField();
        t4=new TextField();
		
	
		b1=new Button("Save");
		b2=new Button("Update");
		b3=new Button("Delete");
		b4=new Button("Clear");
		b5=new Button("Exit");
		
		l1.setBounds(50,90,100,30);
		l9.setBounds(160,90,100,30);
		l2.setBounds(50,130,100,30);
		l3.setBounds(160,130,100,30);
		l4.setBounds(50,170,100,30);
		
		l5.setForeground(new Color(255, 00, 10));
		l5.setFont(new Font("Comic Sans MS",Font.ITALIC ,28));
		l6.setFont(new Font("Comic Sans MS",Font.ITALIC ,25));
		l6.setForeground(new Color(255, 00, 10));
		l7.setBounds(600,40,80,50);
		
		
		t1.setBounds(340,180,200,30);
		t2.setBounds(340,230,200,30);
		t3.setBounds(340,280,200,30);
		t4.setBounds(340,330,200,30);
		
		c.setBounds(160,50,100,30);
		
		
		
		b1.setBounds(80,550,80,50);
		b2.setBounds(200,550,80,50);
		b3.setBounds(320,550,80,50);
		b4.setBounds(440,550,80,50);
	    b5.setBounds(560,550,80,50);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		
		
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		
		
		add(c);
		
	
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
	
		

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
	    l7=new Label(strdate);
	    add(l7);
	    l7.setBounds(680,40,80,50);
	
        
        
         try
        {
        		
	   				Class.forName("com.mysql.jdbc.Driver");
			        cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rr","root","root");
			        st=cn.createStatement();
			        rs=st.executeQuery("select * from customer");
			        
			       while( rs.next())
			       {
			        c.add(rs.getString("cno"));
			       }
			       cn.close();
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
    			Class.forName("com.mysql.jdbc.Driver");
			    cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/RR","root","root");
			    st=cn.createStatement();
    			rs=st.executeQuery("select * from customer where cno="+n);
    			rs.next();
    			t1.setText(rs.getString("cname"));
			    t2.setText(rs.getString("cadd"));
			    t3.setText(rs.getString("cmob"));
			    
			
			}
			catch(Exception en)
			{
					System.out.println(en);	
			}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String str1=e.getActionCommand();		
						
			if(str1.equals("Exit"))
		{
			setVisible(false);
			main m=new main();
			m.setVisible(true);
		}	
			try
			{
		       	Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/RR","root","root");
				st=cn.createStatement();
			
				if(str1.equals("Save"))
		      {
			
				int cuno,cumob;
				String cuname,cuadd;
			    cuno=Integer.parseInt(t4.getText());
				cuname=t1.getText();
				cuadd=t2.getText();
				cumob=Integer.parseInt(t3.getText());
			
			    
				String str2="insert into customer values("+cuno+",'"+cuname+"','"+cuadd+"',"+cumob+")"; 
				k=st.executeUpdate(str2);
				
					if(k>0)
					{
					   JOptionPane.showMessageDialog(null,"Record Added Successfuly ");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"General Exception ");
					}
				}
				if(str1.equals("Update"))
				{
				
				String strr=" ";
			    strr=" "+c.getSelectedItem();
				cname=t1.getText();
				cadd=t2.getText();
				cmob=Integer.parseInt(t3.getText());
				
				
				String str3="update customer set name='"+cname+"',add='"+cadd+"',mobileno="+cmob+",cno="+c.getSelectedItem()+" where custno="+c.getSelectedItem();
				int k=st.executeUpdate(str3);
				
				if(k>0)
				{
					 JOptionPane.showMessageDialog(null,"Record Update Successfuly ");
				}
			  }
			  if(str1.equals("Delete"))
			  {
			  	
				String strr=" ";
			    strr=" "+c.getSelectedItem();
				String str4="Delete from customer where custno="+c.getSelectedItem();
				int k=st.executeUpdate(str4);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null,"Record Deleted Successfuly ");
				}
			 }

					
			
		}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			       
			
			            
			if(str1.equals("Clear"))
			{
				t1.setText(" ");
				t2.setText(" ");
				t3.setText(" ");
				
             }
	       
}			
 public static void main(String args[])
{
  customer c= 	new customer();
  c.show();
 }
}