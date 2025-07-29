import java.util.ArrayList;

public class OldMacDonaldsFarm {
    private String farmerName;
    private ArrayList<Animal> farmAnimals;

    public OldMacDonaldsFarm() {
        farmerName = "Old MacDonald";
        farmAnimals = new ArrayList<Animal>();
    }

    public static void main(String[] args) {


    OldMacDonaldsFarm singer = new OldMacDonaldsFarm();
        singer.farmAnimals.add(new Chicken());
        singer.singVerse();
        singer.farmAnimals.add(new Chick());
        singer.singVerse();
        singer.farmAnimals.add(new ooster());
        singer.singVerse();
        singer.farmAnimals.add(new Pig());
        singer.singVerse();
}
}



