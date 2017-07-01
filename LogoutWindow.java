import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class LogoutWindow extends JFrame 
{
	JPanel top, bottom;
	JLabel logoutConfirmation;
	JButton confirmYes, confirmNo;
	BankAccount  account;
	LogoutWindow(BankAccount account)
	{
		this.account = account;
		setTitle("Logout");
		buildTopPanel();
		buildBottomPanel();
		getContentPane().add(top, BorderLayout.NORTH);
		getContentPane().add(bottom);
		setSize(250,100);
		setResizable(false);
	}
	private void buildTopPanel()
	{
		top = new JPanel();
		logoutConfirmation = new JLabel("Are you sure you want to logout?");
		top.add(logoutConfirmation);
	}
	private void buildBottomPanel()

	{
		bottom = new JPanel();
		confirmYes = new JButton("Yes");
		confirmYes.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
					try {
						BankAccount.LoadAccountInformation(accountList);
					} catch (Exception e) {
					}
					setVisible(true);
					dispose();
					LoginWindow loginWin = new LoginWindow(accountList);
					loginWin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					loginWin.setSize(400,200);
					loginWin.setVisible(true);
				}
			});
		confirmNo= new JButton("No");
		confirmNo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				dispose();
				InitialWindow initWin =  new InitialWindow(account);
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				initWin.setSize(300,300);
				initWin.setVisible(true);
			}
		});
		bottom.add(confirmYes);
		bottom.add(confirmNo);
	}
	
}
