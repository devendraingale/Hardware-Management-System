import java.awt.*;
import java.sql.*;
import javax.swing.*;
public class EmployeeReport extends Frame
{



       public EmployeeReport()
           {


                 try
                 {

                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		         		Connection cn=DriverManager.getConnection("jdbc:odbc:MDII");
						Statement st=cn.createStatement();
			 			String d[][]=new String[100][7];
			 			String h[]={"Employee_ID","Employee_Name","Employee_Address","Employee_Gender","Employee_E-mail","Employee_Contcat","Employee_DateofBirth","Employee_Designation"};
			 			ResultSet rs=st.executeQuery("select * from Employee");
			 			int i=0;
			 			while(rs.next())
			   			{
				  			d[i][0]=rs.getString(1);
				  			d[i][1]=rs.getString(2);
		          			d[i][2]=rs.getString(3);
				 	 		d[i][3]=rs.getString(4);
				  			d[i][4]=rs.getString(5);
				  			d[i][5]=rs.getString(6);
				  			d[i][6]=rs.getString(7);
				  			i++;

		           		}
                        JTable obj=new JTable(d,h);
                        JScrollPane ob=new JScrollPane(obj);
                        ob.setBounds(50,50,500,300);
                        add(ob);
                        setSize(3000,3000);
                        setVisible(true);


		    	}
                catch(Exception e)
                {
					   System.out.println(e);
			    }
        }
}
