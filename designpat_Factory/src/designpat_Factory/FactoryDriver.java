package designpat_Factory;

public class FactoryDriver {

	public static void main(String [] args) {
		String [] str = {"Boy", "Girl", "Boy" };
		
		for (String st: str) {
			Human human = HumanFactory.createHuman(st);
			human.walk();
			human.talk();
			System.out.println();
		}
	}
}
