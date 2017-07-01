import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;


public class WithdrawWindow extends JFrame{
	JPanel top, bottom;
	JButton submit, back;
	JTextField withdrawAmount;
	JLabel withdraw;
	BankAccount account;
	WithdrawWindow(BankAccount account)
	{
		this.account = account;
		buildTopPanel();
		buildBottomPanel();
		setSize(300,150);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().add(top,BorderLayout.NORTH);
		getContentPane().add(bottom);
		setResizable(false);
		addWindowListener(new confirmExit());
	}
	private void buildTopPanel()
	{
		top = new JPanel();
		withdraw = new JLabel("Withdraw Amount:");
		withdrawAmount = new JTextField();
		withdrawAmount.setPreferredSize(new Dimension(100,30));
		top.add(withdraw);
		top.add(withdrawAmount);
	}
	private void buildBottomPanel()
	{
		bottom= new JPanel();
		submit = new JButton("Withdraw");
		submit.setAlignmentX(Component.TOP_ALIGNMENT);
		submit.setPreferredSize(new Dimension(80,40));
		submit.setMargin(new Insets(0, 0, 0, 0));
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				double withdrawValue = Double.parseDouble(withdrawAmount.getText());
				account.withdrawal(withdrawValue);
				JOptionPane.showMessageDialog(null,"Withdraw Successful.");
				requestFocus();
				dispose();
				InitialWindow initWin =  new InitialWindow(account);
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				initWin.setSize(300,300);
				initWin.setVisible(true);

			}
		}
		);
		back = new JButton("Back");
		back.setAlignmentX(Component.TOP_ALIGNMENT);
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
		bottom.add(submit);
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
