package com.hoffenkloffen.lonewolf.core.random;

import com.hoffenkloffen.lonewolf.core.random.RandomNumberResult;

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
