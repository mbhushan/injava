package hash_HashMap;

import java.util.LinkedList;
import java.util.Queue;

public class HashMapST<Key, Value> {

	private static final int INIT_CAPACITY = 4;
	
	private int N = 0; // number of key-value pairs.
	private int M = 0; // size of the hashtable.
	private SequentialSearchST<Key, Value> [] ST;
	
	public HashMapST() {
		this(INIT_CAPACITY);
	}
	
	public HashMapST(int m) {
		this.M = m;
		ST = new SequentialSearchST[M];
		for (int i=0; i<M; i++) {
			ST[i] = new SequentialSearchST<Key, Value>();
		}
	}
	
	private void resize(int chains) {
		HashMapST<Key, Value> temp = new HashMapST<Key, Value>(chains);
		for (int i=0; i<M; i++) {
			for (Key key: ST[i].keys()) {
				temp.put(key, ST[i].get(key));
			}
		}
		this.M = temp.M;
		this.N = temp.N;
		this.ST = temp.ST;
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean containsKey(Key key) {
		if (key == null) {
			throw new NullPointerException("argument to containsKey is null");
		}
		return get(key) != null;
	}
	
	public Value get(Key key) {
		if (key == null) {
			throw new NullPointerException("arguement to get method is null");
		}
		int h = hash(key);
		return ST[h].get(key);
	}
	
	public void put(Key key, Value value) {
		if (key == null) {
			throw new NullPointerException("arguments to put method is null");
		}
		if (value == null) {
			delete(key);
			return;
		}
		// double table size if average length of list >= 10
		if (N >= 10*M) {
			resize(2*M);
		}
		int h = hash(key);
		if (!ST[h].containsKey(key)) {
			++N;
		}
		ST[h].put(key, value);
	}
	
	public void delete(Key key) {
		if (key == null) {
			throw new NullPointerException("arguments to delete method is null");
		}
		int h = hash(key);
		if (ST[h].containsKey(key)) {
			--N;
		}
			ST[h].delete(key);
        // halve table size if average length of list <= 2
		if (M > INIT_CAPACITY && (N <= 2*M)) {
			resize(M/2);
		}
	}
	
	public Iterable<Key> keys() {
		Queue<Key> Q = new LinkedList<Key>();
		for (int i=0; i<M; i++) {
			for (Key k: ST[i].keys()) {
				Q.add(k);
			}
		}
		return Q;
	}
}
