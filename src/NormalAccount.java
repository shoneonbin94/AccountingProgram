
public class NormalAccount extends Account
{
	int interRate;			//이자율 단위
	
	
	
	public NormalAccount(int ID, int money, String name, int rate) 
	{
		super(ID, money, name);
		this.interRate = rate;
		// TODO Auto-generated constructor stub
	}	
}
