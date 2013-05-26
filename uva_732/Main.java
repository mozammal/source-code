/**
 * 
 *  Algorithm: Backtracking (Very Slow, if I could prune aggressively) 
 * 
 */

import java.util.*;

public class Main {

	static TreeSet<String> res;

	public static void doit(StringBuilder s, StringBuilder s1, String r, int cnt) {

		if (s.toString().equals("") && s1.toString().equals("")) {
			res.add(r.trim());
			return;
		}

		/** try if we can match from our previous stack **/
		if (cnt > 0 && s.charAt(cnt - 1) == s1.charAt(0)) {
			char c = s.charAt(cnt - 1);
			char ch = s1.charAt(0);
			doit(s.deleteCharAt(cnt - 1), s1.deleteCharAt(0), r + " " + "o",
					cnt - 1);
			s.insert(cnt - 1, c);
			s1.insert(0, ch);
		}

		/** Try if we can match from our current element **/
		if (s != null && s1 != null && (cnt < s.length())
				&& (s.charAt(cnt) == s1.charAt(0))) {
			char c = s.charAt(cnt);
			char ch = s1.charAt(0);
			doit(s.deleteCharAt(cnt), s1.deleteCharAt(0), r + " " + "i" + " "
					+ "o", cnt);
			s.insert(cnt, c);
			s1.insert(0, ch);
		}

		/** Try if we can extend our current stack **/
		if (s != null && s1 != null && (cnt < s.length())
				&& (s.charAt(cnt) != s1.charAt(0)))
			doit(s, s1, r + " " + "i", cnt + 1);

		/**
		 * Try if we can extend our current stack even if there's a match for
		 * our current element
		 **/
		if (s != null && s1 != null && (cnt < s.length())
				&& (s.charAt(cnt) == s1.charAt(0)))
			doit(s, s1, r + " " + "i", cnt + 1);

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		res = new TreeSet<String>();

		while (in.hasNext()) {
			String s = in.next();
			String s1 = in.next();
			int n = s.length();
			int m = s1.length();

			if (m != n) {
				System.out.println("[");
				System.out.println("]");

			}

			else

			{
				doit(new StringBuilder(s), new StringBuilder(s1), "", 0);

				System.out.println("[");
				for (String i : res)
					System.out.println(i);
				System.out.println("]");
				res.clear();
			}
		}

	}
}