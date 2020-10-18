package com.company;

public class Main {
    public static void main(String[] args) {
        MyList<Double> list = new MyList<>();
//             ((a, b) -> {
//          if (((int) a.getValue() -  (int)b.getValue()) > 0) {
//             return 1;
//          } else {
//             if (((int) a.getValue() - (int) b.getValue()) == 0) {
//                return 0;
//             } else return (-1);
//          }
//       });
        Randomizer.randomDouble(list, 3);
        System.out.println(list.toString());

    }
}
