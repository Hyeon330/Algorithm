package samsungDX.dataStructure;

public class MaxHeap {
    private static final int MAX_N = 100000;

    int[] data = new int[MAX_N + 1];
    int size = 0;

    static int parent(int i) {return i >> 1;}
    static int left(int i) {return  i << 1;}
    static int right(int i) {return i << 1 | 1;}

    private void swap(int n1, int n2) {
        int tmp;

        tmp = data[n1];
        data[n1] = data[n2];
        data[n2] = tmp;
    }

    // x 삽입
    public void push(int x) {
        data[++size] = x;
        for (int i = size; parent(i) != 0 && data[parent(i)] < data[i]; i >>= 1)
            swap(parent(i), i);
    }
    // 최대값 리턴
    public int top() {
        if (size == 0)
            return -1;
        return data[1];
    }
    // 최대값 삭제
    public int pop() {
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
                } else {
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; data[i] != 0; i++)
            sb.append(data[i] + " ");
        return sb.toString();
    }
}
