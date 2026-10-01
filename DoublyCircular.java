class Node {
    int data;
    Node next, previous;
    Node(int d) {
        data = d;
        next = previous = null;
    }
}
public class DoublyCircular {
    Node head = null;
    Node tail = null;
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            head.next = head;
            head.previous = head;
            return;
        }
        if (data <= head.data) {
            newNode.next = head;
            newNode.previous = tail;
            tail.next = newNode;
            head.previous = newNode;
            head = newNode;
            return;
        }
        if (data >= tail.data) {
            tail.next = newNode;
            newNode.previous = tail;
            newNode.next = head;
            head.previous = newNode;
            tail = newNode;
            return;
        }

        Node nodeptr = head.next;
        while (nodeptr != head && nodeptr.data < data) {
            nodeptr = nodeptr.next;
        }
        newNode.previous = nodeptr.previous;
        newNode.next = nodeptr;
        nodeptr.previous.next = newNode;
        nodeptr.previous = newNode;
    }

    public void delete(int data) {
        if (head == null){
            System.out.println("list is empty");
            return;}
        if (head == tail && head.data == data) {
            head = tail = null;
            return;
        }

        if (head.data == data) {
            tail.next = head.next;
            head.next.previous = tail;
            head = head.next;
            return;
        }

        Node nodeptr = head.next;
        while (nodeptr != head) {
            if (nodeptr.data == data) {
                if (nodeptr == tail) {
                    tail = tail.previous;
                }
                nodeptr.previous.next = nodeptr.next;
                nodeptr.next.previous = nodeptr.previous;
                return;
            }
            nodeptr = nodeptr.next;
        }
        System.out.println("Value list mein nahi mili!");}
    public void print() {
        if (head == null) {
            System.out.println("empty");
            return;
        }

        Node Nodeptr = head;
        do {
            System.out.println(Nodeptr.data);
            Nodeptr = Nodeptr.next;
        } while (Nodeptr != head);
    }
    static void main() {
        DoublyCircular obj = new DoublyCircular();
        obj.add(5);
        obj.add(2);
        obj.add(3);
        obj.add(1);
        obj.print();
        obj.delete(1);
        System.out.println("after delete 1");
        obj.print();
    }

}