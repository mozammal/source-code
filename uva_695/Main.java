/** ChildHood Puzzle
 * 
 * Solved using backtracking too slow :-) 
 */


import java.util.*;

public class Main {

	static boolean found;
	static String puzz;
	static String nm, nm1;
	static int n, m;
	static String[][] dp, dp1;
	static int[][] strToDigit1, strToDigit2;

	public static void recurse(String op, int d, String res, String res1,
			int[] flag, int depth, int sum1, int sum2) {

		String str;
		char c;
		int r;

		if (depth == 0 && d == n + m) {
			if (sum1 == sum2) {
				found = false;
				puzz = res + "=" + res1;
			}

			return;
		}

		else if (depth == 0 && (n + m != d)) {
			if (d == n) {
				sum2 = strToDigit2[0][m - 1];
				res1 = res1 + dp1[0][m - 1];
			}
			if (d == n && sum1 == sum2) {
				found = false;
				puzz = res + "=" + res1;
			}

			return;
		}

		for (int i = d; i < (n + m) && found; i++) {
			int j = 0;
			for (j = 0; j < op.length() && found; j++)
				if (flag[j] == 0) {

					if (i < n) {
						if (d == 0) {
							str = dp[d][i];
							recurse(op, i + 1, res + str, res1, flag, depth,
									strToDigit1[d][i] + sum1, sum2);
						}

						else if ((i + 1 <= n)) {
							c = op.charAt(j);
							str = dp[d][i];
							r = strToDigit1[d][i];
							if (r == 0 && c == '/')
								continue;
							flag[j] = 1;
							int sum = 0;
							if (c == '+')
								sum = sum1 + r;
							else if (c == '-')
								sum = sum1 - r;
							else if (c == '*')
								sum = sum1 * r;
							else if (c == '/' && (r != 0))
								sum = (int) Math.floor(sum1 * 1.0 / r);
							recurse(op, i + 1, res + op.charAt(j) + str, res1,
									flag, depth - 1, sum, sum2);
							flag[j] = 0;
						}
					}

					else {
						if (d - n == 0) {
							str = dp1[d - n][i - n];
							recurse(op, i + 1, res, res1 + str, flag, depth,
									sum1, strToDigit2[d - n][i - n] + sum2);
						} else if ((i + 1 - n <= m) && d >= n) {
							c = op.charAt(j);
							str = dp1[d - n][i - n];
							r = strToDigit2[d - n][i - n];
							if (r == 0 && c == '/')
								continue;
							flag[j] = 1;
							int sum = 0;
							if (c == '+')
								sum = sum2 + r;
							else if (c == '-')
								sum = sum2 - r;
							else if (c == '*')
								sum = sum2 * r;
							else if (c == '/' && (r != 0))
								sum = (int) Math.floor(sum2 * 1.0 / r);
							recurse(op, i + 1, res, res1 + op.charAt(j) + str,
									flag, depth - 1, sum1, sum);
							flag[j] = 0;
						}
					}
				}
		}
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int cas = 1;
		dp = new String[101][101];
		dp1 = new String[101][101];
		strToDigit1 = new int[101][101];
		strToDigit2 = new int[101][101];

		while (true) {

			String nmm = in.nextLine();
			if (nmm.equals("$"))
				break;
			String op = in.nextLine();
			String[] s1 = nmm.split("=");
			found = true;
			puzz = "";
			int[] flag = new int[op.length()];
			nm = s1[0];
			nm1 = s1[1];
			n = s1[0].length();
			m = s1[1].length();

			for (int i = 0; i < n; i++)
				for (int j = i; j < n; j++) {
					dp[i][j] = nm.substring(i, j + 1);
					strToDigit1[i][j] = Integer.parseInt(dp[i][j]);
				}

			for (int i = 0; i < m; i++)
				for (int j = i; j < m; j++) {
					dp1[i][j] = nm1.substring(i, j + 1);
					strToDigit2[i][j] = Integer.parseInt(dp1[i][j]);
				}

			recurse(op, 0, "", "", flag, op.length(), 0, 0);

			if (found == false)
				System.out.printf("Case %d: %s\n", cas++, puzz);
			else
				System.out.printf("Case %d: %s\n", cas++, "NO SOLUTION");
		}
	}
}
