package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by JUVA on 20.11.2020.
 */
public class CompassModel implements Serializable{
    AtomicInteger newID = new AtomicInteger(1);
    private static final CompassModel instanse = new CompassModel();

    private final List<Compass> model;

    public CompassModel() {
        model = new LinkedList<Compass>();
    }

    public static CompassModel getInstanse() {
        return instanse;
    }

    public void create(Map<String, String> compass) {

        for (Map.Entry<String, String> entry : compass.entrySet()
                ) {
            if (entry.getKey().equals("North")||entry.getKey().equals("north")||entry.getKey().equals("Север")||entry.getKey().equals("север")) {
                int northMin = Integer.parseInt(entry.getValue().split("-")[0]);
                int northMax = Integer.parseInt(entry.getValue().split("-")[1]);
                Map<Integer, Integer> north = new HashMap<Integer, Integer>();
                north.put(northMin, 360);
                north.put(0, northMax);
                model.add(new Compass(entry.getKey(), north));
            } else {
                int min = Integer.parseInt(entry.getValue().split("-")[0]);
                int max = Integer.parseInt(entry.getValue().split("-")[1]);
                Map<Integer, Integer> elseSide = new HashMap<Integer, Integer>();
                elseSide.put(min, max);
                model.add(new Compass(entry.getKey(), elseSide));
            }
        }
    }

    public String get(int degree) {
        if (degree > 360 || degree < 0) {
            return "Введите значение от 0 до 360";
        } else {
            for (Compass compass : model
                    ) {
                for (Map.Entry<Integer, Integer> entry : compass.getDegrees().entrySet()) {
                    if (degree >= entry.getKey() && degree <= entry.getValue()) {
                        return compass.getSide();
                    }
                }
            }
        }
        return "Сторона света не найдена";
    }
}
