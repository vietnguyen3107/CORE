package com.lb.jwitter.core.hibernate;

import org.apache.commons.logging.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lb.jwitter.core.Tbl_Quyen_ChiTiet;
import com.lb.jwitter.core.Tbl_Quyen_Menu;
import com.lb.jwitter.core.Tbl_Quyen_NhomQuyen;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_Quyen_ChiTietDAO")
public class Tbl_Quyen_ChiTietHibernateDAO extends HibernateGenericDao<Tbl_Quyen_ChiTiet, Long> implements Tbl_Quyen_ChiTietDAO {
   private Log log = LogFactory.getLog(Tbl_Quyen_ChiTietHibernateDAO.class);

   @Autowired
   public Tbl_Quyen_ChiTietHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_Quyen_ChiTiet> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_Quyen_ChiTiet.class).list(); 
       return getSession().createCriteria(Tbl_Quyen_ChiTiet.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_Quyen_ChiTiet _newInstance) {
   	return super.save(_newInstance);
   }

//@Transactional
//   public final boolean exists(Long id) {
//       
//   	return super.exist(id);
//   }

@Transactional
   public Collection<Tbl_Quyen_ChiTiet> find(Tbl_Quyen_ChiTiet obj,int pageSize,int page){
   	Collection<Tbl_Quyen_ChiTiet> _tbl_Quyen_ChiTiets = new ArrayList<Tbl_Quyen_ChiTiet>();
   	try {
   		String sql = "select d from tbl_Quyen_ChiTiet as d where 1=1 ";
   sql += " and d.id = " + obj.getId() + " ";
   sql += " and d.Xem = " + obj.getXem() + " ";
   sql += " and d.Them = " + obj.getThem() + " ";
   sql += " and d.Xoa = " + obj.getXoa() + " ";
   sql += " and d.Sua = " + obj.getSua() + " ";
   sql += " and d.quyenId. = " + obj.getQuyenId().getId() + " ";
   sql += " and d.bangId. = " + obj.getBangId().getId() + " ";
   		sql += " order by d.id DESC ";
   		_tbl_Quyen_ChiTiets = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_Quyen_ChiTiets;
   }
   @Transactional
   public boolean checkRight(Long nhomQuyenId, String tableName, String right){

		Criteria critQ = getSession().createCriteria(Tbl_Quyen_NhomQuyen.class);
		critQ.add(Restrictions.eq("maNhomQuyen.id", nhomQuyenId));
		
		List<Tbl_Quyen_NhomQuyen> quyens = critQ.list();

		Criteria critQCT = getSession().createCriteria(Tbl_Quyen_ChiTiet.class);
		
		critQCT.createAlias("bangId", "b").add(Restrictions.eq("b.ten", tableName.toLowerCase()).ignoreCase());
		critQCT.add(Restrictions.eq(right, true));		
		
		Disjunction dis = Restrictions.disjunction();
		
		for(Tbl_Quyen_NhomQuyen q : quyens){
			
			dis.add(Restrictions.eq("quyenId.id", q.getMaQuyen().getId()));
		}

		critQCT.add(dis);
				
		if(critQCT.list() != null && critQCT.list().size() > 0)
			return true;
		else 
			return false;

   }

}//endclass
