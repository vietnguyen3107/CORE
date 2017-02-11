package com.lb.jwitter.service;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lb.jwitter.*;
import com.lb.jwitter.core.Tbl_QLDTLT_OptionGroup;
import com.lb.jwitter.core.hibernate.Tbl_QLDTLT_OptionGroupDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_QLDTLT_OptionGroupService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_QLDTLT_OptionGroupService")
public class Tbl_QLDTLT_OptionGroupServiceImpl implements Tbl_QLDTLT_OptionGroupService,Serializable {

   private Log log = LogFactory.getLog(Tbl_QLDTLT_OptionGroupServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_QLDTLT_OptionGroupDAO")
   private Tbl_QLDTLT_OptionGroupDAO _tbl_QLDTLT_OptionGroupDao;

   public final List<Tbl_QLDTLT_OptionGroup> findAllTbl_QLDTLT_OptionGroup(int pageSize, int page){
   List<Tbl_QLDTLT_OptionGroup> result = get_tbl_QLDTLT_OptionGroupDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createTbl_QLDTLT_OptionGroup(Tbl_QLDTLT_OptionGroup obj){
       return _tbl_QLDTLT_OptionGroupDao.save(obj);
   }

   public final void updateTbl_QLDTLT_OptionGroup(Tbl_QLDTLT_OptionGroup obj){
       _tbl_QLDTLT_OptionGroupDao.update(obj);
   }//end update methode

   public final Tbl_QLDTLT_OptionGroup getTbl_QLDTLT_OptionGroup (Long id){
       log.info("Try to retrieve the tbl_QLDTLT_OptionGroup: "+id);
       return get_tbl_QLDTLT_OptionGroupDao().get(id);
   }

   public void deleteTbl_QLDTLT_OptionGroup(Long id){
       log.info("Try to delete the Tbl_QLDTLT_OptionGroup by Id : "+ id);
       if(true){
	    _tbl_QLDTLT_OptionGroupDao.delete(id);
       } else {
       	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       }
   }

   public void deleteListTbl_QLDTLT_OptionGroup(String[] listId){
       for(String id : listId){
   	    deleteTbl_QLDTLT_OptionGroup(Long.parseLong(id));
       }
   }

   public List<Tbl_QLDTLT_OptionGroup> findTbl_QLDTLT_OptionGroupByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_QLDTLT_OptionGroupDao.findByCondition(Tbl_QLDTLT_OptionGroup.class, cons, pageSize, page); 
   } 
 
   public int countTbl_QLDTLT_OptionGroupByCondition(List<ConditionReport> cons){ 
       return _tbl_QLDTLT_OptionGroupDao.countByCondition(Tbl_QLDTLT_OptionGroup.class, cons); 
   } 
 
public List<Object> findColumnTbl_QLDTLT_OptionGroupByCondition( 
       List<ConditionReport> cons, List<String> columns, int pageSize, int page) { 
   return _tbl_QLDTLT_OptionGroupDao.findColumnByCondition( 
		Tbl_QLDTLT_OptionGroup.class, cons, columns, pageSize, page); 
} 
public List<Tbl_QLDTLT_OptionGroup> queryHQLTbl_QLDTLT_OptionGroup( 
       String hql, int pageSize, int page) { 
   return _tbl_QLDTLT_OptionGroupDao.queryHQL( hql, pageSize, page); 
} 
   public final Tbl_QLDTLT_OptionGroupDAO get_tbl_QLDTLT_OptionGroupDao() {
   	return _tbl_QLDTLT_OptionGroupDao;
   }
   public final void set_tbl_QLDTLT_OptionGroupDao(Tbl_QLDTLT_OptionGroupDAO obj) {
   	this._tbl_QLDTLT_OptionGroupDao = obj;
   }

}//endclass

