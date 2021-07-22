package com.company.factory;

import com.company.model.*;

import java.util.Random;

import static com.company.model.StatsRepository.*;

public class RandomCharacterFactory {
    public static ICharacter getRandomCharacter(){
        Random random = new Random();
        int randomNumber = random.nextInt(5);

        return switch (randomNumber) {
            case 0 -> new Hunter((int) (MAX_ATTACK* BASE_HUNTER_ATTACK_PERCENTAGE), (int) (MAX_HP* BASE_HUNTER_HP_PERCENTAGE), (int) (MAX_ARMOR* BASE_HUNTER_ARMOR_PERCENTAGE));
            case 1 -> new Assassin((int) (MAX_ATTACK* BASE_ASSASSIN_ATTACK_PERCENTAGE), (int) (MAX_HP* BASE_ASSASSIN_HP_PERCENTAGE), (int) (MAX_ARMOR* BASE_ASSASSIN_ARMOR_PERCENTAGE));
            case 2 -> new Warrior((int) (MAX_ATTACK* BASE_WARRIOR_ATTACK_PERCENTAGE), (int) (MAX_HP * BASE_WARRIOR_HP_PERCENTAGE), (int) (MAX_ARMOR* BASE_WARRIOR_ARMOR_PERCENTAGE));
            case 3 -> new Mage((int) (MAX_ATTACK* BASE_MAGE_ATTACK_PERCENTAGE), (int) (MAX_HP * BASE_MAGE_HP_PERCENTAGE), (int) (MAX_ARMOR* BASE_MAGE_ARMOR_PERCENTAGE));
            case 4 -> new Slayer((int) (MAX_ATTACK* BASE_SLAYER_ATTACK_PERCENTAGE), (int) (MAX_HP * BASE_SLAYER_HP_PERCENTAGE), (int) (MAX_ARMOR* BASE_SLAYER_ARMOR_PERCENTAGE));
            case 5 -> new Tank((int) (MAX_ATTACK* BASE_TANK_ATTACK_PERCENTAGE), (int) (MAX_HP * BASE_TANK_HP_PERCENTAGE), (int) (MAX_ARMOR* BASE_TANK_ARMOR_PERCENTAGE));
            default -> null;
        };
    }
}
