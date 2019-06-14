public class HighCreditAccount extends NormalAccount
{
	int specialRate;
	
	
	
	public HighCreditAccount(int ID, int money, String name, int rate, int special) 
	{
		super(ID, money, name, rate);
		this.specialRate = special;
		// TODO Auto-generated constructor stub
	}
	
}
