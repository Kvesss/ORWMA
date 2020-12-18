package com.example.lv5dk;

import java.util.Random;

public class RandomGenerator {
    private static volatile RandomGenerator instance;
    private final Random random;

    private RandomGenerator(){
        random = new Random();
    }


    public static RandomGenerator getInstance(){
        if(instance==null){
            synchronized (RandomGenerator.class){
                if (instance == null) {
                    instance = new RandomGenerator();
                }
            }

        }
        return instance;
    }
    public int nextInt(int maxNumber){
        return random.nextInt(maxNumber);
    }


}
