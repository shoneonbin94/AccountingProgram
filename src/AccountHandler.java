import java.util.Scanner;

public class AccountHandler 
{
	Scanner scan = new Scanner(System.in);
	Account[] accArr = new Account[100];
	int accNum;
	
	
	//-----------------------------------------------
	public AccountHandler()
	{
		this.accNum = 0;
	}
	
	
	//-----------------------------------------------
	//�޴� ���
	void ShowMenu()
	{
		System.out.println("------------MENU------------");
		System.out.println("[1]�� �� �� ��");
		System.out.println("[2]��       ��");
		System.out.println("[3]��       ��");
		System.out.println("[4]�� ü �� ��");
		System.out.println("[5]��       ��");
		System.out.println("----------------------------");
	}
	
	//���� ����
	void MakeAccount()
	{
		int select;
		
		System.out.println("<<���� ����>>");
		System.out.println("1. ���뿹�ݰ���");
		System.out.println("2. �ſ�ŷڰ���");
		System.out.println("������ ���¸� �Է��Ͻÿ� : ");
		select = Integer.parseInt(scan.nextLine());
		
		if(select == 1)
			MakeNormalAccount();
		else
			MakeCreditAccount();
	}
	
	//�Ϲݰ��� ����
	void MakeNormalAccount()
	{
		int ID;
		String name;
		int balance;
		int normalRate = 4;
		
		System.out.println("[�Ϲ� ���� ����]");
		System.out.println("����  ID : ");
		ID = Integer.parseInt(scan.nextLine());
		
		System.out.println("��    �� : ");
		name = scan.nextLine();
		
		System.out.println("�� �� �� : ");
		balance = Integer.parseInt(scan.nextLine());
		
		accArr[accNum++] = new NormalAccount(ID, balance, name, normalRate);
	}
	
	//�ſ���� ����
	void MakeCreditAccount()
	{
		int ID;
		String name;
		int balance;
		int specialRate = 9;
		int creditLevel;
		
		System.out.println("[�ſ� ���� ����]");
		System.out.println("����  ID : ");
		ID = Integer.parseInt(scan.nextLine());
		
		System.out.println("��    �� : ");
		name = scan.nextLine();
		
		System.out.println("�� �� �� : ");
		balance = Integer.parseInt(scan.nextLine());
		
		System.out.println("�ſ���(1toA, 2toB, 3toC) : ");
		creditLevel = Integer.parseInt(scan.nextLine());
		
		switch(creditLevel)
		{
		case 1:
			accArr[accNum++] = new HighCreditAccount(ID, balance, name, specialRate, 7);
			break;
			
		case 2:
			accArr[accNum++] = new HighCreditAccount(ID, balance, name, specialRate, 4);
			break;
			
		case 3:
			accArr[accNum++] = new HighCreditAccount(ID, balance, name, specialRate, 2);
			break;
		}
	}
	
	//�Ա�
	void DepositMoney()
	{
		int money;
		int ID;

		System.out.println("<<�Ա�>>");
		System.out.println("�Ա��� ���� : ");
		ID = Integer.parseInt(scan.nextLine());
		
		System.out.println("�Աݾ� : ");
		money = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < accNum; i++)
		{
			if (accArr[i].getAccID() == ID)
			{
				accArr[i].Deposit(money);
				System.out.println("�Ա� �Ϸ�.");
				System.out.println();
				return;
			}
		}
		System.out.println("��ȿ���� ���� ���¹�ȣ �Դϴ�.");
		System.out.println();
	}
	
	//���
	void WithdrawMoney()
	{
		int money;
		int ID;

		System.out.println("<<���>>");
		System.out.println("����� ���� : ");
		ID = Integer.parseInt(scan.nextLine());
		
		System.out.println("��ݾ� : ");
		money = Integer.parseInt(scan.nextLine());


		for (int i = 0; i < accNum; i++)
		{
			if (accArr[i].getAccID() == ID)
			{
				if (accArr[i].WithDraw(money) == 0)
				{
					System.out.println("�ܾ��� �����մϴ�.");
					System.out.println();
					return;
				}
				System.out.println("����� �Ϸ�Ǿ����ϴ�.");
				System.out.println();
				return;
			}
		}
		System.out.println("��ȿ���� ���� ���¹�ȣ �Դϴ�.");
		System.out.println();
	}
	
	//��ü���
	void ShowAllAccInfo()
	{
		for (int i = 0; i < accNum; i++)
		{
			accArr[i].ShowAccInfo();
			System.out.println();
		}
	}
}
