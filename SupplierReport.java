import java.awt.*;
import java.sql.*;
import javax.swing.*;
public class SupplierReport extends JFrame
{



       public SupplierReport()
           {


                 try
                 {

                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		         		Connection cn=DriverManager.getConnection("jdbc:odbc:MDII");
						Statement st=cn.createStatement();
			 			String d[][]=new String[100][7];
			 			String h[]={"Supplier_ID","Supplier_Name","Supplier_Address","Supplier_Gender","Supplier_E-mail","Supplier_Contcat"};
			 			ResultSet rs=st.executeQuery("select * from Supplier");
			 			int i=0;
			 			while(rs.next())
			   			{
				  			d[i][0]=rs.getString(1);
				  			d[i][1]=rs.getString(2);
		          			d[i][2]=rs.getString(3);
				 	 		d[i][3]=rs.getString(4);
				  			d[i][4]=rs.getString(5);
				  			d[i][5]=rs.getString(6);
				  			i++;


		           		}
                        JTable obj=new JTable(d,h);
                        JScrollPane ob=new JScrollPane(obj);
                        ob.setBounds(50,50,500,300);
                        add(ob);
                        setSize(500,300);
                        setVisible(true);


		    	}
                catch(Exception e)
                {
					   System.out.println(e);
			    }
        }
}
