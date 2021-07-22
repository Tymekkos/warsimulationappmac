package com.company.factory;

import com.company.util.Vector2d;

import java.util.Random;

public class RandomVector2dFactory {
    public static Vector2d getRandomVector2d(int bound){
        Random random = new Random();
        return new Vector2d(random.nextInt(bound), random.nextInt(bound));
    }
}