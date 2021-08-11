package com.company.model;

import java.util.Random;

import static com.company.model.StatsRepository.BASE_ASSASSIN_HP_PERCENTAGE;
import static com.company.model.StatsRepository.MAX_HP;

//big dmg to low max health targets (struggles against tanks)
public class Assassin implements ICharacter{
    private int attack;
    private int hp;
    private int armor;

    public Assassin(int attack, int hp, int armor) {
        this.attack = attack;
        this.hp = hp;
        this.armor = armor;
    }

    @Override
    public String toString(){
        return "A";
    }

    @Override
    public int attack(int opponentArmor) {
        // hp = 400 attack = 40 armor = 20 jesli pzdorwie przeciwnika jest takie samo lub
        // mniejesze od assasina - zadawaj 50% wiecvej obrazen
        Random random = new Random();
        int value = random.nextInt(99)+1;
        int armorValue = random.nextInt(99)+1;
        int tmpAttack = (value*attack)/100 - (opponentArmor*armorValue)/100;
        if(tmpAttack <= 0){
            tmpAttack = 0;
        }
        //System.out.println("Assassin attacked!");
        return tmpAttack;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void setAttack(int attack) {
        this.attack = attack;
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
        this.hp = (int) (MAX_HP* BASE_ASSASSIN_HP_PERCENTAGE);
    }


}

