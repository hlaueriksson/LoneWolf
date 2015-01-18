package com.hoffenkloffen.lonewolf.base.core.random;

import java.util.Random;

public class RandomNumberTable {

    private Random random;

    public RandomNumberTable() {
        random = new Random();
    }

    public RandomNumberResult getResult()
    {
        return new RandomNumberResult(random.nextInt(10));
    }
}
