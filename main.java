import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;
public class main extends Frame implements ActionListener
{
	

	MenuBar menubar;
	Menu customer,employee,bikes,bill,report,help,exit;
	MenuItem cd,ed,bd,bbd,cr,er,br,bbr,he,ex;
	Font f1;
	JLabel l1;
	public main()
	{
		
	f1=new Font("Arial",Font.BOLD,18);
    setFont(f1);
      setBackground(Color.orange);
    setForeground(Color.red);
	
	    setTitle("Welcome");
		setSize(800,800);
		setLayout(null);
		setVisible(true);
l1=new JLabel(new ImageIcon("cc.jpg"));
        l1.setFont(f1);
        l1.setBounds(80,260,1100,640);
	   
		menubar=new MenuBar();
		customer=new Menu("Customer");
		employee=new Menu("Employee");
		
		bikes=new Menu("Bikes");
	
		bill=new Menu("Bill");
		report=new Menu("Report");
		help=new Menu("Help");
		exit=new Menu("Exit");
		
		cd=new MenuItem("Costomer Details");
		ed=new MenuItem("Employee Details");
		bd=new MenuItem("Bikes Details");
		bbd=new MenuItem("Bill Form");
		cr=new MenuItem("Customer Report");
		er=new MenuItem("Employee Report");

		br=new MenuItem("Bikes Report");
		bbr=new MenuItem("Bill Report");
		he=new MenuItem("Help");
		ex=new MenuItem("quit");
		
	    setMenuBar(menubar);
	    
		
		menubar.add(customer);
		
		menubar.add(employee);
		menubar.add(bikes);
	
		menubar.add(bill);
		menubar.add(report);
		menubar.add(help);
		menubar.add(exit);
		customer.add(cd);
	//	cd.setForeground(Color.red);
		employee.add(ed);
		
		bikes.add(bd);
		bill.add(bbd);
		report.add(cr);
		report.add(er);
		report.add(br);
		report.add(bbr);
		help.add(he);
		exit.add(ex);
		
		
	//		help =new JMenu("Help");
    //	he=new JMenuItem("Help");
    //	MenuBar.add(help);
    //	help.add(he);
    //	
    //	exit =new JMenu("Exit");
        //ex=new JMenuItem("Exit");
    	//MenuBar.add(exit);
        //exit.add(ex);
		
		add(l1);
		
		cd.addActionListener(this);
        ed.addActionListener(this);	
        bd.addActionListener(this);
        bbd.addActionListener(this);
        cr.addActionListener(this);
        er.addActionListener(this);
        br.addActionListener(this);
        bbr.addActionListener(this);
        
        br.addActionListener(this);
        he.addActionListener(this);
		ex.addActionListener(this);
    }
       public void actionPerformed(ActionEvent ea)
       {
       	
       	String str=ea.getActionCommand();
       	
       	    if(str.equals("Costomer Details"))
          {
            
            customer1 c=new customer1(); 
            c.show();
            c.setSize(800,700);
		    c.setLayout(null);
	    	c.setVisible(true);
             
          }
          if(str.equals("Employee Details"))
          {
             employee p=new employee();
          }
         
          if(str.equals("Bikes Details"))
          {
          	bikes s=new bikes();
          }
          if(str.equals("Customer Report"))
          {
          	customerreport cr=new customerreport();
          }
          if(str.equals("Employee Report"))
          {
          	employeereport pr=new employeereport();
          }
         if(str.equals("Bikes Report"))
          {
          	bikesreport qr=new bikesreport();
          }
          
          	
          if(str.equals("Bill Form"))
          {
          	bill b=new bill();
          }
          if(str.equals("Bill Report"))
          {
          	billreport br=new billreport();
          }
         
          if(str.equals("Help"))
          {
          	help h=new help();
          	
          }
         if(str.equals("quit"))
          {
          	exit ex=new exit();
          }
         
          
        }        		
		 public static void main(String args[])
		 {
		 main m=new main();
		 }
}
		
		
