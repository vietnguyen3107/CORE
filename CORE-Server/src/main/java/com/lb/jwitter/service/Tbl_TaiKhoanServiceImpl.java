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
import com.lb.jwitter.core.Tbl_TaiKhoan;
import com.lb.jwitter.core.hibernate.Tbl_CanBoDAO;
import com.lb.jwitter.core.hibernate.Tbl_NhomQuyenDAO;
import com.lb.jwitter.core.hibernate.Tbl_TaiKhoanDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_TaiKhoanService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_TaiKhoanService")
public class Tbl_TaiKhoanServiceImpl implements Tbl_TaiKhoanService,Serializable {

   private Log log = LogFactory.getLog(Tbl_TaiKhoanServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_TaiKhoanDAO")
   private Tbl_TaiKhoanDAO _tbl_TaiKhoanDao;

   @Autowired
   @Qualifier("tbl_NhomQuyenDAO")
   private Tbl_NhomQuyenDAO _tbl_NhomQuyenDao;

   @Autowired
   @Qualifier("tbl_CanBoDAO")
   private Tbl_CanBoDAO _tbl_CanBoDao;

   public final List<Tbl_TaiKhoan> findAlltbl_TaiKhoan(int pageSize, int page){
   List<Tbl_TaiKhoan> result = get_tbl_TaiKhoanDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createtbl_TaiKhoan(Tbl_TaiKhoan obj){
       return _tbl_TaiKhoanDao.save(obj);
   }

   public final void updatetbl_TaiKhoan(Tbl_TaiKhoan obj){
       _tbl_TaiKhoanDao.update(obj);
   }//end update methode

   public final Tbl_TaiKhoan gettbl_TaiKhoan (Long id){
       log.info("Try to retrieve the tbl_TaiKhoan: "+id);
       return get_tbl_TaiKhoanDao().get(id);
   }

   public void deletetbl_TaiKhoan(Long id){
       log.info("Try to delete the tbl_TaiKhoan by Id : "+ id);
       //if(_tbl_TaiKhoanDao.exists(id)){
	    _tbl_TaiKhoanDao.delete(id);
       //} else {
       //	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       //}
   }

   public void deleteListtbl_TaiKhoan(String[] listId){
       for(String id : listId){
   	    deletetbl_TaiKhoan(Long.parseLong(id));
       }
   }

   public List<Tbl_TaiKhoan> findtbl_TaiKhoanByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_TaiKhoanDao.findByCondition(Tbl_TaiKhoan.class, cons, pageSize, page); 
   } 
 
   public int counttbl_TaiKhoanByCondition(List<ConditionReport> cons){ 
       return _tbl_TaiKhoanDao.countByCondition(Tbl_TaiKhoan.class, cons); 
   } 
 
   public final Tbl_TaiKhoanDAO get_tbl_TaiKhoanDao() {
   	return _tbl_TaiKhoanDao;
   }
   public final void set_tbl_TaiKhoanDao(Tbl_TaiKhoanDAO obj) {
   	this._tbl_TaiKhoanDao = obj;
   }

   public Tbl_NhomQuyenDAO get_tbl_NhomQuyenDao() {
       return _tbl_NhomQuyenDao;
   }
   public void set_tbl_NhomQuyenDao(Tbl_NhomQuyenDAO _tbl_NhomQuyenDao) {
       this._tbl_NhomQuyenDao = _tbl_NhomQuyenDao;
   }

   public Tbl_CanBoDAO get_tbl_CanBoDao() {
       return _tbl_CanBoDao;
   }
   public void set_tbl_CanBoDao(Tbl_CanBoDAO _tbl_CanBoDao) {
       this._tbl_CanBoDao = _tbl_CanBoDao;
   }

}//endclass

