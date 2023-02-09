package samsungDX.no12;
// 모듈화와 비트마스킹의 중요성...
import java.util.LinkedList;
import java.util.List;

class Node {
    int name, count;
    Node parent;
    List<Node> children = new LinkedList<>();

    Node(int name, Node parent) {
        this.name = name;
        this.parent = parent;
        count = 0;
    }
}

class UserSolution {
    Node root;

    // char[] name을 각 글자당 5bit씩 이어 붙어서 정수형태로 바꿔주는 함수
    int traceName(char[] name) {
        return traceName(name, 0, name.length - 1);
    }
    int traceName(char[] name, int s, int e) {
        int ret = 0;

        for (int i = s; i < e; i++)
            ret = ret << 5 | (name[i] ^ 96);
        return ret;
    }

    // 경로의 최하위 디렉토리 노드를 반환하는 함수
    Node getDir(char[] path) {
        Node p = root;
        int pathName, s = 1;

        for (int i = 1; i < path.length - 1; i++) {
            if (path[i] == '/') {
                pathName = traceName(path, s, i++);
                for (Node c : p.children) {
                    if (c.name == pathName) {
                        p = c;
                        break;
                    }
                }
                s = i;
            }
        }
        return p;
    }

    // 디렉토리가 생성되거나 삭제되면 상위 조상노드들의 count를 업데이트 해주는 함수
    void updateCnt(Node n, int cnt) {
        while (n != null) {
            n.count += cnt;
            n = n.parent;
        }
    }

    void init(int n) {
        char[] r = "/ ".toCharArray();
        r[1] = 0;
        root = new Node(traceName(r),null);
    }

    void cmd_mkdir(char[] path, char[] name) {
        Node node = getDir(path);
        node.children.add(new Node(traceName(name), node));
        updateCnt(node, 1);
    }

    void cmd_rm(char[] path) {
        Node p, c = getDir(path);
        p = c.parent;
        p.children.remove(c);
        updateCnt(p, (c.count + 1) * -1);
    }

    Node oneCp(Node srcN, Node dstN) {
        Node newNode = new Node(srcN.name, dstN);
        newNode.count = srcN.count;
        dstN.children.add(newNode);
        return newNode;
    }

    void trav(Node srcN, Node dstN) {
        for (Node n : srcN.children)
            trav(n, oneCp(n, dstN));
    }

    void cmd_cp(char[] srcPath, char[] dstPath) {
        Node srcN, dstN;

        srcN = getDir(srcPath);
        dstN = getDir(dstPath);
        trav(srcN, oneCp(srcN, dstN));
        updateCnt(dstN, srcN.count + 1);
    }

    void cmd_mv(char[] srcPath, char[] dstPath) {
        Node srcN, dstN;

        srcN = getDir(srcPath);
        dstN = getDir(dstPath);
        srcN.parent.children.remove(srcN);
        updateCnt(srcN.parent, (srcN.count + 1) * -1);
        dstN.children.add(srcN);
        srcN.parent = dstN;
        updateCnt(dstN, srcN.count + 1);
    }

    int cmd_find(char[] path) {
        return getDir(path).count;
    }
}

/*
공통적으로 사용할 함수
- 함수 1. 루트에서 특정 노드까지 패스네임을 사용해서 찾아감
- 함수 2. 이름을 한글자당 5bit씩 압축하여 정수로 만드는 함수. 차일드 노드를 어떻게 빨리 찾을것이냐가 중요
  - 최대 글자 6개
    - 한 글자를 5비트로 표현 가능
    - 6글자는 30bit -> 32bit안에 저장 가능
- 함수 3. count 업데이트 함수

디렉토리 생성
- 생성할 디렉토리를 1번 함수를 사용해서 찾아감
- 그 디렉토리에 새로운 이름을 하나 추가하고 포인터를 추가해서 연결
- 만들어진 노드의 부모와 그 부모들 전부 count를 업데이트 시킴(3번 함수)

디렉토리 제거
- 생성할 디렉토리를 1번 함수를 사용해서 찾아감
- 부모노드에서 링크 제거
- 모든 조상 노드에서 count update

디렉토리 복사
- 소스와 타겟이 있기 때문에 1번 함수를 두번 해야 함
- 트래버스 알고리즘 사용하여 모든 노드 하나씩 복사
- target쪽 조상들 count update

디렉토리 이동
- 소스와 타겟이 있기 때문에 1번 함수를 두번 해야 함
- 노드를 끈어서 목적지에 붙여주면 됨
- source쪽 조상들 count update
- targete쪽 조상들 count update

디렉토리 개수 세기
- 노드의 count반환

선형 시간(Linear Time):	입력으로 받은 데이터의 양에 비해 별로 크지 않은 시간을 사용한다는 뜻
						입력으로 받은 데이터의 양에 비례하여 증가하는 시간

한 노드에서 자식 찾기
- 한 노드에 존재하는 노드의 개수가 최대 30개(30이 아닌 찾아야 하는 개수가 많을 경우 TRIE's같은 알고리즘을 사용)

 */