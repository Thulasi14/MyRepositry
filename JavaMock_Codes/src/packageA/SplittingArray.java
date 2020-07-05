package packageA;

import java.util.*;

public class SplittingArray {
	
	public static void main(String[] args) {
		
		int[] a= {1,2,3,4};
		
		List<Integer> st=new ArrayList<Integer>();
		
		List<Integer> l1=new ArrayList<Integer>();
		
		for(int k=0;k<a.length;k++) {
			
			st.add(a[k]);
		}
		
			for(int j=1;j<st.size();j++) {
				
				int p=st.get(0);
				int q=st.get(j);
				
				if(p+q==5) {
					
					l1.add(p);					
					l1.add(q);
				}
				
			}
		st.removeAll(l1);
			
		
		System.out.println(l1);
		System.out.println(st);
		
	}
	
	

}
