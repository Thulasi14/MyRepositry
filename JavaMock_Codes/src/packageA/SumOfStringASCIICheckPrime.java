package packageA;

public class SumOfStringASCIICheckPrime {

	public static void main(String[] args) {
		
		String str="Java and Selenium";
		
		int[] a=new int[str.length()];
		
		int sum=0;
		
		for(int i=0;i<str.length();i++) {
			
			a[i]=(int)str.charAt(i);
			
			//System.out.println(a[i]);
			
			sum=sum+a[i];
		}
		
		System.out.println(sum);
		int count=0;
		
		for(int i=2;i<sum/2;i++) {
			
			if(sum%i==0) {
				
				count++;
				
			}
		}
		
		if(count>1) {
			
			System.out.println("Non Prime");
		
		}
		else {
			
			System.out.println("Prime");
		}
	}
	
	
}
