package main;

import java.util.*;

public class TicTacToe{
public static int[][] ticbox;
	public static int win(int [][]tic) {
		int sum=0;
		boolean flag=true;
		//check all rows
		//loop through rows from 0 to 3 and check if all the 3 places have same marks
 		for(int i=0;i<3;i++)
 		{
 			sum=0;
 			flag=true;
 			for(int j=0;j<3;j++)
 			{
 				if(tic[i][j]==0)
 					flag=false;
 					sum+=tic[i][j];
 			}
 			if((sum==3 || sum==6) && flag)
 				return tic[i][0];
 		}
		
		//check all cols
		//loop through columns from 0 to 3 and check if all the 3 places have same marks
 		for(int i=0;i<3;i++)
 		{
 			sum=0;
 			flag=true;  		
 			for(int j=0;j<3;j++)
 			{ 
 				if(tic[j][i]==0)
 					flag=false;
 					sum+=tic[j][i];
 			}
 			if((sum==3 || sum==6)&& flag)
 				return tic[0][i];
 		}
		
 		
 		//check both diagonals 
 	    sum=0;
 	   flag=true;
 		for(int i=0;i<3;i++)
 		{
 			if(tic[i][i]==0)
					flag=false;
 					sum+=tic[i][i];
 		}
 	   if((sum==3 || sum==6) && flag)
			return tic[0][0];
 		
 			
 	    sum=0;
 	   flag=true;
 	    int j=0,k=2;
 		for(int i=0;i<3;i++)
 		{
 			if(tic[i][j]==0)
				flag=false;
 			
 			sum+=tic[j++][k--];
 			
 		}		
 		 if((sum==3 || sum==6) && flag)
 			return tic[0][2];
 		
		
		
		
		return 0;
		
	}
	
	public static void printBox(int [][]tic) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(tic[i][j]);
			}
			System.out.println("");
		}
	}
	public static boolean validate(int a1,int a2,int [][] tic) {
		//check if a1 is between 0 & 3
		//check if a2 is between 0 & 3
    	//check if the selected box is empty ie, already not marked by other player
		if(a1>=0 && a1<3)
			if(a2>=0 && a2<3)
				if(tic[a1][a2]==0)
					return true;
		return false;
	}
	public static void main(String args[]) {
		
		ticbox = new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				ticbox[i][j] = 0;
			}
		}
		
		 int chk = win(ticbox);

		boolean turn= true;
		int limit = 9;
		while(chk==0 && limit > 0) {
			//if true player 1	
			if(turn) {
				System.out.println("Player 1 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				if(valid) {
					ticbox[a1][a2] = 1;
					chk = win(ticbox);
					turn = false;
					limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
			}else {
				System.out.println("Player 2 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				if(valid) {
				ticbox[a1][a2] = 2;
				chk = win(ticbox);
				turn = true;
				limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
			}
			
			
			//if false player 2 
		}
		
		if(chk!=0) {
			System.out.println("The winner is Player "+chk);
		}else {
			System.out.println("Its a draw match!!");
		}
		
	}
}