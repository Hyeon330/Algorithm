package samsungDX.no19;

class Node {
    int x, y;
    boolean chk;
    Q<Node> adjacent = new Q<>();;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
        chk = true;
    }
}

class Q<T> {
    class N<T> {
        T data;
        N next;
        N prev;

        N(T data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    private int size;
    private N head;
    private N tail;

    Q() {
        head = new N(null);
        tail = null;
        size = 0;
    }

    void offer(T data) {
        N n = new N(data);
        if (tail != null) {
            tail.next = n;
            n.prev = tail;
        } else {
            head.next = n;
            n.prev = head;
        }
        tail = n;
        size++;
    }

    T poll() {
        N tmp = head.next;
        if (tmp != null)
            head.next = tmp.next;
        else
            head.next = null;
        if (head.next != null)
            head.next.prev = head;
        else
            tail = null;
        size--;
        return (T) tmp.data;
    }

    boolean empty() {
        if (head.next == null)
            return true;
        return false;
    }

    int size() {
        return size;
    }

    T get(int index) {
        N n = head.next;

        for (int i = 0; i < index && n != null; i++)
            n = n.next;
        return (T) n.data;
    }
}

class UserSolution {
    static int[] ud = {-1, 0, 1, 0};
    static int[] lr = {0, 1, 0, -1};
    static Node[][] mapNode;

    void bfs_init(int map_size, int map[][]) {
        mapNode = new Node[map_size][map_size];
        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                if (map[i][j] == 0)
                    mapNode[i][j] = new Node(j, i);
            }
        }
        edge(map_size);
    }

    int bfs(int x1, int y1, int x2, int y2) {
        Q<Node> queue = new Q();
        Node n, tmp;
        int cnt = 0, qSize;

        queue.offer(mapNode[y1 - 1][x1 - 1]);
        while (!queue.empty()) {
            qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                n = queue.poll();
                n.chk = false;
                if (n.x == x2 - 1 && n.y == y2 - 1) {
                    reset_true(x1, y1);
                    return cnt;
                }
                for (int j = 0; j < n.adjacent.size(); j++) {
                    tmp = n.adjacent.get(j);
                    if (tmp.chk)
                        queue.offer(tmp);
                }
            }
            cnt++;
        }
        reset_true(x1, y1);
        return -1;
    }

    void reset_true(int x, int y) {
        Q<Node> queue = new Q();
        Node n, tmp;

        queue.offer(mapNode[y - 1][x - 1]);
        while (!queue.empty()) {
            n = queue.poll();
            n.chk = true;
            for (int j = 0; j < n.adjacent.size(); j++) {
                tmp = n.adjacent.get(j);
                if (!tmp.chk)
                    queue.offer(tmp);
            }
        }
    }

    void edge(int map_size) {
        int tmpX, tmpY;

        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                if (mapNode[i][j] != null) {
                    for (int k = 0; k < 4; k++) {
                        tmpX = i + ud[k];
                        tmpY = j + lr[k];
                        if (tmpX >= 0 && tmpX < map_size &&
                            tmpY >= 0 && tmpY < map_size &&
                            mapNode[tmpX][tmpY] != null)
                            mapNode[i][j].adjacent.offer(mapNode[tmpX][tmpY]);
                    }
                }
            }
        }
    }
}