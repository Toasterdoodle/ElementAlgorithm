import java.io.*;
import java.util.*;

public class Backpack {

    private ArrayList<Element> elementList = new ArrayList<>();

    private boolean[] containsElement;

    private int totValue, totWeight, score;

    private int maxWeight = 1000;

    //constructor
    public Backpack(){

        loadElements();

//        for (Element e: elementList) {
//
//            System.out.println(e.toString());
//
//        }

        containsElement = new boolean[elementList.size()];

        //initializes backpack to be empty
        for (int i = 0; i < containsElement.length; i++) {

            containsElement[i] = false;

        }

        initializeBackpack();

        calcValue();

        calcWeight();

        calcScore();

    }

    //methods

    //loads elements into array list
    public void loadElements(){

        try (BufferedReader br = new BufferedReader(new FileReader("Elements.txt"))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {

                String[] arr = sCurrentLine.split(" ");

                elementList.add(new Element(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));

            }

        }
        catch(IOException e){

            e.printStackTrace();

        }

    }

    public void initializeBackpack(){

        int rand;

        for (int i = 0; i < containsElement.length; i++) {

            rand = (int)(Math.random() * 100);

            if(rand == 1){

                containsElement[i] = true;

            }
            else{

            }

        }

    }

    public void soutStuff(){

        for (int i = 0; i < containsElement.length; i++) {

            System.out.println(elementList.get(i).getName() + ": " + containsElement[i]);

        }

        System.out.println("Total Value: " + totValue);

        System.out.println("Total Weight: " + totWeight);

        System.out.println("Total Score: " + score);

    }

    public void calcValue(){

        totValue = 0;

        for (int i = 0; i < elementList.size(); i++) {

            if(containsElement[i]){

                totValue += elementList.get(i).getValue();

            }

        }

    }

    public void calcWeight(){

        totWeight = 0;

        for (int i = 0; i < elementList.size(); i++) {

            if(containsElement[i]){

                totWeight += elementList.get(i).getWeight();

            }

        }

    }

    public void calcScore(){

        score = totValue;

        if(totWeight > maxWeight){

            score -= (totWeight - maxWeight) * 50;

        }

    }

    public int getTotValue() {
        return totValue;
    }

    public void setTotValue(int totValue) {
        this.totValue = totValue;
    }

    public int getTotWeight() {
        return totWeight;
    }

    public void setTotWeight(int totWeight) {
        this.totWeight = totWeight;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean[] getContainsElement() {
        return containsElement;
    }

    public void setContainsElement(boolean[] containsElement) {
        this.containsElement = containsElement;
    }

    //changes the index of the booleanArray to be the opposite of what it is now
    public void changeBackpackElement(int index){

        int rand;

        rand = (int)(Math.random() * 2);

        if(containsElement[index]) {

            if(rand < 1) {

                containsElement[index] = false;

            }

        }
        else{

            containsElement[index] = true;

        }

    }

}
