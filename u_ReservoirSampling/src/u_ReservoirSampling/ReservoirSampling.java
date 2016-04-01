package u_ReservoirSampling;

/*
 https://en.wikipedia.org/wiki/Reservoir_sampling
 A Primer on Reservoir Sampling
For this problem, the simplest concrete example would be a stream that only contained a single item. 
In this case, our algorithm should return this single element with probability 1. Now let’s try a slightly harder problem,
 a stream with exactly two elements. We know that we have to hold on to the first element we see from this stream, because we 
 don’t know if we’re in the case that the stream only has one element. When the second element comes along, we know that we want to 
 return one of the two elements, each with probability 1/2. So let’s generate a random number R between 0 and 1, and return the first
  element if R is less than 0.5 and return the second element if R is greater than 0.5.

Now let’s try to generalize this approach to a stream with three elements. After we’ve seen the second element in the stream,
 we’re now holding on to either the first element or the second element, each with probability 1/2. When the third element arrives, 
 what should we do? Well, if we know that there are only three elements in the stream, we need to return this third element with 
 probability 1/3, which means that we’ll return the other element we’re holding with probability 1 – 1/3 = 2/3. That means that the 
 probability of returning each element in the stream is as follows:

First Element: (1/2) * (2/3) = 1/3
Second Element: (1/2) * (2/3) = 1/3
Third Element: 1/3
By considering the stream of three elements, we see how to generalize this algorithm to any N: at every step N, 
keep the next element in the stream with probability 1/N. This means that we have an (N-1)/N probability of keeping 
the element we are currently holding on to, which means that we keep it with probability (1/(N-1)) * (N-1)/N = 1/N.
 */
import java.util.Random;

public class ReservoirSampling {

	public static void main(String [] args) {
		int [] streams = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int k = 5;
		selectKItems(streams, k);
	}
	
	public static void selectKItems(int [] S, int k) {
		int n = S.length;
		int [] R = new int[k];
		for (int i=0; i<k; i++) {
			R[i] = S[i];
		}
		
		Random rand = new Random();
		for (int i=k; i<n; i++) {
			int x = rand.nextInt(i+1);
			if (x < k) {
				R[x] = S[i];
			}
		}
		
		System.out.println(k + " samples are: ");
		for (int s: R) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
