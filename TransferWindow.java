import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class TransferWindow extends JFrame 
{
	JPanel top, middle, bottom;
	JLabel name, accountNumber, amount, request;
	JTextField transferName, transferAccount, transferAmount;
	JButton confirm, back;
	BankAccount account;
	TransferWindow(BankAccount account)
	{
		this.account = account;
		setTitle("Transfer");
		buildTopPanel();
		buildMiddlePanel();
		buildBottomPanel();
		setSize(300,275);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().add(top, BorderLayout.NORTH);
		getContentPane().add(middle , BorderLayout.CENTER);
		getContentPane().add(bottom, BorderLayout.SOUTH);
		setResizable(false);
		addWindowListener(new confirmExit());
	}
	private void buildTopPanel()
	{
		top = new JPanel();
		request = new JLabel("Please fill out the following information and click submit.");
		top.add(request);
	}
	private void buildMiddlePanel()
	{
		middle = new JPanel();
		name  = new JLabel("Name:");
		accountNumber = new JLabel("Account Number:");
		amount = new JLabel("Amount to Transfer:");
		transferName = new JTextField();
		transferName.setPreferredSize(new Dimension(100,30));
		
		transferAccount = new JTextField();
		transferAccount.setPreferredSize(new Dimension(100,30));
		
		transferAmount = new JTextField();
		transferAmount.setPreferredSize(new Dimension(100,30));
		middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
		
		middle.add(name);
		middle.add(transferName);
		middle.add(accountNumber);
		middle.add(transferAccount);
		middle.add(amount);
		middle.add(transferAmount);
	}
	private void buildBottomPanel()
	{
		bottom = new JPanel();
		confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				double transferValue = Double.parseDouble(transferAmount.getText());
				int numberValue = Integer.parseInt(transferAccount.getText());
				ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
				try {
					BankAccount.LoadAccountInformation(accountList);
				} catch (Exception e) {
					e.printStackTrace();
				}
				for(int i = 0; i < accountList.size(); i++)
				{
					if(numberValue == accountList.get(i).getAccountNumber())
						account.transfer(accountList.get(i),transferValue);
				}
				
				JOptionPane.showMessageDialog(null,"Transfer Successful.");
				requestFocus();
				dispose();
				InitialWindow initWin =  new InitialWindow(account);
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				initWin.setSize(300,300);
				initWin.setVisible(true);

			}
		}
		);
		confirm.setPreferredSize(new Dimension(80, 40));
		confirm.setAlignmentX(Component.TOP_ALIGNMENT);
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
		bottom.add(confirm);
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
