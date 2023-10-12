import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;


public class MDIuser extends Frame implements ActionListener
{
	MenuBar	mb;
	Menu f,Ex,Log,AboutUs,Report,bi;
	MenuItem c,e,s,p,exi,bii,lo;
	int result;




	public MDIuser()
	{
		setLayout(null);

		mb=new MenuBar();
		f=new Menu("Master Entry");
		Ex=new Menu("Exit");
		bi=new Menu("SalesOrder");

		Log=new Menu("Logout");



		AboutUs=new Menu("AboutUs");
		Report=new Menu("Report");


		c=new MenuItem("Customer");
		e=new MenuItem("Employee");
		s=new MenuItem("Supplier");
		p=new MenuItem("Product");
		lo=new MenuItem("Logout");
		exi=new MenuItem("Exit");
		bii=new MenuItem("SalesOrder");





		f.add(c);
		f.add(e);
		f.add(s);
		f.add(p);
		Log.add(lo);
		Ex.add(exi);
		bi.add(bii);


		mb.add(f);
		//mb.add(Report);
		mb.add(bi);
		mb.add(AboutUs);
		mb.add(Log);


		mb.add(Ex);


 		setMenuBar(mb);
		setVisible(true);
		setSize(3000,3000);


        c.addActionListener(this);
        e.addActionListener(this);
        s.addActionListener(this);
        p.addActionListener(this);
		exi.addActionListener(this);
		bii.addActionListener(this);
		Log.addActionListener(this);

	}



	public void actionPerformed(ActionEvent ae)
	              {
	                   try

	                   {
	               		  	String cmp=(String)ae.getActionCommand();

	           				if(cmp.equals("Customer"))
	           	      		{
	                             		new CustomerUser();
	                       	}
	             			if(cmp.equals("Employee"))
	           	    		{
	                          		new EmployeeUser();
	                       	}
	              			if(cmp.equals("Supplier"))
	                       	{
	                          		new SupplierUser();
	                        }
	              			if(cmp.equals("Product"))
	                     	{
	                          		new ProductUser();
	                       	}
	                       	if(cmp.equals("Exit"))
							{
								result = JOptionPane.showConfirmDialog(null,"Are you sure you wish to exit application?",null,JOptionPane.YES_NO_OPTION);
								if(result == JOptionPane.YES_OPTION)
								{
								            JOptionPane.showMessageDialog(null, "GOODBYE");
								            System.exit(0);
								}

							}
							if(cmp.equals("SalesOrder"))
							{
								    new Bill();
	                       	}
	                       	if(cmp.equals("Logout"))
							{

									new Loginmain();
	                       	}


						}
						catch(Exception e)
						{
							System.out.println(e);
						}

		}


	public static void main(String args[]) throws Exception
	{
		new MDIuser();
	}
}