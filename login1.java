import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class login1 extends Frame implements ActionListener
{
   
	Label l1,l2,l3,l4,l5;
	JTextField t1;
	JPasswordField t2;
	Button b1,b2;
	Font f1;
	 public String loginname;
    public String loginpass;
	//JLabel img1;
//	JLabel l3;
	
	login1()
	{
		super("Login");
		

		
	f1=new Font("Lucida Calligraphy",Font.BOLD,18);
    setFont(f1);
     setBackground(Color.pink);
    setForeground(Color.blue);
	
		setSize(600,600);
		setVisible(true);
		//l3=new JLabel(new ImageIcon("sh.jpg"));
        //l3.setFont(f1);
        //l3.setBounds(130,280,200,50);
       
		
		setLayout(null);
		l1=new Label("Enter User Name");
		l2=new Label("Enter Passward");
		//l3=new Label("Develop By");
		//l4=new Label("Shete .");
		//l5=new Label("aaaaaaaaa");
		
	
		t1=new JTextField();
		t2=new JPasswordField();
		b1=new Button("Login");
		b2=new Button("Exit");
		
	//img1=new JLabel(new ImageIcon("Koala.jpg"));//
		l1.setBounds(130,100,100,50);
		add(l1);
		l2.setBounds(130,190,140,50);
		add(l2);
		t1.setBounds(270,110,150,30);
		add(t1);
		t2.setBounds(270,200,150,30);
		add(t2);
		b1.setBounds(130,320,80,30);
		add(b1);
		b2.setBounds(320,320,80,30);
		add(b2);
	//	l3.setBounds(130,360,180,50);
	//	add(l3);
		//l3=setForeground(Color.black);
	
		//l4.setBounds(130,410,220,50);
		//add(l4);
		//l4=setForeground(Color.black);
	
	//	l5.setBounds(130,460,260,50);
	//	add(l5);
		//l5=setForeground(Color.black);
	
		
		
		
//l3=new JLabel(new ImageIcon("sh.jpg"));
       // l3.setFont(f1);
       // l3.setBounds(130,280,200,50);
       
		b1.addActionListener(this);
		b2.addActionListener(this);
		
        
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
		if(str.equals("Exit"))
		{
			System.exit(0);
		}
		loginname=t1.getText().trim();
		loginpass=t2.getText().trim();
		if(str.equals("Login"))
		{
			
			
			 String s1=t1.getText();
	   	  String s2= new String(t2.getPassword());
			if(t1.getText().equals("nikita") && t2.getText().equals("nikita"))
			 {
			    
				JOptionPane.showMessageDialog(null,"You Have successfuly Login");
				setVisible(false);
				main m=new main();
			        
			 } 
			  else
			  {
			  	JOptionPane.showMessageDialog(null,"Invalid UserName And Passward");
			  }
		}		
    }
   
    public static void main(String args[])
    {
    	login1 l1=new login1();
    
    }
}