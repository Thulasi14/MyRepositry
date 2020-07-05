package packageA;

import java.util.*;
public class ArraySortBasedOnIndex {
	
	public static void main(String[] args) {
		
	int[] a= {3,4,1,5}; // 5,4,1,3
	int[] b= new int[a.length];
	
	List<Integer> l=new ArrayList<Integer>();
	List<Integer> l1=new ArrayList<Integer>();
	
	for(int i=0;i<a.length;i++) {
		
		if(i==0 || i%2==0) {
			l.add(a[i]);
		}
		else {
			l1.add(a[i]);
		}
	}
	
	Collections.sort(l);
	
	Collections.sort(l1, Collections.reverseOrder());
	
	l1.addAll(l);
	
	//System.out.println(l1);
	
	for(int i=0;i<l1.size();i++) {
		
		b[i]=l1.get(i);
		
		System.out.print(b[i]+" ");
	}
	}

}
