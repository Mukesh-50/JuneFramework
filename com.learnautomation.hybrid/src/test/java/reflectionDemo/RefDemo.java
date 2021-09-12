package reflectionDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefDemo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InvocationTargetException 
	{
		Students s1=new Students();
		
		Class cls=s1.getClass();
		
		System.out.println(cls.getName());
		
		Constructor const1=cls.getConstructor();

		System.out.println(const1.getName());
		
		Method[] allMethods=cls.getMethods();
		
		for(Method m:allMethods)
		{
			System.out.println(m.getName());
		}
		
		Field f1=cls.getDeclaredField("collName");
		
		System.out.println(f1.getName());
		
		System.out.println(f1.get(s1));
		
		Method pvtMethod=cls.getDeclaredMethod("breakSession");
		
		pvtMethod.setAccessible(true);
		
		pvtMethod.invoke(s1);
		
	}

}
