package application;

public class Program {

	public static void main(String[] args) {
		
		//Boxing
		int x = 20;
		
		Object obj = x;
		
		System.out.println(obj);
		
		//Unboxing
		int y = (int) obj;
		
		System.out.println(y);
		
		//Wrapper Class
		Integer obj2 = x;
		
		int z = obj2;
		
		System.out.println(z);
	}

}
