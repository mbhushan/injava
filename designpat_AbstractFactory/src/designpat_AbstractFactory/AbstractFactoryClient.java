package designpat_AbstractFactory;

import java.util.ArrayList;

interface CPU {
	void process();
}

interface CPUFactory {
	CPU produceCPU();
}

class IntelCPU implements CPU {

	@Override
	public void process() {
		System.out.println("Intel is processing...");
	}
}

class IntelFactory implements CPUFactory {

	@Override
	public CPU produceCPU() {
		return new IntelCPU();
	}
}

class AMDCPU implements CPU {

	@Override
	public void process() {
		System.out.println("AMD is processing...");
	}
}

class AMDFactory implements CPUFactory {

	@Override
	public CPU produceCPU() {
		return new AMDCPU();
	}
}

class Computer {
	CPU cpu;
	
	public Computer(CPUFactory cpuFactory) {
		cpu = cpuFactory.produceCPU();
		cpu.process();
	}
}

public class AbstractFactoryClient {
	
	public static void main(String [] args) {
		int [] A = {1, 0, 0, 1, 1};
		ArrayList<Computer> compList = new ArrayList<Computer>();
		for (int i=0; i<A.length; i++) {
			CPUFactory factory = createSpecificFactory(A[i]);
			compList.add(new Computer(factory));
		}
	}
	
	public static CPUFactory createSpecificFactory(int sys) {
		CPUFactory factory = null;
		switch (sys) {
		case 0:
			factory = new IntelFactory();
			break;
		case 1:
			factory = new AMDFactory();
		default:
			break;
		}
		return factory;
	}
}
