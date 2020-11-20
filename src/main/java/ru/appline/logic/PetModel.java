package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JUVA on 19.11.2020.
 */
public class PetModel implements Serializable{
    private static final PetModel instanse = new PetModel();

    private final Map<Integer, Pet> model;

    public PetModel() {
        model = new HashMap<Integer, Pet>();
    }

    public static PetModel getInstanse() {
        return instanse;
    }

    public void add(Pet pet, int id){
        model.put(id, pet);
    }

    public Pet getFromList(int id) {
        return model.get(id);
    }

    public void delete(int id){
        model.remove(id);
    }

    public Map<Integer, Pet> getAll(){
        return model;
    }
}
