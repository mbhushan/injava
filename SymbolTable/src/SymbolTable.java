
public class SymbolTable<Key, Value> {
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
	
	public Iterable<Key> keys() {
		return null;
	}

}
