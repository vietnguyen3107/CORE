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
import com.lb.jwitter.core.Tbl_CanBo;
import com.lb.jwitter.core.hibernate.Tbl_CanBoDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_CanBoService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_CanBoService")
public class Tbl_CanBoServiceImpl implements Tbl_CanBoService,Serializable {

   private Log log = LogFactory.getLog(Tbl_CanBoServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_CanBoDAO")
   private Tbl_CanBoDAO _tbl_CanBoDao;

   public final List<Tbl_CanBo> findAlltbl_CanBo(int pageSize, int page){
   List<Tbl_CanBo> result = get_tbl_CanBoDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createtbl_CanBo(Tbl_CanBo obj){
       return _tbl_CanBoDao.save(obj);
   }

   public final void updatetbl_CanBo(Tbl_CanBo obj){
       _tbl_CanBoDao.update(obj);
   }//end update methode

   public final Tbl_CanBo gettbl_CanBo (Long id){
       log.info("Try to retrieve the tbl_CanBo: "+id);
       return get_tbl_CanBoDao().get(id);
   }

   public void deletetbl_CanBo(Long id){
       log.info("Try to delete the tbl_CanBo by Id : "+ id);
       //if(_tbl_CanBoDao.exists(id)){
	    _tbl_CanBoDao.delete(id);
       //} else {
       //	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       //}
   }

   public void deleteListtbl_CanBo(String[] listId){
       for(String id : listId){
   	    deletetbl_CanBo(Long.parseLong(id));
       }
   }

   public List<Tbl_CanBo> findtbl_CanBoByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_CanBoDao.findByCondition(Tbl_CanBo.class, cons, pageSize, page); 
   } 

   public List<Tbl_CanBo> findtbl_CanBoByHQL(String hql,int pageSize,int page){ 
       return _tbl_CanBoDao.findByHQL(hql, pageSize, page);
   } 
 
   public int counttbl_CanBoByCondition(List<ConditionReport> cons){ 
       return _tbl_CanBoDao.countByCondition(Tbl_CanBo.class, cons); 
   } 
 
   public final Tbl_CanBoDAO get_tbl_CanBoDao() {
   	return _tbl_CanBoDao;
   }
   public final void set_tbl_CanBoDao(Tbl_CanBoDAO obj) {
   	this._tbl_CanBoDao = obj;
   }

}//endclass

