package packageA;

import java.util.*;

public class PrintCharFromStringFibSeries {
	
	public static void main(String[] args) {
		
		String st="7YaA";
		
		char[] ch = st.toCharArray();
		
		List<Integer> l=new ArrayList<Integer>();
		
		int i=0;
		int j=1;
		l.add(i);
		l.add(j);
		int temp=0;
		
		while(i<100) {
			
			temp=i+j;
			l.add(temp);
			i=j;
			j=temp;
		}
		
		System.out.println(l);
		
		String y="";
		
		for(int x=0;x<ch.length;x++) {
			
			Integer c=(int)ch[x];
			
			if(l.contains(c)) {
				
				y=y+ch[x];
			}
		}
		
		System.out.println(y);
	}

}
