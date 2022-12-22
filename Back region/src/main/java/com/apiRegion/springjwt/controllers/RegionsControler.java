package com.apiRegion.springjwt.controllers;


import com.apiRegion.springjwt.Message.ReponseMessage;
import com.apiRegion.springjwt.models.Pays;
import com.apiRegion.springjwt.repository.PaysRepository;
import com.apiRegion.springjwt.security.services.RegionsService;
import com.apiRegion.springjwt.img.ConfigImage;
import com.apiRegion.springjwt.models.Regions;
import com.apiRegion.springjwt.repository.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/projet/odk/Regions", name = "Regions")
public class RegionsControler {

    @Autowired
    RegionsService regionsService;

    @Autowired
    PaysRepository paysRepository;
    //Controller
            /*
            @Autowired
            public RegionsControler(RegionsService regionsService)
            {
                this.regionsService=regionsService;
            }
             */
//Classe d'ajout des regions

    @PostMapping(path = "/creer", name = "create")
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasRole('ADMIN')")
    public ReponseMessage add(@RequestBody Regions regions) {
        return this.regionsService.ajouterRegions(regions);
    }

   // ICI ON TENTE DE CREER UNE REGION AVEC IMAGES

    private int nombrecommentaire;
    @Autowired
    private RegionsRepository regionsRepository;

    @PostMapping("/ajouterRegion/{nomPays}")
    public ReponseMessage ajouterRegion(@Param("nomregions") String nomregions,@Param("population") Long population, @Param("coderegion") String coderegion, @Param("activiterregion") String activiterregion, @Param("superficieregion") String superficieregion, @Param("languemregion") String languemregion, @Param("description") String description, @PathVariable("nomPays") String nomPays, @Param("file") MultipartFile file) throws IOException {
        Pays pays = paysRepository.findByNompays(nomPays);
        Regions regions = new Regions();
        String nomfile = StringUtils.cleanPath(file.getOriginalFilename());

        System.out.println(nomregions);
        regions.setNomregions(nomregions);

        System.out.println(coderegion);
       regions.setCoderegion(coderegion);

        System.out.println(description);
        regions.setDescription(description);

        System.out.println(activiterregion);
       regions.setActiviterregion(activiterregion);

        System.out.println(nomfile);
        regions.setImages(nomfile);

        System.out.println(nomregions);
        regions.setNomregions(nomregions);

        System.out.println(languemregion);
        regions.setLanguemregion(languemregion);

        System.out.println(superficieregion);
        regions.setSuperficieregion(superficieregion);

        System.out.println(nombrecommentaire);
        regions.setPopulation(population);

        regions.setPays(pays);
        System.out.println(regions.getId_regions());
        System.out.println(regions.getNomregions());

        if(regionsRepository.findByNomregions(nomregions) == null){

          //  String u = "C:/Users/adcoulibaly/Desktop/ERP/ApplicationERPInterface/src/assets/images";
            String uploaDir = "C:/Users/ammariko/Documents/front-jetravail-1/src/assets";
            //String uploaDir = new ClassPathResource("files/").getFile().getAbsolutePath();
            ConfigImage.saveimg(uploaDir, nomfile, file);
            //  entiteServiceImplement.ajouter(entite);
            return regionsService.ajouterRegions(regions);
        }else {
            ReponseMessage message = new ReponseMessage("Regions existe déja",false);
            return message;
        }

    }

//Classe afficher toute les regions
    @GetMapping(path = "/liste", name = "list")
    @ResponseStatus(HttpStatus.OK) //Permet de monter l'etat de notre requete
    public List<Regions> list() {
        return this.regionsService.afficherRegions();
    }
//Classe afficher une regions


    @GetMapping(path = "/uneRegion/{id_regions}", name = "lire")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Regions> lire(@PathVariable Long id_regions) {
        return this.regionsService.afficherUneRegion(id_regions);
    }
//Classe permettant de modifier les regions

    @PutMapping(path = "/modifier/{id_regions}", name = "modifier")
    @ResponseStatus(HttpStatus.OK)
    public ReponseMessage modifier(@RequestBody Regions regions, @PathVariable Long id_regions) {
        return this.regionsService.modifierRegions(regions, id_regions);
    }

    //Classe permettant de supprimer une region
    @DeleteMapping(path = "/supprimer/{id_regions}", name = "supprimer")
    //  @ResponseStatus(HttpStatus.NO_CONTENT)
    public ReponseMessage supprimer(@PathVariable Long id_regions) {
        return this.regionsService.supprimer(id_regions);
    }

    // La liste des regions sans pays

    @GetMapping(path = "/regionssansPays")
    public Iterable<Object[]> mesRegions() {
        return this.regionsService.mesRegions();
    }


    // La liste des regions avec pays

    @GetMapping(path = "/regionsavecPays")
    public Iterable<Object[]> mesRegionsAvecPays() {
        return this.regionsService.mesRegionsAvecPays();
    }
/*
            // Generale
            @ApiOperation(value = "Crée une Region en generale")
            @PostMapping(path ="/ajouter", name = "create")
            public Regions Generale(Regions regions) {
                return this.regionsService.Generale(regions);
            }

 */


}

