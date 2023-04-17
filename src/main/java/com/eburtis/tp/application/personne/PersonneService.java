package com.eburtis.tp.application.personne;


public interface PersonneService {
    /**
     * 
     * @param personneVo
     * @return
     */
    public String savePersonne(PersonneVO personneVo);

    /**
     * 
     * @param id
     * @param personneVo
     * @return
     */
    public String updatePersonne(Long id, PersonneVO personneVo);

    /**
     * 
     * @return
     */
    public String fetchAllPersonne();

    /**
     * 
     * @param id
     * @return
     */
    public String fetchPersonne(Long id);

    /**
     * 
     * @param id
     * @return
     */
    public String deletePersonne(Long id);
}
