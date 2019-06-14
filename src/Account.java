
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
	
	
	
	//�Ա�
	void Deposit(int money)
	{
		this.balance += money;
	}
	
	//���
	int WithDraw(int money)
	{
		if( this.balance < money)
			return 0;
		
		this.balance -= money;
		return money;			//����
	}
	
	void ShowAccInfo()
	{
		System.out.println("���� ID : " + this.accID);
		System.out.println("�̸� : " + this.cusName);
		System.out.println("�ܾ� : " + this.balance);
	}
	
}
