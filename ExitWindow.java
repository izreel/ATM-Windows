import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class ExitWindow extends JFrame
{
	JPanel  top, bottom;
	JLabel exitLabel;
	JButton acceptExit, cancelExit;
	ExitWindow()
	{
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
		exitLabel = new JLabel("Are you sure you want to exit?");
		top.add(exitLabel);
	}
	private void buildBottomPanel()

	{
		bottom = new JPanel();
		acceptExit = new JButton("ok");
		acceptExit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					System.exit(0);
				}
			});
		cancelExit = new JButton("Cancel");
		cancelExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
			dispose();
			}
		});
		bottom.add(acceptExit);
		bottom.add(cancelExit);
	}

}
