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
import com.lb.jwitter.core.Tbl_DBTable;
import com.lb.jwitter.core.hibernate.Tbl_DBTableDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_DBTableService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_DBTableService")
public class Tbl_DBTableServiceImpl implements Tbl_DBTableService,Serializable {

   private Log log = LogFactory.getLog(Tbl_DBTableServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_DBTableDAO")
   private Tbl_DBTableDAO _tbl_DBTableDao;

   public final List<Tbl_DBTable> findAlltbl_DBTable(int pageSize, int page){
   List<Tbl_DBTable> result = get_tbl_DBTableDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createtbl_DBTable(Tbl_DBTable obj){
       return _tbl_DBTableDao.save(obj);
   }

   public final void updatetbl_DBTable(Tbl_DBTable obj){
       _tbl_DBTableDao.update(obj);
   }//end update methode

   public final Tbl_DBTable gettbl_DBTable (Long id){
       log.info("Try to retrieve the tbl_DBTable: "+id);
       return get_tbl_DBTableDao().get(id);
   }

   public void deletetbl_DBTable(Long id){
       log.info("Try to delete the tbl_DBTable by Id : "+ id);
       //if(_tbl_DBTableDao.exists(id)){
	    _tbl_DBTableDao.delete(id);
       //} else {
       //	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       //}
   }

   public void deleteListtbl_DBTable(String[] listId){
       for(String id : listId){
   	    deletetbl_DBTable(Long.parseLong(id));
       }
   }

   public List<Tbl_DBTable> findtbl_DBTableByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_DBTableDao.findByCondition(Tbl_DBTable.class, cons, pageSize, page); 
   } 
 
   public int counttbl_DBTableByCondition(List<ConditionReport> cons){ 
       return _tbl_DBTableDao.countByCondition(Tbl_DBTable.class, cons); 
   } 
 
   public final Tbl_DBTableDAO get_tbl_DBTableDao() {
   	return _tbl_DBTableDao;
   }
   public final void set_tbl_DBTableDao(Tbl_DBTableDAO obj) {
   	this._tbl_DBTableDao = obj;
   }

}//endclass

