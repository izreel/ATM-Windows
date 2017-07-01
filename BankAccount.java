import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount 
{
	private String firstName;
	private String lastName;
	private int accountNumber;
	private double accountBalance;
	private String atmAccess;
	private String accountPassword;
	
	public BankAccount(String firstName, String lastName, int accountNumber,double accountBalance,String password, String atmAccess )
	{
		 setFirstName(firstName );
		 setLastName(lastName);
		 this.accountNumber = accountNumber;
		 this.accountBalance = accountBalance;
		 accountPassword= password;
		 this.atmAccess = atmAccess;
	}
	public BankAccount(String firstName, String lastName, int accountNumber,double accountBalance, String atmAccess )
	{
		 setFirstName(firstName );
		 setLastName(lastName);
		 this.accountNumber = accountNumber;
		 this.accountBalance = accountBalance;
		 this.atmAccess = atmAccess;
	}
	public BankAccount(String firstName, String lastName, int accountNumber, String password)
	{
		 setFirstName(firstName );
		 setLastName(lastName);
		 this.accountNumber = accountNumber;
		 accountPassword= password;
		 accountBalance = 0;
	}
	public BankAccount(String firstName, String lastName, int accountNumber, double accountBalance)
	{
		 setFirstName(firstName );
		 setLastName(lastName);
		 this.accountNumber = accountNumber;
		 this.accountBalance = accountBalance;
	}
	private void setFirstName(String firstName )
	{
		this.firstName = firstName;
		
	}
	private void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public void changeATMAccess(String access)
	{
		atmAccess = access;
	}
	public void setPassword(String password)
	{
		accountPassword= password;
	}
	public double getAccountBalance()
	{
		return accountBalance;
	}
	public String getAtmAccess()
	{
		return atmAccess;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public int getAccountNumber()
	{
		return accountNumber;
	}
	public String getPassword()
	{
		return accountPassword;
	}
	public static void SavePasswords(ArrayList<BankAccount> accounts) throws IOException
	{
		File wordFiles = new File("passwords.txt");
		PrintWriter output = new PrintWriter (wordFiles);
		for(int i=0;i<accounts.size();i++)
			output.println(accounts.get(i).getAccountNumber() + " " + accounts.get(i).getPassword());
		output.close();
	}

	public static void SaveAccounts(ArrayList<BankAccount> accounts) throws IOException
	{
		File wordFiles = new File("accounts.txt");
		PrintWriter output = new PrintWriter (wordFiles);
		for(int i=0;i<accounts.size();i++)
		{
			output.println(accounts.get(i).getAccountNumber());
			output.println(accounts.get(i).getLastName());
			output.println(accounts.get(i).getFirstName());
			output.println(accounts.get(i).getAccountBalance());
			output.println(accounts.get(i).getAtmAccess());
		}
		output.close();
	}
	public static void LoadAccountInformation(ArrayList<BankAccount> accounts) throws IOException
	{

	        File file1 = new File("accounts.txt");
	        File file2 = new File("passwords.txt");
	        if(! file1.exists())
	            file1.createNewFile();
	        if(! file2.exists())
	            file2.createNewFile();
	        FileReader accountFiles = new FileReader("accounts.txt");
	        FileReader passwordFiles = new FileReader("passwords.txt");
	        BufferedReader accountReader = new BufferedReader(accountFiles);
	        BufferedReader passwordReader = new  BufferedReader(passwordFiles);
	        BankAccount temp;
	        String accountLine, atmAccess;
	        String passwordLine ="";
	        String firstName= "";
	        String LastName = "";
	        int accountNumber= 0;
	        double balance = 0;
	        int lines = 0;
	        do
	        {   
	        	accountLine = accountReader.readLine();
	            if(lines ==0)
	            	{
	            	try{
	            		accountNumber =Integer.parseInt(accountLine);
	            	}catch(Exception e)
	            	{}
	            		lines++;
	            		continue;
	            	}
	            if(lines ==1)
	            {
	            	LastName = accountLine;
	            	lines++;
	            	continue;
	            }
	            if(lines ==2)
	            {
	            	firstName = accountLine;
	            	lines++;
	            	continue;
	            }
	            if(lines ==3)
	            {
	            	balance = Double.parseDouble(accountLine);
	            	lines++;
	            	continue;
	            }
	            if(lines == 4)
	            {
	            	atmAccess = accountLine;
	            	lines =0;
	            	temp = new BankAccount(firstName, LastName,accountNumber,balance,atmAccess);
	            	accounts.add(temp);
	            }
	            
	        }while(( accountLine!=null));
	      
	        
	        lines = 0;
	        while((  passwordLine = passwordReader.readLine()) !=null)
	        {

	        	
	            String[] tempLine = passwordLine.split(" ");
	            accounts.get(lines).setPassword(tempLine[1]);
	            lines++;
	           
	        }
	        System.out.println(accounts.get(0).getPassword());
	        accountFiles.close();
	        passwordFiles.close();
	        accountReader.close();
	        passwordReader.close();
	 }
	public void deposit(double deposit)
    {
        accountBalance = accountBalance+deposit; 
    }
    public void withdrawal(double withdraw)
    {
        accountBalance = accountBalance-withdraw;
    }
    public void transfer(BankAccount dAccount, double transferAmount)
    {
    	accountBalance -= transferAmount;
        dAccount.deposit(transferAmount);
    }

}
