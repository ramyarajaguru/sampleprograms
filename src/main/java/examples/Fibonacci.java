package examples;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci fs=new Fibonacci();
		fs.fibonacciSeries();
		

	}
	void fibonacciSeries()
	{
		int a,b,c,i;
		a=-1;
		b=1;
		System.out.println("Fibonacci Series");
				
		for(i=1;i<13; i++)
		{
			c=a+b;
			System.out.println(c);
			a=b;
			b=c;
		}
	}

}
