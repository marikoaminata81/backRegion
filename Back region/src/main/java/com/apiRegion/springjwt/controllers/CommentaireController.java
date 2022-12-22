package com.apiRegion.springjwt.controllers;


import com.apiRegion.springjwt.models.Commentaire;
import com.apiRegion.springjwt.models.Regions;
import com.apiRegion.springjwt.repository.CommentaireRepository;
import com.apiRegion.springjwt.security.services.CommentaireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/projet/odk/Commentaire",name ="Commentaire")
public class CommentaireController {

    private CommentaireService commentaireService;
    private final CommentaireRepository commentaireRepository;

    public CommentaireController(CommentaireService commentaireService,
                                 CommentaireRepository commentaireRepository) {
        this.commentaireService = commentaireService;
        this.commentaireRepository = commentaireRepository;
    }

    @PostMapping(path = "/creer")
    public String ajouterCommentaire(@RequestBody Commentaire commentaire){
         //   System.out.println("############################################: tttt " + commentaire + "##############################");
        return commentaireService.addNewCommentaire(commentaire);
    }

    @GetMapping(path = "/lister")
    public List<Commentaire> mesCommanteurs(){
        return commentaireService.toutLesCommentaires();
    }


    @GetMapping(path = "/RegionsCommentaire/{id_regions}")
    public List<Commentaire> LesCommentaireDuneRegion(@PathVariable("id_regions") Long id_region){
        return commentaireService.LesCommentaireDuneRegion(id_region);
    }
}
