public class ScheduleManager {

    // 🔹 Inner class Node
    class Node {
        Schedule data;
        Node next;

        Node(Schedule data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head, tail;

    // INSERTION - addFirst
    public void addFirst(Schedule data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // INSERTION - addLast
    public void addLast(Schedule data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // DELETION - removeFirst
    public void removeFirst() {
        if (head == null) {
            System.out.println("List kosong!");
            return;
        }

        head = head.next;

        if (head == null) {
            tail = null;
        }
    }

    // DELETION - removeLast
    public void removeLast() {
        if (head == null) {
            System.out.println("List kosong!");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;
    }

    // TRAVERSAL
    public void displayAll() {
        Node temp = head;

        if (temp == null) {
            System.out.println("Tidak ada jadwal.");
            return;
        }

        while (temp != null) {
            temp.data.display();
            temp = temp.next;
        }
    }

    // SEARCH
    public void search(String keyword) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.data.trainName.equalsIgnoreCase(keyword) ||
                    temp.data.origin.equalsIgnoreCase(keyword) ||
                    temp.data.destination.equalsIgnoreCase(keyword)) {

                temp.data.display();
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Data tidak ditemukan.");
        }
    }

    // COUNT
    public int count() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}