package samsungDX.no12.s2;

class Node {
    int idx;
    char[] name;
    Node prev;
    Node[] subD = new Node[30];

    Node(int idx, char[] name, Node prev) {
        this.idx = idx;
        this.name = name;
        this.prev = prev;
    }
}

class N<T> {
    T data;
    T prev;
    N next;

    N(T data) {
        this.data = data;
        prev = null;
        next = null;
    }
    N(T data, T prev) {
        this.data = data;
        this.prev = prev;
        next = null;
    }
}
class DeQ<T> {
    private N<T> head;
    private N<T> tail;
    private int size;

    DeQ() {
        head = new N<>(null, null);
        tail = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean offer(T data) {
        if (data == null)
            return false;
        N<T> newNode = new N<>(data);
        if (head.next == null)
            head.next = newNode;
        if (tail != null)
            tail.next = newNode;
        tail = newNode;
        size++;
        return true;
    }

    T poll() {
        N tmp = head.next;

        if (tmp == null)
            return null;
        head.next = tmp.next;
        size--;
        return (T) tmp.data;
    }

    boolean push(T data, T prev) {
        if (data == null)
            return false;
        N<T> newNode = new N<>(data, prev);
        newNode.next = head.next;
        head.next = newNode;
        if (tail == null)
            tail = newNode;
        size++;
        return true;
    }

    N pop() {
        N tmp = head.next;

        if (tmp == null)
            return null;
        head.next = tmp.next;
        size--;
        return tmp;
    }

    boolean empty() {
        if (head.next == null)
            return true;
        return false;
    }
}

class UserSolution {

    private final static int NAME_MAXLEN	= 6;
    private final static int PATH_MAXLEN	= 1999;

    //	 The below commented methods are for your reference. If you want
//	 to use it, uncomment these methods.
//
    int mstrcmp(char[] a, char[] b) {
        int i;
        for (i = 0; a[i] != '\0'; i++) {
            if (a[i] != b[i])
                return a[i] - b[i];
        }
        return a[i] - b[i];
    }
    //
//	int mstrncmp(char[] a, char[] b, int len) {
//		for (int i = 0; i < len; i++) {
//			if (a[i] != b[i])
//				return a[i] - b[i];
//		}
//		return 0;
//	}
//
//    int mstrlen(char[] a) {
//        int len = 0;
//
//        while (a[len] != '\0')
//            len++;
//
//        return len;
//    }
//
//	void mstrcpy(char[] dest, char[] src) {
//		int i = 0;
//		while (src[i] != '\0') {
//			dest[i] = src[i];
//			i++;
//		}
//		dest[i] = src[i];
//	}
//
//	void mstrncpy(char[] dest, char[] src, int len) {
//		for (int i = 0; i < len; i++) {
//			dest[i] = src[i];
//		}
//		dest[len] = '\0';
//	}

    private Node pathLastNode(char[] path) {
        Node n = root;
        char[] tmp = new char[NAME_MAXLEN + 1];
        int ti = 0;

        for (int i = 1; path[i] != '\0'; i++) {
            if (path[i] == '/') {
                for (int j = 0; j < 30; j++) {
                    if (n.subD[j] != null && mstrcmp(tmp, n.subD[j].name) == 0)
                        n = n.subD[j];
                }
                tmp = new char[NAME_MAXLEN + 1];
                ti = 0;
            } else {
                tmp[ti++] = path[i];
                tmp[ti] = '\0';
            }
        }
        return n;
    }

    Node root;
    void init(int n) {
        root = new Node(0, "/\0".toCharArray(), null);
    }

    private int appNode(Node n, char[] name) {
        int i = -1;

        while (++i < 30) {
            if (n.subD[i] == null) {
                n.subD[i] = new Node(i, name, n);
                break;
            }
        }
        return i;
    }

    void cmd_mkdir(char[] path, char[] name) {
        appNode(pathLastNode(path), name);
    }

    void cmd_rm(char[] path) {
        Node n = pathLastNode(path);
        n.prev.subD[n.idx] = null;
    }

    void cmd_cp(char[] srcPath, char[] dstPath) {
        DeQ<Node> stack = new DeQ<>();
        N n;
        int appNum;

        stack.push(pathLastNode(srcPath), pathLastNode(dstPath));
        while (!stack.empty()) {
            n = stack.pop();
            appNum = appNode((Node) n.prev, ((Node) n.data).name);
            for (int i = 0; i < 30; i++) {
                if (((Node) n.data).subD[i] != null)
                    stack.push(((Node) n.data).subD[i], ((Node) n.prev).subD[appNum]);
            }
        }
    }

    void cmd_mv(char[] srcPath, char[] dstPath) {
        Node dstNode = pathLastNode(dstPath);
        Node srcNode = pathLastNode(srcPath);

        for (int i = 0; i < 30; i++) {
            if (dstNode.subD[i] == null) {
                dstNode.subD[i] = srcNode;
                srcNode.prev.subD[srcNode.idx] = null;
                srcNode.prev = dstNode;
                srcNode.idx = i;
                break;
            }
        }
    }

    int cmd_find(char[] path) {
        DeQ<Node> queue = new DeQ<>();
        Node n;
        int cnt = 0;

        queue.offer(pathLastNode(path));
        while (!queue.empty()) {
            n = queue.poll();
            cnt++;
            for (int i = 0; i < 30; i++) {
                if (n.subD[i] != null)
                    queue.offer(n.subD[i]);
            }
        }
        return cnt - 1;
    }
}