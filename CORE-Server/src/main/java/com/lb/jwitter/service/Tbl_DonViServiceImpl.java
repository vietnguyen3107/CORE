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
import com.lb.jwitter.core.Tbl_DonVi;
import com.lb.jwitter.core.hibernate.Tbl_DonViDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_DonViService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_DonViService")
public class Tbl_DonViServiceImpl implements Tbl_DonViService,Serializable {

   private Log log = LogFactory.getLog(Tbl_DonViServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_DonViDAO")
   private Tbl_DonViDAO _tbl_DonViDao;

   public final List<Tbl_DonVi> findAllTbl_DonVi(int pageSize, int page){
   List<Tbl_DonVi> result = get_tbl_DonViDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createTbl_DonVi(Tbl_DonVi obj){
       return _tbl_DonViDao.save(obj);
   }

   public final void updateTbl_DonVi(Tbl_DonVi obj){
       _tbl_DonViDao.update(obj);
   }//end update methode

   public final Tbl_DonVi getTbl_DonVi (Long id){
       log.info("Try to retrieve the tbl_DonVi: "+id);
       return get_tbl_DonViDao().get(id);
   }

   public void deleteTbl_DonVi(Long id){
       log.info("Try to delete the Tbl_DonVi by Id : "+ id);
       if(true){
	    _tbl_DonViDao.delete(id);
       } else {
       	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       }
   }

   public void deleteListTbl_DonVi(String[] listId){
       for(String id : listId){
   	    deleteTbl_DonVi(Long.parseLong(id));
       }
   }

   public List<Tbl_DonVi> findTbl_DonViByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_DonViDao.findByCondition(Tbl_DonVi.class, cons, pageSize, page); 
   } 
 
   public int countTbl_DonViByCondition(List<ConditionReport> cons){ 
       return _tbl_DonViDao.countByCondition(Tbl_DonVi.class, cons); 
   } 
 
public List<Object> findColumnTbl_DonViByCondition( 
       List<ConditionReport> cons, List<String> columns, int pageSize, int page) { 
   return _tbl_DonViDao.findColumnByCondition( 
		Tbl_DonVi.class, cons, columns, pageSize, page); 
} 
public List<Tbl_DonVi> queryHQLTbl_DonVi( 
       String hql, int pageSize, int page) { 
   return _tbl_DonViDao.queryHQL( hql, pageSize, page); 
} 
   public final Tbl_DonViDAO get_tbl_DonViDao() {
   	return _tbl_DonViDao;
   }
   public final void set_tbl_DonViDao(Tbl_DonViDAO obj) {
   	this._tbl_DonViDao = obj;
   }

}//endclass

