/**
 *
 */
package com.bean;

import java.util.List;

/**
 * @author Ananthu PM
 *
 */
public class Relationships {
    
    private Person father;
    private Person mother;
    private List<LogicalRelation> logicalRelation;

    /**
     * @return the father
     */
    public Person getFather() {
        return father;
    }

    /**
     * @param father the father to set
     */
    public void setFather(Person father) {
        this.father = father;
    }

    /**
     * @return the mother
     */
    public Person getMother() {
        return mother;
    }

    /**
     * @param mother the mother to set
     */
    public void setMother(Person mother) {
        this.mother = mother;
    }

    /**
     * @return the logicalRelation
     */
    public List<LogicalRelation> getLogicalRelation() {
        return logicalRelation;
    }

    /**
     * @param logicalRelation the logicalRelation to set
     */
    public void setLogicalRelation(List<LogicalRelation> logicalRelation) {
        this.logicalRelation = logicalRelation;
    }
    
}
