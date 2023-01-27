package samsungDX;

public class Test {
    static char[][] split(char[] path) {
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
                ri++;
                rii = 0;
            } else {
                result[ri][rii++] = path[pi];
                result[ri][rii] = '\0';
            }
        }
        return result;
    }

    static char[] mstrndup(char[] a, int len) {
        char[] c = new char[len];

        for (int i = 0; i < len; i++)
            c[i] = a[i];
        return c;
    }
    public static void main(String[] args) {
        char[] str = "/aa/bb/cc/\0".toCharArray();
        char[][] strSp = split(str);

        for (int i = 0; i < strSp.length; i++) {
            System.out.println(strSp[i].length);
        }
    }
}
