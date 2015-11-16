
public class SymbolTable<Key extends Comparable<Key>, Value> {
	public SymbolTable() {}
	
	public Value get(Key key) {
		return null;
	}
	
	public void put(Key key, Value value) {}
	
	public void delete(Key key) {
		this.put(key, null);
	}
	
	public boolean contains(Key key) {
		return this.get(key) != null;
	}
	
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	public int size() {
		return 0;
	}
	
	public Key min() { return null; }
	
	public Key max() { return null; }
	
	public Iterable<Key> keys() {
		return null;
	}
	
	public Key floor(Key key) {return null;}
	
	public Key ceiling(Key key) {return null; }
	
	//number of keys less than key
	public int rank(Key key) { return -1; }
	
	//key of rank k
	public Key select(int k) { return null; }
	
	public void deleteMin() {
		delete(min());
	}
	
	public void deleteMax() {
		delete(max());
	}
	
	public Iterable<Key> keys(Key lo, Key hi) { 
		return null;
	}

}
