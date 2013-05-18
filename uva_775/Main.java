

/**
 * 
 * Algorithm: Palmer
 * Complexity: O(n^2)
 */
import java.util.*;

public class Main {

	static int n;
	static int cnt;
	static int[][] a;

	public static void palmer()

	{

		int[] cycle = new int[n + 1];

		/** Arbitrary cycle  of vertices **/
		for (int i = 0; i <= n; i++)
			cycle[i] = i % n;

		
		for ( ; ; ) {
			
			int i = -1;

			/** find i and i+1 **/
			for (int j = 0; j < n; j++) {
				int[] ch = new int[n + 2];
				ch[cycle[j]]++;
				ch[cycle[j + 1]]++;

				if (ch[cycle[j]] == 1 && ch[cycle[j + 1]] == 1
						&& a[cycle[j]][cycle[j + 1]] == 0) {
					i = j;
					break;
				}
			}

			if (i == -1)
				break;
			int k = -1;

			/** find j and j+1  **/
			for (int j = 0; j < n; j++) {
				int[] ch = new int[n + 2];
				ch[cycle[j]]++;
				ch[cycle[i]]++;
				ch[cycle[j + 1]]++;
				ch[cycle[(i + 1)]]++;

				if (ch[cycle[j]] == 1 && ch[cycle[i]] == 1
						&& ch[cycle[j + 1]] == 1 && ch[cycle[(i + 1)]] == 1
						&& a[cycle[i]][cycle[j]] > 0
						&& a[cycle[i + 1]][cycle[j + 1]] > 0) {
					k = j;
					break;
				}

			}

			if (k == -1)
				break;

			/** reverse  nodes between i+1 and j ***/
			int l1 = Math.min(i + 1, k);
			int l2 = Math.max(i + 1, k);
			for (int j = 0, indx = 0; j < (l2 - l1 + 1) / 2; j++, indx++) {

				int tmp = cycle[l1 + j];
				cycle[j + l1] = cycle[l2 - indx];
				cycle[l2 - indx] = tmp;
			}
		}
		
		/**  print Hamiltonian Cycle **/
		
		int start = 0;
		for (int j = 0; j < n; j++)

			if (a[cycle[j]][cycle[j + 1]] > 0) {
				start = j;
				break;
			}
		cnt = 0;
		for (int j = start; j <= n; j++) {
			if (cnt == 0)
				System.out.print(cycle[j] + 1);
			else
				System.out.print(" " + (cycle[j] + 1));
			cnt++;
		}

		for (int j = 0; j < start; j++) {
			if (cnt == 0)
				System.out.print(cycle[j] + 1);
			else
				System.out.print(" " + (cycle[j] + 1));
			cnt++;
		}
		System.out.println("");
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		a = new int[260][260];
		int u, v;
		while (in.hasNext()) {

			n = Integer.parseInt(in.next().trim());

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					a[i][j] = 0;

			for (;;) {

				String s = in.next();
				if (s.equals("%"))
					break;
				String s1 = in.next();
				u = Integer.parseInt(s);
				v = Integer.parseInt(s1);
				u--;
				v--;
				if (u == v)
					continue;
				a[u][v] = 1;
				a[v][u] = 1;
			}
			palmer();
		}
	}
}
