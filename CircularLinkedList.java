class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularList {
    Node head = null;
    Node tail = null;
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        }
        else {
            tail.next=newNode;
            tail = newNode;
            tail.next=head;
            return;
        }

    }
    void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        }
    }
    public void deleteAtValue(int value) {
        if (head == null) return;

        Node Nodeptr = head;

        if (head.next == head && head.data == value) {
            head = null;
            tail = null;
            return;
        }
        if (head.data == value) {
            tail.next = head.next;
            head = head.next;
            return;
        }
        while (Nodeptr.next != head && Nodeptr.next.data != value) {
            Nodeptr = Nodeptr.next;
        }
        if (Nodeptr.next.data == value) {
            if (Nodeptr.next == tail) {
                tail = Nodeptr;
            }

            Nodeptr.next = Nodeptr.next.next;
        } else {
            System.out.println("Value list me nahi mili!");
        }
    } public void insertAtAllPositions(int data){
        Node Nodeptr = head;
        Node newNode = new Node(data);
        if (tail == null) {
            insertAtEnd(data);
            return;
        }
        if(head.next == head){
            if (data < head.data) {
                insertAtStart(data);
            } else {
                insertAtEnd(data);
            }
            return;
        }
        while(Nodeptr.next != head && Nodeptr.next.data < data){
            Nodeptr = Nodeptr.next;
        }

        newNode.next = Nodeptr.next;
        Nodeptr.next = newNode;
        if (newNode.next == head && newNode.data > tail.data) {
            tail = newNode;
        }
    } void display() {
        if (head == null) {
            System.out.println("Circular List khali hai!");
            return;
        }
        Node cur = head;
        System.out.print("Circular List: ");
        do {
            System.out.print(cur.data + " ");
            cur = cur.next;
        } while (cur != head);

        System.out.println();
    }
    public static void main(String[] args) {
        CircularList cl = new CircularList();

        cl.insertAtStart(30);
        cl.insertAtStart(20);
        cl.insertAtStart(10);
        cl.insertAtEnd(40);
        cl.insertAtAllPositions(31);
        cl.insertAtAllPositions(41);
        cl.insertAtAllPositions(12);
        cl.deleteAtValue(12);
        cl.deleteAtValue(10);
        cl.display();

    }}
