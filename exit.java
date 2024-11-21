import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class exit extends JFrame implements ActionListener
{
	JButton b1,b2;
	JLabel p1l1,p1l2,l1;
		ImageIcon img,img1;
		JPanel p1;
		 Font f,f1;
	public exit()
	{
		        
	            setVisible(true);
	            	//setSize(1350,800);
		       
		      	setTitle("Exit Details");
		        setDefaultCloseOperation(EXIT_ON_CLOSE);
		       	setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
	             setLayout(null);
		 f=new Font("Modern No. 20",Font.BOLD,40);
        f1=new Font("Modern No. 20",Font.BOLD,30);
        	
		p1=new JPanel();
		p1.setLayout(null);
		p1.setVisible(true);
		p1.setBounds(350,100,600,250);
		p1.setBackground(Color.cyan);
		p1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		p1.setBorder(BorderFactory.createTitledBorder("Exit System...."));
			 add(p1);
			 
			  p1l1=new JLabel("Thank's For Visit Showroom :-");
	             	p1l1.setBounds(30,60,700,50);
	             		p1l1.setFont(f);
	                p1l1.setForeground(Color.BLACK)  ;	
		            p1.add(p1l1);
		             
		 	b1=new JButton("Main Menu");
		    	b1.setBounds(350,600,250,50);
		      	b1.setFont(f1);
		      	b1.setBackground(Color.lightGray);
		      	b1.setToolTipText("To Set A Current Main Menu of System...");
		            add(b1);
		            	b2=new JButton("OUT");
		    	b2.setBounds(650,600,300,50);
		      	b2.setFont(f1);
		      	b2.setBackground(Color.lightGray);
		      	b2.setToolTipText("To Quit The Current Menu of System...");
		            add(b2);
		         
		  
		img1 = new ImageIcon("a.jpg");
			//img1 = new ImageIcon("Home _ Products _ Home Supplies _ Furniture _ Bedroom Furniture.jpg");
				//img1 = new ImageIcon("kitchen-appliances.jpg");
			l1  = new JLabel(img1);
			l1.setBounds(0,0,1250,950);
			  add(l1);
			    img = new ImageIcon("search bill.jpg");
			l1 = new JLabel(img);
				l1.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
			//l1.setBounds(20,20,400,420);
		          add(l1); 
			  
			  
		   
		   
	b1.addActionListener(this);	
	b2.addActionListener(this);    
	}
   public  void actionPerformed(ActionEvent a)
   {
    if(a.getSource()==b1)
    {
    	{

	        	int p=JOptionPane.showConfirmDialog(null,"Are You Sure To Home Menu", "Quit ", JOptionPane.YES_NO_OPTION);
			  if(p==JOptionPane.OK_OPTION)
		    new main();
		    setVisible(false);
          }
    	 
     	
    }
     if(a.getSource()==b2)
    {
    	
             {

	        	int p=JOptionPane.showConfirmDialog(null,"Are you sure to Quit?", "Home Menu?", JOptionPane.YES_NO_OPTION);
			  if(p==JOptionPane.OK_OPTION)
		    	System.exit(0);
          }
    }
   }
 
	public static void main (String[] args) 
	{
	new exit();
    }
}
