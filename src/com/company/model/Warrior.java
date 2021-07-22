package com.company.model;

import java.util.Random;

import static com.company.model.StatsRepository.BASE_WARRIOR_HP_PERCENTAGE;
import static com.company.model.StatsRepository.MAX_HP;

public class Warrior implements ICharacter {

    private final int attack;
    private int hp;
    private int armor;

    public Warrior(int attack, int hp, int armor) {
        this.attack = attack;
        this.hp = hp;
        this.armor = armor;
    }

    @Override
    public String toString(){
        return "W";
    }

    @Override
    public int attack(int opponentArmor) {
        // hp = 600 attack = 35-50 armor = 30
//        attack = raandom(50, 100)
//        attacking = attack - oponent.armor
        Random random = new Random();
        int value = random.nextInt(99)+1;
        int armorValue = random.nextInt(99)+1;
        int tmpAttack = (value*attack)/100 - (opponentArmor*armorValue)/100;
        if(tmpAttack <= 0){
            tmpAttack = 0;
        }
        System.out.println("Warrior attacked!");
        return tmpAttack;
    }

    @Override
    public int getHP() {
        return this.hp;
    }

    @Override
    public void setHP(int hp) {
        this.hp = hp;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public void restartHP() {
        this.hp = (int) (MAX_HP* BASE_WARRIOR_HP_PERCENTAGE);
    }
}