import java.util.Scanner;

public class Start 
{
	Scanner scan = new Scanner(System.in);
	AccountHandler manager = new AccountHandler();
	int choice;
	
	void MainStart()
	{
		while(true)
		{
			manager.ShowMenu();
			System.out.println("메뉴를 선택하시오 : ");
			choice = Integer.parseInt(scan.nextLine());
			
			
			switch (choice)
			{
			case 1:		manager.MakeAccount();		break;
			case 2:		manager.DepositMoney();		break;
			case 3:		manager.WithdrawMoney();	break;
			case 4:		manager.ShowAllAccInfo();	break;
			case 5:			return;
			default:		System.out.println("Illegal Selection...");
			}		
		}
	}
	
	
	
	public static void main(String args[])
	{
		Start start = new Start();
		start.MainStart();
	}
}
