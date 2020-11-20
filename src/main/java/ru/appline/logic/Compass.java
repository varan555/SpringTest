package ru.appline.logic;

import java.util.Map;

/**
 * Created by JUVA on 20.11.2020.
 */
public class Compass {

    private String side;
    private Map<Integer, Integer> degrees;

    public Compass(){
        super();
    }

    public Compass(String side, Map<Integer, Integer> degrees) {
        this.side = side;
        this.degrees = degrees;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setDegrees(Map<Integer, Integer> degrees) {
        this.degrees = degrees;
    }

    public String getSide() {
        return side;
    }

    public Map<Integer, Integer> getDegrees() {
        return degrees;
    }
}
