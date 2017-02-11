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
import com.lb.jwitter.core.Tbl_QLDT_Config;
import com.lb.jwitter.core.hibernate.Tbl_QLDT_ConfigDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_QLDT_ConfigService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_QLDT_ConfigService")
public class Tbl_QLDT_ConfigServiceImpl implements Tbl_QLDT_ConfigService,Serializable {

   private Log log = LogFactory.getLog(Tbl_QLDT_ConfigServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_QLDT_ConfigDAO")
   private Tbl_QLDT_ConfigDAO _tbl_QLDT_ConfigDao;

   public final List<Tbl_QLDT_Config> findAlltbl_QLDT_Config(int pageSize, int page){
   List<Tbl_QLDT_Config> result = get_tbl_QLDT_ConfigDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createtbl_QLDT_Config(Tbl_QLDT_Config obj){
       return _tbl_QLDT_ConfigDao.save(obj);
   }

   public final void updatetbl_QLDT_Config(Tbl_QLDT_Config obj){
       _tbl_QLDT_ConfigDao.update(obj);
   }//end update methode

   public final Tbl_QLDT_Config gettbl_QLDT_Config (Long id){
       log.info("Try to retrieve the tbl_QLDT_Config: "+id);
       return get_tbl_QLDT_ConfigDao().get(id);
   }

   public void deletetbl_QLDT_Config(Long id){
       log.info("Try to delete the tbl_QLDT_Config by Id : "+ id);
       //if(_tbl_QLDT_ConfigDao.exists(id)){
	    _tbl_QLDT_ConfigDao.delete(id);
       //} else {
       //	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       //}
   }

   public void deleteListtbl_QLDT_Config(String[] listId){
       for(String id : listId){
   	    deletetbl_QLDT_Config(Long.parseLong(id));
       }
   }

   public List<Tbl_QLDT_Config> findtbl_QLDT_ConfigByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_QLDT_ConfigDao.findByCondition(Tbl_QLDT_Config.class, cons, pageSize, page); 
   } 
 
   public int counttbl_QLDT_ConfigByCondition(List<ConditionReport> cons){ 
       return _tbl_QLDT_ConfigDao.countByCondition(Tbl_QLDT_Config.class, cons); 
   } 
 
public List<Object> findColumntbl_QLDT_ConfigByCondition( 
       List<ConditionReport> cons, List<String> columns, int pageSize, int page) { 
   return _tbl_QLDT_ConfigDao.findColumnByCondition( 
		Tbl_QLDT_Config.class, cons, columns, pageSize, page); 
} 
   public final Tbl_QLDT_ConfigDAO get_tbl_QLDT_ConfigDao() {
   	return _tbl_QLDT_ConfigDao;
   }
   public final void set_tbl_QLDT_ConfigDao(Tbl_QLDT_ConfigDAO obj) {
   	this._tbl_QLDT_ConfigDao = obj;
   }

}//endclass

