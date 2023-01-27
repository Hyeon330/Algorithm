package samsungDX.no12.s1;

class Node {
    char[] name;
    Node[] subD = new Node[30];

    Node(char[] name) {
        this.name = name;
    }
}

class Q<T> {
    private class N {
        T data;
        N next;

        N(T data) {
            this.data = data;
            next = null;
        }
    }

    private N head;
    private N tail;
    private int size;

    Q() {
        head = new N(null);
        tail = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean offer(T data) {
        if (data == null)
            return false;
        N newNode = new N(data);
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
        return tmp.data;
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
	int mstrlen(char[] a) {
		int len = 0;

		while (a[len] != '\0')
			len++;

		return len;
	}
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
//
//    char[] mstrdup(char[] a) {
//        int aLen = mstrlen(a);
//        char[] c = new char[aLen];
//
//        for (int i = 0; i < aLen; i++)
//            c[i] = a[i];
//        return c;
//    }

    char[][] split(char[] path) {
        char[][] result;
        int cnt, pi, ri, rii;

        pi = ri = -1;
        cnt = rii = 0;
        while (path[++pi] != '\0') {
            if (path[pi] == '/')
                cnt++;
        }
        if (--cnt < 1)
            return null;
        result = new char[cnt][7];
        pi = -1;
        while (path[++pi] != '\0') {
            if (path[pi] == '/') {
                ri++;
                rii = 0;
            } else {
                result[ri][rii++] = path[pi];
                result[ri][rii] = '\0';
            }
        }
        return result;
    }

    private Node pathLastNode(char[] path) {
        char[][] pathSp;
        Node n = root;

        if ((pathSp = split(path)) != null) {
            for (int i = 0; i < pathSp.length; i++) {
                for (int j = 0; j < 30; j++) {
                    if (n.subD[j] != null && mstrcmp(n.subD[j].name, pathSp[i]) == 0) {
                        n = n.subD[j];
                        break;
                    }
                }
            }
            if (n == root)
                return null;
        }
        return n;
    }

    Node root;
    Node[] allD;
    void init(int n) {
        root = new Node("/\0".toCharArray());
        allD = new Node[n];
    }

    void cmd_mkdir(char[] path, char[] name) {
        Node n = pathLastNode(path);

        for (int i = 0; i < 30; i++) {
            if (n.subD[i] == null) {
                n.subD[i] = new Node(name);
                break;
            }
        }
    }

    void cmd_rm(char[] path) {
        Node n = root;
        char[][] pathSp;

        if ((pathSp = split(path)) == null)
            return ;
        for (int i = 0; i < pathSp.length; i++) {
            if (i < pathSp.length - 1) {
                for (int j = 0; j < 30; j++) {
                    if (n.subD[j] != null && mstrcmp(n.subD[j].name, pathSp[i]) == 0)
                        n = n.subD[j];
                }
            } else {
                for (int j = 0; j < 30; j++) {
                    if (n.subD[j] != null && mstrcmp(n.subD[j].name, pathSp[i]) == 0) {
                        n.subD[j] = null;
                        break;
                    }
                }
            }
        }
    }

    private char[] newPath(char[] a, char[] b) {
        int aLen = mstrlen(a);
        int bLen = mstrlen(b);
        int pLen = aLen + bLen + 2;
        int i = 0;
        char[] path = new char[pLen];

        path[pLen - 1] = '\0';
        path[pLen - 2] = '/';
        for (int j = 0; j < aLen; j++)
            path[i++] = a[j];
        for (int j = 0; j < bLen; j++)
            path[i++] = b[j];
        return path;
    }

    private void cpDfs(char[] path, Node n) {
        char[] nextPath;

        cmd_mkdir(path, n.name);
        nextPath = newPath(path, n.name);
        for (int i = 0; i < 30; i++) {
            if (n.subD[i] != null)
                cpDfs(nextPath, n.subD[i]);
        }
    }

    void cmd_cp(char[] srcPath, char[] dstPath) {
        cpDfs(dstPath, pathLastNode(srcPath));
    }

    void cmd_mv(char[] srcPath, char[] dstPath) {
        char[][] srcPathSp;
        Node srcNode, srcPrevNode;
        Node dstNode = pathLastNode(dstPath);

        srcNode = root;
        srcPrevNode = null;
        if ((srcPathSp = split(srcPath)) != null) {
            for (int i = 0; i < srcPathSp.length; i++) {
                srcPrevNode = srcNode;
                for (int j = 0; j < 30; j++) {
                    if (srcNode.subD[j] != null && mstrcmp(srcNode.subD[j].name, srcPathSp[i]) == 0) {
                        srcNode = srcNode.subD[j];
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < 30; i++) {
            if (dstNode.subD[i] == null) {
                dstNode.subD[i] = srcNode;
                break;
            }
        }
        if (srcPrevNode != null) {
            for (int i = 0; i < 30; i++) {
                if (srcPrevNode.subD[i] != null && mstrcmp(srcPrevNode.subD[i].name, srcPathSp[srcPathSp.length - 1]) == 0) {
                    srcPrevNode.subD[i] = null;
                    break;
                }
            }
        }
    }

    int cmd_find(char[] path) {
        Q<Node> queue = new Q<>();
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
// 10 / 7