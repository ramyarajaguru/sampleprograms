package Sample;

public class Checkprimeornot {

	public static void main(String[] args) {
	
		
		Checkprimeornot cp=new Checkprimeornot();
		cp.checkPrime(56);
	}
		
		public void checkPrime(int n)
		{
		int count=0;
		for(int i=1; i<=n; i++)
		{
			if(n%i==0)
				count++;
		}
		if(count==2)
			System.out.println(" The given "+n+" number is a prime number");
		else
			System.out.println(" The given "+n+" number is not a prime number");

	}

}
