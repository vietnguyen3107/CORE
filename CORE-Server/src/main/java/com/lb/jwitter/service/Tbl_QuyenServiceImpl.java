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
import com.lb.jwitter.core.Tbl_Quyen;
import com.lb.jwitter.core.hibernate.Tbl_QuyenDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_QuyenService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_QuyenService")
public class Tbl_QuyenServiceImpl implements Tbl_QuyenService,Serializable {

   private Log log = LogFactory.getLog(Tbl_QuyenServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_QuyenDAO")
   private Tbl_QuyenDAO _tbl_QuyenDao;

   public final List<Tbl_Quyen> findAlltbl_Quyen(int pageSize, int page){
   List<Tbl_Quyen> result = get_tbl_QuyenDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createtbl_Quyen(Tbl_Quyen obj){
       return _tbl_QuyenDao.save(obj);
   }

   public final void updatetbl_Quyen(Tbl_Quyen obj){
       _tbl_QuyenDao.update(obj);
   }//end update methode

   public final Tbl_Quyen gettbl_Quyen (Long id){
       log.info("Try to retrieve the tbl_Quyen: "+id);
       return get_tbl_QuyenDao().get(id);
   }

   public void deletetbl_Quyen(Long id){
       log.info("Try to delete the tbl_Quyen by Id : "+ id);
       //if(_tbl_QuyenDao.exists(id)){
	    _tbl_QuyenDao.delete(id);
       //} else {
       //	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       //}
   }

   public void deleteListtbl_Quyen(String[] listId){
       for(String id : listId){
   	    deletetbl_Quyen(Long.parseLong(id));
       }
   }

   public List<Tbl_Quyen> findtbl_QuyenByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_QuyenDao.findByCondition(Tbl_Quyen.class, cons, pageSize, page); 
   } 
 
   public int counttbl_QuyenByCondition(List<ConditionReport> cons){ 
       return _tbl_QuyenDao.countByCondition(Tbl_Quyen.class, cons); 
   } 
 
   public final Tbl_QuyenDAO get_tbl_QuyenDao() {
   	return _tbl_QuyenDao;
   }
   public final void set_tbl_QuyenDao(Tbl_QuyenDAO obj) {
   	this._tbl_QuyenDao = obj;
   }

}//endclass

