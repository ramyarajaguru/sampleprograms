package examples;

public class Findeven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Findeven fe=new Findeven();
		fe.findEven100to200();

	}
  void findEven100to200()
  {
	  for(int i=100; i<=200; i++)
	  {
		 if(i%2==0)
			 System.out.println(i);
	  }
  }
}
