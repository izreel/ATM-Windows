import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class DepositWindow extends JFrame
{
	JPanel top, bottom;
	JButton submit, back;
	JTextField depositAmount;
	JLabel deposit;
	BankAccount account;
	public DepositWindow(BankAccount account)
	{
		this.account = account;
		setTitle("Deposit");
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
		deposit = new JLabel("Deposit Amount:");
		depositAmount = new JTextField();
		depositAmount.setPreferredSize(new Dimension(100,30));
		top.add(deposit);
		top.add(depositAmount);
	}
	private void buildBottomPanel()
	{
		bottom= new JPanel();
		submit = new JButton("Deposit");
		submit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						double depositValue = Double.parseDouble(depositAmount.getText());
						account.deposit(depositValue);
						JOptionPane.showMessageDialog(null,"Deposit Successful.");
						requestFocus();
						dispose();
						InitialWindow initWin =  new InitialWindow(account);
						setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						initWin.setSize(300,300);
						initWin.setVisible(true);

					}
				}
				);
		submit.setPreferredSize(new Dimension(80,40));
		back = new JButton("Back");
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
