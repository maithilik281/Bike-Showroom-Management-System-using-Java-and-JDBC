import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.awt.print.*;
import java.util.GregorianCalendar;
public class cbill extends JFrame implements ActionListener,ItemListener,Printable
{
	
    JPanel p1,p2,p3,p4,p5;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,lcno,ldt;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1,b2,b3,b4,b5,b6;   
    Font f,f1,f2,f3,f4;	
    Choice c1,c2;	
    PreparedStatement pstat,pstat1;
    Date d;	 	  	
 	Connection cn;
    Statement st;
    ResultSet rs,rs1,rs2,rs3,rs4,rs9;    
    String cname,mmname;		
    Icon img;		
    public cbill() 
    {
    
    
    	setVisible(true);
    	//setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
    //	setSize(800,720);
    //	setDefaultCloseOperation(EXIT_ON_CLOSE); 
    	setLayout(null);	
    	setTitle("Customer Bill Details");
    		
    	l1=new JLabel("Bill No");
    	l2=new JLabel("Customer Name");
        l3=new JLabel("Model No");
        l4=new JLabel("Model Name");
       
        l5=new JLabel("Total");
        
        l6=new JLabel("Model  Quantity");
       lcno=new JLabel("Customer No.");
        ldt=new JLabel("Date");
        l7=new JLabel("Model Prize");
        
        l8=new JLabel("Customer Bill");
        f3=new Font("Modern No. 20",Font.BOLD,60);
        l8.setBounds(500,5,570,80);
        add(l8);
        l8.setFont(f3);
        l8.setForeground(Color.RED);
        
        
        
         l1.setForeground(Color.BLUE);
        l2.setForeground(Color.BLUE);
        l3.setForeground(Color.BLUE);
        l4.setForeground(Color.BLUE);
        l5.setForeground(Color.BLUE);
        l6.setForeground(Color.BLUE);
        l7.setForeground(Color.BLUE);
        lcno.setForeground(Color.BLUE);
        ldt.setForeground(Color.BLUE);
        
       	t1=new JTextField();
    	t2=new JTextField();
    	t3=new JTextField();
    	t4=new JTextField();
    	t5=new JTextField();
    	t6=new JTextField();
    	t7=new JTextField();
    	t8=new JTextField();
    
    	
    	
    	c1=new Choice();
    	c2=new Choice();
    				
    	b1=new JButton("NEW BILL");
        b2=new JButton("SAVE BILL");
        b3=new JButton("EXIT");
        b4=new JButton("GO BACK");  
        b5=new JButton("Total");  
         b6=new JButton("Print");
         
        b1.setBounds(50,500,100,40);
        add(b1);
        b2.setBounds(180,500,100,40);
        add(b2);
        b3.setBounds(50,540,100,40);
        add(b3);
        b4.setBounds(180,540,100,40);
        add(b4);  
        b6.setBounds(300,500,100,40);
        add(b6);
        b5.setBounds(300,540,100,40);
        add(b5);
        
        	
    	p1=new JPanel();
      	p2=new JPanel();	
    	p3=new JPanel();
    	p4=new JPanel();
    	p5=new JPanel();
    		
    	p1.setVisible(true);
    	p1.setSize(100,600);
    	p1.setLayout(null);
    	p1.setBorder(BorderFactory.createLineBorder(Color.black,2));
        p1.setBounds(20,20,480,230);
    	p1.setBorder(BorderFactory.createTitledBorder("Customer Details"));
    	add(p1);
    	
        f=new Font("Modern No. 20",Font.BOLD,50);
        f1=new Font("Modern No. 20",Font.BOLD,20);
        		
    	l1.setBounds(20,40,150,50);
    	l1.setFont(f1);
    	p1.add(l1);	
    	l2.setBounds(20,100,150,50);
        l2.setFont(f1);    	
    	p1.add(l2);	
    	
    	lcno.setBounds(20,160,150,50);
    	lcno.setFont(f1);
    	p1.add(lcno);	
    		
    	l7.setBounds(320,20,150,50);
    	l7.setFont(f1);
    	p3.add(l7);	
    	
    	t1.setBounds(240,40,100,40);
    	p1.add(t1);	
    	c1.setBounds(240,100,150,40);
    	p1.add(c1);		
    	t3.setBounds(240,160,100,40);
    	p1.add(t3);		
    		
    	p3.setVisible(true);
    //	p3.setSize(100,600);
    	p3.setLayout(null);
    	p3.setBorder(BorderFactory.createLineBorder(Color.black,2));
    	p3.setBounds(20,250,900,150);
    	p3.setBorder(BorderFactory.createTitledBorder("Bikes Details"));
    	add(p3);	
    		
    	l5.setBounds(680,20,150,50);
    	l5.setFont(f1);
    	p3.add(l5);
    	
    	l4.setFont(f1);
    	p3.add(l4);						
    	l4.setBounds(20,20,150,50);		
    	l3.setBounds(180,20,150,50);
    	l3.setFont(f1);
    	p3.add(l3);	
    	l6.setBounds(470,20,200,50);
    	l6.setFont(f1);
    	p3.add(l6);	
    	ldt.setBounds(790,20,200,50);
    	ldt.setFont(f1);
    	p3.add(ldt);	
    	
    	c2.setBounds(20,80,140,40);
    	p3.add(c2);	
    	t4.setBounds(170,80,100,40);
    	p3.add(t4);				
    	t5.setBounds(320,80,100,40);
    	p3.add(t5);	
    	t6.setBounds(470,80,100,40);
    	p3.add(t6);
    	t7.setBounds(650,80,100,40);
    	p3.add(t7);	
    	t8.setBounds(790,80,100,40);
    	p3.add(t8);
    		
    //	p4.setVisible(true);
    //	p4.setSize(100,600);
    //	p4.setLayout(null);
    //	p4.setBorder(BorderFactory.createLineBorder(Color.black,2));
    //	p4.setBounds(600,400,700,250);
    //	p4.setBorder(BorderFactory.createTitledBorder("Purchase Details"));
    //	add(p4);	
    	
    
    /*	t8.setBounds(200,30,100,40);
    	p4.add(t8);
    	t9.setBounds(200,100,100,40);
    	p4.add(t9);
    		
    	l13.setBounds(400,30,200,50);		
    	l13.setFont(f1);
    	p4.add(l13);		
    	l14.setBounds(400,100,200,50);		
    	l14.setFont(f1);
    	p4.add(l14);		
    	t10.setBounds(550,30,100,40);
    	p4.add(t10);
    	t11.setBounds(550,100,100,40);
    	p4.add(t11);
    	b5.setBounds(300,170,100,40);
    	p4.add(b5);
    		
    	p5.setVisible(true);
    //	p5.setSize(100,600);
    	p5.setLayout(null);
    	p5.setBorder(BorderFactory.createLineBorder(Color.black,2));
    	p5.setBounds(1100,20,200,60);
    	p5.setBorder(BorderFactory.createTitledBorder("Date Time"));
    	add(p5);	
    	l8.setBounds(10,10,200,50);		
    	l8.setFont(f1);
    	p5.add(l8);		
    	l9.setBounds(10,50,200,50);		
    	l9.setFont(f1);
    //	p5.add(l9);		
    	
    	
    							
        p2.setVisible(true);
        p2.setSize(100,600);
    	p2.setLayout(null);
    	p2.setBorder(BorderFactory.createLineBorder(Color.black,2));
    	p2.setBounds(20,550,580,100);
    	
 		p2.setBorder(BorderFactory.createTitledBorder("Operation"));
    	add(p2);
    	
    	b1.setBounds(10,30,100,40);
    	p2.add(b1);
    		
    	b2.setBounds(150,30,100,40);
    	p2.add(b2);
    		
    	b3.setBounds(300,30,100,40);
    	p2.add(b3);
    		
    	b4.setBounds(450,30,100,40);
    	p2.add(b4);*/
    	
    	f2=new Font("Modern No. 20",Font.BOLD,20);
    	f4=new Font("Modern No. 20",Font.BOLD,15);
    	t1.setFont(f2);
    	t2.setFont(f2);
        t3.setFont(f2);
    	t4.setFont(f2);
    	t5.setFont(f2);
    	t6.setFont(f2);
    	t7.setFont(f2);
    	t8.setFont(f2);
        
    	c1.setFont(f4);
    	c2.setFont(f4);
    	
    		
    	b1.setForeground(Color.RED);
        b2.setForeground(Color.RED);
       	b3.setForeground(Color.RED);
        b4.setForeground(Color.RED);
       	b5.setForeground(Color.RED);
    	
    	t1.setForeground(Color.MAGENTA);
    	t3.setForeground(Color.MAGENTA);
    	t4.setForeground(Color.MAGENTA);
    	t5.setForeground(Color.MAGENTA);
    	t6.setForeground(Color.MAGENTA);
    	t7.setForeground(Color.MAGENTA);
    	t8.setForeground(Color.MAGENTA);
    
    	
    	b1.addActionListener(this);
 	  	b2.addActionListener(this);
 	  	b3.addActionListener(this);
 	  	b4.addActionListener(this);
 	  	b5.addActionListener(this);
 	    b6.addActionListener(this);
 	  	
 	  	
        c1.addItemListener(this);
        c2.addItemListener(this);
    	try
    	{
    		cn=DriverManager.getConnection("\"jdbc:mysql://localhost:3306/RR","root","root");
    	    System.out.println("connection created");
    	    
    	    st=cn.createStatement();
    	    System.out.println("statement created");
    	    
    	   	rs=st.executeQuery("select * from customer");
    		
    		while(rs.next())
    		{
    			c1.addItem(rs.getString(2));
    			
    		}	
    		rs=st.executeQuery("select * from bikes");
    		
    		while(rs.next())
    		{
    			c2.addItem(rs.getString(2));
    			
    		}		
    			
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
        Date date;
	    GregorianCalendar calender;
	    String tdate;
	   	date=new Date();
		calender=new GregorianCalendar();
		calender.setTime(date);
		
		tdate=calender.get(Calendar.DATE)+"/"+(calender.get(Calendar.MONTH)+1)+"/"+calender.get(Calendar.YEAR);
	    t8.setText(tdate);
    	t8.setEnabled(true);	
    			
         b2.setEnabled(true);
    }
   
   public void itemStateChanged(ItemEvent e)
   {
   	 if(e.getSource()==c1)
     	{
			try
			{
				cname= c1.getSelectedItem();
				rs1  = st.executeQuery("select * from customer where name='"+cname+"'"); 
				while(rs1.next())
				{
				
						t3.setText(rs1.getString(1));
						break;
					
				}
				rs1.close();
			}
			catch(Exception ee){}
		}
		if(e.getSource()==c2)
     	{
			try
			{
				mmname= c2.getSelectedItem();
				rs2  = st.executeQuery("select * from product where mname='"+mmname+"'"); 
				while(rs2.next())
				{
						t4.setText(rs2.getString(1));
						t5.setText(rs2.getString(3));
						t6.setText(rs2.getString(6));
						t7.setText(rs2.getString(5));
						break;
					
				}
				rs2.close();
			}
			catch(Exception ee){}
		}
   }
     public void num()
    {
    	int x,z;
    	String y;
    	try
    	{
    		x=Integer.parseInt(t6.getText());
    		y=c2.getSelectedItem();
    		String str="update bikes set qty="+x+" where mname='"+y+"'";
    		st.executeUpdate(str);
    	
    		
    	//	st.executeQuery("update product set pquantity('"+x+"') where pno=(c2.getSelectedItem())");
           
           
    	   //JOptionPane.showMessageDialog(null,"Stock update product......");
            	
    	}	
    	catch(Exception g){} 	
    	
    }	
 
       public void clear()
    	{
    		try
    		{
               t1.setText("");
               //t2.setText("");
               
    	       t3.setText("");
    	       t4.setText("");
               t5.setText(""); 	
               t6.setText("");	
    	       t7.setText("");
    	       t8.setText("");
    	   
    		}	
    		catch(Exception r){}	
    	    
    	  
    			
    	}	
        
    public void actionPerformed(ActionEvent e)
    {
    	String name,type;
    	int prize,no,quantity;
    	if(e.getSource()==b1)
    	{
    		b2.setEnabled(true);
    		try
    		{
    			String qcnt = "select max(bno)+1 from bill ";     
		     	rs9 = st.executeQuery(qcnt);
		     	rs9.next();
		    	int cnt = rs9.getInt(1);
		    	t1.setText(""+cnt);
                
               t8.setText("");
               
    	       t3.setText("");
    	       t4.setText("");
               //t5.setText(""); 	
               ////t6.setText("");	
    	       //t7.setText("");    		
    	       // clear();
    		}	
    		
           	catch(SQLException ev)
     		{
     			JOptionPane.showMessageDialog(null,"New bill Id is not set", "MsgBox!!!",JOptionPane.INFORMATION_MESSAGE);
     		}
	     	
    			
    		
		    
    	  
    	}		
    	if(e.getSource()==b2)
    	{
    		
    	   	String cname,pname;
    	    int pno,cno,billno,pquantity,tprize,date,ttotal;
    		 
    	    try
            {
        pstat = cn.prepareStatement("insert into bill values (?,?,?,?,?,?,?,?,?)");
    	
    	billno = Integer.parseInt(t1.getText());
    	cno = Integer.parseInt(t2.getText());
    	date =Integer.parseInt(t8.getText());
        pquantity = Integer.parseInt(t5.getText());
    	//rstock = Integer.parseInt(t9.getText());
    	//cno = Integer.parseInt(t3.getText());
    	pno = Integer.parseInt(t3.getText());
    //	prate = Integer.parseInt(t7.getText());
    	pname =c2.getSelectedItem();
    	tprize = Integer.parseInt(t6.getText());
    	ttotal = Integer.parseInt(t7.getText());	
        cname=  c1.getSelectedItem();
       // purqty= Integer.parseInt(t8.getText());
        //dis = Integer.parseInt(t10.getText());
    //	tamt = Integer.parseInt(t11.getText());
   	  
        pstat.setInt(1,billno);
    	pstat.setString(2,cname);
    	pstat.setInt(3,cno);
    	pstat.setInt(4,pno);
    	pstat.setString(5,pname);
    	pstat.setInt(6,pquantity);
    	pstat.setInt(7,tprize);
    	pstat.setInt(8,ttotal);
    	pstat.setInt(9,date);
    
    	pstat.executeUpdate();
    	JOptionPane.showMessageDialog(null,"Record Saved customer bill......");
            	
            }
            catch(Exception e2)
            {
                System.out.println(e2);
                System.out.println(e2.toString());
            }
            b2.setEnabled(false);
        
         }
           
           // new Menu();
    		
    	if(e.getSource()==b3)
    	{
    	    setVisible(false);
    	}		
    	if(e.getSource()==b4)
    	{
    	   setVisible(false);	
    	   new Menu();
    	}		
    	if(e.getSource()==b5)
    	{
    	    int total;//,total1,total2
    	    //int a,b,c;
    	    total=Integer.parseInt(t6.getText())*Integer.parseInt(t5.getText());
    	    t7.setText(Integer.toString(total));
    	   	JOptionPane.showMessageDialog(null,"Total="+total);
    	    //total1=total*Integer.parseInt(t10.getText())/100;
    	    //total2=total-total1;
    	  // t7.setText(Integer.toString(total3));
    	    //c=Integer.parseInt(t6.getText())-Integer.parseInt(t8.getText());
    	    //t8.setText(Integer.toString(c));
    	    num();
    	}		
    	if(e.getSource()==b6)
    	{
            // b1.setEnabled(false);
             // b2.setEnabled(false);
    	   	PrinterJob job = PrinterJob.getPrinterJob();
     		job.setPrintable(this);
     		boolean ok = job.printDialog();
     		if (ok) 
     		{
         	 try 
         	 	{
         	 	 job.print();
         		} 
         		catch (PrinterException ex) 
         		{
                         /* The job did not successfully complete */
                }
     		}
    	}
    							
    }
   	public int print(Graphics g, PageFormat pf, int page)throws PrinterException 
  	{
    	
    Graphics2D g2d = (Graphics2D)g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());

    // Print the entire visible contents of a
    // java.awt.Frame.
    this.printAll(g);

    return PAGE_EXISTS;
	}
  		 	 
    
    public static void main(String[] args) 
    {
      cbill bd=new cbill();
    }
}
