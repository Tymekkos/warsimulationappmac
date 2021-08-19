package com.company.consoleVisualisation;

import com.company.map.WorldMap;
import com.company.util.Vector2d;
import static com.company.stats.ApplicationProperties.bound;


public class Visualisator {

    public static void printWorld(WorldMap worldMap) {
        var map = worldMap.getMap();
        for(int i=0; i<bound; i++){
            for(int j=0; j<bound; j++){
                var characters = map.get(new Vector2d(j,i));
                if(!characters.isEmpty()){
                    System.out.print("|" + characters.get(characters.size()-1).toString() + "|");
                }else{
                    System.out.print("| |");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}