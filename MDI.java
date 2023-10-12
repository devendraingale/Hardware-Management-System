import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;


public class MDI extends Frame implements ActionListener
{
	MenuBar	mb;
	Menu f,Ex,Log,AboutUs,Report,bi;
	MenuItem c,e,s,p,exi,bii,lo,cReport,eReport,sReport,pReport,soReport;
	int result;
	Label l1;




	public MDI()
	{
		setLayout(null);
		l1=new Label("Hardware Management System");

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
		cReport=new MenuItem("Customer Report");
		eReport=new MenuItem("Employee Report");
		sReport=new MenuItem("Supplier Report");
		pReport=new MenuItem("Product Report");
		soReport=new MenuItem("SalesOrder Report");

		bii=new MenuItem("SalesOrder");
		exi=new MenuItem("Exit");

		l1.setBounds(550,50,390,30);
		l1.setFont(new Font("times new roman", Font.BOLD, 20));




		add(l1);
		f.add(c);
		f.add(e);
		f.add(s);
		f.add(p);
		Log.add(lo);
		Ex.add(exi);
		bi.add(bii);
		Report.add(cReport);
		Report.add(eReport);
		Report.add(sReport);
		Report.add(pReport);
		Report.add(soReport);


		mb.add(f);
		mb.add(Report);
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
		Report.addActionListener(this);


	}



	public void actionPerformed(ActionEvent ae)
	              {
	                   try

	                   {
	               		  	String cmp=(String)ae.getActionCommand();

	           				if(cmp.equals("Customer"))
	           	      		{
	                             		new CustomerAdmin();
	                       	}
	             			if(cmp.equals("Employee"))
	           	    		{
	                          		new EmployeeAdmin();
	                       	}
	              			if(cmp.equals("Supplier"))
	                       	{
	                          		new SupplierAdmin();
	                        }
	              			if(cmp.equals("Product"))
	                     	{
	                          		new ProductAdmin();
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
	                       	if(cmp.equals("Customer Report"))
	                       	{

									new CustomerReport();
	                       	}
	                       	if(cmp.equals("Employee Report"))
							{

								new EmployeeReport();
	                       	}
	                       	if(cmp.equals("Supplier Report"))
							{

								new SupplierReport();
	                       	}
	                       	if(cmp.equals("Product Report"))
							{

									new ProductReport();
	                       	}
	                       	if(cmp.equals("SalesOrder Report"))
							{

								new SaleOrderReport();
							}



						}
						catch(Exception e)
						{
							System.out.println(e);
						}

		}


	public static void main(String args[]) throws Exception
	{
		new MDI();
	}
}