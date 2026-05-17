import java.util.ArrayList;

public class PassengerManager {
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public void addPassenger(Passenger p) {
        passengers.add(p);
    }

    public Passenger getPassenger(int index) {
        return passengers.get(index);
    }

    public void searchByName(String name) {
        for (Passenger p : passengers) {
            if (p.getName().equalsIgnoreCase(name)) {
                p.displayInfo();
            }
        }
    }

    public void updatePassenger(int index, String newName) {
        passengers.get(index).setName(newName);
    }

    public void removePassengerById(int id) {
        passengers.removeIf(p -> p.getPassengerId() == id);
    }

    public void displayAll() {
        for (Passenger p : passengers) {
            p.displayInfo();
        }
    }
}