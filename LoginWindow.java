import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class LoginWindow extends JFrame
{
	JPanel top,center, bottom;
	JLabel accNum, accPass;
	JTextField accountNumber, accountPassword;
	JButton login;
	int attemptAccountNumber = 0;
	String attemptPassword;
	ArrayList<BankAccount> account;
	int failedLoginTries;
	LoginWindow(ArrayList<BankAccount>  account)
	{
		this.account = account;
		buildTopPanel();
		buildCenterPanel();
		buildBottomPanel();
		setTitle("Login");
		getContentPane().add(top, BorderLayout.NORTH);
		getContentPane().add(center , BorderLayout.CENTER);
		getContentPane().add(bottom, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(400,200);
		setResizable(false);
		addWindowListener(new confirmExit());
	}
	private void buildTopPanel()
	{
		top = new JPanel();
		accNum = new JLabel("Account Number:");
		accountNumber = new JTextField();
		accountNumber.setPreferredSize(new Dimension(100,30));
		accountNumber.setAlignmentX(Component.TOP_ALIGNMENT);
		top.add(accNum);
		top.add(accountNumber);
	}
	private void buildCenterPanel()
	{
		center = new JPanel();
		accPass = new JLabel("Account Password:");
		accountPassword = new JPasswordField();
		accountPassword.setPreferredSize(new Dimension(100,30));
		accountNumber.setAlignmentX(Component.TOP_ALIGNMENT);
		center.add(accPass);
		center.add(accountPassword);
	}
	private void buildBottomPanel()
	{
		bottom = new JPanel();
		login = new JButton("Login");
		login.setAlignmentX(Component.TOP_ALIGNMENT);
		login.setPreferredSize(new Dimension(80,40));
		login.addActionListener(new ActionListener()
				{		
					public void actionPerformed(ActionEvent event)
					{
						attemptAccountNumber = Integer.parseInt(accountNumber.getText());
						attemptPassword = accountPassword.getText();
						for(int i = 0; i <account.size(); i++)
						{
							if((attemptPassword.equals(account.get(i).getPassword()))&& (attemptAccountNumber == account.get(i).getAccountNumber()))
							{
								if((account.get(i).getAtmAccess().equals("active")))
								{
									dispose();
									InitialWindow initWin =  new InitialWindow(account.get(i));
									initWin.setVisible(true);
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Cannot Access ATM with this account.");
									requestFocus();
									accountNumber.setText("");
									accountPassword.setText("");
								}
							}
							if(!((attemptPassword.equals(account.get(i).getPassword()))&& (attemptAccountNumber == account.get(i).getAccountNumber())))
							{	
								JOptionPane.showMessageDialog(null,"Wrong Account Number or password, please try again.");
								requestFocus();
								failedLoginTries++;
							}
							if(failedLoginTries == 3)
							{
									JOptionPane.showMessageDialog(null,"Wrong Account Number or password, ATM will now close.");
									requestFocus();
									System.exit(0);
							}
						}
					}
				}
		);
		bottom.add(login);
	}
	private class confirmExit implements WindowListener
	{
	    public void windowOpened(WindowEvent e)
        {}
        public void windowClosing(WindowEvent e)
        {
            ExitWindow exitConfirm = new ExitWindow( );
            exitConfirm.setVisible(true);
        }
        public void windowClosed(WindowEvent e)
        {}
        public void windowIconified(WindowEvent e)
        {}
         public void windowDeiconified(WindowEvent e)
        {}
        public void windowActivated(WindowEvent e)
        {}
        public void windowDeactivated(WindowEvent e)
        {}
    } 

}
