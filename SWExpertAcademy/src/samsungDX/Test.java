package samsungDX;

<<<<<<< HEAD
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class SinglyList {
    static final int MAX_NODE = 1000;

    Node[] nodePool = new Node[MAX_NODE];
    Node head;
    int nodeCount = 0;

    SinglyList() {
        head = new Node(0);
        init();
    }

    private Node newNode(int data) {
        nodePool[nodeCount] = new Node(data);
        return nodePool[nodeCount++];
    }

    void init() {
        head.next = null;
        nodeCount = 0;
    }

    void insert(int x) {
        Node node = newNode(x);

        node.next = head.next;
        head.next = node;
    }

    void remove(int x) {
        Node prev = head;
        while (prev.next != null && prev.next.data != x) prev = prev.next;
        if (prev.next != null) prev.next = prev.next.next;
    }

    boolean contains(int x) {
        Node n = head.next;
        while (n != null && n.data != x) n = n.next;
        return n != null;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node n = head.next;

        sb.append("[List]");
        while (n != null) {
            sb.append(n.data);
            if (n.next != null) sb.append(" -> ");
            n = n.next;
        }
        return sb.toString();
    }
}

public class Test {
    public static void main(String[] args) {

=======
import java.util.PriorityQueue;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        char[] name = "aa ".toCharArray();
        name[2] = 0;
        int a = 0;
        for (int i = 0; name[i] != 0; i++) {
            a = a << 5 | (name[i] ^ 96);
        }
        System.out.println(a);
>>>>>>> 3362433cf1c3b7aade13f7883d1ae078545e4e62
    }
}