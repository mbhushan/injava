import java.util.Iterator;


public class Stack<T> implements Iterable<T>{

	private T[] data; //stack data
	private int N; //size
	
	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		data = (T []) new Object[capacity];
		N = 0;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int max) {
		T [] temp = (T []) new Object[max];
		for (int i=0; i<N; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
	
	public void push(T value) {
		if (N == data.length) {
			resize(2* (data.length));
		}
		
		data[N++] = value;
	}
	
	public T pop() {
		 T value = data[--N];
		 data[N] = null; //avoid loitering.
		 if (N > 0 && N == data.length/4) {
			 resize(data.length/2);
		 }
		 return value;
	}
	
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public Iterator<T> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<T> {
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public T next() {
			return data[--i];
		}

		@Override
		public void remove() {}
	}
}

