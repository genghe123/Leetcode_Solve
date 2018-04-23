package Exercise;

// Implement of Tree using binary heap
public class TreeList<Key extends Comparable<Key>> {
    private Key[] heap;
    private int N;

    public TreeList(int initialCapacity) {
        if (initialCapacity <= 0) throw new IllegalArgumentException();
        heap = (Key[]) new Comparable[initialCapacity + 1];
        N = 0;
    }

    public void insert(Key key) {
        int i = 1;
        while (heap[i] != null) {
            int cmp = key.compareTo(heap[i]);
            if (cmp < 0) i = left(i);
            else if (cmp > 0) i = right(i);
            else break;

            if (!positionCheck(i)) {
                resize(i);
            }
        }
        heap[i] = key;
        N++;
    }

    public Key get(int i) {
        return positionCheck(i) ? heap[i] : null;
    }

    public void set(int i, Key key) {
        if (!positionCheck(i)) return;
        heap[i] = key;
    }

    public int left(int i) {
        return !positionCheck(i) ? -1 : (positionCheck(2 * i) ? 2 * i : -1);
    }

    public int right(int i) {
        return !positionCheck(i) ? -1 : (positionCheck(2 * i + 1) ? 2 * i + 1 : -1);
    }

    public int parent(int i) {
        return !positionCheck(i) ? -1 : i / 2;
    }

    public int commonAncestor(int i, int j) {
        if (positionCheck(i) && positionCheck(j)) {
            int a = i, b = j;
            while (a != b) {
                a = parent(a) == 0 ? j : parent(a);
                b = parent(b) == 0 ? i : parent(b);
            }
            return a;
        }
        return -1;
    }

    private void resize(int capacity) {
        Key[] temp = (Key[]) new Comparable[capacity];
        System.arraycopy(heap, 1, temp, 1, heap.length - 1);
        heap = temp;
    }

    private boolean positionCheck(int i) {
        return i > 0 && i < heap.length;
    }
}
