package designpat_Factory;

interface Human {
	public void walk();
	public void talk();
}

class Boy implements Human {

	@Override
	public void walk() {
		System.out.println("Boy is walking ..");
	}

	@Override
	public void talk() {
		System.out.println("Boy is talking ..");
	}
	
}

class Girl implements Human {

	@Override
	public void walk() {
		System.out.println("Girl is walking..");
	}

	@Override
	public void talk() {
		System.out.println("Girl is talking..");
	}
}

public class HumanFactory {
	public static Human createHuman(String str) {
		Human h = null;
		if (str.toLowerCase().equals("boy")) {
			h = new Boy();
		} else if (str.toLowerCase().equals("girl")) {
			h = new Girl();
		}
		return h;
	}
}
