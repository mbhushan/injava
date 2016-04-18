package designpat_Prototype;

interface Prototype {
	public void setSize(int size);
	public void printSize();
}

class Sample implements Prototype, Cloneable {
	
	private int size;
	
	public Sample(int size) {
		this.size = size;
	}
	
	@Override
	public Sample clone () throws CloneNotSupportedException {
		return (Sample) super.clone();
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void printSize() {
		System.out.println("size: " + this.size);
	}
	
}

public class PrototypeTest {

	public static void main(String [] args) throws CloneNotSupportedException {
		Sample sample = new Sample(1);
		for (int i=2; i<10; i++) {
			Prototype temp = sample.clone();
			temp.setSize(i);
			temp.printSize();
		}
	}
}
