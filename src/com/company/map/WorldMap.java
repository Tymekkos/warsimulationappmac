package com.company.map;

import com.company.factory.CharacterFactory;
import com.company.factory.RandomVector2dFactory;
import com.company.model.ICharacter;
import com.company.util.Vector2d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.company.map.WorldMapUtils.pvpForList;

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
            map.get(RandomVector2dFactory.getRandomVector2d(10)).add(CharacterFactory.getRandomCharacter());
        }
    }

    public void printAllCharacters(){
        map.forEach((vector2d, iCharacters) -> iCharacters.forEach(iCharacter -> System.out.println(iCharacter.toString() + vector2d.toString())));
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
            pvpForList(iCharacters);
            for(int i=1; i<iCharacters.size(); i+=2){
                var child = CharacterFactory.getParticularCharacter(iCharacters.get(i));
                var newField = RandomVector2dFactory.getFieldAroundTheVector2d(vector2d, 10);
                map.get(newField).add(child);
                System.out.println(map.get(newField));
                System.out.println(newField);

            }
        }));

    }

}





