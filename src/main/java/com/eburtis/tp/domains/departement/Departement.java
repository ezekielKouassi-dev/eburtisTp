package com.eburtis.tp.domains.departement;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.JSONObject;

import com.eburtis.tp.domains.personne.Personne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "designation", nullable = false)
    private String designation;

    @OneToMany(mappedBy = "departement")
    private List<Personne> persons;

    public Departement(Long id, String code, String designation) {
        this.id = id;
        this.code = code;
        this.designation = designation;
    }

    public JSONObject getJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", this.id);
        jsonObject.put("code", this.code);
        jsonObject.put("designation", this.designation);
        return jsonObject;
    }

}
