package packageA;

public class PyramidFloyds {
	
	public static void main(String[] args) {
		
		int a=1;
		
		int row=4;
		
		/*for(int x=0;x<row;x++) {
			
			for(int z=0;z<row-x;z++) {
				
				System.out.print(" ");
			}
			
			
			for(int y=0;y<x+1;y++) {
				
				System.out.print(a*a+" ");
				a++;
			}
			
			System.out.println();	*/
		
		
		for(int i=1;i<=row;i++) {
			
			for(int j=0;j<row-i;j++) {
				
				System.out.print(" ");
			}
			
			for(int k=1;k<i+1;k++) {
				
				System.out.print(a+" ");
				
				a++;
			}
			
			System.out.println();
		}
		
		
	}

}
