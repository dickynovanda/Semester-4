class Schedule {
    private static int counter = 1;

    int scheduleId;
    String trainName;
    String origin;
    String destination;

    public Schedule(String trainName, String origin, String destination) {
        this.scheduleId = counter++;
        this.trainName = trainName;
        this.origin = origin;
        this.destination = destination;
    }

    public void display() {
        System.out.println(scheduleId + " | " + trainName + " | " + origin + " -> " + destination);
    }
}