package packageA;

public class LargestToSmallestInanArray {
	
	public static void main(String[] args) {
		int[] a= {1,5,3,8,2,9,4,7,6};
		for(int i=0;i<a.length;i++) {
			int temp=0;
			for(int j=i+1;j<a.length;j++) {
				if(a[i]<a[j]) {
					temp=a[j];
					a[j]=a[i];
					a[i]=temp;
				}
			}
		}
		for(int k=0;k<a.length;k++) {
			if(k==0) {
				System.out.println("First Largest:"+a[k]);
			}
			else if(k==a.length-1){
				System.out.println("First Smallest:"+a[k]);
			}
			else if(k==1) {
				System.out.println("Second Largest:"+a[k]);
			}
			else if(k==a.length-2){
				System.out.println("Second Smallest:"+a[k]);
			}	
			else if(k==2) {
				System.out.println("Third Largest:"+a[k]);
			}	
			else if(k==a.length-3){
				System.out.println("Third Smallest:"+a[k]);
			}
			else if(k==3) {
				System.out.println("Fourth Largest:"+a[k]);
			}
			else if(k==a.length-4){
				System.out.println("Fourth Smallest:"+a[k]);
			}
			else {
				System.out.println("Middle Element"+a[k]);
			}
			
		}
		
	}

}
