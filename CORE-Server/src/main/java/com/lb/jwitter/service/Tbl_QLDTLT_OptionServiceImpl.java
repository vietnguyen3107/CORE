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
import com.lb.jwitter.core.Tbl_QLDTLT_Option;
import com.lb.jwitter.core.hibernate.Tbl_QLDTLT_OptionDAO;
import com.lb.jwitter.core.hibernate.Tbl_QLDTLT_OptionGroupDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_QLDTLT_OptionService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_QLDTLT_OptionService")
public class Tbl_QLDTLT_OptionServiceImpl implements Tbl_QLDTLT_OptionService,Serializable {

   private Log log = LogFactory.getLog(Tbl_QLDTLT_OptionServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_QLDTLT_OptionDAO")
   private Tbl_QLDTLT_OptionDAO _tbl_QLDTLT_OptionDao;

   @Autowired
   @Qualifier("tbl_QLDTLT_OptionGroupDAO")
   private Tbl_QLDTLT_OptionGroupDAO _tbl_QLDTLT_OptionGroupDao;

   public final List<Tbl_QLDTLT_Option> findAllTbl_QLDTLT_Option(int pageSize, int page){
   List<Tbl_QLDTLT_Option> result = get_tbl_QLDTLT_OptionDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createTbl_QLDTLT_Option(Tbl_QLDTLT_Option obj){
       return _tbl_QLDTLT_OptionDao.save(obj);
   }

   public final void updateTbl_QLDTLT_Option(Tbl_QLDTLT_Option obj){
       _tbl_QLDTLT_OptionDao.update(obj);
   }//end update methode

   public final Tbl_QLDTLT_Option getTbl_QLDTLT_Option (Long id){
       log.info("Try to retrieve the tbl_QLDTLT_Option: "+id);
       return get_tbl_QLDTLT_OptionDao().get(id);
   }

   public void deleteTbl_QLDTLT_Option(Long id){
       log.info("Try to delete the Tbl_QLDTLT_Option by Id : "+ id);
       if(true){
	    _tbl_QLDTLT_OptionDao.delete(id);
       } else {
       	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       }
   }

   public void deleteListTbl_QLDTLT_Option(String[] listId){
       for(String id : listId){
   	    deleteTbl_QLDTLT_Option(Long.parseLong(id));
       }
   }

   public List<Tbl_QLDTLT_Option> findTbl_QLDTLT_OptionByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_QLDTLT_OptionDao.findByCondition(Tbl_QLDTLT_Option.class, cons, pageSize, page); 
   } 
 
   public int countTbl_QLDTLT_OptionByCondition(List<ConditionReport> cons){ 
       return _tbl_QLDTLT_OptionDao.countByCondition(Tbl_QLDTLT_Option.class, cons); 
   } 
 
public List<Object> findColumnTbl_QLDTLT_OptionByCondition( 
       List<ConditionReport> cons, List<String> columns, int pageSize, int page) { 
   return _tbl_QLDTLT_OptionDao.findColumnByCondition( 
		Tbl_QLDTLT_Option.class, cons, columns, pageSize, page); 
} 
public List<Tbl_QLDTLT_Option> queryHQLTbl_QLDTLT_Option( 
       String hql, int pageSize, int page) { 
   return _tbl_QLDTLT_OptionDao.queryHQL( hql, pageSize, page); 
} 
   public final Tbl_QLDTLT_OptionDAO get_tbl_QLDTLT_OptionDao() {
   	return _tbl_QLDTLT_OptionDao;
   }
   public final void set_tbl_QLDTLT_OptionDao(Tbl_QLDTLT_OptionDAO obj) {
   	this._tbl_QLDTLT_OptionDao = obj;
   }

   public Tbl_QLDTLT_OptionGroupDAO get_tbl_QLDTLT_OptionGroupDao() {
       return _tbl_QLDTLT_OptionGroupDao;
   }
   public void set_tbl_QLDTLT_OptionGroupDao(Tbl_QLDTLT_OptionGroupDAO _tbl_QLDTLT_OptionGroupDao) {
       this._tbl_QLDTLT_OptionGroupDao = _tbl_QLDTLT_OptionGroupDao;
   }

}//endclass

