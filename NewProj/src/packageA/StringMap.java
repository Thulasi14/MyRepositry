package packageA;

import java.util.*;
import java.util.Map.Entry;

public class StringMap {
	
	public static void main(String[] args) {
		
		String s="Hello Java World";
		
		String[] a = s.split(" ");
		
		Map<Character,Integer> m=new LinkedHashMap<Character,Integer>();
		
		String c="";
		
		for(String b:a) {
			
			for(int i=0;i<b.length();i++) {
				
				if(!(m.containsKey(b.charAt(i)))) {
					
					m.put(b.charAt(i), 1);
				}
				
				else {
					
					m.put(b.charAt(i),m.get(b.charAt(i))+1);
				}
			}
			
			Set<Entry<Character,Integer>> et=m.entrySet();
			
			for(Entry<Character,Integer> d:et) {
				
				c=c+d.getKey()+d.getValue();
			}
			
			m=new LinkedHashMap<Character,Integer>();
		}
		
		
		System.out.println(c);
	}
	
	

}
