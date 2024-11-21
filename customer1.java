import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.lang.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class customer1 extends Frame implements ActionListener,ItemListener
{
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement ps;
	Label l1,l2,l3,l4,l5,l6,l8,l9,l10,l11,l7;
	TextField t1,t2,t3,t4,t5,t6;
	Choice c;
	Button b1,b2,b3,b4,b5;
	int k,ccno,cmobileno;
	String cname,cemail,cadd,cstate;
	Font f1;
	Icon img1=new ImageIcon("sh.jpg");
    JLabel l12;	  	
	public customer1()
	{
	super("Customer  Form");
	
	
	f1=new Font("Arial",Font.BOLD,18);
    setFont(f1);
      setBackground(Color.pink);
    setForeground(Color.black);
	
		setSize(800,700);
		setLayout(null);
		setVisible(true);
			 l12=new JLabel(img1);
      //  l9.setBounds(10,10,100,100);
       	add(l12);
		c=new Choice();
		l1=new Label("Enter Customer Number");
		l2=new Label("Enter customer no");
		l3=new Label("Enter Customer Name");
		l4=new Label("Enter Customer Address");
		l5=new Label("Enter Mobile Number");
		l6=new Label("Enter Customr  email");
		l7=new Label("Enter state name");
		
		
		l8=new Label("Customer Details Form");
		l12.add(l8);
		l9=new Label("_____________________");
		l11=new Label("Today's :-");

        
		t1=new TextField();
		t2=new TextField();
	    t3=new TextField();
		t4=new TextField();
		t5=new TextField();
		
		t6=new TextField();
		
	
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
		l6.setBounds(80,430,200,30);
		l7.setBounds(80,480,180,30);
		
		l8.setBounds(250,50,350,50);
		l9.setBounds(250,64,280,50);
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
	    t6.setBounds(340,480,200,30);
	    
		
		
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
		add(l7);
		
		add(l8);
        add(l9);
        add(l11);
	
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(c);
		add(t5);
		
		add(t6);
		
	
		
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
	    l10.setBounds(680,40,90,50);
	      try
        {
        		
	   				Class.forName("com.mysql.cj.jdbc.Driver");
			        con=DriverManager.getConnection("\"jdbc:mysql://localhost:3306/RR","root","root");
			        st=con.createStatement();
			        rs=st.executeQuery("select * from customer");
			        
			       while( rs.next())
			       {
			        c.add(rs.getString("cno"));
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
			    con=DriverManager.getConnection("\"jdbc:mysql://localhost:3306/RR","root","root");
			    st=con.createStatement();
    			rs=st.executeQuery("select * from customer where cno="+n);
    			rs.next();
    			t1.setText(rs.getString("cno"));
    			t2.setText(rs.getString("name"));
			    t3.setText(rs.getString("add"));
			    t4.setText(rs.getString("mobileno"));
			    t5.setText(rs.getString("email"));
			    t6.setText(rs.getString("state"));
			
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
				t6.setText(" ");
			}
		        
		try
		{
			    Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("\"jdbc:mysql://localhost:3306/RR","root","root");
				st=con.createStatement();
			if(str.equals("Save"))
			{
				
			    //String strr=" ";
			    //strr=" "+c.getSelectedItem();
			    int ctcno=Integer.parseInt(t1.getText());
			    cname=t1.getText();
	            cadd=t2.getText();
	            cmobileno=Integer.parseInt(t3.getText());
	            cemail=t4.getText();
	            cstate=t5.getText();
	            
				String str1="insert into customer values("+ctcno+",'"+cname+"','"+cadd+"',"+cmobileno+",'"+cemail+"','"+cstate+"')";	
				
				
				
				
				int k=st.executeUpdate(str1);
				
				
				
				if(k>0)
				{
					JOptionPane.showMessageDialog(null,"Record is added");
					
				//JOptionPane.showMessageDialog(this,"login succssfully","Input Box",JOptionPane.INFORMATION_MESSAGE);//
				
		    	}
				con.close();
			}
			if(str.equals("Update"))
			{
			    //String strr=" ";
			    //strr=" "+c.getSelectedItem();
			    cname=t1.getText();
	            //cadd=t2.getText();
	            cmobileno=Integer.parseInt(t3.getText());
	            //cemail=t4.getText();
	            //cstate=t5.getText();
	            
				String str2="Update customer set mobileno="+cmobileno+" where name='"+cname+"'";
				int k=st.executeUpdate(str2);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null,"Record Updated Successfuly ");
				}
				con.close();
			}
			if(str.equals("Delete"))
			{
				
				cname=t2.getText();
				String str3="Delete * from customer where name='"+cname+"'";
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
			customer1 c=new customer1();
			c.show();
		}
	}
			
				
				
			
		
	
		