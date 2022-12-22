package com.apiRegion.springjwt.repository;

import com.apiRegion.springjwt.models.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {
   /* @Query(value =" SELECT * FROM `pays` WHERE pays.nom_pays=:nomPays",nativeQuery = true)
    List<String> VerifierPay(String nomPays);

    */

    public Pays findByNompays(String pays);

    //REQUETTE PEREMTTANT DE RETORUNER UN PAYS EN FONCTION DE SON ID
    Pays findByIdPays(Long IdPays);

    //REQUETTE PERMETTANT DE REOURNER UN PAYS EN FONCTION DE SON NOM
    //Pays findByNompays(String nom);



}
