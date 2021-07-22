package com.company.model;

import java.util.Random;

import static com.company.model.StatsRepository.BASE_TANK_HP_PERCENTAGE;
import static com.company.model.StatsRepository.MAX_HP;

public class Tank implements ICharacter {

    private final int attack;
    private int hp;
    private int armor;

    public Tank(int attack, int hp, int armor) {
        this.attack = attack;
        this.hp = hp;
        this.armor = armor;
    }

    @Override
    public String toString(){
        return "T";
    }

    @Override
    public int attack(int opponentArmor){
        // hp = 1000 attack = 10 armor = 50 20%chance to fully block an attack
        Random random = new Random();
        int armorValue = random.nextInt(99)+1;
        int value = random.nextInt(99)+1;
        int blockChance = random.nextInt(99)+1;
        int tmpAttack = (value*attack)/100 - (opponentArmor*armorValue)/100;
        if(blockChance <= 20)
        {
            //block an attack
        }
        if (tmpAttack <=0)
        {
            tmpAttack = 0;
        }
        System.out.println("Tank attacked!");
        return attack;
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
        this.hp = (int) (MAX_HP* BASE_TANK_HP_PERCENTAGE);
    }
}