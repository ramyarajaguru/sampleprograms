package examples;

public class Reverseprime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverseprime rp=new Reverseprime();
		System.out.println("Reverse Prime Number Generation");
		rp.reverseofPrime(40);

	}
	public void reverseofPrime(int n)
	{
		
		int primecount=0;
			
			for(int i=n;i>=2; i--)
			{
				int count=0;
				for(int j=1; j<=i; j++)
				{
					if(i%j==0)
					{
						count++;
					}
					
						
				}
				if(count==2)
				{
					primecount++;
					System.out.println(" " +i);
				}
				
				
			}
			System.out.println("Totally "+primecount+" prime numbers available for this input ");
				
			
	}

}


