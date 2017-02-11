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
import com.lb.jwitter.core.Tbl_QLDT_Log;
import com.lb.jwitter.core.hibernate.Tbl_QLDT_LogDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_QLDT_LogService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_QLDT_LogService")
public class Tbl_QLDT_LogServiceImpl implements Tbl_QLDT_LogService,Serializable {

   private Log log = LogFactory.getLog(Tbl_QLDT_LogServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_QLDT_LogDAO")
   private Tbl_QLDT_LogDAO _tbl_QLDT_LogDao;

   public final List<Tbl_QLDT_Log> findAlltbl_QLDT_Log(int pageSize, int page){
   List<Tbl_QLDT_Log> result = get_tbl_QLDT_LogDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createtbl_QLDT_Log(Tbl_QLDT_Log obj){
       return _tbl_QLDT_LogDao.save(obj);
   }

   public final void updatetbl_QLDT_Log(Tbl_QLDT_Log obj){
       _tbl_QLDT_LogDao.update(obj);
   }//end update methode

   public final Tbl_QLDT_Log gettbl_QLDT_Log (Long id){
       log.info("Try to retrieve the tbl_QLDT_Log: "+id);
       return get_tbl_QLDT_LogDao().get(id);
   }

   public void deletetbl_QLDT_Log(Long id){
       log.info("Try to delete the tbl_QLDT_Log by Id : "+ id);
       //if(_tbl_QLDT_LogDao.exists(id)){
	    _tbl_QLDT_LogDao.delete(id);
       //} else {
       //	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       //}
   }

   public void deleteListtbl_QLDT_Log(String[] listId){
       for(String id : listId){
   	    deletetbl_QLDT_Log(Long.parseLong(id));
       }
   }

   public List<Tbl_QLDT_Log> findtbl_QLDT_LogByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_QLDT_LogDao.findByCondition(Tbl_QLDT_Log.class, cons, pageSize, page); 
   } 
 
   public int counttbl_QLDT_LogByCondition(List<ConditionReport> cons){ 
       return _tbl_QLDT_LogDao.countByCondition(Tbl_QLDT_Log.class, cons); 
   } 
 
public List<Object> findColumntbl_QLDT_LogByCondition( 
       List<ConditionReport> cons, List<String> columns, int pageSize, int page) { 
   return _tbl_QLDT_LogDao.findColumnByCondition( 
		Tbl_QLDT_Log.class, cons, columns, pageSize, page); 
} 
   public final Tbl_QLDT_LogDAO get_tbl_QLDT_LogDao() {
   	return _tbl_QLDT_LogDao;
   }
   public final void set_tbl_QLDT_LogDao(Tbl_QLDT_LogDAO obj) {
   	this._tbl_QLDT_LogDao = obj;
   }

}//endclass

