package com.hoffenkloffen.lonewolf.controllers;

import com.hoffenkloffen.lonewolf.models.RandomNumberResult;

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
