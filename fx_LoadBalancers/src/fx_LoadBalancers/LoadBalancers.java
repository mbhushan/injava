package fx_LoadBalancers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Design a load balancer where you can add,remove and find random server in O(1) time -
*/
public class LoadBalancers {

	private List<String> servers = new ArrayList<String>();
	private Map<String, Integer> hmap = new HashMap<String, Integer>();
	
	public LoadBalancers() {}
	
	public void addServer(String name) {
		name = name.trim();
		servers.add(name);
		hmap.put(name, servers.size()-1);
	}
	
	public String getRandom() {
		int rand = (int)(Math.random()*1000);
		return servers.get(rand%(servers.size()));
	}
	
	public void removeServer(String name) {
		if (!hmap.containsKey(name)) {
			throw new IllegalArgumentException();
		}
		int pos = hmap.get(name);
		servers.set(pos, servers.get(servers.size()-1));
		servers.remove(servers.size()-1);
	}
	
	public static void main(String[] args) {
		LoadBalancers lb = new LoadBalancers();
		
		lb.addServer("1");
		lb.addServer("2");
        lb.addServer("3");
        lb.addServer("4");
        lb.addServer("5");
        
        System.out.println(lb.getRandom());
        System.out.println(lb.getRandom());
        System.out.println(lb.getRandom());
        System.out.println(lb.getRandom());
        
        lb.removeServer("3");
        lb.removeServer("1");
        System.out.println(lb.getRandom());
        System.out.println(lb.getRandom());
        System.out.println(lb.getRandom());
        System.out.println(lb.getRandom());
        
	}
}
