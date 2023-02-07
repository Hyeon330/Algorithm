package samsungDX.no25_.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MinHeap {
    int[] data;
    int size;
    MinHeap(int N) {
        data = new int[(N + 1) * 2];
        size = 0;
    }

    void push(int x) {
        int tmp;

        data[++size] = x;
        for (int i = size; i >> 1 != 0 && data[i >> 1] > data[i]; i >>= 1) {
            tmp = data[i >> 1];
            data[i >> 1] = data[i];
            data[i] = tmp;
        }
    }

    int top() {
        if (size == 0)
            return -1;
        return data[1];
    }

    int pop() {
        int tmp, result = top();
        if (result < 0) return result;
        data[1] = data[size--];
        for (int i = 1; i << 1 <= size;) {
            if (i << 1 == size || data[i << 1] < data[i << 1 | 1]) {
                if (data[i] > data[i << 1]) {
                    tmp = data[i];
                    data[i] = data[i << 1];
                    data[i << 1] = tmp;
                    i <<= 1;
                } else
                    break;
            } else {
                if (data[i] > data[i << 1 | 1]) {
                    tmp = data[i];
                    data[i] = data[i << 1 | 1];
                    data[i << 1 | 1] = tmp;
                    i = i << 1 | 1;
                } else
                    break;
            }
        }
        return result;
    }
}

public class Solution {
    static final int MAX_NUM = 20171109;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        MinHeap minHeap1, minHeap2, tmp;
        int T, N, n1, n2, m, heapSize, result;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            result = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            minHeap1 = new MinHeap(N);
            minHeap2 = new MinHeap(N);
            m = Integer.parseInt(st.nextToken());
            minHeap1.push(m);
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                n1 = Integer.parseInt(st.nextToken());
                n2 = Integer.parseInt(st.nextToken());
                minHeap1.push(n1);
                minHeap1.push(n2);
                if ((m >= n1 && m <= n2) || (m <= n1 && m >= n2))
                    result += m % MAX_NUM;
                else {
                    heapSize = minHeap1.size;
                    for (int j = 0; j < heapSize; j++) {
                        if (j == heapSize / 2) {
                            m = minHeap1.top();
                            result += m % MAX_NUM;
                        }
                        minHeap2.push(minHeap1.pop());
                    }
                    tmp = minHeap1;
                    minHeap1 = minHeap2;
                    minHeap2 = tmp;
                }
            }
            sb.append("#" + tc + " " + result + "\n");
        }
        System.out.print(sb);
    }
}
