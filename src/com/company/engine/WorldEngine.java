package com.company.engine;

import com.company.consoleVisualisation.Visualisator;
import com.company.map.WorldMap;

public class WorldEngine {
    WorldMap worldMap;

    public WorldEngine(int size){
        worldMap = new WorldMap(size);
        worldMap.putCharactersOnMap(50);

        int daysNumber = 1000;
        for(int i=0; i<daysNumber; i++){
            worldMap.day();
            Visualisator.printWorld(worldMap);
        }

    }
}
