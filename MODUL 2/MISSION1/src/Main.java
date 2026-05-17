import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //1. Deklarasi
        ArrayList<String> soecerers = new ArrayList<>();

        //2. Rekuitmen
        soecerers.add("Yuji Itadori");
        soecerers.add("Megumi Fushiguro");
        soecerers.add("Nobara Kugisaki");

        System.out.println("Initial list of sorcerers:" + soecerers);

        //3. Transfer Student
        soecerers.add(1,"Yuta Okkotsu");
        System.out.println("After transfer student:" + soecerers);

        //4. Identifikasi
        System.out.println("Sorcerer at index 2:" + soecerers.get(2));

        //5. Possesion
        soecerers.set(0,"Yuji Itadori (Possessed by Sukuna)");
        System.out.println("After possession:" + soecerers);

        //6. Casual
        soecerers.remove(3);
        System.out.println("After Shibuya Incident:" + soecerers);

        //7. Laporan
        System.out.println("Total number of sorcerers:" + soecerers.size());
        System.out.println("Is roster empty? " + false);

        //8. Total Wipeout
        soecerers.clear();
        System.out.println("Roster After Culling Game:" + soecerers);
    }
}