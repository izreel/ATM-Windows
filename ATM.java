import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
 * Group 21, Intro 2 Compsci
 * James Lee 1406657
 * Israel Perez 1400809
 * Madeleine Wilson 1364100
 */
public class ATM 
{

	public static void main(String[] args) throws Exception 
	{
		ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
		BankAccount.LoadAccountInformation(accountList);
		BankAccount.SaveAccounts(accountList);
		BankAccount.SavePasswords(accountList);
		LoginWindow loginWin = new LoginWindow(accountList);
		loginWin.setVisible(true);
	}


}
