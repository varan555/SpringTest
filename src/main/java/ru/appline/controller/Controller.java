package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by JUVA on 20.11.2020.
 */
@RestController
public class Controller {
    public static final PetModel petModel = PetModel.getInstanse();
    AtomicInteger newID = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json")
    public String creatPet (@RequestBody Pet pet) {
        petModel.add(pet, newID.getAndIncrement());
        if (petModel.getAll().size() == 1) {
            return "Поздравляем, Вы создали своего первого питомца";
        }
        else { return "Поздравляем, Вы создали питомца";}

    }

    @GetMapping (value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return petModel.getFromList(id.get("id"));
    }

    @PutMapping (value = "/putPet", consumes = "application/json")
    public void putPet(@RequestBody Map<String, String> req){
        Pet pet = new Pet(req.get("name"), req.get("type"), Integer.parseInt(req.get("age")));
        petModel.add(pet, Integer.parseInt(req.get("id")));
    }

    @DeleteMapping (value = "/delete", consumes = "application/json")
    public void deletePete(@RequestBody Map<String, Integer> id) {
        petModel.delete(id.get("id"));
    }
}
