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
import com.lb.jwitter.core.Tbl_Menu;
import com.lb.jwitter.core.hibernate.Tbl_MenuDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_MenuService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_MenuService")
public class Tbl_MenuServiceImpl implements Tbl_MenuService,Serializable {

   private Log log = LogFactory.getLog(Tbl_MenuServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_MenuDAO")
   private Tbl_MenuDAO _tbl_MenuDao;

   public final List<Tbl_Menu> findAlltbl_Menu(int pageSize, int page){
   List<Tbl_Menu> result = get_tbl_MenuDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createtbl_Menu(Tbl_Menu obj){
       return _tbl_MenuDao.save(obj);
   }

   public final void updatetbl_Menu(Tbl_Menu obj){
       _tbl_MenuDao.update(obj);
   }//end update methode

   public final Tbl_Menu gettbl_Menu (Long id){
       log.info("Try to retrieve the tbl_Menu: "+id);
       return get_tbl_MenuDao().get(id);
   }

   public void deletetbl_Menu(Long id){
       log.info("Try to delete the tbl_Menu by Id : "+ id);
       //if(_tbl_MenuDao.exists(id)){
	    _tbl_MenuDao.delete(id);
       //} else {
       //	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       //}
   }

   public void deleteListtbl_Menu(String[] listId){
       for(String id : listId){
   	    deletetbl_Menu(Long.parseLong(id));
       }
   }

   public List<Tbl_Menu> findtbl_MenuByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_MenuDao.findByCondition(Tbl_Menu.class, cons, pageSize, page); 
   } 
 
   public int counttbl_MenuByCondition(List<ConditionReport> cons){ 
       return _tbl_MenuDao.countByCondition(Tbl_Menu.class, cons); 
   } 
 
   public final Tbl_MenuDAO get_tbl_MenuDao() {
   	return _tbl_MenuDao;
   }
   public final void set_tbl_MenuDao(Tbl_MenuDAO obj) {
   	this._tbl_MenuDao = obj;
   }

}//endclass

