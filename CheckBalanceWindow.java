import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;



public class CheckBalanceWindow extends JFrame
{
	JPanel top, bottom;
	JLabel currentBalance;
	JButton back;
	BankAccount account;
	public CheckBalanceWindow(BankAccount account)
	{
		this.account = account;
		setTitle("Check Account Balance");
		buildTopPane();
		buildBottomPane();
		setSize(300,150);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().add(top, BorderLayout.NORTH);
		getContentPane().add(bottom, BorderLayout.SOUTH);
		addWindowListener(new confirmExit());
		setResizable(false);
	}
	private void buildTopPane()
	{
		top = new JPanel();
		currentBalance = new JLabel("Current Balance is " + account.getAccountBalance());
		top.add(currentBalance);
	}
	private void buildBottomPane()
	{
		bottom = new JPanel();
		back = new JButton("Back");
		back.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		back.setPreferredSize(new Dimension(80,40));
		back.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						dispose();
						InitialWindow initWin =  new InitialWindow(account);
						setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						initWin.setSize(300,300);
						initWin.setVisible(true);
					}
				}
				);
		bottom.add(back);
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
