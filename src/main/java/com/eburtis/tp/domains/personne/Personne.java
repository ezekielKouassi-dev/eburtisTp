package com.eburtis.tp.domains.personne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.json.JSONObject;

import com.eburtis.tp.domains.departement.Departement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "personne")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenoms;

    private Long age;

    @ManyToOne
    @JoinColumn(name = "id_departement")
    private Departement departement;

    public JSONObject getJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", this.id);
        jsonObject.put("nom", this.nom);
        jsonObject.put("prenoms", this.prenoms);
        jsonObject.put("age", this.age);
        return jsonObject;
    }
    
}
