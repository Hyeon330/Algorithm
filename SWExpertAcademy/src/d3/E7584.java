package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E7584 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(bf.readLine());
//		
//		StringBuffer sb = new StringBuffer();
//		for(int i=1; i<=T; i++) {
//			sb.append("#"+i+" ");
//			
//			StringBuffer P = new StringBuffer().append("0");
////			BigInteger cnt = new BigInteger(bf.readLine());
////			while(new BigInteger(P.toString(), 2).compareTo(cnt)==-1) {
//////				P.append("0"+f(g(P))); 
////			}
////			
////			sb.append(P.charAt((int)(cnt-1)) + "\n"); 10000000000000000
////			long cnt = Long.parseLong(bf.readLine());
//		}
//		
////		System.out.println(sb.toString());
//		System.out.println(Integer.MAX_VALUE);
//	}
//	
//	// 좌우 반전
////	static String g(BigInteger P) {
////		String reverseP = P.reverse().toString();
////		P.reverse();
////		return reverseP;
////	}
//	
//	// 문자 반전
//	static String f(String P) {
//		int PLeng = P.toString().length();
//		BigInteger big = new BigInteger(P, 2);
//		for(int i=0; i<PLeng; i++) {
//			big = new BigInteger(big.flipBit(i).toString(2), 2);
//		}
//		return String.format("%"+PLeng+"s", big.toString(2)).replace(" ", "0");
//	}
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            long k = Long.parseLong(br.readLine());
            while(k%4==0) {
                k /= 4;
            }
            int val;
            if(k%4 == 1) val = 0;
            else if(k%4 == 3) val = 1;
            else {
                if(k%8 == 2) val = 0;
                else val = 1;
            }
            System.out.println("#"+test_case+" "+val);
        }
 
    }
}
