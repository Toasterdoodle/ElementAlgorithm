import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BackpackList {

    //instance fields
    private Backpack[] backpacks = new Backpack[10];

    private int gen = 1;

    private int genLimit = 10000;

    private int mutationChance = 100;

    private int previousError = 0;

    private int improvement = 0;

    //constructor
    public BackpackList(){

        gen = 0;

        for (int i = 0; i < backpacks.length; i++) {

            backpacks[i] = new Backpack();

        }

        //backpacks[0].soutStuff();

//        sort();
//
//        killAndReplace();
//
//        soutBackpacks();

        cycleOfLife();

    }

    //methods
    public void soutBackpacks(){

        System.out.println("-----Generation: " + gen + "-----");

        for (int i = 0; i < backpacks.length; i++) {

            backpacks[i].calcWeight();
            backpacks[i].calcValue();
            backpacks[i].calcScore();

            System.out.println("Backpack " + (i + 1) + ":");
            System.out.println("Weight: " + backpacks[i].getTotWeight());
            System.out.println("Value: " + backpacks[i].getTotValue());
            System.out.println("Score: " + backpacks[i].getScore());
            System.out.println("-----");

        }

        System.out.println("-------------------------");

    }

    public void sort(){

        Backpack temp;

        for (int i = 0; i < backpacks.length; i++) {

            for (int j = i; j < backpacks.length; j++) {

                if(backpacks[i].getScore() > backpacks[j].getScore()){

                    temp = backpacks[i];

                    backpacks[i] = backpacks[j];

                    backpacks[j] = temp;

                }

            }

        }

    }

    public void killAndReplace(){
        //needs to save some shitty ones for the sake of mutation

        for (int i = 1; i < 5; i++) {

            backpacks[i].setContainsElement(backpacks[i + 5].getContainsElement());

            backpacks[i].calcWeight();
            backpacks[i].calcValue();
            backpacks[i].calcScore();

        }

    }

    public void mutate(){
        //need to remove more elements than it puts in

        int rand;

//        System.out.println(backpacks[1].getContainsElement().length);
//
//        System.out.println(backpacks.length);

        //cycles through all backpacks
        for (int i = 0; i < backpacks.length; i++) {

            //cycles through each element in the backpack array
            for (int j = 0; j < backpacks[i].getContainsElement().length; j++) {
                //first time it removes elements

                rand = (int)(Math.random() * 1000);

//                System.out.println(rand);

                if(rand < mutationChance){

                    backpacks[i].changeBackpackElement(j);

                }

            }

            backpacks[i].calcValue();
            backpacks[i].calcWeight();
            backpacks[i].calcScore();

        }

    }

    public void cycleOfLife(){

        for (int i = 0; i < genLimit; i++) {

            gen++;

            sort();

            killAndReplace();

            mutate();

            soutBackpacks();

        }

//        sort();
//
//        soutBackpacks();
//
//        //-----
//
//        killAndReplace();
//
//        soutBackpacks();
//
//        //-----
//
//        System.out.println("mutate");
//
//        mutate();
//
//        soutBackpacks();
//
//        //-----

//        sort();
//
//        soutBackpacks();
//
//        killAndReplace();
//
//        soutBackpacks();
//
//        mutate();
//
//        soutBackpacks();

    }


}
