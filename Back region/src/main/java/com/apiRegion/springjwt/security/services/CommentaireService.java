package com.apiRegion.springjwt.security.services;

import com.apiRegion.springjwt.models.Commentaire;
import com.apiRegion.springjwt.models.Regions;

import java.util.List;
import java.util.Optional;

public interface CommentaireService {

    String addNewCommentaire(Commentaire commentaire);

    String SupprimerCommentaire(Long idCommentaire);
    String ModifierCommentaire(String username,Commentaire commentaire);
    List<Commentaire> toutLesCommentaires();
    List<Commentaire> LesCommentaireDuneRegion(Long id_region);
}
