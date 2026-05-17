class GrandLine {

    Island head;

    public void addIsland(String name) {
        Island newIsland = new Island(name);

        if (head == null) {
            head = newIsland;
        } else {
            Island current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newIsland;
        }
    }

    public void showIslands() {
        Island current = head;

        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }
}