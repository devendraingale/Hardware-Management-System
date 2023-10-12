import java.awt.*;
import java.sql.*;
import javax.swing.*;
public class SaleOrderReport extends Frame
{



       public SaleOrderReport()
           {


                 try
                 {

                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		       			 Connection cn=DriverManager.getConnection("jdbc:odbc:MDII");
						Statement st=cn.createStatement();
						String d[][]=new String[100][50];
			String h[]={"Sales ID","Customer_name","Cutomer_Contact","Customer_email","Purchase_Date","Product_1","Product_2","Product_3","Product_4","Product_5","Product_Qnt1","Product_Qnt2","Product_Qnt3","Product_Qnt4","Product_Qnt5","Product_rate1","Product_rate2","Product_rate3","Product_rate4","Product_rate5","Product_amt1","Product_amt2","Product_amt3","Product_amt4","Finail_total"};
			ResultSet rs=st.executeQuery("select * from SalesOrder");
			int i=0;
			while(rs.next())
			{
				  			d[i][0]=rs.getString(1);
				  			d[i][1]=rs.getString(2);
		          			d[i][2]=rs.getString(3);
				 	 		d[i][3]=rs.getString(4);
				  			d[i][4]=rs.getString(5);
				  			d[i][5]=rs.getString(6);
				  			d[i][7]=rs.getString(7);
				  			d[i][8]=rs.getString(8);
				  			d[i][9]=rs.getString(9);
				  			d[i][10]=rs.getString(10);
				  			d[i][11]=rs.getString(11);
				  			d[i][12]=rs.getString(12);
				  			d[i][13]=rs.getString(13);
				  			d[i][14]=rs.getString(14);
				  			d[i][15]=rs.getString(15);
				  			d[i][16]=rs.getString(16);
				  			d[i][17]=rs.getString(17);
				  			d[i][18]=rs.getString(18);
				  			d[i][19]=rs.getString(19);
				  			d[i][20]=rs.getString(20);
				  			d[i][21]=rs.getString(21);
				  			d[i][22]=rs.getString(22);
				  			d[i][23]=rs.getString(23);
				  			d[i][24]=rs.getString(24);
				  			d[i][25]=rs.getString(25);
				  			d[i][26]=rs.getString(26);

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
