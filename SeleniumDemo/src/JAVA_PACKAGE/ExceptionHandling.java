package JAVA_PACKAGE;

public class ExceptionHandling {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		try
		{
		int a=20;
		int b = 0;
		int c = a/b;
		System.out.println(c);
		}
		catch(Exception a)
		{
			System.out.println("You cannot divide by Zero");
		}
		finally
		{
			System.out.println("This is from finally");
		}
	}

}
