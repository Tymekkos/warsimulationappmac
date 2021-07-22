package com.company.map;

import com.company.factory.RandomCharacterFactory;
import com.company.factory.RandomVector2dFactory;
import com.company.model.ICharacter;
import com.company.util.Vector2d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

public class WorldMap {
    private final Map<Vector2d, List<ICharacter>> map = new HashMap<>();
    private final int size;

    public WorldMap(int size){
        this.size = size;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                map.put(new Vector2d(j, i), new ArrayList<>());
                }
            }
        }

    public int getSize() {
        return size;
    }

    public Map<Vector2d, List<ICharacter>> getMap() {
        return map;
    }

    public void putCharactersOnMap(int charactersNumber){
        for(int i=0; i<charactersNumber; i++){
            map.get(RandomVector2dFactory.getRandomVector2d(10)).add(RandomCharacterFactory.getRandomCharacter());
        }
    }

    public void printAllCharacters(){
        map.forEach((vector2d, iCharacters) -> iCharacters.forEach(iCharacter -> System.out.println(iCharacter.toString() + vector2d.toString())));
    }

    public ICharacter pvp(ICharacter character1, ICharacter character2){
        //returns winning unit
        while(character1.getHP() > 0 && character2.getHP() > 0){
            int damage1 = character1.attack(character2.getArmor()) ;
            int damage2 = character2.attack(character1.getArmor()) ;
            character2.setHP(character2.getHP() - damage1);
            character1.setHP(character1.getHP() - damage2);
        }
        if(character1.getHP() > 0)
            return character1;
        else
            return character2;

    }
    public ICharacter pvpForList(List<ICharacter> ICharacters) {
        ICharacter winner;
        if(ICharacters.isEmpty()){
            return null;
        }
        else if(ICharacters.size() == 1){
            return ICharacters.get(0);
        }
        else{
            winner = pvp(ICharacters.get(0), ICharacters.get(1));
            winner.restartHP();
            for(int i=2; i<ICharacters.size(); i++){
                winner = pvp(winner, ICharacters.get(i));
                winner.restartHP();
            }
            return winner;
        }
    }

    public void day(){

        Map<Vector2d, List<ICharacter>> mockMap = new HashMap<>();

        map.forEach(((vector2d, iCharacters) -> {
            List<ICharacter> ICharacterList = new ArrayList<>(iCharacters);
            mockMap.put(vector2d, ICharacterList);
        }));

        mockMap.forEach(((vector2d, iCharacters) -> iCharacters.forEach(iCharacter -> iCharacter.move(map, vector2d))));
        //pvp
        Map<Vector2d, List<ICharacter>> mockMap2 = new HashMap<>();
        map.forEach(((vector2d, iCharacters) -> {
            List<ICharacter> ICharacterList = new ArrayList<>(iCharacters);
            mockMap2.put(vector2d, ICharacterList);
        }));
        mockMap2.forEach(((vector2d, iCharacters) -> {
            ICharacter winner = pvpForList(iCharacters);
            if(winner != null) {
                map.get(vector2d).clear();
                map.get(vector2d).add(winner);
            }
        }));


    }

}

