import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class SupplierAdmin extends JFrame implements ActionListener,MouseMotionListener,MouseListener

{
	JLabel l1,l2,l3,l4,l5,l6,l7,limg,l11;
	JTextField t1,t2,t4,t5,td1,td2,td3,td4,td5;
	JButton b2,b3,b4,b5,b6,b7;
	JTextArea t3;
	int w;
	String a;
	Connection cn;
	Statement st;
	ResultSet rs;
	JLabel ll1,ll2,ll3,ll4,ll5,ll6;
	CheckboxGroup Gender = new CheckboxGroup();

	Checkbox op1 = new Checkbox("Male", Gender, true);
    Checkbox op2 = new Checkbox("Female", Gender, false);
	ImageIcon img=new ImageIcon("Supplier.png");

	public SupplierAdmin()
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
		l1=new JLabel("Supplier ID");
		l2=new JLabel("Name");
		l3=new JLabel("Address");
		l4=new JLabel("E-mail");
		l5=new JLabel("Contact");
		l6=new JLabel("Gender");
		l7=new JLabel("Supplier");
		td5=new JTextField();
		l11=new JLabel("Quick Links");
		limg=new JLabel(img);

		l7.setFont(new Font("times new roman", Font.BOLD, 30));

		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextArea();
		t4=new JTextField();
		t5=new JTextField();
		td1=new JTextField();
		td2=new JTextField();
		td3=new JTextField();
		td4=new JTextField();

		b2=new JButton("Save");
		b3=new JButton("Search");
		b4=new JButton("Update");
		b5=new JButton("Delete");
		b6=new JButton("Report");
		b7=new JButton("Clear");


		l1.setBounds(500,150,150,30);
		l2.setBounds(500,200,150,30);
		l3.setBounds(500,250,150,30);
		l6.setBounds(500,300,150,30);
		l4.setBounds(500,350,100,30);
		l5.setBounds(500,400,150,30);
		l7.setBounds(590,20,200,30);

		t1.setBounds(620,150,200,30);
		t2.setBounds(620,200,200,30);
		t3.setBounds(620,250,200,30);
		t4.setBounds(620,350,200,30);
		t5.setBounds(620,400,200,30);

		td1.setBounds(0,60,1500,1);
		td2.setBounds(0,660,1500,1);
		td3.setBounds(200,60,1,600);
		td4.setBounds(1050,60,1,600);

		op1.setBounds(650,300,100,30);
		op2.setBounds(750,300,100,30);


		b2.setBounds(440,510,100,30);
		b3.setBounds(610,510,100,30);
		b4.setBounds(775,510,100,30);
		b5.setBounds(440,580,100,30);
		b6.setBounds(610,580,100,30);
		b7.setBounds(775,580,100,30);
		limg.setBounds(965,60,500,200);


		td1.setBackground(Color.BLACK);
		td2.setBackground(Color.BLACK);
		td3.setBackground(Color.BLACK);
		td4.setBackground(Color.BLACK);

		td5.setBounds(0,108,200,1);
		l11.setBounds(30,70,150,30);
		td5.setBackground(Color.BLACK);
		l11.setFont(new Font("times new roman", Font.BOLD, 20));
		l11.setForeground(Color.BLUE);
		add(td5);
		add(l11);

		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(td1);
		add(td2);
		add(td3);
		add(td4);
		add(limg);

		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);

		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);

		add(op1);
		add(op2);

		setVisible(true);
		setSize(3000,3000);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
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


		b4.setEnabled(false);
		b5.setEnabled(false);
		t1.setEnabled(false);



			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				cn=DriverManager.getConnection("jdbc:odbc:MDII");
				st=cn.createStatement();
				ResultSet rs;
				rs=st.executeQuery("Select * From Supplier");
				while (rs.next())
				{
					String a=rs.getString(1);
					 w=Integer.parseInt(a);

					 w=w+1;
					String po=Integer.toString(w);
					t1.setText(po);
				}
			}
			catch(Exception g)
			{
				System.out.println(g);
			}



	}
	public void actionPerformed (ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
//**********************Save Button Code***************************************
		if(b==b2)
		{
			int c=0;
				///*********************************************Name Validation	*******************************************
									String cname=t2.getText();
									int cnamel=cname.length();
									for(int i=0;i<cnamel;i++)
									{
										char ch=cname.charAt(i);
										if(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
										{
										}
										else
										{
											JOptionPane.showMessageDialog(null,"Enter Correct Value Name");
											c++;
											break;
										}
									}
				///*********************************************Address Validation*******************************************

									String cadd=t3.getText();
									int caddl=cadd.length();
									for(int i=0;i<caddl;i++)
									{
										char ch=cadd.charAt(i);
										if(ch>='A' && ch<='Z' || ch>='a' && ch<='z'||ch>='0' && ch<='9' || ch==',' ||ch=='.' ||ch=='-'||ch==' ')
										{
										}

										else
										{
											 JOptionPane.showMessageDialog(null,"Enter Correct Address");
											 c++;
											break;
										}
									}

				///*********************************************E-mail Validation*******************************************


								String t44;
								t44=t4.getText();
								if(t44.endsWith("@gmail.com"))
								{

								}
								else if(t44.endsWith("@yahoo.com"))
								{
								}
								else if(t44.endsWith("@rediff.com"))
								{
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Worng Email");
									c++;


								}




//	**********************************************************Contact Validation*******************************************************************
									String Qt=t5.getText();  //
									int qtl=Qt.length();

									for(int i=0;i<qtl;i++)
									{
										char ch=Qt.charAt(i);
										if(ch>='0' && ch<='9')
										{
											if(qtl==10)
											{


											}
											 else
											{
												JOptionPane.showMessageDialog(null,"Enter Correct Value To Correct contact");
												c++;
												break;
											}
										}

										else
										{
											JOptionPane.showMessageDialog(null,"Enter Correct Value To Contact Quanity Box");
											//c++;
											break;
										}

									}


				//*******************************not null Validation********************************************************************

											if (t2.getText().equals("")) //name not null validation
											 {
													JOptionPane.showMessageDialog(null,"Fill Product Name Box");
													c++;
											 }

											 if (t3.getText().equals("")) //Address not null validation
											 							 {
											 									JOptionPane.showMessageDialog(null,"Fill Address Box");
											 									c++;
											 }
											 if (t4.getText().equals("")) //Email not null validation
											 							 {
											 									JOptionPane.showMessageDialog(null,"Fill E-mailBox");
											 									c++;
											 }
											 if (t5.getText().equals("")) //Contact not null validation
											 							 {
											 									JOptionPane.showMessageDialog(null,"Fill Contact Box");
											 									c++;
							 }




				if(c==0)
				{

					String Gender;
					boolean q=op1.getState();
					if(q==true)
						 Gender="Male";
					else
	 					Gender="Fmale";
					try
					{
						int sv;
						String str="insert into Supplier values("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+Gender+"','"+t4.getText()+"','"+t5.getText()+"')";
						sv=st.executeUpdate(str);
						if(sv>0)
						{
							JOptionPane.showMessageDialog(null,"Recored Inserted");
							int xy=Integer.parseInt(t1.getText());
							xy=xy+1;
							t1.setText(""+xy);
							t2.setText("");
							t3.setText("");
							t4.setText("");
							t5.setText("");
						}
					}
					catch(Exception t)
					{
						System.out.println(t);
					}


				}
			}
//**********************************Search Button Code*********************************
	if(b==b3)
	{
		try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				cn=DriverManager.getConnection("jdbc:odbc:MDII");
				st=cn.createStatement();
				ResultSet rs;
				int temp;
				temp=Integer.parseInt(JOptionPane.showInputDialog("Enter 0 for Supplier Id And 1 For Supplier Name "));

				if(temp==0)
				{
						int sid;
						sid=Integer.parseInt(JOptionPane.showInputDialog("Enter Id"));
												 String str="select * from Supplier where Supplier_ID="+sid;
												 rs= st.executeQuery(str);
												 while(rs.next())
												 {
													 t1.setText(rs.getString(1));
													 t2.setText(rs.getString(2));
													 t3.setText(rs.getString(3));
													  if(rs.getString(4)=="Male")
													  {
													 			op1.setState(true);
													  }
													  else
													  {
													 			op2.setState(true);
													  }
													 t4.setText(rs.getString(5));
													 t5.setText(rs.getString(6));
													 		b2.setEnabled(false);
															b4.setEnabled(true);
															b5.setEnabled(true);




												}
				}
				else if(temp==1)
				{
							String en;
							en=JOptionPane.showInputDialog("Enter Supplier Name");
							String pqr="select * from Supplier where Supplier_ID="+en;
							rs=st.executeQuery(pqr);

							while (rs.next())
							{
								t1.setText(rs.getString(1));
								 t2.setText(rs.getString(2));
								t3.setText(rs.getString(3));
								if(rs.getString(4)=="Male")
								{
									op1.setState(true);
								}
								else
								{
									op2.setState(true);
								}
								t4.setText(rs.getString(5));
								t5.setText(rs.getString(6));
								b2.setEnabled(false);
								b4.setEnabled(true);
								b5.setEnabled(true);


				}



									}
							}
							catch(Exception z)
							{
								System.out.println(z);
							}


						}
//*****************Report Button Code***************************************************
					if(b==b6)
					{
						new SupplierReport();
					}
//*********************************Update Button Code**********************************************************
	if(b==b4)
		{

			try
			{
				int c=0;
				///*********************************************Name Validation	*******************************************
									String cname=t2.getText();
									int cnamel=cname.length();
									for(int i=0;i<cnamel;i++)
									{
										char ch=cname.charAt(i);
										if(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
										{
										}
										else
										{
											JOptionPane.showMessageDialog(null,"Enter Correct Value Name");
											c++;
											break;
										}
									}
				///*********************************************Address Validation*******************************************

									String cadd=t3.getText();
									int caddl=cadd.length();
									for(int i=0;i<caddl;i++)
									{
										char ch=cadd.charAt(i);
										if(ch>='A' && ch<='Z' || ch>='a' && ch<='z'||ch>='0' && ch<='9' || ch==',' ||ch=='.' ||ch=='-'||ch==' ')
										{
										}

										else
										{
											 JOptionPane.showMessageDialog(null,"Enter Correct Address");
											 c++;
											break;
										}
									}

				///*********************************************E-mail Validation*******************************************


								String t44;
								t44=t4.getText();
								if(t44.endsWith("@gmail.com"))
								{

								}
								else if(t44.endsWith("@yahoo.com"))
								{
								}
								else if(t44.endsWith("@rediff.com"))
								{
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Worng Email");
									c++;


								}




//				**********************************************************Contact Validation*******************************************************************
									String Qt=t5.getText();  //
									int qtl=Qt.length();

									for(int i=0;i<qtl;i++)
									{
										char ch=Qt.charAt(i);
										if(ch>='0' && ch<='9')
										{
											if(qtl==10)
											{


											}
											 else
											{
												JOptionPane.showMessageDialog(null,"Enter Correct Value To Correct contact");
																					c++;
												 	break;
											}
										}

										else
										{
											JOptionPane.showMessageDialog(null,"Enter Correct Value To Contact Quanity Box");
											//c++;
											break;
										}

									}


				//*******************************not null Validation********************************************************************

											if (t2.getText().equals("")) //name not null validation
											 {
													JOptionPane.showMessageDialog(null,"Fill Product Name Box");
													c++;
											 }

											 if (t3.getText().equals("")) //Address not null validation
											 							 {
											 									JOptionPane.showMessageDialog(null,"Fill Address Box");
											 									c++;
											 }
											 if (t4.getText().equals("")) //Email not null validation
											 							 {
											 									JOptionPane.showMessageDialog(null,"Fill E-mailBox");
											 									c++;
											 }
											 if (t5.getText().equals("")) //Contact not null validation
											 							 {
											 									JOptionPane.showMessageDialog(null,"Fill Contact Box");
											 									c++;
							 }
					if(c==0)
					{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					cn=DriverManager.getConnection("jdbc:odbc:MDII");
					st=cn.createStatement();
					String Gender;

					boolean q=op1.getState();
					if(q==true)
					Gender="Male";
					else
					Gender="Female";

								int x;
								int sid=Integer.parseInt(t1.getText());

			  					int selectedOption = JOptionPane.showConfirmDialog(null,"Do you wanna Update This Recored","Choose",JOptionPane.YES_NO_OPTION);
			  					if (selectedOption == JOptionPane.YES_OPTION)
			  					{
									x=st.executeUpdate("update Supplier set Supplier_Name='"+t2.getText()+"',Supplier_Address='"+t3.getText()+"',Supplier_Gender='"+Gender+"',Supplier_Email='"+t4.getText()+"',Supplier_Contcat='"+t5.getText()+"' where Supplier_ID="+sid);
									if(x>0)
									{
										JOptionPane.showMessageDialog(null,"Record updated");
//******************************************Auto increment BillId Code*****************************************
											try
											{
													Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
													cn=DriverManager.getConnection("jdbc:odbc:MDII");
													st=cn.createStatement();
													ResultSet rs=st.executeQuery("Select * From Supplier");
													while (rs.next())
													{
															 a=rs.getString(1);
															 System.out.println(a);


													}
													w=Integer.parseInt(a);
													System.out.println(w);
													w=w+1;

														t1.setText(""+w);

												}
												catch(Exception p)
												{
														System.out.println(p);
												}

										t2.setText(" ");
										t3.setText(" ");
										t4.setText(" ");
										t5.setText(" ");
										b4.setEnabled(false);
										b5.setEnabled(false);
										b2.setEnabled(true);

									}

								}
				}


			}
			catch(Exception j)
			{
						System.out.println(j);
			}
	}
//***************************Delete Button Code**************************************
	if(b==b5)
	{

		try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				cn=DriverManager.getConnection("jdbc:odbc:MDII");
				st=cn.createStatement();

			  	int sid=Integer.parseInt(t1.getText());
			  	int selectedOption = JOptionPane.showConfirmDialog(null,"Do you wanna Delete This Recored","Choose",JOptionPane.YES_NO_OPTION);
				if (selectedOption == JOptionPane.YES_OPTION)
			  	{
					int sv=st.executeUpdate("Delete From Supplier where Supplier_ID="+sid);
					if(sv>0)
					{
						JOptionPane.showMessageDialog(null,"Recored Deleted");
						t1.setText(" ");
						t2.setText(" ");
						t3.setText(" ");
						t4.setText(" ");
						t5.setText(" ");
							b4.setEnabled(false);
							b5.setEnabled(false);
							b2.setEnabled(true);
					}

				}

		}
		catch(Exception h)
		{
			System.out.println(h);
		}
	}
//***********************Clear Button Code**********************************
	if(b==b7)
	{
			t2.setText(" ");
			t3.setText(" ");
			t4.setText(" ");
			t5.setText(" ");
	}
}
public void mouseClicked(MouseEvent e)
{

		JLabel L = (JLabel)e.getSource();

		if (ll1 == L)
		{
			new CustomerAdmin();
		}

		if (ll2 == L)
		{
			new EmployeeAdmin();
		}
		if (ll3 == L)
		{
			new ProductAdmin();
		}
		if (ll4 == L)
		{
			new SupplierAdmin();
		}
		if (ll5 == L)
		{
			new Bill();
		}
		if (ll6 == L)
		{
			new MDI();
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
//**********************Main Method*********************************************************************************
	public static void main(String args[])
		{
			new SupplierAdmin();
	}
}
