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
import com.lb.jwitter.core.Tbl_Quyen_ChiTiet;
import com.lb.jwitter.core.hibernate.Tbl_DBTableDAO;
import com.lb.jwitter.core.hibernate.Tbl_QuyenDAO;
import com.lb.jwitter.core.hibernate.Tbl_Quyen_ChiTietDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_Quyen_ChiTietService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_Quyen_ChiTietService")
public class Tbl_Quyen_ChiTietServiceImpl implements Tbl_Quyen_ChiTietService,Serializable {

   private Log log = LogFactory.getLog(Tbl_Quyen_ChiTietServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_Quyen_ChiTietDAO")
   private Tbl_Quyen_ChiTietDAO _tbl_Quyen_ChiTietDao;

   @Autowired
   @Qualifier("tbl_QuyenDAO")
   private Tbl_QuyenDAO _tbl_QuyenDao;

   @Autowired
   @Qualifier("tbl_DBTableDAO")
   private Tbl_DBTableDAO _tbl_DBTableDao;

   public final List<Tbl_Quyen_ChiTiet> findAlltbl_Quyen_ChiTiet(int pageSize, int page){
   List<Tbl_Quyen_ChiTiet> result = get_tbl_Quyen_ChiTietDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createtbl_Quyen_ChiTiet(Tbl_Quyen_ChiTiet obj){
       return _tbl_Quyen_ChiTietDao.save(obj);
   }

   public final void updatetbl_Quyen_ChiTiet(Tbl_Quyen_ChiTiet obj){
       _tbl_Quyen_ChiTietDao.update(obj);
   }//end update methode

   public final Tbl_Quyen_ChiTiet gettbl_Quyen_ChiTiet (Long id){
       log.info("Try to retrieve the tbl_Quyen_ChiTiet: "+id);
       return get_tbl_Quyen_ChiTietDao().get(id);
   }

   public void deletetbl_Quyen_ChiTiet(Long id){
       log.info("Try to delete the tbl_Quyen_ChiTiet by Id : "+ id);
       //if(_tbl_Quyen_ChiTietDao.exists(id)){
	    _tbl_Quyen_ChiTietDao.delete(id);
       //} else {
       //	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       //}
   }

   public void deleteListtbl_Quyen_ChiTiet(String[] listId){
       for(String id : listId){
   	    deletetbl_Quyen_ChiTiet(Long.parseLong(id));
       }
   }

   public List<Tbl_Quyen_ChiTiet> findtbl_Quyen_ChiTietByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_Quyen_ChiTietDao.findByCondition(Tbl_Quyen_ChiTiet.class, cons, pageSize, page); 
   } 
 
   public int counttbl_Quyen_ChiTietByCondition(List<ConditionReport> cons){ 
       return _tbl_Quyen_ChiTietDao.countByCondition(Tbl_Quyen_ChiTiet.class, cons); 
   } 
   
   public boolean checkRight(Long nhomQuyenId, String tableName, String right){
	   
	   return _tbl_Quyen_ChiTietDao.checkRight(nhomQuyenId, tableName, right);
   }
   
   
   
   
   //************************************************************************************
 
   public final Tbl_Quyen_ChiTietDAO get_tbl_Quyen_ChiTietDao() {
   	return _tbl_Quyen_ChiTietDao;
   }
   public final void set_tbl_Quyen_ChiTietDao(Tbl_Quyen_ChiTietDAO obj) {
   	this._tbl_Quyen_ChiTietDao = obj;
   }

   public Tbl_QuyenDAO get_tbl_QuyenDao() {
       return _tbl_QuyenDao;
   }
   public void set_tbl_QuyenDao(Tbl_QuyenDAO _tbl_QuyenDao) {
       this._tbl_QuyenDao = _tbl_QuyenDao;
   }

   public Tbl_DBTableDAO get_tbl_DBTableDao() {
       return _tbl_DBTableDao;
   }
   public void set_tbl_DBTableDao(Tbl_DBTableDAO _tbl_DBTableDao) {
       this._tbl_DBTableDao = _tbl_DBTableDao;
   }

}//endclass

