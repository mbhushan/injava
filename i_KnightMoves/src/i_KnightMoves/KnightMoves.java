package i_KnightMoves;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class pair {
	int ff;
	int ss;

	pair(int x, int y) {
		ff = x;
		ss = y;
	}
}

class MyPair {
	pair p;
	int i;

	public MyPair(pair p, int n) {
		this.p = p;
		int i = n;
	}
}

public class KnightMoves {
	static int[] dx = { 2, 2, -2, -2, 1, 1, -1, -1 };
	static int[] dy = { -1, 1, 1, -1, 2, -2, 2, -2 };

	public static void main(String[] args) {
		int ans = knight(8, 8, 1, 1, 8, 8);
		System.out.println("ans: " + ans);
	}

	public static boolean valid(int x, int y, int N, int M) {
		if (x <= 0 || y <= 0 || x > N || y > M)
			return false;
		return true;
	}

	public static int bfs(pair p1, pair p2, pair p3) {

		int N = p3.ff;
		int M = p3.ss;
		Queue<MyPair> Que = new LinkedList<MyPair>();
		HashMap<pair, Boolean> Vis = new HashMap<pair, Boolean>();

		Que.add(new MyPair(p1, 0));

		while (!Que.isEmpty()) {

			MyPair temp = Que.remove();

			if (temp.p.ff == p2.ff && temp.p.ss == p2.ss)
				return temp.i;
			int x = temp.p.ff;
			int y = temp.p.ss;
			int dis = temp.i + 1;

			// if(Vis.count(mpa(x, y)))
			// continue;
			if (Vis.containsKey(temp.p)) {
				continue;
			}
			// Vis[mpa(x, y)] = true;
			Vis.put(new pair(x, y), true);

			for (int i = 0; i < 8; ++i) {

				int x1 = x + dx[i];
				int y1 = y + dy[i];
				if (valid(x1, y1, N, M))
					Que.add(new MyPair(new pair(x1, y1), dis)); // mpa(mpa(x1,
																// y1), dis));
			}

		}

		return -1;
	}

	public static int knight(int N, int M, int x1, int y1, int x2, int y2) {

		pair p1 = new pair(x1, y1);
		p1.ff = x1;
		p1.ss = y1;

		pair p2 = new pair(x2, y2);
		p2.ff = x2;
		p2.ss = y2;

		pair p3 = new pair(N, M);
		p3.ff = N;
		p3.ss = M;

		int ans = bfs(p1, p2, p3);
		return ans;
	}
}
