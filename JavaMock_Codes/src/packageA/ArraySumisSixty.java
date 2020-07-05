package packageA;

public class ArraySumisSixty {
	
	public static void main(String[] args)  {
		
		int[] a= {15,25,15,30,45,25,15,15};
		
		/*for(int i=0;i<a.length;i++) {
			
			int sum=0;
			
			for(int j=i+1;j<a.length;j++) {
				
				sum=a[i]+a[j];
				
				if(sum==60) {
					
					System.out.println("Value at index "+i+":"+a[i]+
					" Value at index "+j+":"+a[j]+",sum:"+sum);
				}
			}*/
			
			for(int k=0;k<a.length;k++) {
				
				int sum1=0;
				
				for(int l=k+1;l<a.length;l++) {
					
					for(int m=k+2;m<a.length;m++) {
						
						sum1=a[k]+a[l]+a[m];
						
						if(sum1==60) {
							
							System.out.println("Value at index "+k+":"+a[k]+" Value at index "+l+":"+a[l]+" Value at index "+m+":"+a[m]+",sum:"+sum1);
						}
						
					}
				}
					
					
				}
					}
}
