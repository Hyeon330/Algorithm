package samsungDX.no04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class MyList<T> {
    private class Node<T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private final static int MAX_NODE = 10000;
    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;
    private Node tail;

    MyList() {
        head = new Node(null);
        tail = head;
        nodeCnt = 0;
    }

    Node getNode(T data) {
        if (nodeCnt < MAX_NODE) {
            node[nodeCnt] = new Node(data);
            return node[nodeCnt++];
        } else
            return new Node(data);
    }

    void insert(int locate, int num, T[] data) {
        Node n, newNode, tmpH, tmpT, prev;

        n = head;
        for (int i = 0; i < locate; i++) {
            if (n == null)
                return ;
            n = n.next;
        }
        newNode = null;
        tmpH = null;
        tmpT = null;
        for (int i = 0; i < num; i++) {
            prev = newNode;
            newNode = getNode(data[i]);
            if (i == 0)
                tmpH = newNode;
            else
                prev.next = newNode;
            if (i == num - 1)
                tmpT = newNode;
        }
        tmpT.next = n.next;
        if (tmpT.next == null)
            this.tail = tmpT;
        if (tmpH != null)
            n.next = tmpH;
    }

    void delete(int locate, int num) {
        Node n, next;

        n = head;
        for (int i = 0; i < locate; i++) {
            if (n == null)
                return ;
            n = n.next;
        }
        next = n;
        for (int i = 0; i < num; i++) {
            if (next == null)
                return ;
            next = next.next;
        }
        if (next.next == null)
            n.next = null;
        else
            n.next = next.next;
        if (n.next == null)
            tail = n;
    }

    void append(T data) {
        Node newNode = getNode(data);
        if (head.next == null)
            head.next = newNode;
        else
            tail.next = newNode;
        tail = newNode;
    }

    String getList10() {
        StringBuffer sb = new StringBuffer();
        Node n = head;
        for (int i = 0; i < 10 && n.next != null; i++) {
            n = n.next;
            sb.append(n.data + " ");
        }
        return sb.toString();
    }
}

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuffer sb;
    static MyList<Integer> lst;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        Integer[] insertNumArr;
        int T, M, x, y;

        T = 10;
        for (int i = 1; i <= T; i++) {
            lst = new MyList<>();
            br.readLine();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                lst.append(Integer.parseInt(st.nextToken()));
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                switch (st.nextToken()) {
                    case "I" :
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        insertNumArr = new Integer[y];
                        for (int k = 0; k < y; k++)
                            insertNumArr[k] = Integer.parseInt(st.nextToken());
                        lst.insert(x, y, insertNumArr);
                        break;

                    case "D" :
                        lst.delete(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                        break;

                    case "A" :
                        y = Integer.parseInt(st.nextToken());
                        for (int k = 0; k < y; k++)
                            lst.append(Integer.parseInt(st.nextToken()));
                        break;
                }
            }
            sb.append("#" + i + " " + lst.getList10() + "\n");
        }
        System.out.print(sb.toString());
    }
}
