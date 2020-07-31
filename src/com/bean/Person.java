/**
 *
 */
package com.bean;

import java.util.UUID;

/**
 * @author Ananthu PM
 *
 */
public class Person implements IPerson {

    private UUID id;
    private Deatils persinalDetails;
    private Relationships relationships;

    public Person() {
        id = UUID.randomUUID();
        persinalDetails = new Deatils();
        relationships = new Relationships();
    }
    
    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }
    
    /**
     * @return the persinalDetails
     */
    public Deatils getPersinalDetails() {
        return persinalDetails;
    }
    
    /**
     * @param persinalDetails the persinalDetails to set
     */
    public void setPersinalDetails(Deatils persinalDetails) {
        this.persinalDetails = persinalDetails;
    }
    
    /**
     * @return the relationships
     */
    public Relationships getRelationships() {
        return relationships;
    }
    
    /**
     * @param relationships the relationships to set
     */
    public void setRelationships(Relationships relationships) {
        this.relationships = relationships;
    }

    @Override
    public String toString() {
        String show = "(" + this.id + "):" + this.persinalDetails.getName() + "\n";
        if (this.relationships.getFather() != null) {
            show = show + "\tfather: " + this.relationships.getFather();
        }
        if (this.relationships.getMother() != null) {
            show = show + "\tmother: " + this.relationships.getMother();
        }
        return show;
    }

}
