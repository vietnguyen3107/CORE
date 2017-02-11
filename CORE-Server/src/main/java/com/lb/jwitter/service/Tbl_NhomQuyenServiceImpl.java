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
import com.lb.jwitter.core.Tbl_NhomQuyen;
import com.lb.jwitter.core.hibernate.Tbl_NhomQuyenDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_NhomQuyenService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_NhomQuyenService")
public class Tbl_NhomQuyenServiceImpl implements Tbl_NhomQuyenService,Serializable {

   private Log log = LogFactory.getLog(Tbl_NhomQuyenServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_NhomQuyenDAO")
   private Tbl_NhomQuyenDAO _tbl_NhomQuyenDao;

   public final List<Tbl_NhomQuyen> findAlltbl_NhomQuyen(int pageSize, int page){
   List<Tbl_NhomQuyen> result = get_tbl_NhomQuyenDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createtbl_NhomQuyen(Tbl_NhomQuyen obj){
       return _tbl_NhomQuyenDao.save(obj);
   }

   public final void updatetbl_NhomQuyen(Tbl_NhomQuyen obj){
       _tbl_NhomQuyenDao.update(obj);
   }//end update methode

   public final Tbl_NhomQuyen gettbl_NhomQuyen (Long id){
       log.info("Try to retrieve the tbl_NhomQuyen: "+id);
       return get_tbl_NhomQuyenDao().get(id);
   }

   public void deletetbl_NhomQuyen(Long id){
       log.info("Try to delete the tbl_NhomQuyen by Id : "+ id);
       //if(_tbl_NhomQuyenDao.exists(id)){
	    _tbl_NhomQuyenDao.delete(id);
       //} else {
       //	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       //}
   }

   public void deleteListtbl_NhomQuyen(String[] listId){
       for(String id : listId){
   	    deletetbl_NhomQuyen(Long.parseLong(id));
       }
   }

   public List<Tbl_NhomQuyen> findtbl_NhomQuyenByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_NhomQuyenDao.findByCondition(Tbl_NhomQuyen.class, cons, pageSize, page); 
   } 
 
   public int counttbl_NhomQuyenByCondition(List<ConditionReport> cons){ 
       return _tbl_NhomQuyenDao.countByCondition(Tbl_NhomQuyen.class, cons); 
   } 
 
   public final Tbl_NhomQuyenDAO get_tbl_NhomQuyenDao() {
   	return _tbl_NhomQuyenDao;
   }
   public final void set_tbl_NhomQuyenDao(Tbl_NhomQuyenDAO obj) {
   	this._tbl_NhomQuyenDao = obj;
   }

}//endclass

