package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.print("확률을 입력하세요(종료 x): ");
			try {
				String play = bf.readLine();
				if(play.equals("x") || play.equals("X")) {
					System.out.println("종료");
					break;
				}
				else {
					int prob = Integer.parseInt(play);
					int rand = (int)(Math.random()*100)+1;
					if(rand <= prob) System.out.println("성공!!");
					else System.out.println("실패...");
				}
			} catch (Exception e) {
				System.out.println("올바른 값을 입력해주세요.");
			}
			
			System.out.println();
		}
	}
}
