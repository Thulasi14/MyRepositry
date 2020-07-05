package packageA;

public class RemoveVowelsFromString {
	
	public static void main(String[] args) {
		
		String s="Selenium";
		
		char[] ch = s.toCharArray();
		
		String n="";
		
		for(int i=0;i<ch.length;i++) {
			
			char c=ch[i];
			
			if(!(c=='a'|| c=='e'|| c=='i'|| c=='o'|| c=='u')) {
				
				n=n+c;
			}
		}
		
		System.out.println(n);
		
	}
	
	

}
