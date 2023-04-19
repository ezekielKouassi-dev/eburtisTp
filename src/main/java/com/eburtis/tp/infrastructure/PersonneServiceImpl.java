package com.eburtis.tp.infrastructure;

import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.eburtis.tp.application.personne.PersonneService;
import com.eburtis.tp.application.personne.PersonneVO;
import com.eburtis.tp.domains.personne.Personne;
import com.eburtis.tp.domains.personne.PersonneRepository;

@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public String savePersonne(PersonneVO personneVo) {
        JSONObject jsonObject = new JSONObject();
        Personne personne = new Personne();

        personne.setNom(personneVo.getNom());
        personne.setPrenoms(personneVo.getPrenoms());
        personne.setAge(personneVo.getAge());
        personne.setDepartement(personneVo.getDepartement());

        personneRepository.save(personne);

        jsonObject.put("status", HttpStatus.OK.value());
        jsonObject.put("message", "personne enregistré avec succès");

        return jsonObject.toString();
    }

    @Override
    public String updatePersonne(Long id, PersonneVO personneVo) {
        JSONObject jsonObject = new JSONObject();
        Optional<Personne> personne = personneRepository.findById(id);
        if(!personne.isPresent()) {
            jsonObject.put("status", HttpStatus.NOT_FOUND.value());
            jsonObject.put("message", "impossible de MAJ une personne qui n'existe pas!");
            return jsonObject.toString();
        }
        
        personne.get().setNom(personneVo.getNom());
        personne.get().setPrenoms(personneVo.getPrenoms());
        personne.get().setAge(personneVo.getAge());
        personne.get().setDepartement(personneVo.getDepartement());

        personneRepository.save(personne.get());

        jsonObject.put("status", HttpStatus.OK.value());
        jsonObject.put("message", "personne MAJ avec succès");

        return jsonObject.toString();
    }

    @Override
    public String fetchAllPersonne() {
        
        JSONObject jsonObject;
        JSONArray jsonArray = new JSONArray();

        List<Personne> personnes = personneRepository.findAll();

        for(Personne personne : personnes) {
            jsonObject = new JSONObject();
            jsonObject.put("id",personne.getId());
            jsonObject.put("nom", personne.getNom());
            jsonObject.put("prenoms", personne.getPrenoms());
            jsonObject.put("departement", personne.getDepartement().getJson().toMap());
            jsonObject.put("age", personne.getAge());
            jsonArray.put(jsonObject);
        }

        jsonObject = new JSONObject();

        jsonObject.put("status", HttpStatus.OK.value());
        jsonObject.put("message", "succèss");
        jsonObject.put("data", jsonArray);

        return jsonObject.toString();
    }

    @Override
    public String fetchPersonne(Long id) {
        JSONObject jsonObject = new JSONObject();
        Optional<Personne> personne = personneRepository.findById(id);

        if(!personne.isPresent()) {
            jsonObject.put("status", HttpStatus.NOT_FOUND.value());
            jsonObject.put("message", "personne introuvable");
            return jsonObject.toString();
        }

        jsonObject.put("status", HttpStatus.OK.value());
        jsonObject.put("message", "personne trouvé");
        jsonObject.put("data", personne.get().getJson());

        return jsonObject.toString();
    }

    @Override
    public String deletePersonne(Long id) {
        JSONObject jsonObject = new JSONObject();
        Optional<Personne> personne = personneRepository.findById(id);
        if(!personne.isPresent()) {
            jsonObject.put("status", HttpStatus.NOT_FOUND.value());
            jsonObject.put("message", "personne impossible à trouvé");
            return jsonObject.toString();
        }

        personneRepository.delete(personne.get());

        jsonObject.put("status", HttpStatus.OK.value());
        jsonObject.put("message", personne.get().getNom() + " " + personne.get().getPrenoms() + " supprimé avec succèss");
        return jsonObject.toString();
    }
    
}
