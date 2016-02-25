package uva_13004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean found;
	static String res;
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=in.readLine())!=null) {
			  int []count = new int[10];
			  int n = s.length();
			  found = false;
			  res="";
			  String str[] = new String[n];
			  
			  for (int i =0; i<n; i++)
				  str[i] = s.substring(0,i+1);
			  back(s,count,"",0,n, str);
			  int cnt = 0;
			  int m = res.length();
			  while(cnt<m && res.charAt(cnt)=='0') {
				  cnt++;
			  }
			  System.out.println(res.substring(cnt));
			  
			  
		}
		
		
		
	}

	private static void back(String s, int[] count, String s1, int n, int len, String []str) {

		//System.out.println("x "+s1);
		    if (found && s1.compareTo(res.substring(0,n))<0)
		    	return;
		    if (n == len) {
		    	  if (res.compareTo(s1)<0)
		    		  res=s1;
		    	//System.out.println(s1);
		    	found = true;
		    	return;
		    }
		    else  {
		     int d = s.charAt(n)-'0';

		      
		         for (int i = 9; i>=0; i--) {
		        	 int val = count[i];
		        	 if (str[n].compareTo(s1+i)>=0 && (val+1)<=2) {
				    	 count[i]++;
				    	 //System.out.println("III "+(s1+i)+" "+i);
				    	 back(s, count, s1+i, n+1, len, str);
				    	 //System.out.println("JJJ "+s1+" "+i);
				    	 count[i]--;
				     }
		         }
		        }
		     
	}

}
package uva_13004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean found;
	static String res;
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=in.readLine())!=null) {
			  int []count = new int[10];
			  int n = s.length();
			  found = false;
			  res="";
			  String str[] = new String[n];
			  
			  for (int i =0; i<n; i++)
				  str[i] = s.substring(0,i+1);
			  back(s,count,"",0,n, str);
			  int cnt = 0;
			  int m = res.length();
			  while(cnt<m && res.charAt(cnt)=='0') {
				  cnt++;
			  }
			  System.out.println(res.substring(cnt));
			  
			  
		}
		
		
		
	}

	private static void back(String s, int[] count, String s1, int n, int len, String []str) {

		//System.out.println("x "+s1);
		    if (found && s1.compareTo(res.substring(0,n))<0)
		    	return;
		    if (n == len) {
		    	  if (res.compareTo(s1)<0)
		    		  res=s1;
		    	//System.out.println(s1);
		    	found = true;
		    	return;
		    }
		    else  {
		     int d = s.charAt(n)-'0';

		      
		         for (int i = 9; i>=0; i--) {
		        	 int val = count[i];
		        	 if (str[n].compareTo(s1+i)>=0 && (val+1)<=2) {
				    	 count[i]++;
				    	 //System.out.println("III "+(s1+i)+" "+i);
				    	 back(s, count, s1+i, n+1, len, str);
				    	 //System.out.println("JJJ "+s1+" "+i);
				    	 count[i]--;
				     }
		         }
		        }
		     
	}

}
