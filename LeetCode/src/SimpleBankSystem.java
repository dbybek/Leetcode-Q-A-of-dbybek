import java.util.Scanner;

//2043. Simple Bank System (Medium)
//---------------------------------
//You have been tasked with writing a program for a popular bank that will automate all its incoming transactions
//(transfer, deposit, and withdraw). The bank has n accounts numbered from 1 to n.
//The initial balance of each account is stored in a 0-indexed integer array balance,
//with the (i + 1)th account having an initial balance of balance[i].
//
//Execute all the valid transactions. A transaction is valid if:
//
//The given account number(s) are between 1 and n, and
//The amount of money withdrawn or transferred from is less than or equal to the balance of the account.
//Implement the Bank class:
//
//Bank(long[] balance) Initializes the object with the 0-indexed integer array balance.
//boolean transfer(int account1, int account2, long money):
//Transfers money dollars from the account numbered account1 to the account numbered account2.
//Return true if the transaction was successful, false otherwise.
//
//boolean deposit(int account, long money):
//Deposit money dollars into the account numbered account.
//Return true if the transaction was successful, false otherwise.
//
//boolean withdraw(int account, long money):
//Withdraw money dollars from the account numbered account.
//Return true if the transaction was successful, false otherwise.
//
//Constraints:
//-----------
//n == balance.length
//1 <= n, account, account1, account2 <= 10^5
//0 <= balance[i], money <= 10^12
//At most 10^4 calls will be made to each function transfer, deposit, withdraw.

public class SimpleBankSystem 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] balance = new long[N];
		for(int i=0;i<N;i++) {
			balance[i] = sc.nextLong();
		}
		sc.close();
		Bank b = new Bank(balance);
		System.out.println(b.withdraw(3, 10));
		System.out.println(b.transfer(5, 1, 20));
		System.out.println(b.deposit(5, 20));
		System.out.println(b.transfer(3, 4, 20));
		System.out.println(b.withdraw(10, 50));
	}
}

class Bank {
    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1-1>balance.length || account2-1>balance.length){
            return false;
        }
        if(withdraw(account1,money)){
            return deposit(account2,money);
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(account-1>balance.length){
            return false;
        }
        balance[account-1]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account-1>balance.length){
            return false;
        }
        if(balance[account-1]<money){
            return false;   
        }
        balance[account-1]-=money;
        return true;
    }
}
