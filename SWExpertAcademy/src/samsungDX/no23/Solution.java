package samsungDX.no23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MaxHeap {
    static int[] data = new int[100001];
    static int size = 0;

    static int parent(int i) {return i >> 1;}
    static int left(int i) {return i << 1;}
    static int right(int i) {return i << 1 | 1;}

    void swap(int i1, int i2) {
        int tmp = data[i1];
        data[i1] = data[i2];
        data[i2] = tmp;
    }

    void push(int x) {
        data[++size] = x;
        for (int i = size; parent(i) != 0 && data[parent(i)] < data[i]; i >>= 1)
            swap(parent(i), i);
    }

    int top() {
        if (size == 0)
            return -1;
        return data[1];
    }

    int pop() {
       int result = top();
       if (result < 0) return result;
       data[1] = data[size--];
       for (int i = 1; left(i) <= size;) {
           if (left(i) == size || data[left(i)] > data[right(i)]) {
               if (data[i] < data[left(i)]) {
                   swap(i, left(i));
                   i = left(i);
               } else
                   break;
           } else {
               if (data[i] < data[right(i)]) {
                   swap(i, right(i));
                   i = right(i);
               } else
                   break;
           }
       }
       return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sbCase, sb = new StringBuffer();
        StringTokenizer st;
        MaxHeap mh;
        int T, N;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sbCase = new StringBuffer();
            mh = new MaxHeap();
            N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                if (st.nextToken().equals("1"))
                    mh.push(Integer.parseInt(st.nextToken()));
                else
                    sbCase.append(" " + mh.pop());
            }

            sb.append("#" + tc + sbCase + "\n");
        }
        System.out.print(sb);
    }
}
