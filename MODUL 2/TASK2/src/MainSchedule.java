public class MainSchedule {
    public static void main(String[] args) {
        ScheduleManager list = new ScheduleManager();

        // INSERTION
        list.addLast(new Schedule("Argo Bromo", "Jakarta", "Surabaya"));
        list.addLast(new Schedule("Taksaka", "Jakarta", "Yogyakarta"));
        list.addFirst(new Schedule("Gajayana", "Malang", "Jakarta"));

        // TRAVERSAL
        System.out.println("=== DATA JADWAL ===");
        list.displayAll();

        // SEARCH
        System.out.println("\n=== SEARCH  ===");
        list.search("Malang");

        // COUNT
        System.out.println("\nTotal Jadwal: " + list.count());

        // DELETE FIRST
        System.out.println("\n=== REMOVE FIRST ===");
        list.removeFirst();
        list.displayAll();

        // DELETE LAST
        System.out.println("\n=== REMOVE LAST ===");
        list.removeLast();
        list.displayAll();
    }
}