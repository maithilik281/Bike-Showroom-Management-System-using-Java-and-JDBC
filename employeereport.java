import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class employeereport extends JFrame
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	String head[]={"eno","ename","eadd","emob","esal"};
	String arr[][]=new String[50][50];
	public employeereport()
	{
		super("Employee Report");
		try
		{
				Class.forName("com.mysql.cj.jdbc.Driverr");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RR","root","root");
				st=con.createStatement();
				rs=st.executeQuery("select * from employee");
				int i=0;
				while(rs.next())
				{
					arr[i][0]=rs.getString("eno");
					arr[i][1]=rs.getString("ename");
					arr[i][2]=rs.getString("eadd");
					arr[i][3]=rs.getString("emob");
					arr[i][4]=rs.getString("esal");
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
			employeereport er=new employeereport();
		}
	}