package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Compass;
import ru.appline.logic.CompassModel;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by JUVA on 20.11.2020.
 */
@RestController
public class ControllerCompass {
    public static final CompassModel compassModel = CompassModel.getInstanse();

    @PostMapping(value = "/createCompass", consumes = "application/json")
    public void creatCompass (@RequestBody Map<String, String> compass) {
        compassModel.create(compass);
    }

    @GetMapping(value = "/getCompass", produces = "application/json")
    public String get(@RequestBody Map<String, Integer> id) {
        return "Side: " + compassModel.get(id.get("Degree"));
    }

}
//{    "North": "337-22",
//        "Pravo": "23-45",
//        "East":  "46-100",
//        "Niz": "101-135",
//        "South": "136-180",
//        "Levo": "181-225",
//        "West": "226-315"
//        }