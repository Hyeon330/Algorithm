package samsungDX.no25.s1;

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
        MinHeap minH1, minH2, tmp;
        int T, N, heapSize, result;
        int[] arr;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            result = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            minH1 = new MinHeap(N);
            minH2 = new MinHeap(N);
            minH1.push(Integer.parseInt(st.nextToken()));
            arr = new int[N * 2 + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                minH1.push(Integer.parseInt(st.nextToken()));
                minH1.push(Integer.parseInt(st.nextToken()));
                heapSize = minH1.size;
                for (int j = 0; j < heapSize; j++) {
                    arr[j] = minH1.top();
                    minH2.push(minH1.pop());
                }
                result += arr[heapSize >> 1] % MAX_NUM;
                tmp = minH1;
                minH1 = minH2;
                minH2 = tmp;
            }
            sb.append("#" + tc + " " + result + "\n");
        }
        System.out.print(sb);
    }
}
