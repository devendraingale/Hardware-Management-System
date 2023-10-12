import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.JList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



public class ParchaseOrder extends JFrame implements ActionListener,ItemListener,MouseMotionListener,MouseListener

{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,limg;
	JTextField t1,t3,t4,t5,t6,t7,td1,td2,td3,td4,t8;
	JButton b2,b3,b7,b8,b4;
	List li1,li2,li3,li4;
	String pname[]=new String[5];
	int qnt[]=new int[5];
	int amt[]=new int[5];
    int tamt[]=new int[5];

	Choice c3,c1;
	Connection cn;
	Statement st;
	ResultSet rs;
	String n,mn;
	String q,sname;
    int ftotal=0,i=0,w;
    static int t;
    String con;
	String el;
	int m;
	int bt;
	JLabel ll1,ll2,ll3,ll4,ll5,ll6;
	ImageIcon img=new ImageIcon("SaleOrder.jpg");


		Date d = new Date(System.currentTimeMillis());


		String dayString = d.toString();







	public ParchaseOrder()
	{



		setLayout(null);

		//**************Quick Links**********************************

				ll1=new JLabel("Customer");
				ll2=new JLabel("Employee");
				ll3=new JLabel("Product");
				ll4=new JLabel("Supplier");
				ll5=new JLabel("Sales Order");
				ll6=new JLabel("Exit");

				ll1.setBounds(30,120,100,50);
				ll2.setBounds(30,180,100,50);
				ll3.setBounds(30,240,100,50);
				ll4.setBounds(30,300,100,50);
				ll5.setBounds(30,360,150,50);
				ll6.setBounds(30,420,150,50);

				ll1.setFont(new Font("times new roman", Font.BOLD, 20));
				ll2.setFont(new Font("times new roman", Font.BOLD, 20));
				ll3.setFont(new Font("times new roman", Font.BOLD, 20));
				ll4.setFont(new Font("times new roman", Font.BOLD, 20));
				ll5.setFont(new Font("times new roman", Font.BOLD, 20));
				ll6.setFont(new Font("times new roman", Font.BOLD, 20));

				add(ll1);
				add(ll2);
				add(ll3);
				add(ll4);
				add(ll5);
				add(ll6);

//***********************************************************************
		limg=new JLabel(img);
		l1=new JLabel("Purchase ID");
		l2=new JLabel("Supplier Name");
		l3=new JLabel("Contact");
		l4=new JLabel("DATE");
		l5=new JLabel("Purchase Oreder");
		l6=new JLabel("Product");
		l7=new JLabel("Qunaitity");
		l8=new JLabel("Cutomer Email");
		l9=new JLabel("Product Name");
		l10=new JLabel("Qty");
		l11=new JLabel("Rate");
		l12=new JLabel("Amount");
		l13=new JLabel("Total");
		t7=new JTextField();
		t8=new JTextField();
		li1=new List();
		li2=new List();
		li3=new List();
		li4=new List();
		c1=new Choice();
		c3=new Choice();
		t5=new JTextField();
		li1.setForeground(Color.GRAY);
		li2.setForeground(Color.GRAY);
		li3.setForeground(Color.GRAY);
		li4.setForeground(Color.GRAY);

		int x=0;
		while(x<=4)
		{
		pname[x]="null";
		x++;
		}
		while(x<=4)
		{
		qnt[x]=0;
		amt[x]=0;
    	tamt[x]=0;
		}






		l5.setFont(new Font("times new roman", Font.BOLD, 20));


		t1=new JTextField();
		c3=new Choice();
		c1=new Choice();
		t3=new JTextField();
		t4=new JTextField();
		t6=new JTextField();

		td1=new JTextField();
		td2=new JTextField();
		td3=new JTextField();
		td4=new JTextField();





		b2=new JButton("Submit");
		b3=new JButton("Search");

		b7=new JButton("Clear");
		b8=new JButton("Exit");
		b4=new JButton("Report");





		l1.setBounds(340,100,150,30);
		l2.setBounds(650,100,150,30);
		l3.setBounds(370,150,150,30);
		l6.setBounds(370,200,150,30);
		l7.setBounds(650,200,200,30);
		l4.setBounds(980,60,100,30);
		l5.setBounds(580,20,150,30);
		l8.setBounds(650,150,200,30);
		l9.setBounds(410,290,200,30);
		l10.setBounds(575,290,100,30);
		l11.setBounds(690,290,150,30);
		l12.setBounds(870,290,200,30);
		l13.setBounds(770,540,150,20);
		t7.setBounds(820,540,150,30);

		t1.setBounds(420,100,200,30);

		t3.setBounds(420,150,200,30);
		t4.setBounds(1040,63,100,30);

		   //Customer name
		t5.setBounds(760,200,200,30);     //Quantity
		t6.setBounds(760,150,200,30);		//Customer e-mail


		td1.setBounds(0,60,1500,1);
		td2.setBounds(0,660,1500,1);
		td3.setBounds(200,60,1,600);
		td4.setBounds(1150,60,1,600);





		td1.setBackground(Color.BLACK);
		td2.setBackground(Color.BLACK);
		td3.setBackground(Color.BLACK);
		td4.setBackground(Color.BLACK);

		b2.setBounds(400,600,100,30);
		b3.setBounds(550,600,100,30);
		b7.setBounds(700,600,100,30);
		b8.setBounds(1000,600,100,30);
		b4.setBounds(850,600,100,30);


		li1.setBounds(380,320,150,200);
		li2.setBounds(550,320,70,200);
		li3.setBounds(640,320,150,200);
		li4.setBounds(820,320,150,200);


		c3.setBounds(420,205,200,30); //product Comobox
		c1.setBounds(760,105,200,30);
        t8.setBounds(760,100,200,30);
        t8.setVisible(false);

		limg.setBounds(1000,70,500,200);

		add(limg);

		add(t1);

		add(t3);
		add(t4);

		add(li1);
		add(li2);
		add(li3);
		add(li4);

		add(c1);
		add(t6);

		add(c3);

		add(td1);
		add(td2);
		add(td3);
		add(td4);
		add(t7);

		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);

		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(l12);
		add(l13);

