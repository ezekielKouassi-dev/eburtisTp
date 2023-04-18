package com.eburtis.tp.infrastructure;

import com.eburtis.tp.application.departement.DepartementService;
import com.eburtis.tp.domains.departement.Departement;
import com.eburtis.tp.domains.departement.DepartementRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartementServiceImpl implements DepartementService {
    
    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public String fetchAllDepartement() {
        JSONObject jsonObject;
        JSONArray jsonArray = new JSONArray();

        for(Departement departement: departementRepository.findAll()) {
            jsonObject = new JSONObject();
            jsonObject.put("id", departement.getId());
            jsonObject.put("code", departement.getCode());
            jsonObject.put("designation", departement.getDesignation());
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }
}
