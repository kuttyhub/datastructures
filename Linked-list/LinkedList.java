public class LinkedList {
    private Node head;
    private Node tail;

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        // list.deleteElement(40);
        list.insertAtFirst(30);
        list.print();

        // list.findKthElementFromLast(3);

        // list.deleteAtFirst();
        // list.print();
        // list.deleteAtLast();
        // list.print();

    }

    public void insert(int data) {
        if (head == null) {
            head = tail = new Node(data);
            return;
        }
        Node temp = new Node(data);
        tail.next = temp;
        tail = temp;
    }

    public void insertAtFirst(int data) {
        if (head == null) {
            head = tail = new Node(data);
            return;
        }
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    public void deleteAtFirst() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        // unlink the bond
        var second = head.next;
        head.next = null;
        head = second;
    }

    public void deleteElement(int data) {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }
        Node current = head;
        Node prev = head;
        while (current.data != data) {
            prev = current;
            current = current.next;
            System.out.println(prev.data + " " + current.data);
        }
        prev.next = current.next;
    }

    public void deleteAtLast() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        tail = current;
        tail.next = null;
    }

    public void findKthElementFromLast(int k) {
        if (head == null || k >= size())
            return;
        var kNode = head;
        var temp = head;
        while (k > 1) {
            temp = temp.next;
            k--;
        }
        while (temp.next != null) {
            kNode = kNode.next;
            temp = temp.next;
        }
        System.out.println(kNode.data);
    }

    public int size() {
        int size = 0;
        if (head == null) {
            return 0;
        }
        var current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print("\n");
    }
}
