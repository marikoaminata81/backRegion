package com.apiRegion.springjwt.repository;

import com.apiRegion.springjwt.models.Commentaire;
import com.apiRegion.springjwt.models.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {

    Commentaire findByObjet(Commentaire objets);

    @Query(value = "SELECT * FROM `commentaire` WHERE commentaire.regions_id_regions = :id_regions",nativeQuery = true)
    List<Commentaire> LesCommentaireDuneRegion(Long id_regions);

}
