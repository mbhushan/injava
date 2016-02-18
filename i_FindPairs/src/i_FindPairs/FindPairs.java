package i_FindPairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FindPairs {
	
	public static void main(String[] args) {
		 Integer [] A = {3, 4, 7, 1, 2, 9, 8};
		//findPairs(A);
		 ArrayList<Integer> X = new ArrayList<Integer>();
		 Collections.addAll(X, A);
		 ArrayList<Integer> ans = equal(X);
		 for (Integer a: ans) {
			 System.out.print(a + " ");
		 }
		 System.out.println();
		 
	}
	
	public static ArrayList<Integer> equal(ArrayList<Integer> a) {
        ArrayList<Integer> res = null;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                int sum = a.get(i) + a.get(j);
                
                if (map.containsKey(sum)) {
                    ArrayList<Integer> pair = map.get(sum);
                    if (pair.get(0) != i &&
                        pair.get(1) != j &&
                        pair.get(0) != j &&
                        pair.get(1) != i) {
                            ArrayList<Integer> _temp = new ArrayList<>();
                            _temp.add(pair.get(0));
                            _temp.add(pair.get(1));
                            _temp.add(i);
                            _temp.add(j);
                            
                            if (res == null) res = _temp;
                            else {
                                for (int k = 0; k < 4; k++) {
                                    if (res.get(k) < _temp.get(k)){
                                        break;
                                    } else if (res.get(k) > _temp.get(k)) {
                                        res = _temp;
                                        break;
                                    }
                                }
                            }
                            
                        }
                } else {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    map.put(sum, pair);
                }
            }
        }
        
        return res;
    }


// 
//public static ArrayList<Integer> solve(ArrayList<Integer> vec) {
//         
//    int N = vec.size();
//    // With every sum, we store the lexicographically first occuring pair of integers. 
//    HashMap<Integer, pair<int, int> > Hash;
//    vector<int> Ans;
//         
//    for(int i = 0; i < N; ++i) {
//        for(int j = i + 1; j < N; ++j) {
//                 
//            int Sum = vec[i] + vec[j];
// 
//            if (Hash.find(Sum) == Hash.end()) {
//                Hash[Sum] = make_pair(i, j);
//                continue;
//            }
//                 
//            pair<int, int> p1 = Hash[Sum];
//            if(p1.first != i && p1.first != j && p1.second != i && p1.second != j) {
//                vector<int> ans;
//                ans.push_back(p1.first);
//                ans.push_back(p1.second);
//                ans.push_back(i);
//                ans.push_back(j);
//                     
//                if (Ans.size() == 0) Ans = ans;
//                else {
//                    // compare and assign Ans
//                    bool shouldReplace = false;
//                    for (int i1 = 0; i1 < Ans.size(); i1++) {
//                        if (Ans[i1] < ans[i1]) break;
//                        if (Ans[i1] > ans[i1]) {
//                            shouldReplace = true;
//                            break;
//                        }
//                    }
//                    if (shouldReplace) Ans = ans;
//                }
//            }
//        }
//    }
// 
//    return Ans;
//} 

	static class pair
    {
        int first, second;
        pair(int f,int s)
        {
            first = f; second = s;
        }
    };
 
    public static boolean  findPairs(int arr[])
    {
        // Create an empty Hash to store mapping from sum to
        // pair indexes
        HashMap<Integer,pair> map = new HashMap<Integer,pair>();
        int n=arr.length;
 
        // Traverse through all possible pairs of arr[]
        for (int i=0; i<n; ++i)
        {
            for (int j=i+1; j<n; ++j)
            {
                // If sum of current pair is not in hash,
                // then store it and continue to next pair
                int sum = arr[i]+arr[j];
                if (!map.containsKey(sum))
                    map.put(sum,new pair(i,j));
 
                else // Else (Sum already present in hash)
                {
                    // Find previous pair
                    pair p = map.get(sum);
 
                    // Since array elements are distinct, we don't
                    // need to check if any element is common among pairs
                    System.out.println("("+arr[p.first]+", "+arr[p.second]+
                                      ") and ("+arr[i]+", "+arr[j]+")");
                    return true;
                }
            }
        }
        return false;
    }
}
