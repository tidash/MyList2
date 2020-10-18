package com.company;

import java.util.Collection;
import java.util.Comparator;

public class Randomizer {
public static void randomInteger(Collection<Integer> collection, long quantity) {
    if(quantity > 0) {
        for(int num = 0;num < quantity;num++) {
            collection.add((int)(Math.random()*100));
        }
    }
}

public static void randomDouble(Collection<Double> collection, long quantity) {
    if(quantity > 0) {
        for(int num = 0;num < quantity;num++) {
            collection.add(Math.random()*100);
        }
    }
}

    public static void randomString(MyList<String> z, int i) {
    }

    public static void randomString(Collection<String> collection, long quantity, long length) {
    boolean check = true;
    int indexSymbol=0;
    String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
    String cell ="";
    String symbol;

    if (quantity > 0) {
        for(int num=0;num < quantity; num++) {
            for(int num1=0;num1<length;num1++) {
                while (check) {
                    indexSymbol = (int) (Math.random() * 100);
                    if ((indexSymbol >= 0) &&(indexSymbol < 36)) {
                        check = false;
                    }
                }
                cell=cell + alphabet.charAt(indexSymbol);
                check = true;
            }
            collection.add(cell);
            cell="";
            indexSymbol=0;
        }
    }
}
}
