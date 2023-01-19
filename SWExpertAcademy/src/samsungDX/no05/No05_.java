package samsungDX.no05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MyList<T> {
    private class Node {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    MyList() {
        head = null;
        tail = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean add(T data) {
        Node newNode = new Node(data, null);
        if (newNode == null)
            return false;
        if (head == null)
            head = newNode;
        if (tail != null)
            tail.next = newNode;
        tail = newNode;
        size++;
        return true;
    }

    boolean add(int index, T data) {
        if (index > size())
            return false;
        if (index == size())
            return add(data);
        Node tmp = this.head;
        Node prev = null;
        for (int i = 0; i < index; i++) {
            prev = tmp;
            tmp = tmp.next;
        }
        Node newNode = new Node(data, tmp);
        if (newNode == null)
            return false;
        if (prev == null)
            this.head = newNode;
        else
            prev.next = newNode;
        size++;
        return true;
    }

    boolean remove(int index) {
        if (index >= size())
            return false;
        Node tmp = this.head;
        Node prev = null;
        for (int i = 0; i < index; i++) {
            prev = tmp;
            tmp = tmp.next;
        }
        if (prev == null)
            this.head = tmp.next;
        else
            prev.next = tmp.next;
        size--;
        return true;
    }

    T set(int index, T data) {
        if (index >= size())
            return null;
        Node tmp = this.head;
        Node prev = null;
        for (int i = 0; i < index; i++) {
            prev = tmp;
            tmp = tmp.next;
        }
        Node newNode = new Node(data, tmp.next);
        if (prev == null)
            this.head = newNode;
        else
            prev.next = newNode;
        return tmp.data;
    }

    T get(int index) {
        if (index >= size())
            return null;
        Node tmp = this.head;
        for (int i = 0; i < index; i++)
            tmp = tmp.next;
        return tmp.data;
    }
}

public class No05_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        MyList<Integer> lst;
        String cmd;
        int T, M, L;

        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            M = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            lst = new MyList<>();
            while (st.hasMoreTokens())
                lst.add(Integer.parseInt(st.nextToken()));
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                cmd = st.nextToken();
                if (cmd.equals("I"))
                    lst.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                if (cmd.equals("D"))
                    lst.remove(Integer.parseInt(st.nextToken()));
                if (cmd.equals("C"))
                    lst.set(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            if (lst.size() > L)
                sb.append("#" + i + " " + lst.get(L) + "\n");
            else
                sb.append("#" + i + " " + -1 + "\n");
        }
        System.out.print(sb);
    }
}
