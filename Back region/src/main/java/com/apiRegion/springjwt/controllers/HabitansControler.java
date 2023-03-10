package com.apiRegion.springjwt.controllers;


import com.apiRegion.springjwt.security.services.HabitantsService;
import com.apiRegion.springjwt.models.Habitants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/projet/odk/Habitants",name ="Habitants")
public class HabitansControler {

    private HabitantsService habitantsService;

    @Autowired
    public HabitansControler(HabitantsService habitantsService)
    {
        this.habitantsService=habitantsService;
    }


    @PostMapping(path = "/creer")
    public Habitants ajouterHabitant(@RequestBody Habitants habitants)
    {
        return this.habitantsService.ajouterHabitant(habitants);
    }
    @GetMapping(path ="/liste", name = "list")

    public List<Habitants> list()
    {
        return this.habitantsService.maListe();
    }


    @PutMapping(path ="/modifier/{id_habitans}", name = "modifier")
    public Habitants modifierHabitant(@RequestBody Habitants habitants, @PathVariable Long id_habitants)
    {
        return habitantsService.modifierHabitant(habitants, id_habitants);
    }


    @DeleteMapping(path ="/supprimer/{id_habitants}", name = "supprimer")
    public void supprimerHabitant(@PathVariable Long id_habitants)
    {
        this.habitantsService.supprimerHabitant(id_habitants);
    }




}
