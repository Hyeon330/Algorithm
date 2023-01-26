package samsungDX.no12;

class Node {
    char[] name;
    Node[] subD = new Node[30];

    Node(char[] name) {
        this.name = name;
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
//	int mstrlen(char[] a) {
//		int len = 0;
//
//		while (a[len] != '\0')
//			len++;
//
//		return len;
//	}
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
        result = new char[cnt][6];
        pi = -1;
        while (path[++pi] != '\0') {
            if (path[pi] == '/') {
                pi++;
                ri++;
                result[ri][rii] = '\0';
                rii = 0;
            }
            result[ri][rii++] = path[pi];
        }
        return result;
    }

    Node root;
    void init(int n) {
        root = new Node("/\0".toCharArray());
    }

    void cmd_mkdir(char[] path, char[] name) {
        char[][] pathSp;
        Node n = root;

        if ((pathSp = split(path)) != null) {
            for (int i = 0; i < pathSp.length; i++) {
                for (int j = 0; j < 30; j++) {
                    if (mstrcmp(n.subD[j].name, pathSp[i]) == 0) {
                        n = n.subD[j];
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < 30; i++) {
            if (n.subD[i] == null)
                n.subD[i] = new Node(name);
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
                    if (mstrcmp(n.subD[j].name, pathSp[i]) == 0)
                        n = n.subD[j];
                }
            } else {
                for (int j = 0; j < 30; j++) {
                    if (mstrcmp(n.subD[j].name, pathSp[i]) == 0) {
                        n.subD[j] = null;
                        break;
                    }
                }
            }
        }
    }

    void cmd_cp(char[] srcPath, char[] dstPath) {
        Node newNode;
    }

    void cmd_mv(char[] srcPath, char[] dstPath) {

    }

    int cmd_find(char[] path) {

        return 0;
    }
}
