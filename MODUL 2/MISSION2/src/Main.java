public class Main {

    public static void main(String[] args) {

        GrandLine grandLine = new GrandLine();

        grandLine.addIsland("Loguetown");
        grandLine.addIsland("Reverse Mountain");
        grandLine.addIsland("Whiskey Peak");
        grandLine.addIsland("Little Garden");
        grandLine.addIsland("Alabasta");

        System.out.println("Daftar Island di Grand Line:");

        grandLine.showIslands();
    }
}