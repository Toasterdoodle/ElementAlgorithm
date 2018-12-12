public class Element {

    //instance fields
    private int weight, value;
    private String name;

    //constructor
    public Element(String name, int weight, int value) {

        this.weight = weight;

        this.value = value;

        this.name = name;

    }

    //methods
    public String toString(){
        return name + ", weight: " + weight + " value: " + value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}