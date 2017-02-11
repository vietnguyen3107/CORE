package com.lb.utils.orm.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.lb.jwitter.util.ConditionReport;

/**
 *
 * @author lbouin
 */
public interface GenericDao<EntityClass, PKClass extends Serializable> {
   
    /**
     * Save an instance
     * @param transientInstance The instance to save
     * @return The PK of the saved instance
     */
    PKClass save(EntityClass transientInstance);

    /**
     * Update the given instance 
     * @param detachedInstance The instance to update
     */
    void update(EntityClass detachedInstance);

    /**
     * Save or Update the given instance 
     * @param object The instance to save or update
     */
    void saveOrUpdate(EntityClass object);
    

    /**
     * Save or Update  All the given instances 
     * @param objects The list of instance to save or update
     */
	void saveOrUpdateAll(Collection<EntityClass> objects);
    /**
     * Get the entity with the given id
     * @param id the id of the instance to get
     * @return The existing entity
     */
    EntityClass get(PKClass id);

    /**
     * Load the entity with the given id
     * @param id the id of the instance to load
     * @return The existing entity
     */
    EntityClass load(PKClass id);

    /**
     * Delete the given instance from the DB
     * @param persistentInstance The instance to delete
     */
    void delete(EntityClass persistentInstance);

    /**
     * Delete the instance with the given id from the DB
     * @param persistentObjectPK The PK of the instance to delete
     */
    void delete(PKClass persistentObjectPK);
    
    boolean exists(PKClass persistentObjectPK);
    
    List findByCondition(Class cclass,List<ConditionReport> cons,int pageSize,int page);
    
    List findColumnByCondition(Class cclass,List<ConditionReport> cons,List<String> columns,int pageSize,int page);

    
    Integer countByCondition(Class cclass,List<ConditionReport> cons);
   
        
//    Double sumByCondition(Class cclass,List<ConditionReport> cons, String column);
    
}