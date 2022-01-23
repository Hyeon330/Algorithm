package bronze.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam1110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int r = num;
        int count = 0;
        
        while(true) {
        	count++;
        	r = r%10*10+(r/10 + r%10)%10;
        	if(r==num) {
        		break;
        	}
        }
        System.out.println(count);
	}

}
