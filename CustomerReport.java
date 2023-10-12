import java.awt.*;
import java.sql.*;
import javax.swing.*;
public class CustomerReport extends Frame
{



       public CustomerReport()
           {


                 try
                 {

                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		         		Connection cn=DriverManager.getConnection("jdbc:odbc:MDII");
						Statement st=cn.createStatement();
			 			String d[][]=new String[100][7];
			 			String h[]={"Customer No","Name","Address","Gender","Email_ID","Contact No","Birth Date"};
			 			ResultSet rs=st.executeQuery("select * from Customer");
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
                        cn.close();
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
