// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package pass;

import java.lang.System;

public interface test1 {

}

public interface test2 {

}

public interface organism extends test1, test2 {
    int x = 3;
}

public interface haveSoul {
    int y = 3;
}

abstract class Animal implements organism, haveSoul {

    protected String scientificName;

    protected Animal(String scientificName) {
        this.scientificName = scientificName;
    }

    public String scientificName() {
        return scientificName;
    }

}

class FruitFly extends Animal {

    public FruitFly() {
        super("Drosophila melanogaster");
    }

}

class Tiger extends Animal {

    public Tiger() {
        super("Panthera tigris corbetti");
    }

}

public class Animalia {

    public static void main(String[] args) {
        FruitFly fruitFly = new FruitFly();
        Tiger tiger = new Tiger();
        System.out.println(fruitFly.scientificName());
        System.out.println(tiger.scientificName());
    }

}
