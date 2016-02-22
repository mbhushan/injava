package i_MinWindow;

public class MinWindow {
	
	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		String A = minWindow(S, T);
		System.out.println("Ans: " + A);
	}

	public static String minWindow(String S, String T) {
		int sLen = S.length();
		  int tLen = T.length();
		  int [] needToFind = new int[256];
		 
		  for (int i = 0; i < tLen; i++) {
		    needToFind[T.charAt(i)]++;
		  }
		  int minWindowBegin = -1;
		  int minWindowEnd = -1;
		 
		  int hasFound[] = new int[256];
		  int minWindowLen = Integer.MAX_VALUE;
		  int count = 0;
		  for (int begin = 0, end = 0; end < sLen; end++) {
		    // skip characters not in T
		    if (needToFind[S.charAt(end)] == 0) {
		    	continue;
		    }
		    hasFound[S.charAt(end)]++;
		    if (hasFound[S.charAt(end)] <= needToFind[S.charAt(end)]) {
		      count++;
		    }
		 
		    // if window constraint is satisfied
		    if (count == tLen) {
		      // advance begin index as far right as possible,
		      // stop when advancing breaks window constraint.
		      while (needToFind[S.charAt(begin)] == 0 ||
		            hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) {
		        if (hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) {
		          hasFound[S.charAt(begin)]--;
		        }
		        begin++;
		      }
		 
		      // update minWindow if a minimum length is met
		      int windowLen = end - begin + 1;
		      if (windowLen < minWindowLen) {
		        minWindowBegin = begin;
		        minWindowEnd = end;
		        minWindowLen = windowLen;
		      } // end if
		    } // end if
		  } // end for
		 
		  StringBuffer sb = new StringBuffer();
		  if (count == tLen) {
			  for (int i=minWindowBegin; i<=minWindowEnd; i++) {
				  sb.append(S.charAt(i));
			  }
		  }
		  return sb.toString();
	}
}
