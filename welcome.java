import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
class welcome extends JFrame implements ActionListener
{
	Icon img1=new ImageIcon("sh.jpg");
    JLabel l1,l2,l3,l4,l5,l6,l7; 
      Font f,f1,f2,f3;  
     JButton b1; 	  	  
    welcome() 
    {
    	setTitle("Welcome");
		
		l7=new JLabel(img1);
       	add(l7);
    	//setSize(300,300);
	//	setLocation(200,200);
		setVisible(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLayout(new GridLayout());
	//	setLayout(null);
		l1=new JLabel("WEL COME TO RAJENDRA HONDA SHOWROOM");
		l2=new JLabel("Developed By:-");
		l3=new JLabel("Varpe Madhuri Kailas");
		l4=new JLabel("Kanawade Manisha Sanjay");
		l5=new JLabel("Under The Guidence Of:-");
		l6=new JLabel("Prof.Bachchav S.K");
			
		f=new Font("Modern No. 20",Font.BOLD,50);
		l1.setFont(f);
		l1.setBounds(40,0,1260,100);
        l1.setForeground(Color.RED);
		l7.add(l1);
		
				
		f1=new Font("Modern No. 20",Font.BOLD,35);
		l2.setFont(f1);
		l2.setBounds(50,100,400,100);
        l2.setForeground(Color.BLUE);
		l7.add(l2);
		
        f2=new Font("Modern No. 20",Font.BOLD,40);
		l3.setFont(f2);
		l3.setBounds(250,150,450,100);
        l3.setForeground(Color.MAGENTA);
		l7.add(l3);
		
	//	f2=new Font("Modern No. 20",Font.BOLD,40);
		l4.setFont(f2);
		l4.setBounds(250,220,500,100);
        l4.setForeground(Color.MAGENTA);
		l7.add(l4);
		
	//	f1=new Font("Modern No. 20",Font.BOLD,35);
		l5.setFont(f1);
		l5.setBounds(50,300,450,100);
        l5.setForeground(Color.BLUE);
		l7.add(l5);
		
	    f2=new Font("Modern No. 20",Font.BOLD,40);
		l6.setFont(f2);
		l6.setBounds(450,350,400,100);
        l6.setForeground(Color.MAGENTA);
		l7.add(l6);
    	
    	f3=new Font("Modern No. 20",Font.BOLD,20);
    	b1=new JButton("OK");
    	b1.setForeground(Color.RED);
    //	b1.setBackground(Color.blue);
    	b1.setFont(f3);
    	
    	b1.setBounds(700,500,100,40);
    	l7.add(b1);
    	
    	b1.setToolTipText("To Click On Next Button ");
    	b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==b1)
    	{
    		setVisible(false);
            new login1();
    	
    	}	
    }	
    
    public static void main(String[] args) 
    {
    	welcome w=new welcome();
    }
}
