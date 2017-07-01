import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;


public class ChangePasswordWindow extends JFrame
{
	JPanel top, middle, bottom;
	JPasswordField current, newPass, confirmPass;
	JLabel currentP, newP, confirmP, request;
	JButton confirm, back;
	BankAccount account;
	String currentPass, newPassword, tempPass;
	ChangePasswordWindow(BankAccount account)
	{
		this.account = account;
		setTitle("Change Password");
		buildTopPanel();
		buildMiddlePanel();
		buildBottomPanel();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().add(top, BorderLayout.NORTH);
		getContentPane().add(middle , BorderLayout.CENTER);
		getContentPane().add(bottom, BorderLayout.SOUTH);
		setSize(420,300);
		setResizable(false);
		addWindowListener(new confirmExit());
	}
	private void buildTopPanel()
	{
		top = new JPanel();
		request = new JLabel("Please type in current password, desired password, and confirm desired password.");
		request.setBorder(null);
		top.add(request);
	}
	private void buildMiddlePanel()
	{
		middle = new JPanel();
		currentP =new JLabel("Current Password:");
		newP = new JLabel("New Password:");
		confirmP = new JLabel("Confirm New Password");
		current = new JPasswordField();
		current.setPreferredSize(new Dimension(100,30));
		newPass = new JPasswordField();
		newPass.setPreferredSize(new Dimension(100,30));
		confirmPass = new JPasswordField();
		confirmPass.setPreferredSize(new Dimension(100,30));

		middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
		middle.add(currentP);
		middle.add(current);
		middle.add(newP);
		middle.add(newPass);
		middle.add(confirmP);
		middle.add(confirmPass);
	}
	private void buildBottomPanel()
	{
		bottom = new JPanel();
		confirm = new JButton("Confirm");
		confirm.setPreferredSize(new Dimension(80, 40));
		confirm.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				newPassword = newPass.getText();
				tempPass = confirmPass.getText();
				currentPass= current.getText();
				System.out.println(currentPass);
				System.out.println(account.getPassword());
				System.out.println(newPassword);
				System.out.println(tempPass);
				if((currentPass.equals(account.getPassword()))&&( newPassword.equals(tempPass)))
				{
					dispose();
					account.setPassword(newPassword);
					JOptionPane.showMessageDialog(null,"Password changed.");
					requestFocus();
					InitialWindow initWin =  new InitialWindow(account);
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					initWin.setSize(300,300);
					initWin.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Cannot change password, please check the following fields and try again.");
					requestFocus();
				}
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
