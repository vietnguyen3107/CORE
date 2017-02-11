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
import com.lb.jwitter.core.Tbl_Quyen_Menu;
import com.lb.jwitter.core.hibernate.Tbl_MenuDAO;
import com.lb.jwitter.core.hibernate.Tbl_QuyenDAO;
import com.lb.jwitter.core.hibernate.Tbl_Quyen_MenuDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_Quyen_MenuService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_Quyen_MenuService")
public class Tbl_Quyen_MenuServiceImpl implements Tbl_Quyen_MenuService,Serializable {

   private Log log = LogFactory.getLog(Tbl_Quyen_MenuServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_Quyen_MenuDAO")
   private Tbl_Quyen_MenuDAO _tbl_Quyen_MenuDao;

   @Autowired
   @Qualifier("tbl_MenuDAO")
   private Tbl_MenuDAO _tbl_MenuDao;

   @Autowired
   @Qualifier("tbl_QuyenDAO")
   private Tbl_QuyenDAO _tbl_QuyenDao;

   public final List<Tbl_Quyen_Menu> findAlltbl_Quyen_Menu(int pageSize, int page){
   List<Tbl_Quyen_Menu> result = get_tbl_Quyen_MenuDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createtbl_Quyen_Menu(Tbl_Quyen_Menu obj){
       return _tbl_Quyen_MenuDao.save(obj);
   }

   public final void updatetbl_Quyen_Menu(Tbl_Quyen_Menu obj){
       _tbl_Quyen_MenuDao.update(obj);
   }//end update methode

   public final Tbl_Quyen_Menu gettbl_Quyen_Menu (Long id){
       log.info("Try to retrieve the tbl_Quyen_Menu: "+id);
       return get_tbl_Quyen_MenuDao().get(id);
   }

   public void deletetbl_Quyen_Menu(Long id){
       log.info("Try to delete the tbl_Quyen_Menu by Id : "+ id);
       //if(_tbl_Quyen_MenuDao.exists(id)){
	    _tbl_Quyen_MenuDao.delete(id);
       //} else {
       //	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       //}
   }

   public void deleteListtbl_Quyen_Menu(String[] listId){
       for(String id : listId){
   	    deletetbl_Quyen_Menu(Long.parseLong(id));
       }
   }

   public List<Tbl_Quyen_Menu> findtbl_Quyen_MenuByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_Quyen_MenuDao.findByCondition(Tbl_Quyen_Menu.class, cons, pageSize, page); 
   } 
 
   public int counttbl_Quyen_MenuByCondition(List<ConditionReport> cons){ 
       return _tbl_Quyen_MenuDao.countByCondition(Tbl_Quyen_Menu.class, cons); 
   } 
   
   public List<Tbl_Quyen_Menu> findtbl_Quyen_MenuByNhomQuyen(Long nhomQuyenId, int pageSize, int page){
	   return _tbl_Quyen_MenuDao.findByNhomQuyen(nhomQuyenId, pageSize, page);    
   }
 
   public final Tbl_Quyen_MenuDAO get_tbl_Quyen_MenuDao() {
   	return _tbl_Quyen_MenuDao;
   }
   public final void set_tbl_Quyen_MenuDao(Tbl_Quyen_MenuDAO obj) {
   	this._tbl_Quyen_MenuDao = obj;
   }

   public Tbl_MenuDAO get_tbl_MenuDao() {
       return _tbl_MenuDao;
   }
   public void set_tbl_MenuDao(Tbl_MenuDAO _tbl_MenuDao) {
       this._tbl_MenuDao = _tbl_MenuDao;
   }

   public Tbl_QuyenDAO get_tbl_QuyenDao() {
       return _tbl_QuyenDao;
   }
   public void set_tbl_QuyenDao(Tbl_QuyenDAO _tbl_QuyenDao) {
       this._tbl_QuyenDao = _tbl_QuyenDao;
   }

}//endclass

