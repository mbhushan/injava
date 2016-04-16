package designpat_Builder;

class Starbucks {
	private String size;
	private String drink;
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setDrink(String drink) {
		this.drink = drink;
	}
}

abstract class StarbucksBuilder {
	protected Starbucks starbucks;
	
	public Starbucks getStarbucks() { return starbucks; }
	
	public void createStarbucks() {
		System.out.println("A starbuck drink is getting created!");
		starbucks = new Starbucks();
	}
	
	public abstract void buildSize(String size);
	public abstract void buildDrink(String drink);
}

class TeaBuilder extends StarbucksBuilder {
	public void buildSize(String size) {
		starbucks.setSize(size);
		System.out.println("building " + size + " drink.");
	}
	
	public void buildDrink(String drink) {
		starbucks.setDrink(drink);
		System.out.println("building " + drink);
	}
}

class CoffeeBuilder extends StarbucksBuilder {
	public void buildSize(String size) {
		starbucks.setSize(size);
		System.out.println("building " + size + " drink.");
	}
	
	public void buildDrink(String drink) {
		starbucks.setDrink(drink);
		System.out.println("building " + drink);
	}
}

//director to encapsulate the builder
class Waiter {
	private StarbucksBuilder starbucksBuilder;
	
	public void setStarbucksBuilder(StarbucksBuilder SB) {
		starbucksBuilder = SB;
	}
	
	public Starbucks getStarbucks() {
		return starbucksBuilder.getStarbucks();
	}
	
	public void constructStarbucks(String size, String drink) {
		starbucksBuilder.createStarbucks();
		starbucksBuilder.buildSize(size);
		starbucksBuilder.buildDrink(drink);
		
	}
}

public class Customer {

	public static void main(String [] args) {
		Waiter waiter = new Waiter();
		StarbucksBuilder coffeeBuilder = new CoffeeBuilder();
		waiter.setStarbucksBuilder(coffeeBuilder);
		waiter.constructStarbucks("Large", "Chilled Coffee!");
	}
}
