import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author gopi
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s="raja is my name".trim();
		int j=s.indexOf(4);
		s=s.substring(0, j);
		System.out.println(s);
		char[] sa=s.toCharArray();
		List<Integer> s2=new LinkedList<Integer>();
		int n=0;
		String.valueOf(n);
			s2.add(n);
		
		List<Character> s1=new LinkedList<Character>();
		for(char sam:sa){
			s1.add(sam);
		}
		Collections.reverse(s1);
		for(char va:s1)
		System.out.print(va);/*
		
		int a[][][] =new int [3][3][3];
int n=0;
	a[0][0][0]=1;
	a[0][0][1]=2;
	a[0][0][2]=2;
	a[0][1][0]=3;
	a[0][2][0]=3;
	a[0][1][1]=4;
	a[0][1][2]=2;
	a[0][2][2]=2;
	a[1][0][0]=5;
	a[1][0][1]=6;
	a[1][0][2]=6;
	a[1][1][0]=7;
	a[1][1][1]=8;
	a[1][1][2]=8;
	a[1][2][0]=8;
	a[1][2][1]=8;
	a[1][2][2]=8;
	a[2][0][0]=8;
	a[2][0][1]=8;
	a[2][0][2]=8;
	a[2][1][0]=8;
	a[2][1][2]=8;
	a[2][2][2]=8;
	
	for(int i=0;i<=1;i++){
		
	
		for(int j=0;j<=2;j++){
			if(n==0||n==2){
				for(int k=0;k<=2;k++)
				{
				System.out.print(a[i][j][k]);	
				}
			}
			else{
		for(int k=2;k>=0;k--)
		{
		System.out.print(a[i][j][k]);	
		}
			}
n++;
System.out.println();
		}
	}
	*/
		
	
	
	
	}

}
