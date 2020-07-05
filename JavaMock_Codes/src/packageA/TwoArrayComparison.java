package packageA;

import java.util.*;

public class TwoArrayComparison {
	
	public static void main(String[] args) {
		
		int a[]= {1,3,4,5};
		int b[]= {3,2,3,1}; 
		
		int commonlength=a.length;
		
		int c[]=new int[commonlength];
		for(int i=0;i<commonlength;i++) {
			
			if(a.length!=b.length) {
				
				System.out.println("Invalid Array Size");
				return;
			}
			else if (a[i]<0 || b[i]<0) {
				
				System.out.println("Array Digits are Negative");
				return;
			}
		}
		
		List<Integer>l=new ArrayList<Integer>();
		for(int i=0;i<commonlength;i++) {
			
			l.add(a[i]);
			l.add(b[i]);
		}
		
		Collections.sort(l, Collections.reverseOrder());
		
		for(int i=c.length-1;i>=0;i--) {
			
			c[i]=l.get(i);
			
			System.out.print(c[i]+" ");
		}	
		
	}
}
