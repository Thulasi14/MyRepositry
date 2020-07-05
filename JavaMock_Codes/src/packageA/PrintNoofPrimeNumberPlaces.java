package packageA;
import java.util.*;
import java.util.Arrays;
import java.util.Map.Entry;
public class PrintNoofPrimeNumberPlaces {
	public static void main(String[] args) {
		
		int[] a= {1,2,3,4,5,6};
		Map<Integer, Integer> m=new LinkedHashMap<Integer,Integer>();
		
		for(int i=0;i<a.length;i++) {
			
			m.put(a[i], i);
		}
		
		System.out.println(m);
		Set<Entry<Integer,Integer>> et=m.entrySet();
		
	for(Entry<Integer,Integer> e:et) {
			int temp=e.getValue();
			int count=0;
			if(temp==2) {
				
				System.out.println(e.getKey());
			}
		else if(temp!=0 && temp!=1 && temp!=2) {
				for(int j=2;j<temp;j++) {
				
						if(temp%j==0) {
								count++;
						}
				}
				
			if(count==0) {
				System.out.println(e.getKey());
			}	
			
	}
			
		}	
	}
}
