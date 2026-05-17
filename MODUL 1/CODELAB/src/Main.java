class Ticket<T> {
    private T bookingCode; //Generic Class
    private String passengerName;
    private String type;

    public void setData(T bookingCode, String passengerName, String type) {
        this.bookingCode = bookingCode;
        this.passengerName = passengerName;
        this.type = type;
    }

    public void display() {
        System.out.println("=== Railway Ticket Information ===");
        System.out.println("Booking Code   : " + bookingCode);
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Booking Code Type : " + type);
    }
}
public class Main {
    public static void main(String[] args) {

        Ticket<String> t1 = new Ticket<>();
        t1.setData("KA-001", "Andi", "Economy");

        Ticket<String> t2 = new Ticket<>();
        t2.setData("KA-002", "Budi", "Business");

        Ticket<String> t3 = new Ticket<>();
        t3.setData("KA-003", "Citra", "Executive");

        t1.display();
        System.out.println();

        t2.display();
        System.out.println();

        t3.display();
    }
}