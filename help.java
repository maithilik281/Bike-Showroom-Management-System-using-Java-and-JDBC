import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class help extends JFrame implements ActionListener
{
	JButton b1;
	JLabel l1,p1l2,l3,l4,l5,l6,l7,p2l1,p2l2,p2l3,p2l4,p2l5;
		ImageIcon img,img1;
		JPanel p1,p2;
		 Font f,f1,f2,f3;
	public help()
	{
		    
	            setVisible(true);
	            	//setSize(1350,800);
		        setLayout(null);
		      	setTitle("Help Details");
	  	      	f3=new Font("Arial",Font.BOLD,18);
    			setFont(f3);
     			 setBackground(Color.pink);
    			setForeground(Color.black);
	
		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		       	setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
	
		 f=new Font("Modern No. 20",Font.BOLD,40);
        f1=new Font("Modern No. 20",Font.BOLD,30);
        f2=new Font("Modern No. 20",Font.BOLD,15);
        	
		p1=new JPanel();
		p1.setLayout(null);
		p1.setVisible(true);
		p1.setBounds(10,10,450,290);
		//p1.setBorder(BorderFactory.createLineBorder(Color.red,3));
		p1.setBorder(BorderFactory.createTitledBorder("Help form .......?"));
		 add(p1);
		 
		 
		   
		    l3=new JLabel("Rajendra Honda Showroom Management System");
	             	//l4.setBounds(20,4,100,100);
	             	//l4.setSize(900,200);
	             	l3.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
	                l3.setForeground(Color.RED)  ;	
	             	l3.setFont(f);
		            add(l3);
		            
		              l4=new JLabel(" Web side= \" www.rajendra@.com \"");
	             	l4.setBounds(100,390,700,200);
	                l4.setForeground(Color.BLACK)  ;	
	             	l4.setFont(f1);
		            add(l4);
		            
		             l5=new JLabel(" Contact Number:-");
	             	l5.setBounds(100,280,400,500);
	                l5.setForeground(Color.BLACK)  ;	
	             	l5.setFont(f1);
		            add(l5);
		            
		             l6=new JLabel(" Varpe Madhuri:-\t\t 8987654567,");
	             	l6.setBounds(100,320,1000,500);
	             	l6.setForeground(Color.BLACK)  ;	
	             	l6.setFont(f1);
		            add(l6);
		           
		             l7=new JLabel(" \nKanawade Manisha:- \t\t9876543219.");
	             	l7.setBounds(100,360,1000,500);
	             	l7.setForeground(Color.BLACK)  ;	
	             	l7.setFont(f1);
		            add(l7);
		 
		 	b1=new JButton("Main");
		    	b1.setBounds(200,640,250,50);
		      	b1.setFont(f1);
		      	b1.setBackground(Color.lightGray);
		      	b1.setToolTipText("To Set A Current Main Menu of System...");
		            add(b1);
		           
		           
		           	p2=new JPanel();
		p2.setLayout(null);
		p2.setBackground(Color.PINK);
		p2.setVisible(true);
		p2.setBounds(800,10,400,230);
		p2.setBorder(BorderFactory.createLineBorder(Color.red,3));
		p2.setBorder(BorderFactory.createTitledBorder("Showroom Places..."));
		 add(p2);
		 
		   
		    p2l1=new JLabel("Visit In Showroom :-");
	             	p2l1.setBounds(30,40,150,50);
	                p2l1.setForeground(Color.BLACK)  ;	
	             	p2l1.setFont(f2);
		            p2.add(p2l1);
		            
		            
		    p2l2=new JLabel("\" Rajendra Honda Showroom \"");
	             	p2l2.setBounds(120,80,350,50);
	                p2l2.setForeground(Color.BLACK)  ;
	                	p2l2.setFont(f2);	
		            p2.add(p2l2);
		            
		                     
		    p2l3=new JLabel("Collage Road");
	             	p2l3.setBounds(160,110,200,50);
	                p2l3.setForeground(Color.BLACK)  ;
	                	p2l3.setFont(f2);	
		            p2.add(p2l3);
		            
		            p2l4=new JLabel(" Sangamner");
	             	p2l4.setBounds(160,140,200,50);
	                p2l4.setForeground(Color.BLACK)  ;
	                	p2l4.setFont(f2);	
		            p2.add(p2l4);
		            
		              p2l5=new JLabel(" 422605 .");
	             	p2l5.setBounds(170,170,200,50);
	                p2l5.setForeground(Color.BLACK)  ;
	                	p2l5.setFont(f2);	
		            p2.add(p2l5);
		            
		            
		 
		    img = new ImageIcon("nn.jpg");
			l1 = new JLabel(img);
			l1.setBounds(10,20,440,300);
		    p1.add(l1); 
		  
		   
		img1 = new ImageIcon("oo.jpg");
			//img1 = new ImageIcon("Home _ Products _ Home Supplies _ Furniture _ Bedroom Furniture.jpg");
				//img1 = new ImageIcon("kitchen-appliances.jpg");
			p1l2  = new JLabel(img1);
				p1l2.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
			//p1l2.setBounds(300,0,1020,750);
			  add(p1l2);
	b1.addActionListener(this);	    
	}
   public  void actionPerformed(ActionEvent a)
   {
    if(a.getSource()==b1)
    {
    	 {

	        	int p=JOptionPane.showConfirmDialog(null,"Are You Sure To Home Menu", "Quit  Help Page?", JOptionPane.YES_NO_OPTION);
			  if(p==JOptionPane.OK_OPTION)
		    new main();
		    setVisible(false);
          }
    	 
    }
   }
 
	public static void main (String[] args) 
	{
			help h=new help();	
    }
}
