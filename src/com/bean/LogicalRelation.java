/**
 *
 */
package com.bean;

/**
 * @author Ananthu PM
 *
 */
public class LogicalRelation {
    
    private Relation relation;
    private Person person;

    /**
     * @return the relation
     */
    public Relation getRelation() {
        return relation;
    }

    /**
     * @param relation the relation to set
     */
    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

}
