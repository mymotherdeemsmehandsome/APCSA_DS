public abstract class Animal implements Comparable<Animal>{
    private String latinName;
    private String commonName;

    public String getLatinName() {
        return latinName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public abstract void speak();

    public int compareTo(Animal animal){
        return (this.commonName).compareTo(animal.getCommonName());
    }
}
