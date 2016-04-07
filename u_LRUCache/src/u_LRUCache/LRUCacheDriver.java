package u_LRUCache;

public class LRUCacheDriver {

	public static void main(String[] args) {
		LRUCache<Integer, Integer> lru = new LRUCache<Integer, Integer>(2);
		lru.set(1, 10);
		lru.set(5, 12);
		System.out.println(lru.get(5));
		System.out.println(lru.get(1));
		System.out.println(lru.get(10));
		lru.set(6, 14);
		System.out.println(lru.get(5));
		
	}
}
