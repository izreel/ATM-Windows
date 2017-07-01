import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class InitialWindow extends JFrame
{	
	public BankAccount account;
	public InitialWindow(BankAccount account)
	{
		this.account = account;
		buildFrame();
		setTitle("ATM");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(300,300);
		setResizable(false);
		addWindowListener(new confirmExit());
	}
	private void buildFrame()
	{
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		getContentPane().add(addDepositButton());
		getContentPane().add(addWithdrawButton());
		getContentPane().add(addCheckBalanceButton());
		getContentPane().add(addTransferButton());
		getContentPane().add(addChangePassButton());
		getContentPane().add(addLogoutButton());
	}
	private Component addDepositButton()
	{
			JButton deposit = new JButton ("Deposit");
			deposit.setPreferredSize(new Dimension(120,60));
			deposit.setMargin(new Insets(0, 0, 0, 0));
			deposit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					dispose();
					DepositWindow depositWin = new DepositWindow(account);
					depositWin.setVisible(true);
				}
			});
			return deposit;
	}
	private Component addWithdrawButton()
	{
		JButton withdraw = new JButton ("Withdraw");
		withdraw.setPreferredSize(new Dimension(120,60));
		withdraw.setMargin(new Insets(0, 0, 0, 0));
		withdraw.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
			dispose();

			WithdrawWindow withdrawWin = new WithdrawWindow(account);
			withdrawWin.setVisible(true);
			}
		});
		return withdraw;
	}
	private Component addCheckBalanceButton()
	{
		JButton checkBalance = new JButton ("Check Balance");
		checkBalance.setPreferredSize(new Dimension(120,60));
		checkBalance.setMargin(new Insets(0, 0, 0, 0));
		checkBalance.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				dispose();
				CheckBalanceWindow balanceWin = new CheckBalanceWindow(account);
				balanceWin.setVisible(true);
			}
		});
		return checkBalance;
	}
	private Component addTransferButton()
	{
		JButton transfer = new JButton ("Make a Transfer");
		transfer.setPreferredSize(new Dimension(120,60));
		transfer.setMargin(new Insets(0, 0, 0, 0));
		transfer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				dispose();
				TransferWindow transWin = new TransferWindow(account);
				transWin.setVisible(true);
			}
		});
		return transfer;
	}
	private Component addChangePassButton()
	{
		JButton changePassword = new JButton ("Change Password");
		changePassword.setPreferredSize(new Dimension(120,60));
		changePassword.setMargin(new Insets(0, 0, 0, 0));
		changePassword.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				dispose();
				ChangePasswordWindow changeWin = new ChangePasswordWindow(account);
				changeWin.setVisible(true);
			}
		});
		return changePassword;
	}
	private Component addLogoutButton()
	{
		JButton logout = new JButton ("Logout");
		logout.setPreferredSize(new Dimension(120,60));
		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				dispose();
				LogoutWindow logoutWin = new LogoutWindow(account);
				logoutWin.setVisible(true);		
			}
		});
		return logout;
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

