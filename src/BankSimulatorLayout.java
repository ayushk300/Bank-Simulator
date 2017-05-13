import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class BankSimulatorLayout extends WindowAdapter implements ActionListener {
	int z,p;
	Statement stmt;
	Object REFbutton=null;boolean flag,b;
	ResultSet rslt;
	JFrame f;
	JInternalFrame open_acc,close_acc,deposit_acc,withdraw_acc;
	JMenuBar mb=new JMenuBar();
	JMenu acc,trans;
	JMenuItem open,close,exit,deposit,withdraw;
	JLabel acc_no_open,name_open,amount_open,balance_close,acc_no_close,name_close,acc_no_deposit,name_deposit,balance_deposit,amount_deposit,
	acc_no_withdraw,name_withdraw,balance_withdraw,amount_withdraw;
	JButton open_save,open_cancel,close_delete,close_cancel,open_close,deposit_cancel,withdraw_cancel,withdraw_withdraw,close_close,deposit_close,withdraw_close,deposit_update;
	JLabel open_acc_field,close_name_field,close_balance_field,deposit_name_field,
	deposit_balance_field,withdraw_balance_field,withdraw_name_field;
	JTextField name_otf,amount_otf,acc_no_ctf,acc_no_dtf,amount_dtf,acc_no_wtf,amount_wtf;
	public BankSimulatorLayout()
	{
		
		f=new JFrame();
		f.setSize(500,500);
		JDesktopPane desktop=new JDesktopPane();
		f.add(desktop);
		open_acc=new JInternalFrame("OPEN ACCOUNT",true,true,false,false);
		open_acc.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		close_acc=new JInternalFrame("CLOSE ACCOUNT",true,true,false,false);
		close_acc.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		deposit_acc=new JInternalFrame("DEPOSIT ACCOUNT",true,true,false,false);
		deposit_acc.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		withdraw_acc=new JInternalFrame("WITHDRAW ACCOUNT",true,true,false,false);
		withdraw_acc.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		 name_otf=new JTextField();
		 amount_otf=new JTextField();
		acc_no_ctf=new JTextField();
		acc_no_dtf=new JTextField();
		amount_dtf=new JTextField();
		acc_no_wtf=new JTextField();
		amount_wtf=new JTextField();
		
		 acc=new JMenu("ACCOUNT");
		trans=new JMenu("TRANSACTION") ;
		
		open=new JMenuItem("OPEN");
		close=new JMenuItem("CLOSE");
		exit=new JMenuItem("EXIT");
		deposit=new JMenuItem("DEPOSIT");
		withdraw=new JMenuItem("WITHDRAW");
		
		acc_no_open=new JLabel("ACCOUNT_NO     :");
		acc_no_close=new JLabel("ACCOUNT_NO     :");
		acc_no_deposit=new JLabel("ACCOUNT_NO     :");
		acc_no_withdraw=new JLabel("ACCOUNT_NO     :");
		name_open=new JLabel("NAME           :"      );
		name_close=new JLabel("NAME           :"      );
		name_withdraw=new JLabel("NAME           :"      );
		name_deposit=new JLabel("NAME           :"      );
		amount_open=new JLabel("AMOUNT         :"        );
		amount_withdraw=new JLabel("AMOUNT         :"        );
		amount_deposit=new JLabel("AMOUNT         :"        );
	   balance_close=new JLabel("BALANCE        :");
	   balance_withdraw=new JLabel("BALANCE        :");
	   balance_deposit=new JLabel("BALANCE        :");
		
	   	open_save=new JButton("SAVE");
		open_cancel=new JButton("CANCEL");
		close_delete=new JButton("DELETE");
		close_cancel=new JButton("CANCEL");
		open_close=new JButton("CLOSE");
		close_close=new JButton("CLOSE");
		withdraw_close=new JButton("CLOSE");
		deposit_close=new JButton("CLOSE");
		deposit_cancel=new JButton("CANCEL");
		withdraw_cancel=new JButton();
		withdraw_withdraw=new JButton("WITHDRAW");
	//	deposit_update=new JButton("CANCEL");
		deposit_update=new JButton("UPDATE"); 
				
		open_acc_field=new JLabel("     0");
		close_name_field=new JLabel("     0");
		close_balance_field=new JLabel("     0");
		deposit_name_field=new JLabel("     0");
		deposit_balance_field=new JLabel("     0");
		withdraw_balance_field=new JLabel("     0");
		withdraw_name_field=new JLabel("     0");
		
		acc.add(open);
		acc.add(close);
		acc.add(exit);
		trans.add(deposit);trans.add(withdraw);
		mb.add(acc);mb.add(trans);
		
		f.setJMenuBar(mb);
		open.addActionListener(this);close.addActionListener(this);exit.addActionListener(this);
		deposit.addActionListener(this);withdraw.addActionListener(this);
		open_save.addActionListener(this);open_cancel.addActionListener(this);close_delete.addActionListener(this);
		close_cancel.addActionListener(this);open_close.addActionListener(this);deposit_cancel.addActionListener(this);
		withdraw_cancel.addActionListener(this);
		withdraw_withdraw.addActionListener(this);deposit_update.addActionListener(this);;
		close_close.addActionListener(this);deposit_close.addActionListener(this);withdraw_close.addActionListener(this);
		
		open_acc.setSize(200, 250);
		open_acc.setLayout(new GridLayout(4,1));
		close_acc.setSize(200, 250);
		close_acc.setLayout(new GridLayout(4,1));
		deposit_acc.setSize(250, 250);
		deposit_acc.setLayout(new GridLayout(5,1));
		withdraw_acc.setSize(250, 250);
		withdraw_acc.setLayout(new GridLayout(5,1));
		
		
		JPanel p1=new JPanel();
		p1.setSize(200,50);
		p1.setLayout(new GridLayout(1,2));
		JPanel p2=new JPanel();
		p2.setSize(200,50);
		p2.setLayout(new GridLayout(1,2));
		JPanel p3=new JPanel();
		p3.setSize(200,50);
		p3.setLayout(new GridLayout(1,2));
		JPanel p4=new JPanel();
		p4.setSize(200,50);
		p4.setLayout(new GridLayout(1,3));
		
		p1.add(acc_no_open);
		p1.add(open_acc_field);
		p2.add(name_open);
		p2.add(name_otf);
		p3.add(amount_open);
		p3.add(amount_otf);
		p4.add(open_save);
		p4.add(open_cancel);
		p4.add(open_close);
		
		open_acc.add(p1);open_acc.add(p2);open_acc.add(p3);open_acc.add(p4);
		
		
		p1=new JPanel();
		p1.setSize(200,50);
		p1.setLayout(new GridLayout(1,2));
		p2=new JPanel();
		p2.setSize(200,50);
		p2.setLayout(new GridLayout(1,2));
		p3=new JPanel();
		p3.setSize(200,50);
		p3.setLayout(new GridLayout(1,2));
		p4=new JPanel();
		p4.setSize(200,50);
		p4.setLayout(new GridLayout(1,3));
		
		p1.add(acc_no_close);
		p1.add(acc_no_ctf);
		p2.add(name_close);
		p2.add(close_name_field);
		p3.add(balance_close);
		p3.add(close_balance_field);
		p4.add(close_delete);
		p4.add(close_cancel);
		p4.add(close_close);
		
		close_acc.add(p1); close_acc.add(p2); close_acc.add(p3); close_acc.add(p4);
		
		
		
		p1=new JPanel();
		p1.setSize(250,50);
		p1.setLayout(new GridLayout(1,2));
		p2=new JPanel();
		p2.setSize(250,50);
		p2.setLayout(new GridLayout(1,2));
		p3=new JPanel();
		p3.setSize(250,50);
		p3.setLayout(new GridLayout(1,2));
		p4=new JPanel();
		p4.setSize(250,50);
		p4.setLayout(new GridLayout(1,2));
		JPanel p5=new JPanel();
		p5.setSize(250,50);
		p5.setLayout(new GridLayout(1,3));
		
		p1.add(acc_no_deposit);
		p1.add(acc_no_dtf);
		p2.add(name_deposit);
		p2.add(deposit_name_field);
		p3.add(balance_deposit);
		p3.add(deposit_balance_field);
		p5.add(deposit_update);
		p5.add(deposit_cancel);
		p5.add(deposit_close);
		p4.add(amount_deposit);p4.add(amount_dtf);
		
		deposit_acc.add(p1);deposit_acc.add(p2);deposit_acc.add(p3);deposit_acc.add(p4);deposit_acc.add(p5);
		
		
		

		p1=new JPanel();
		p1.setSize(250,50);
		p1.setLayout(new GridLayout(1,2));
		p2=new JPanel();
		p2.setSize(250,50);
		p2.setLayout(new GridLayout(1,2));
		p3=new JPanel();
		p3.setSize(250,50);
		p3.setLayout(new GridLayout(1,2));
		p4=new JPanel();
		p4.setSize(250,50);
		p4.setLayout(new GridLayout(1,2));
		p5=new JPanel();
		p5.setSize(250,50);
		p5.setLayout(new GridLayout(1,3));
		
		p1.add(acc_no_withdraw);
		p1.add(acc_no_wtf);
		p2.add(name_withdraw);
		p2.add(withdraw_name_field);
		p3.add(balance_withdraw);
		p3.add(withdraw_balance_field);
		p5.add(withdraw_withdraw);
		p5.add(withdraw_cancel);
		p5.add(withdraw_close);
		p4.add(amount_withdraw);p4.add(amount_wtf);
		
		withdraw_acc.add(p1);withdraw_acc.add(p2);withdraw_acc.add(p3);withdraw_acc.add(p4);withdraw_acc.add(p5);
		
		desktop.add(open_acc);
		desktop.add(close_acc);
		desktop.add(withdraw_acc);
		desktop.add(deposit_acc);
		
		f.setVisible(true);
		
		acc_no_ctf.addActionListener(this);
		acc_no_dtf.addActionListener(this);
		acc_no_wtf.addActionListener(this);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts?user=root&password=root");
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rslt=stmt.executeQuery("Select * from account ");
		}
		catch(Exception e)
		{
			System.out.println("ERROR: "+e.getMessage());
		}
	}
	public void synchronize(Object sync) throws SQLException
	{
		
		if(sync==open_save)
		{
			acc_no_ctfprob();
			acc_no_dtfprob();
			acc_no_wtfprob();
		}
		else if(sync==close_delete)
		{
			acc_no_dtfprob();
			acc_no_wtfprob();
			boolean b1=rslt.last();
			if(b1){
				open_acc_field.setText(rslt.getInt("Acc_no")+1+"");
				}
			else {
				open_acc_field.setText("1");	
			}
		}
		else if(sync==deposit_update)
		{
			acc_no_ctfprob();
			acc_no_wtfprob();
		}
		else if(sync==withdraw_withdraw)
		{ 
			acc_no_ctfprob();
			acc_no_dtfprob();
		}
		
	}
	public boolean isNumeric(String s)
	{
		for(int i=0;i< s.length();i++)
		{
			char a=s.charAt(i);
			if(i==0 && a==48  ){return false;}
			if(a<48 && a>57){return false;}
		}
		return true;
	}
	public void acc_no_ctfprob() throws SQLException
	{
		
		REFbutton=	acc_no_ctf;
		 isCorrect();
		 	System.out.println("textEvent in ctf");
		if(b)
		{
			rslt.absolute(p);
			close_name_field.setText(rslt.getString("name"));
			close_balance_field.setText(""+rslt.getInt("balance"));
			
		}
		else
		{
			if((acc_no_ctf.getText()).equals("")){
				close_name_field.setText("");
				close_balance_field.setText("");
			}
			else{
			JOptionPane.showMessageDialog(close_acc,"ACCOUNT DO NOT EXISTS","INVALID",JOptionPane.ERROR_MESSAGE);
			close_name_field.setText("");
			close_balance_field.setText("");
			}
		}
		b=false;
		
	}
	public void acc_no_dtfprob() throws SQLException
	{
		
		REFbutton=acc_no_dtf;
	 	isCorrect(); 
	 	System.out.println("textEvent in dtf");
	 	if(b)
		{
			rslt.absolute(p);
			deposit_name_field.setText(rslt.getString("name"));
			deposit_balance_field.setText(""+rslt.getInt("balance"));
		}
		else
		{
			if((acc_no_dtf.getText()).equals("")){}
			else
			{
				JOptionPane.showMessageDialog(deposit_acc,"ACCOUNT DOES NOT EXISTS","INVALID",JOptionPane.ERROR_MESSAGE);
			}
			deposit_name_field.setText("");
			deposit_balance_field.setText("");
		}
	 	b=false;
	}
	public void acc_no_wtfprob() throws SQLException
	{
		 REFbutton=acc_no_wtf;
		 isCorrect();
		 System.out.println("textEvent in wtf");
		 	if(b)
			{
				
		 		System.out.print("1");
		 	
		 		
		 		rslt.absolute(p);
		 		
		 		withdraw_name_field.setText(rslt.getString("name"));
				withdraw_balance_field.setText(""+rslt.getInt("balance"));
				System.out.print("2");
			}
			else
			{
				System.out.print("3");
				if((acc_no_wtf.getText()).equals("")){}
				else
				{
					JOptionPane.showMessageDialog(withdraw_acc,"ACCOUNT DOES NOT EXISTS","INVALID",JOptionPane.ERROR_MESSAGE);
				}
				withdraw_name_field.setText("");
				withdraw_balance_field.setText("");
				System.out.print("4");
			}
		 b=false;
		
	}
	public void windowClosing(WindowEvent e)
	{
		Window w=e.getWindow();
		w.dispose();
		
	}
	public void isCorrect() throws SQLException
	{
		z=0;p=0;
		b=false;
		String str1;
		 rslt.beforeFirst();
		if(REFbutton==deposit_update || REFbutton== acc_no_dtf)
		{
				
				while(rslt.next())
				{
					z++;
					str1=""+rslt.getInt("acc_no");
					if(str1.equals(acc_no_dtf.getText()))
					 {
						p=z;
						b=true; 
					 }
					 
				}
				 
			 
		}
		else if(REFbutton==close_delete || REFbutton== acc_no_ctf)
		{
			System.out.println("exception ctf ke iscorrcet call mai ,code ke andar 1");
			while(rslt.next())
			{
				z++;
				str1= ""+rslt.getInt("acc_no");
				if(str1.equals(acc_no_ctf.getText()))
				 {
					p=z;
					b=true; 
				 }
				 
			}	System.out.println(b);
		}
		else if(REFbutton==withdraw_withdraw || REFbutton== acc_no_wtf)
		{
			while(rslt.next())
			{
				z++;
				str1=""+rslt.getInt("acc_no") ;
				if(str1.equals(acc_no_wtf.getText()))
				 {
					p=z;
					b=true; 
				 }
				 
			}
		}
		REFbutton=null;
		
	}
	public void actionPerformed(ActionEvent e) 
	{
			try{
			
				
				
		
			if(e.getSource()==open )
			   {
				open_acc.setLocation(0, 0);
				open_acc.setSize(250,200);
				open_acc.setVisible(true);
		
				boolean b1=rslt.last();
				if(b1){
					open_acc_field.setText(rslt.getInt("Acc_no")+1+"");
					}
				else {
					open_acc_field.setText("1");	
				}
				open_acc.toFront();
			   }
			 else if(e.getSource()==exit)
				{
				System.exit(-1);
				}
			 else if(e.getSource()==deposit)
				{
				 deposit_acc.setLocation(50,200);
				 deposit_acc.setSize(250,200);
				 deposit_acc.setVisible(true);
				 deposit_acc.toFront();
				}
			 	else if(e.getSource()==withdraw)
			 	{
				 withdraw_acc.setLocation(150,275);
				 withdraw_acc.setSize(250,200);
				 withdraw_acc.setVisible(true);
				 withdraw_acc.toFront();
				}
			 	else if(e.getSource()==close)
				{
				 close_acc.setLocation(150,50);
				 close_acc.setSize(250,200);
				 close_acc.setVisible(true);
				 close_acc.toFront();
				 
				}
			 	else if(e.getSource()==open_save)
				{
			 		int a=0;
			 		if(isNumeric(amount_otf.getText()))
			 		{
			 			a=new Integer(amount_otf.getText());
			 		}
			 	
			 		
			 	   
			 	  if(a>=1000 && isNumeric(amount_otf.getText()))
			 	   {
			 		 rslt.moveToInsertRow();
			 		   rslt.updateInt("acc_no",new Integer(open_acc_field.getText()).intValue());
			 		   rslt.updateString("name",name_otf.getText());
			 		   rslt.updateInt("balance",new Integer(amount_otf.getText()).intValue());
			 		   rslt.insertRow(); 
			 		  name_otf.setText("");
						amount_otf.setText("");
						boolean b1=rslt.last();
						if(b1){
							open_acc_field.setText(rslt.getInt("Acc_no")+1+"");
							}
						else {
							open_acc_field.setText("1");	
						}
			 	   }
			 	   else
			 	   {
			 		 
			 		  if(a<=999 || (!isNumeric(amount_otf.getText())) )
			 		  {
			 			  JOptionPane.showMessageDialog(open_acc,"Aomunt Should be Atleast 1000 or may be a use of Inappropriate value","InappropriateAmount",JOptionPane.ERROR_MESSAGE);
			 		  }
			 		    
			 	   }	
			 	  b=false;
			 	
				}
			 	else if(e.getSource()==open_cancel)
				{
					name_otf.setText("");
					amount_otf.setText("");
					boolean b1=rslt.last();
					if(b1){
						open_acc_field.setText(rslt.getInt("Acc_no")+1+"");
						}
					else {
						open_acc_field.setText("1");	
					}
				}
			 	else if(e.getSource()==close_delete)
				{
					REFbutton=close_delete;
			 		isCorrect();
					if(b)
					{
						int result=JOptionPane.showConfirmDialog(close_acc, "R U SURE  U WANT TO DELETE THIS ACCOUNT?","CONFIRM",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(result==JOptionPane.YES_OPTION)
						{
							rslt.absolute(p);
							rslt.deleteRow();
							acc_no_ctf.setText("");
							close_name_field.setText("");
							close_balance_field.setText("");
							synchronize(e.getSource());
						}
						else 
						{
							
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(close_acc,"InCorrect Account Number ", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					b=false;
				}
			 	else if(e.getSource()==close_cancel)
				{
					acc_no_ctf.setText("");
					close_name_field.setText("");
					close_balance_field.setText("");
				
				}
			 	else if(e.getSource()==open_close)
				{
				 	name_otf.setText("");
					amount_otf.setText("");	
					open_acc.setVisible(false);
				}
			 	else if(e.getSource()==deposit_cancel)
				{
			 		acc_no_dtf.setText("");
			 		deposit_name_field.setText("");
			 		deposit_balance_field.setText("");
			 		amount_dtf.setText("");
			 	
				}
				else if(e.getSource()==withdraw_cancel)
				{
					acc_no_wtf.setText("");
					withdraw_name_field.setText("");
					withdraw_balance_field.setText("");
					amount_wtf.setText("");
				}
				else if(e.getSource()==withdraw_withdraw)
				{
					REFbutton=withdraw_withdraw;
					isCorrect();
					System.out.println("1");
					if(b && isNumeric(amount_wtf.getText()))
					{
						System.out.println("2");
						int a=new Integer(amount_wtf.getText()).intValue();
						System.out.println(a);
						rslt.absolute(p);
						if ((rslt.getInt("balance") >=(a +1000)) && a<25000)
						{
							System.out.println("3");
						
							int b=rslt.getInt("balance")- a;
							System.out.println(b);
							rslt.updateInt("balance",b);
							rslt.updateRow();
							synchronize(e.getSource());
							acc_no_wtf.setText("");
							withdraw_name_field.setText("");
							withdraw_balance_field.setText("");
							amount_wtf.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(withdraw_acc,"Amount has Exceeded ,should be less than 25000 and should be less than bal-1000","ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(withdraw_acc,"inappropriate amount or acc_no","ERROR",JOptionPane.ERROR_MESSAGE);
					}
					b=false;
				}
				 else if(e.getSource()==close_close)
				{
					 	acc_no_ctf.setText("");
						close_name_field.setText("");
						close_balance_field.setText("");
						close_acc.setVisible(false);
				}
				 else if(e.getSource()==deposit_close)
				{
					 	acc_no_dtf.setText("");
				 		deposit_name_field.setText("");
				 		deposit_balance_field.setText("");
				 		amount_dtf.setText("");	
				 		deposit_acc.setVisible(false);
				}
				 else if(e.getSource()==withdraw_close)
				{
					 acc_no_wtf.setText("");
						withdraw_name_field.setText("");
						withdraw_balance_field.setText("");
						amount_wtf.setText("");	
					 withdraw_acc.setVisible(false);
				}
				 else if(e.getSource()==deposit_update)
				{
					REFbutton=deposit_update;
					 isCorrect();                                           //i think isCorrect function would have worked more efficiently if i
					 														// would have use the boolean return type 
					 if(b  && isNumeric(amount_dtf.getText()) )
					 {
						int result=JOptionPane.showConfirmDialog(deposit_acc,"Sure u want to deposite This amount","CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
						if(result==JOptionPane.YES_OPTION)
						{
							rslt.absolute(p);
							int a=new Integer(amount_dtf.getText()).intValue()+rslt.getInt("balance");
							rslt.updateInt("balance",a);
							rslt.updateRow();
							synchronize(e.getSource());
							acc_no_dtf.setText("");
					 		deposit_name_field.setText("");
					 		deposit_balance_field.setText("");
					 		amount_dtf.setText("");
							
						}
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(deposit_acc,"Details Provided Are Incorrect or amount Entered Is Invalid " ,"ERROR",JOptionPane.ERROR_MESSAGE);
					 }
						
					 b=false;
					
				}
				 else if(e.getSource()==acc_no_ctf)
				 {
					 acc_no_ctfprob();
					
				 }
				 else if(e.getSource()==acc_no_dtf)
				 {
					 acc_no_dtfprob();
					
				 }
				 else if (e.getSource()==acc_no_wtf)
				 {
					 acc_no_wtfprob();
					
				 }
				
			}	
			catch(Exception ex)
			{
				System.out.println("Exception: "+ex.getMessage());
			}
	}
	public static void main(String args[])
	{
		BankSimulatorLayout bs=new BankSimulatorLayout();
	}
}
