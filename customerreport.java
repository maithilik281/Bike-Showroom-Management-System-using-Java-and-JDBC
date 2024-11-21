import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class customerreport extends JFrame 
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	String head[]={"cno","name","add","mobileno","email","state"};
	String arr[][]=new String[50][50];
	public customerreport()
	{
		super("Customer Report");
		try
		{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("\"jdbc:mysql://localhost:3306/RR","root","root");
				st=con.createStatement();
				rs=st.executeQuery("select * from customer");
				int i=0;
				while(rs.next())
				{
					arr[i][0]=rs.getString("cno");
					arr[i][1]=rs.getString("name");
					arr[i][2]=rs.getString("add");
					arr[i][3]=rs.getString("mobileno");
					arr[i][4]=rs.getString("email");
					arr[i][5]=rs.getString("state");
					
					i++;
				}
				JTable jt=new JTable(arr,head);
				JScrollPane pane=new JScrollPane(jt);
				
				getContentPane().add(pane);
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			setSize(800,800);
			setVisible(true);
			
		}
		public static void main(String args[])
		{
			customerreport cr=new customerreport();
		}
	
	}
	