import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FailedLoginWindow extends JFrame 
{
		/*int failedLoginTries;
		JLabel errorMessage;
		JPanel top, bottom;
		JButton ok;
		FailedLoginWindow(int loginTries)
		{
			if(loginTries < 3)
			{
				buildTopPanel1();
				buildBottomPanel1();
			}
			else
			{
				buildTopPanel2();
				buildBottomPanel2();
			}
			getContentPane().add(top, BorderLayout.NORTH);
			getContentPane().add(bottom, BorderLayout.SOUTH);
			getContentPane().add(top);
			getContentPane().add(bottom);
			setSize(400,200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
		}
		FailedLoginWindow(String access)
		{
			buildTopPanel3();
			buildBottomPanel3();
			getContentPane().add(top);
			getContentPane().add(bottom);
			getContentPane().add(top, BorderLayout.NORTH);
			getContentPane().add(bottom, BorderLayout.SOUTH);
			setSize(400,200);
			setResizable(false);
		}
		private void buildTopPanel1( )
		{
			top = new JPanel();
			errorMessage = new JLabel("Failed to login. Please try again.");
			top.add(errorMessage);
		}
		private void buildTopPanel2()
		{
			top = new JPanel();
			errorMessage = new JLabel("Failed to login, ATM will now close.");
			top.add(errorMessage);
		}
		private void buildBottomPanel1()
		{
			bottom = new JPanel();
				ok = new JButton("Ok");
				ok.setPreferredSize(new Dimension(150,100));
				ok.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								dispose();
							}
						});
			bottom.add(ok);
		}
		private void buildBottomPanel2()
		{
			bottom = new JPanel();
				ok = new JButton("Ok");
				ok.setPreferredSize(new Dimension(150,100));
				ok.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								System.exit(0);
							}
						});
			bottom.add(ok);
		}
		private void buildTopPanel3()
		{
			top = new JPanel();
			errorMessage = new JLabel("Failed to login, Account not set up for ATM access. ATM will now close.");
			top.add(errorMessage);
		}
		private void buildBottomPanel3()
		{
			bottom = new JPanel();
			ok = new JButton("Ok");
			ok.setPreferredSize(new Dimension(150,100));
			ok.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							System.exit(0);
						}
					});
			bottom.add(ok);
		}*/

}