		add(b2);
		add(b3);
		add(b4);

		add(b7);
		add(b8);

		add(t8);

		t4.setText(dayString);
		t4.enable(false);

		setVisible(true);
		setSize(3000,3000);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b8.addActionListener(this);
		b7.addActionListener(this);
        c3.addItemListener(this);
        ll1.addMouseMotionListener(this);
		ll1.addMouseListener(this);
		ll2.addMouseMotionListener(this);
		ll2.addMouseListener(this);
		ll3.addMouseMotionListener(this);
		ll3.addMouseListener(this);
		ll4.addMouseMotionListener(this);
		ll4.addMouseListener(this);
		ll5.addMouseMotionListener(this);
		ll5.addMouseListener(this);
		ll6.addMouseMotionListener(this);
		ll6.addMouseListener(this);

        t1.enable(false);


		try
			{
//***************************Comobox Add Item Customer Name****************************
			 	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			 	    cn=DriverManager.getConnection("jdbc:odbc:MDII");
			        st=cn.createStatement();
			        ResultSet rs;
			        rs=st.executeQuery("select * from Supplier");
			        while(rs.next())
			         {

    		        	c1.addItem(rs.getString(2));
			         }
                     cn.close();

 //***************************ComboBox Add Item Product Name ***************************************************
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		            cn=DriverManager.getConnection("jdbc:odbc:MDII");
			        st=cn.createStatement();
			        rs=st.executeQuery("select * from Product");
			        while(rs.next())
			          {
			        	c3.addItem(rs.getString(2));
			          }
                   cn.close();
//******************************************Auto increment BillId Code*****************************************
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				cn=DriverManager.getConnection("jdbc:odbc:MDII");
			    st=cn.createStatement();
				rs=st.executeQuery("Select * From PurchaseOrder");
				while (rs.next())
				{
					String a=rs.getString(1);
					 w=Integer.parseInt(a);
					 System.out.println(w);

					 w=w+1;

				}

					t1.setText(""+w);

		}
		catch(Exception p)
		{
			System.out.println(p);
		}
}


	public void actionPerformed(ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
			if(b==b2)
			{
				String eadd=t3.getText(); //validation
				int eaddl=eadd.length();
				int c=0;
				int billid;

				for(int i=0;i<eaddl;i++)
				{
					char ch=eadd.charAt(i);
					if(ch>='0' && ch<='9')
					{

				    }
				    else
					{
						 JOptionPane.showMessageDialog(null,"Enter Correct Value In Contact Box");
						 c++;
					      break;
				    }

			   }
				 if(c==0)
				 {
					 try
					 {

                         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection cn2=DriverManager.getConnection("jdbc:odbc:MDII");
			            Statement st2=cn2.createStatement();
			             ResultSet rs10=st2.executeQuery("select * from PurchaseOrder");
			             while(rs10.next())
			                {

								bt=Integer.parseInt(rs10.getString(1));
						   }
                          bt++;

						String str="insert into PurchaseOrder values("+ bt +",'"+sname+"','"+t3.getText()+"','"+t6.getText()+"','"+t4.getText()+"','"+pname[0]+"','"+pname[1]+"','"+pname[2]+"','"+pname[3]+"','"+pname[4]+"',"+qnt[0]+","+qnt[1]+","+qnt[2]+","+qnt[3]+","+qnt[4]+","+amt[0]+","+amt[1]+","+amt[2]+","+amt[3]+","+amt[4]+","+tamt[0]+","+tamt[1]+","+tamt[2]+","+tamt[3]+","+tamt[4]+","+mn+")";
						System.out.println(str);
						int x=st.executeUpdate(str);
						if(x>0)
						{
							JOptionPane.showMessageDialog(null,"Bill Saved And Also Printed");
							t=0;
							int a=Integer.parseInt(t1.getText());
							a=a+1;
							t1.setText(""+a);
							t3.setText("");
							t6.setText("");
							t7.setText("");
							li1.clear();
							li2.clear();
							li3.clear();
							li4.clear();


						}

				 	}
				 	catch(Exception p)
				 	  {
						   System.out.println(p);
				      }
			     }
		}
		if(b==b8)
		{
//			new MDI();
		}



	if(b==b3)
	{
		try
		{
			t3.setText("");
			t6.setText("");
						t7.setText("");
						li1.clear();
						li2.clear();
						li3.clear();
						b2.enable(false);
			li4.clear();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn=DriverManager.getConnection("jdbc:odbc:MDII");
			st=cn.createStatement();
			int id;




			id=Integer.parseInt(JOptionPane.showInputDialog("Enter SalesOrder Id"));
			ResultSet rs1=st.executeQuery("Select * from PurchaseOrder where Bill_Id=" + id);
			c1.setVisible(false);
			t8.setVisible(true);
			rs1.next();

				t1.setText(rs1.getString(1));
				t8.setText(rs1.getString(2));
				t3.setText(rs1.getString(3));
				t6.setText(rs1.getString(4));
				li1.add(rs1.getString(5));
				li1.add(rs1.getString(6));
				li1.add(rs1.getString(7));
				li1.add(rs1.getString(8));
				li1.add(rs1.getString(9));
				li2.add(rs1.getString(10));
				li2.add(rs1.getString(11));
				li2.add(rs1.getString(12));
				li2.add(rs1.getString(13));
				li2.add(rs1.getString(14));
				li3.add(rs1.getString(15));
				li3.add(rs1.getString(16));
				li3.add(rs1.getString(17));
				li3.add(rs1.getString(18));
				li3.add(rs1.getString(19));
				li4.add(rs1.getString(20));
				li4.add(rs1.getString(21));
				li4.add(rs1.getString(22));
				li4.add(rs1.getString(23));
				li4.add(rs1.getString(24));
				t7.setText(rs1.getString(25));



		}
		catch(Exception y)
		{
			System.out.println(y);
		}
	}
	if(b==b7)
	  {
		    c1.setVisible(true);
			t8.setVisible(false);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				cn=DriverManager.getConnection("jdbc:odbc:MDII");
				st=cn.createStatement();
				rs=st.executeQuery("Select * from PurchaseOrder");
				while(rs.next())
				{
					m=Integer.parseInt(rs.getString(1));
				}
				t1.setText(""+m);

			}
			catch(Exception r)
			{
				System.out.println(r);
			}

			t3.setText("");
			t6.setText("");
			t7.setText("");
			li1.clear();
			li2.clear();
			li3.clear();
			li4.clear();
			b2.enable(true);


	  }
	if(b==b4)
	{
//		new SaleOrderReport();
	}

	}

      public void itemStateChanged(ItemEvent e)
            {
               try
                   {

//******************************ListBox Code**********************************
                       String n=c3.getSelectedItem();

                       pname[t]=n;
                       li1.add(n);
                       String qnt1=JOptionPane.showInputDialog("Enter Quantity");

                       qnt[t]=Integer.parseInt(qnt1);
                       li2.add(qnt1);
                       String rate1=JOptionPane.showInputDialog("Enter Rate");
					   li3.add(rate1);
					   amt[t]=Integer.parseInt(rate1);
					   int zx1=Integer.parseInt(rate1);
					  int amt1=zx1*qnt[t];
					  tamt[t]=amt1;
					   li4.add(""+amt1);
					   t++;



                        ftotal=ftotal+amt1;
                        mn=Integer.toString(ftotal);
                        t7.setText(mn);


                  }
                 catch(Exception o)
                {

                }
    //*******************Customer Name Choice*****************************

								sname=c1.getSelectedItem();
			   					  try
			   					  {

			   					  	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   					   cn=DriverManager.getConnection("jdbc:odbc:MDII");
			   			           st=cn.createStatement();

			   			          ResultSet rs1=st.executeQuery("Select * from Supplier where Supplier_Name='"+sname+"'");
			   			           while(rs1.next())
			   			           {
			   						   con=rs1.getString(6);
			   						   el=rs1.getString(5);
			   					   }
			   					   t3.setText(con);
			   					   t6.setText(el);
			   					   cn.close();
							   }
							   catch(Exception m)
							   {
								   System.out.println(m);
							   }

            }


public void mouseClicked(MouseEvent e)
{

		JLabel L = (JLabel)e.getSource();

		if (ll1 == L)
		{
//			new CustomerAdmin();
		}

		if (ll2 == L)
		{
			//new EmployeeAdmin();
		}
		if (ll3 == L)
		{
			//new ProductAdmin();
		}
		if (ll4 == L)
		{
			//new SupplierAdmin();
		}
		if (ll5 == L)
		{
			//new Bill();
		}
		if (ll6 == L)
		{
			//new MDI();
		}


}
public void mouseDragged(MouseEvent e)
{

}
public void mouseMoved(MouseEvent e)
{

}
public void mouseEntered(MouseEvent e)
{

}
public void mouseExited(MouseEvent e)
{

}

public void mousePressed(MouseEvent e)
{

}
public void mouseReleased(MouseEvent e)
{

}
	public static void main(String args[]) throws Exception
		{
			new ParchaseOrder();
	}
}