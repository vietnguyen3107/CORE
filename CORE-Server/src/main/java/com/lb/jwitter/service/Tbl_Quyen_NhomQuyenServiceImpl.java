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
import com.lb.jwitter.core.Tbl_Quyen_NhomQuyen;
import com.lb.jwitter.core.hibernate.Tbl_NhomQuyenDAO;
import com.lb.jwitter.core.hibernate.Tbl_QuyenDAO;
import com.lb.jwitter.core.hibernate.Tbl_Quyen_NhomQuyenDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_Quyen_NhomQuyenService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_Quyen_NhomQuyenService")
public class Tbl_Quyen_NhomQuyenServiceImpl implements Tbl_Quyen_NhomQuyenService,Serializable {

   private Log log = LogFactory.getLog(Tbl_Quyen_NhomQuyenServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_Quyen_NhomQuyenDAO")
   private Tbl_Quyen_NhomQuyenDAO _tbl_Quyen_NhomQuyenDao;

   @Autowired
   @Qualifier("tbl_QuyenDAO")
   private Tbl_QuyenDAO _tbl_QuyenDao;

   @Autowired
   @Qualifier("tbl_NhomQuyenDAO")
   private Tbl_NhomQuyenDAO _tbl_NhomQuyenDao;

   public final List<Tbl_Quyen_NhomQuyen> findAlltbl_Quyen_NhomQuyen(int pageSize, int page){
   List<Tbl_Quyen_NhomQuyen> result = get_tbl_Quyen_NhomQuyenDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createtbl_Quyen_NhomQuyen(Tbl_Quyen_NhomQuyen obj){
       return _tbl_Quyen_NhomQuyenDao.save(obj);
   }

   public final void updatetbl_Quyen_NhomQuyen(Tbl_Quyen_NhomQuyen obj){
       _tbl_Quyen_NhomQuyenDao.update(obj);
   }//end update methode

   public final Tbl_Quyen_NhomQuyen gettbl_Quyen_NhomQuyen (Long id){
       log.info("Try to retrieve the tbl_Quyen_NhomQuyen: "+id);
       return get_tbl_Quyen_NhomQuyenDao().get(id);
   }

   public void deletetbl_Quyen_NhomQuyen(Long id){
       log.info("Try to delete the tbl_Quyen_NhomQuyen by Id : "+ id);
       //if(_tbl_Quyen_NhomQuyenDao.exists(id)){
	    _tbl_Quyen_NhomQuyenDao.delete(id);
       //} else {
       //	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       //}
   }

   public void deleteListtbl_Quyen_NhomQuyen(String[] listId){
       for(String id : listId){
   	    deletetbl_Quyen_NhomQuyen(Long.parseLong(id));
       }
   }

   public List<Tbl_Quyen_NhomQuyen> findtbl_Quyen_NhomQuyenByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_Quyen_NhomQuyenDao.findByCondition(Tbl_Quyen_NhomQuyen.class, cons, pageSize, page); 
   } 
 
   public int counttbl_Quyen_NhomQuyenByCondition(List<ConditionReport> cons){ 
       return _tbl_Quyen_NhomQuyenDao.countByCondition(Tbl_Quyen_NhomQuyen.class, cons); 
   } 
 
   public final Tbl_Quyen_NhomQuyenDAO get_tbl_Quyen_NhomQuyenDao() {
   	return _tbl_Quyen_NhomQuyenDao;
   }
   public final void set_tbl_Quyen_NhomQuyenDao(Tbl_Quyen_NhomQuyenDAO obj) {
   	this._tbl_Quyen_NhomQuyenDao = obj;
   }

   public Tbl_QuyenDAO get_tbl_QuyenDao() {
       return _tbl_QuyenDao;
   }
   public void set_tbl_QuyenDao(Tbl_QuyenDAO _tbl_QuyenDao) {
       this._tbl_QuyenDao = _tbl_QuyenDao;
   }

   public Tbl_NhomQuyenDAO get_tbl_NhomQuyenDao() {
       return _tbl_NhomQuyenDao;
   }
   public void set_tbl_NhomQuyenDao(Tbl_NhomQuyenDAO _tbl_NhomQuyenDao) {
       this._tbl_NhomQuyenDao = _tbl_NhomQuyenDao;
   }

}//endclass

