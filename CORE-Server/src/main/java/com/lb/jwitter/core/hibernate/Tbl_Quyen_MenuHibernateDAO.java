package com.lb.jwitter.core.hibernate;

import org.apache.commons.logging.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

import com.lb.jwitter.core.Tbl_Quyen_Menu;
import com.lb.jwitter.core.Tbl_Quyen_NhomQuyen;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_Quyen_MenuDAO")
public class Tbl_Quyen_MenuHibernateDAO extends HibernateGenericDao<Tbl_Quyen_Menu, Long> implements Tbl_Quyen_MenuDAO {
   private Log log = LogFactory.getLog(Tbl_Quyen_MenuHibernateDAO.class);

   @Autowired
   public Tbl_Quyen_MenuHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_Quyen_Menu> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_Quyen_Menu.class).list(); 
       return getSession().createCriteria(Tbl_Quyen_Menu.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_Quyen_Menu _newInstance) {
   	return super.save(_newInstance);
   }

//@Transactional
//   public final boolean exists(Long id) {
//
//   	return super.exist(id);
//   }

@Transactional
   public Collection<Tbl_Quyen_Menu> find(Tbl_Quyen_Menu obj,int pageSize,int page){
   	Collection<Tbl_Quyen_Menu> _tbl_Quyen_Menus = new ArrayList<Tbl_Quyen_Menu>();
   	try {
   		String sql = "select d from tbl_Quyen_Menu as d where 1=1 ";
   sql += " and d.id = " + obj.getId() + " ";
   sql += " and d.ChoPhep = " + obj.getChoPhep() + " ";
   sql += " and d.menuId.id = " + obj.getMenuId().getId() + " ";
   sql += " and d.quyenId.id = " + obj.getQuyenId().getId() + " ";
   		sql += " order by d.id DESC ";
   		_tbl_Quyen_Menus = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_Quyen_Menus;
   }
   
   @Transactional
   public List<Tbl_Quyen_Menu> findByNhomQuyen(Long nhomQuyenId, int pageSize, int page){
	   

		Criteria critQ = getSession().createCriteria(Tbl_Quyen_NhomQuyen.class);
		critQ.add(Restrictions.eq("maNhomQuyen.id", nhomQuyenId));
		
		List<Tbl_Quyen_NhomQuyen> quyens = critQ.list();

		Criteria critQM = getSession().createCriteria(Tbl_Quyen_Menu.class);
		Disjunction dis = Restrictions.disjunction();
		
		for(Tbl_Quyen_NhomQuyen q : quyens){
			
			dis.add(Restrictions.eq("quyenId.id", q.getMaQuyen().getId()));
		}
		
		critQM.add(dis);
		
		critQM.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		critQM.createAlias("menuId","mn")
		.addOrder(Order.asc("mn.STT"));

        		
		if(pageSize == 0)
			return critQM.list();
		
		return critQM.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   }

}//endclass
