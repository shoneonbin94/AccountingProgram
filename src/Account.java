
public class Account 
{
	int accID;
	int balance;
	String cusName;
	
	public Account(int ID, int money, String name)
	{
		this.accID = ID;
		this.balance = money;
		this.cusName = name;
	}
	
	int getAccID() { return this.accID; }
	void setAccID(int accID) { this.accID = accID; }
	
	String getName() { return this.cusName; }
	void setName(String name) { this.cusName = name; }
	
	int getBalance() { return this.balance; }
	void setBalance(int balance) { this.balance = balance; }
	
	
	
	//입금
	void Deposit(int money)
	{
		this.balance += money;
	}
	
	//출금
	int WithDraw(int money)
	{
		if( this.balance < money)
			return 0;
		
		this.balance -= money;
		return money;			//보류
	}
	
	void ShowAccInfo()
	{
		System.out.println("계좌 ID : " + this.accID);
		System.out.println("이름 : " + this.cusName);
		System.out.println("잔액 : " + this.balance);
	}
	
}
