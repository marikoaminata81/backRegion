package com.apiRegion.springjwt.security.services;

import com.apiRegion.springjwt.models.Commentaire;
import com.apiRegion.springjwt.models.Regions;
import com.apiRegion.springjwt.repository.CommentaireRepository;
import com.apiRegion.springjwt.repository.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    CommentaireRepository commentaireRepository;
    @Autowired
    RegionsRepository regionsRepository;

    @Autowired
    RegionsService regionsService;

    public CommentaireServiceImpl(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }


    @Override
    public String addNewCommentaire(Commentaire commentaire) {

        System.out.println("test **************************************** "+commentaire);


        System.out.println("REGION **************************************** "+ commentaire.getRegions());

       //  regionsRepository.findById(commentaire.getRegions().getId_regions());

        regionsService.increment(commentaire.getRegions(), commentaire.getRegions().getId_regions());

            commentaireRepository.save(commentaire);
            return "Commentaires ajouté avec succes";

    }

    @Override
    public String SupprimerCommentaire(Long idCommentaire) {
        return null;
    }

    @Override
    public String ModifierCommentaire(String username, Commentaire commentaire) {
        return null;
    }

    @Override
    public List<Commentaire> toutLesCommentaires() {
        return commentaireRepository.findAll();
    }

    @Override
    public List<Commentaire> LesCommentaireDuneRegion(Long id_region) {
        return commentaireRepository.LesCommentaireDuneRegion(id_region);
    }


}
