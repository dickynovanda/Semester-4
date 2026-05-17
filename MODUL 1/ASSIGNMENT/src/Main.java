import java.util.Scanner;

// ENUM
enum TicketClass {
    ECONOMY,
    BUSINESS,
    EXECUTIVE
}

// GENERIC PASSENGER
class Passenger<T> {
    private T id;
    private String name;

    public Passenger(T id, String name) {
        this.id = id;
        this.name = name;
    }

    public T getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// GENERIC TICKET
class Ticket<T> {
    private T bookingCode;
    private Passenger<?> passenger;
    private TicketClass ticketClass;

    public Ticket(T bookingCode, Passenger<?> passenger, TicketClass ticketClass) {
        this.bookingCode = bookingCode;
        this.passenger = passenger;
        this.ticketClass = ticketClass;
    }

    public void display() {
        System.out.println("\n=== Railway Ticket Information ===");
        System.out.println("Booking Code   : " + bookingCode);
        System.out.println("Passenger Name : " + passenger.getName());
        System.out.println("Identity Number: " + passenger.getId());
        System.out.println("Identity Type  : " + passenger.getId().getClass().getSimpleName());
        System.out.println("Ticket Class   : " + ticketClass);
    }
}

// UTILS
class Utils {
    public static void showPassenger(Passenger<?> p) { //wildcard
        System.out.println("Passenger: " + p.getName() + " (" + p.getId() + ")");
    }
}

// MAIN
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // INPUT
        System.out.print("Masukkan Nama: ");
        String name = input.nextLine();

        System.out.print("Masukkan Identity Number: ");
        String idInput = input.nextLine();

        System.out.print("Masukkan Booking Code: ");
        String bookingCode = input.nextLine();

        // PILIH KELAS
        System.out.println("\nPilih Ticket Class:");
        System.out.println("1. ECONOMY");
        System.out.println("2. BUSINESS");
        System.out.println("3. EXECUTIVE");
        System.out.print("Pilihan: ");
        int pilihan = input.nextInt();

        TicketClass ticketClass;

        switch (pilihan) {
            case 1:
                ticketClass = TicketClass.ECONOMY;
                break;
            case 2:
                ticketClass = TicketClass.BUSINESS;
                break;
            case 3:
                ticketClass = TicketClass.EXECUTIVE;
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        // HITUNG DIGIT
        String digitsOnly = idInput.replaceFirst("^0+", ""); // hilangkan 0 depan
        int digitCount = digitsOnly.length();

        Passenger<?> passenger;

        try {
            if (digitCount <= 10) {
                Integer idInt = Integer.parseInt(idInput);
                passenger = new Passenger<Integer>(idInt, name);
            } else if (digitCount <= 19) {
                Long idLong = Long.parseLong(idInput);
                passenger = new Passenger<Long>(idLong, name);
            } else {
                System.out.println("Error: Identity Number terlalu besar (lebih dari 19 digit)");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Identity Number harus berupa angka!");
            return;
        }

        Ticket<String> ticket = new Ticket<>(bookingCode, passenger, ticketClass);


        Utils.showPassenger(passenger);
        ticket.display();

        input.close();
    }
}