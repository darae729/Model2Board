package test;

public class UseDog {
	
	public static void main(String[] args) {
		//강아지의 인스턴스 만들기 
		Dog d1=Dog.getInstance();
		System.out.println(d1);
		
		Dog d2=Dog.getInstance();
		System.out.println(d2);
	}
}
