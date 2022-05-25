package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E2005 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(bf.readLine());
			sb.append("#"+(i+1)+"\n");
			for(int j=0; j<N; j++) {
				String[] lineArr = sb.toString().split("\n");
				for(int k=0; k<=j; k++) {
					if(k==0) sb.append("1");
					else if(k==j) sb.append(" 1");
					else {
						String[] strArr = lineArr[lineArr.length-1].split(" ");
						sb.append(" "+(Integer.parseInt(strArr[k-1])+Integer.parseInt(strArr[k])));
					}
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
