public class MainPassenger {
    public static void main(String[] args) {
        PassengerManager manager = new PassengerManager();

        // Tambah data
        manager.addPassenger(new Passenger("Andi", "andi@mail.com", "08123", 20));
        manager.addPassenger(new Passenger("Budi", "budi@mail.com", "08234", 25));
        manager.addPassenger(new Passenger("Citra", "citra@mail.com", "08345", 22));

        // Tampilkan semua
        System.out.println("=== DATA PENUMPANG ===");
        manager.displayAll();

        // Search
        System.out.println("\n=== SEARCH 'Budi' ===");
        manager.searchByName("Andi");

        // Update
        System.out.println("\n=== UPDATE INDEX ===");
        manager.updatePassenger(2, "Citraland");
        manager.displayAll();

        // Hapus by ID
        System.out.println("\n=== REMOVE ID ===");
        manager.removePassengerById(1);
        manager.displayAll();
    }
}