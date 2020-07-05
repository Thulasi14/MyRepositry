package packageA;

import java.util.*;

public class Anagram {
	
	public static void main(String[] args) {

		String s="Mary";
		String s1="Army";

		if(s.length()==s1.length()) {
			
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String a = Arrays.toString(ch);
			System.out.println(a);
			
			char[] ch1 = s.toCharArray();
			Arrays.sort(ch1);
			String b = Arrays.toString(ch1);
			System.out.println(b);
			
			System.out.println(Arrays.equals(ch, ch1));
			
			if(Arrays.equals(ch, ch1)) {
				
				System.out.println("Anagram");
			}
			
			else {
				
				System.out.println("Not");
			}
		}
		
		
	}

}
