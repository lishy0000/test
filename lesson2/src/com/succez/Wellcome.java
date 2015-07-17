package com.succez;
import java.util.InputMismatchException;
import java.util.Scanner;
class intToHex{	
	 
				boolean exp=true;
				int s[]=new int[9];
				int j=0;
				int ni;
				static char o[]=new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
				String reresult="";
				public intToHex(int n) 	{
					this.ni=n;
					// TODO Auto-generated constructor stub
				}
				
				String k(int n){ 
					int i=0;
				StringBuffer k = new StringBuffer();
				if(ni<0)k.append("-");
					if(ni<0)
						{ni=-ni;
						reresult=reresult+"-";
						}
					while(exp){                   /*数组化为16进制*/
						s[i]=ni%16;
						ni=ni/16;
						i++;	
						if(ni==0)exp=false;
					         }  
					for(int j=0;j<i;j++){  k.append(o[s[i-j-1]]);}
					reresult=k.toString();
//					for(int j=0;j<i;j++){                /*数组化为字符串*/       
//						if(s[i-j-1]<=15&&s[i-j-1]>=0)
//							reresult=reresult+o[s[i-j-1]];
//					
//	}
					return reresult;	
					}
}

public class Wellcome {
	public static void main(String[] args) 
	{
		 
            System.out.println("请输入一个整数：");
            Scanner sc = new Scanner(System.in);
            try
 		   {
		  int n= sc.nextInt();
            intToHex t=new intToHex(n);
            System.out.println(t.k(n));
            sc.close();
            } catch (InputMismatchException In)
 		   {
    		    System.out.println("你输入的数有误！");
    		   }
            
	}

}