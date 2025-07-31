public class Chicken extends Animal{
    public Chicken(){
        this("Chicken");
    }
    public Chicken(String chickenType){
        super("Gallus Gallus domesticus",chickenType);
    }
    public void speak(){
        System.out.print("bawck");
    }
}
