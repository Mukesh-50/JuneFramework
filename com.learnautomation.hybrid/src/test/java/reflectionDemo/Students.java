package reflectionDemo;

public class Students 
{
	
	private String name;
	
	public String collName="LNCT";
	
	
	public Students()
	{
		System.out.println("I am Cons");
	}
	
	public void math()
	{
		System.out.println("I am in math class");
	}
	
	public void history(int students)
	{
		System.out.println("I am in math class and total students are "+students);
	}
	
	
	private void breakSession()
	{
		System.out.println("Lunch break");
	}
	
	
}
