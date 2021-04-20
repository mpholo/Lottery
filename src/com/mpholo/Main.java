package com.mpholo;

import java.util.*;

public class Main {



    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here

        System.out.print("Number of sets to generate: ");
        int generate=input.nextInt();
        int upperBound=50;

        //lotto
        System.out.println("*************Lotto Numbers***************");
        Map<Integer, TreeSet<Integer>> numberSet1=lotto(generate,upperBound,6);
        printLotto(numberSet1);

        //power ball
        upperBound=57;
        System.out.println("\n************PowerBall Numbers***************");
        Map<Integer, TreeSet<Integer>> numberSet2=powerBall(generate,upperBound,5);
        printPowerBall(numberSet2);


    }

    private static Map<Integer, TreeSet<Integer>> lotto(int generate,int upperBound,int size) {

        Map<Integer, TreeSet<Integer>> numberSet = new HashMap<>();

        for(int i=1;i<=generate;i++) {
            TreeSet<Integer> numbers = new TreeSet<>();
            while(numbers.size()<=size) {
                int rNumber = 1 + new Random().nextInt(upperBound);
                numbers.add(rNumber);
            }
            numberSet.put(i,numbers);
        }
        return numberSet;
    }

    private static void printLotto(Map<Integer, TreeSet<Integer>> numberSet) {
        numberSet.forEach((k, v)->{
            System.out.println(k+" "+v);
        });
    }

    private static void printPowerBall(Map<Integer, TreeSet<Integer>> numberSet) {
        numberSet.forEach((k, v)->{
            int powerBall = 1+new Random().nextInt(20);
            System.out.println(k+" "+v+" "+powerBall);
        });
    }

    private  static Map<Integer, TreeSet<Integer>>  powerBall(int generate,int upperBound,int size) {
        return lotto(generate,upperBound,size);
    }
}