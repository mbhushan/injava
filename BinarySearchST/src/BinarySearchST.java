
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	
	private Key [] keys;
	private Value [] vals;
	private int N;
	
	public BinarySearchST(int capacity) {
		keys = (Key []) new Comparable[capacity];
		vals = (Value []) new Object[capacity];
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void put(Key key, Value value) {
		//search for key, update if found, exapand table if needed.
		int i = rank(key);
		
		if ((i < N) && (keys[i].compareTo(key) == 0)) {
			vals[i] = value;
			return;
		}
		
		for (int j=N; j>i; j--) {
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		keys[i] = key;
		vals[i] = value;
		++N;
	}
	
	public int rank(Key key) {
		int low = 0;
		int high = N-1;
		
		while (low <= high) {
			int mid = low + (high-low)/2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) {
				high = mid - 1;
			} else if (cmp > 0) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return low;
	}
	
	public Value get(Key key) {
		if (isEmpty()) {
			return null;
		}
		
		int i = rank(key);
		if ((i < N) && keys[i].compareTo(key) == 0) {
			return vals[i];
		} else {
			return null;
		}
	}
	
	public void delete(Key key) {
		
	}
	
	public Key min() {
		return keys[0];
	}
	
	public Key max() {
		return keys[N-1];
	}
	
	public Key select(int k) {
		return keys[k];
	}

}
