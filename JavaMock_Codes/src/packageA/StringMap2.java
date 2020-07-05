package packageA;

import java.util.*;

public class StringMap2 {

	public static void main(String[] args) {
	
	String s="Java Worldddd";
	
	String[] a = s.split(" ");
	
	List<Character> l=new ArrayList<Character>();
	//Map<Character, Integer> m=new LinkedHashMap<Character, Integer>();
	String x="";
	int count=1;
	
	for(int k=0;k<a.length;k++){
		
		
		
		for(int i=0;i<a[k].length();i++) {
			
			l.add(a[k].charAt(i));
			//count++;
		
		}
	}
	
	for(int j=0;j<l.size();j++) {
		
		x=x+l.get(j)+count;
	}
	
	System.out.println(x);
}
}