package com.apiRegion.springjwt.repository;

import com.apiRegion.springjwt.models.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionsRepository extends JpaRepository<Regions, Long> {

    @Query(value = "SELECT regions.nomregions," +
            "regions.superficieegion," +
            " regions.activiterregion," +
            "habitants.annee, habitants.nbrepopulation " +
            "FROM habitants,regions " +
            "WHERE  habitants.regions_id_regions = regions.idregions;", nativeQuery = true)
    Iterable<Object[]> mesRegions();

    @Query(value = "SELECT pays.nompays,regions.nomregions," +
            "regions.superficie_region, regions.activiter_region," +
            "habitants.annee, habitants.nbre_population FROM `pays`,`habitants`,`regions` " +
            "WHERE  habitants.regions_id_regions = regions.id_regions " +
            "AND pays.id_pays =regions.id_regions;\n", nativeQuery = true)
    Iterable<Object[]> mesRegionsAvecPays();
/*
    Regions Generale(Regions regions);
*/

    public Regions findByNomregions(String regions);
}
