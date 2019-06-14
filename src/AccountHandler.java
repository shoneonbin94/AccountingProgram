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
	//메뉴 출력
	void ShowMenu()
	{
		System.out.println("------------MENU------------");
		System.out.println("[1]계 좌 개 설");
		System.out.println("[2]입       금");
		System.out.println("[3]출       금");
		System.out.println("[4]전 체 출 력");
		System.out.println("[5]종       료");
		System.out.println("----------------------------");
	}
	
	//계좌 개설
	void MakeAccount()
	{
		int select;
		
		System.out.println("<<계좌 개설>>");
		System.out.println("1. 보통예금계좌");
		System.out.println("2. 신용신뢰계좌");
		System.out.println("선택할 계좌를 입력하시오 : ");
		select = Integer.parseInt(scan.nextLine());
		
		if(select == 1)
			MakeNormalAccount();
		else
			MakeCreditAccount();
	}
	
	//일반계좌 개설
	void MakeNormalAccount()
	{
		int ID;
		String name;
		int balance;
		int normalRate = 4;
		
		System.out.println("[일반 계좌 생성]");
		System.out.println("계좌  ID : ");
		ID = Integer.parseInt(scan.nextLine());
		
		System.out.println("이    름 : ");
		name = scan.nextLine();
		
		System.out.println("입 금 액 : ");
		balance = Integer.parseInt(scan.nextLine());
		
		accArr[accNum++] = new NormalAccount(ID, balance, name, normalRate);
	}
	
	//신용계좌 개설
	void MakeCreditAccount()
	{
		int ID;
		String name;
		int balance;
		int specialRate = 9;
		int creditLevel;
		
		System.out.println("[신용 계좌 생성]");
		System.out.println("계좌  ID : ");
		ID = Integer.parseInt(scan.nextLine());
		
		System.out.println("이    름 : ");
		name = scan.nextLine();
		
		System.out.println("입 금 액 : ");
		balance = Integer.parseInt(scan.nextLine());
		
		System.out.println("신용등급(1toA, 2toB, 3toC) : ");
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
	
	//입금
	void DepositMoney()
	{
		int money;
		int ID;

		System.out.println("<<입금>>");
		System.out.println("입금할 계좌 : ");
		ID = Integer.parseInt(scan.nextLine());
		
		System.out.println("입금액 : ");
		money = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < accNum; i++)
		{
			if (accArr[i].getAccID() == ID)
			{
				accArr[i].Deposit(money);
				System.out.println("입금 완료.");
				System.out.println();
				return;
			}
		}
		System.out.println("유효하지 않은 계좌번호 입니다.");
		System.out.println();
	}
	
	//출금
	void WithdrawMoney()
	{
		int money;
		int ID;

		System.out.println("<<출금>>");
		System.out.println("출금할 계좌 : ");
		ID = Integer.parseInt(scan.nextLine());
		
		System.out.println("출금액 : ");
		money = Integer.parseInt(scan.nextLine());


		for (int i = 0; i < accNum; i++)
		{
			if (accArr[i].getAccID() == ID)
			{
				if (accArr[i].WithDraw(money) == 0)
				{
					System.out.println("잔액이 부족합니다.");
					System.out.println();
					return;
				}
				System.out.println("출금이 완료되었습니다.");
				System.out.println();
				return;
			}
		}
		System.out.println("유효하지 않은 계좌번호 입니다.");
		System.out.println();
	}
	
	//전체출력
	void ShowAllAccInfo()
	{
		for (int i = 0; i < accNum; i++)
		{
			accArr[i].ShowAccInfo();
			System.out.println();
		}
	}
}
