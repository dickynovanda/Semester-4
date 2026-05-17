public class Passenger {
    private static int counter = 1;

    private int passengerId;
    private String name, email, phone;
    private int age;

    public Passenger(String name, String email, String phone, int age) {
        this.passengerId = counter++;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println(passengerId + " - " + name + " - " + email + " - " + phone + " - " + age);
    }
}