import java.util.ArrayList;

public class OldMacDonaldsFarm {
    private String farmerName;
    private ArrayList<Animal> farmAnimals;

    public OldMacDonaldsFarm() {
        farmerName = "Old MacDonald";
        farmAnimals = new ArrayList<Animal>();
    }

    public void singVerse(){
        String commonName = (farmAnimals.get(farmAnimals.size()-1).getCommonName());
        System.out.println("Old MacDonald had a farm, E-I-E-I-O and on his farm he had some "+ commonName + "s, E-I-E-I-O.");
        for (int i = farmAnimals.size()-1; i >= 0; i--)
        {
            System.out.print("With a ");
            farmAnimals.get(i).speak();
            System.out.print("-");
            farmAnimals.get(i).speak();
            System.out.print(" here, and a ");
            farmAnimals.get(i).speak();
            System.out.print("-");
            farmAnimals.get(i).speak();
            System.out.println(" there,");
            System.out.print("Here a ");
            farmAnimals.get(i).speak();
            System.out.print(", there a ");
            farmAnimals.get(i).speak();
            System.out.print(", every where a ");
            farmAnimals.get(i).speak();
            System.out.print("-");
            farmAnimals.get(i).speak();
            System.out.println(", ");
            System.out.print("Old MacDonald had a farm, E-I-E-I-O.");
        }
        System.out.print("\n");
        System.out.print("\n");
    }

    public static void main(String[] args) {
        OldMacDonaldsFarm singer = new OldMacDonaldsFarm();
        singer.farmAnimals.add(new Chicken());
        singer.singVerse();
        singer.farmAnimals.add(new Chick());
        singer.singVerse();
        singer.farmAnimals.add(new Rooster());
        singer.singVerse();
        singer.farmAnimals.add(new Pig());
        singer.singVerse();
    }
    /*
    Old MacDonald had a farm, E-I-E-I-O and on his farm he had some chickens, E-I-E-I-O.
    With a bawk-bawk here, and a bawk-bawk there,
    Here a bawk, there a bawk, every where a bawk-bawk,
    Old MacDonald had a farm, E-I-E-I-O.
     */
}

