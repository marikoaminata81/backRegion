package com.apiRegion.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcommentaire;
    private String objet;
    private String description;


    @JoinColumn(name = "id_users") // ICI IMPORTANT
    @ManyToOne()//cascade=CascadeType.ALL
    private User user;

    /*
    @JoinColumn(name = "id_regions") // ICI IMPORTANT
    @ManyToOne(cascade=CascadeType.ALL)
     */
    @ManyToOne
    @JoinColumn(name = "regions_id_regions")
    private Regions regions;

}
