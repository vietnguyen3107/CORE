package com.lb.utils.orm.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lb.jwitter.core.Tbl_Menu;
import com.lb.jwitter.util.ConditionReport;

public abstract class HibernateGenericDao<T, PK extends Serializable> extends
		HibernateDaoSupport implements GenericDao<T, PK> {

	@Autowired
	public HibernateGenericDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	
	}
	
	@SuppressWarnings("unchecked")
	public final Class getType() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass()
				.getGenericSuperclass();
		return (Class) parameterizedType.getActualTypeArguments()[0];
	}

	
	/**
	 * @see com.lb.utils.orm.hibernate.GenericDao#update(java.lang.Object)
	 */
	public final void update(T o) {
		getHibernateTemplate().update(o);
	}

	/**
	 * {@inheritDoc}
	 */
	public final void delete(T o) {
		getHibernateTemplate().delete(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public final T get(PK id) {
		Object result = getHibernateTemplate().get(getType(), id);
		return result == null ? null : (T) result;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public final T load(PK id) {
		return (T) getHibernateTemplate().load(getType(), id);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public PK save(T newInstance) {
		
		return (PK) getHibernateTemplate().save(newInstance);
	}

	/**
	 * {@inheritDoc}
	 */
	public final void saveOrUpdate(T transientObject) {
		getHibernateTemplate().saveOrUpdate(transientObject);
	}
	public final void saveOrUpdateAll(Collection<T> transientObjects) {
		getHibernateTemplate().saveOrUpdateAll(transientObjects);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public final List findByPaginatedQuery(String query, int pageNumber, int nbPerPage) {
		return findByPaginatedQuery(query, pageNumber, nbPerPage,
				(Object[]) null);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public final List findByPaginatedQuery(String query, int pageNumber,
			int nbPerPage, Object value) {
		return findByPaginatedQuery(query, pageNumber, nbPerPage,
				new Object[] { value });
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public final List findByPaginatedQuery(final String query, final int pageNumber,
			final int nbPerPage, final Object[] values) {

		return (List) getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session) {
						Query queryObject = session.createQuery(query);

						if (values != null) {
							for (int i = 0; i < values.length; i++) {
								queryObject.setParameter(i, values[i]);
							}
						}

						queryObject.setFirstResult(pageNumber * nbPerPage);
						queryObject.setMaxResults(nbPerPage);

						return queryObject.list();
					}
				});
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public final void delete(PK persistentObjectPK) {
		T o = (T) getHibernateTemplate().load(getType(), persistentObjectPK);
		getHibernateTemplate().delete(o);
	}
    public final boolean exists(PK persistentObjectPK){
    	return getSession().createCriteria(getType()).setProjection(Projections.rowCount()).add(
                Restrictions.eq("id", persistentObjectPK)).uniqueResult().equals(new Long(1));
    	
    }
	private boolean isValidDate(String inDate) {

	    if (inDate == null)
	      return false;

	    //set the format to use as a constructor argument
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    
	    if (inDate.trim().length() != dateFormat.toPattern().length())
	      return false;

	    dateFormat.setLenient(false);
	    
	    try {
	      //parse the inDate parameter
	      dateFormat.parse(inDate.trim());
	    }
	    catch(Exception e){
			return false;
		}
	    return true;
	}
	
	
	public final List  findByCondition(Class cclass,List<ConditionReport> cons,int pageSize,int page){
	    String delimiter = "\\.";
	    
	    List<String> aliasList = new ArrayList<String>();
	    
	    String alias = "a";
	    
		Criteria criteria = getSession().createCriteria(cclass, alias);
		aliasList.add(alias);
		
		if(cons != null){
			for(ConditionReport con : cons){
				Object value1= con.getValue1();
				Object value2= con.getValue2();				
				if(con.getType() != null && con.getType().equals("date")){
					try{
						
					    DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
					    DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
					    
					    if(con.getValue1() != null && !con.getValue1().equals("") && isValidDate(con.getValue1().toString())){
						    Date temp1 = format1.parse(con.getValue1().toString());
							String dateStr1 = format2.format(temp1);
							Date startDate = format2.parse(dateStr1);	
							
							value1 = new Date(startDate.getTime());
					    }
						
					    if(con.getValue2() != null && !con.getValue2().equals("") && isValidDate(con.getValue2().toString())){
							Date temp2 = format1.parse(con.getValue2().toString());
							String dateStr2 = format2.format(temp2);
							Date endDate = format2.parse(dateStr2);
							value2 = new Date(endDate.getTime());
					    }
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
				String[] tbls= con.getCol().split(delimiter);
				int i =0;
				String curentAlias = alias;
				for( i = 0; i < tbls.length - 1 ; i++){
					if(i ==0){
						if(!aliasList.contains(tbls[i])){
							criteria.createCriteria(alias+ "." +tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					} else {
						if(!aliasList.contains(tbls[i])){
							criteria.createCriteria(tbls[i-1] + "." +tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					}
					curentAlias = tbls[i];
				}
				
				String property ="";
				if(tbls.length  > 1) property =  tbls[i];
				else property =  con.getCol();

				if(con.getOperator().equals("eq")){
					criteria.add(Restrictions.eq(curentAlias + "." +property, value1));
				}
				
				else if(con.getOperator().equals("like")){
					criteria.add(Restrictions.like(curentAlias + "." +property, value1).ignoreCase());
				}

				else if(con.getOperator().equals("ge")){
					criteria.add(Restrictions.ge(curentAlias + "." +property, value1));
				}//great than or equal
				
				else if(con.getOperator().equals("gt")){
					criteria.add(Restrictions.gt(curentAlias + "." +property, value1));
				}//great than
				
				else if(con.getOperator().equals("le")){
					criteria.add(Restrictions.le(curentAlias + "." +property, value1));
				}//less or equal
				
				else if(con.getOperator().equals("lt")){
					criteria.add(Restrictions.lt(curentAlias + "." +property, value1));
				}//less than
				
				else if(con.getOperator().equals("between")){
					criteria.add(Restrictions.between(curentAlias + "." +property, value1, value2));
					 
				}//between
				
				
				else if(con.getOperator().equals("in")){
					String[] temp = value1.toString().split(";");
					
					if(con.getType() != null){
						if(con.getType().equals("String")){
							criteria.add(Restrictions.in(curentAlias + "." +property, temp));
							
						}else if (con.getType().equals("Long")){
							
							Long[] ids = new Long[temp.length];
							for(int ii =0; ii < temp.length ; ii++){
								try{
									if(!temp[ii].equals(""))
										ids[ii] = new Long(temp[ii]);
								}catch (Exception e) {
									// TODO: handle exception
									e.printStackTrace();
								}
							}
							criteria.add(Restrictions.in(curentAlias + "." +property, ids));
							
						}else if (con.getType().equals("Double")){
							
							Double[] ids = new Double[temp.length];
							for(int ii =0; ii < temp.length ; ii++){
								try{
									if(!temp[ii].equals(""))
										ids[ii] = new Double(temp[ii]);
								}catch (Exception e) {
									// TODO: handle exception
									e.printStackTrace();
								}
							}
							criteria.add(Restrictions.in(curentAlias + "." +property, ids));
							
						}
					}
//					Object[] ids = new Object[temp.length];
//					for(int ii =0; ii < temp.length ; ii++){
//						try{
//							if(!temp[ii].equals(""))
//								ids[ii] = new Object(temp[ii]);
//						}catch (Exception e) {
//							// TODO: handle exception
//							e.printStackTrace();
//						}
//					}
//					
//					criteria.add(Restrictions.in(curentAlias + "." +property, ids));

				}//in list
				
				
				else if(con.getOperator().equals("ne")){
					criteria.add(Restrictions.ne(curentAlias + "." +property, value1));

				}//notEqual
				
				else if(con.getOperator().equals("isNull")){
					criteria.add(Restrictions.isNull(curentAlias + "." +property));

				}//isNull
				
				else if(con.getOperator().equals("isNotNull")){
					criteria.add(Restrictions.isNotNull(curentAlias + "." +property));

				}//isNotNull
				
				else if(con.getOperator().equals("max-obj")){
					DetachedCriteria maxQuery = DetachedCriteria.forClass( cclass, "maxRow" );
					maxQuery.setProjection( Projections.max(property) );
					
					criteria.add(Subqueries.propertyEq(curentAlias + "." +property, maxQuery));

				}//max
				
				else if(con.getOperator().equals("min-obj")){
					DetachedCriteria minQuery = DetachedCriteria.forClass( cclass, "minRow" );
					minQuery.setProjection( Projections.min(property) );
					
					criteria.add(Subqueries.propertyEq(curentAlias + "." +property, minQuery));
				}//min
				
			}//for

			///Order- distinct
			ProjectionList projList = Projections.projectionList();
			for(ConditionReport con : cons){
				String[] tbls= con.getCol().split(delimiter);

				int i =0;
				String curentAlias = alias;
				for( i = 0; i < tbls.length - 1 ; i++){
					if(i ==0){
						if(!aliasList.contains(tbls[i])){
							criteria.createCriteria(alias+ "." +tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					} else {
						if(!aliasList.contains(tbls[i])){
							criteria.createCriteria(tbls[i-1] + "." +tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					}
					curentAlias = tbls[i];
				}
				
				String property ="";
				if(tbls.length  > 1)
					property =  tbls[i];
				else
					property =  con.getCol();

				//order
				if(con.getOperator().equals("order")){
					if(con.getValue1().equals("asc"))
						criteria.addOrder( Order.asc(curentAlias + "." +property));
					else if(con.getValue1().equals("desc"))
						criteria.addOrder( Order.desc(curentAlias + "." +property));
				}
				//groupby
				else if(con.getOperator().equals("groupby")){
					projList.add(Projections.groupProperty(curentAlias + "." +property));
				}
				//projection
				else if(con.getOperator().equals("projection")){
					projList.add(Projections.property(curentAlias + "." +property));
				}
				//sum
				else if(con.getOperator().equals("sum")){
					projList.add(Projections.sum(curentAlias + "." +property));
				}
				//count
				else if(con.getOperator().equals("count")){
					projList.add(Projections.count(curentAlias + "." +property));
				}
				//max
				else if(con.getOperator().equals("max")){
					projList.add(Projections.max(curentAlias + "." +property));
				}
				//min
				else if(con.getOperator().equals("min")){
					projList.add(Projections.min(curentAlias + "." +property));
				}
				//avg
				else if(con.getOperator().equals("avg")){
					projList.add(Projections.avg(curentAlias + "." +property));
				}
			}//for
			
			if(projList.getLength() > 0)
				criteria.setProjection(projList);
		}//if
		
		if(pageSize == 0)
			return criteria.list();
		
		return criteria.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();

	}
	
	public final List  findColumnByCondition(Class cclass,List<ConditionReport> cons,List<String> columns, int pageSize,int page){
		return findByCondition(cclass, cons, pageSize, page);
//	    String delimiter = "\\.";
//	    
//	    List<String> aliasList = new ArrayList<String>();
//	    
//	    String alias = "a";
//	    
//		Criteria criteria = getSession().createCriteria(cclass, alias);
//		aliasList.add(alias);
//		
//		if(cons != null){
//			for(ConditionReport con : cons){
//				Object value1= con.getValue1();
//				Object value2= con.getValue2();				
//				if(con.getType() != null && con.getType().equals("date")){
//					try{
//						
//					    DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
//					    DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
//					    
//					    if(con.getValue1() != null && !con.getValue1().equals("") && isValidDate(con.getValue1().toString())){
//						    Date temp1 = format1.parse(con.getValue1().toString());
//							String dateStr1 = format2.format(temp1);
//							Date startDate = format2.parse(dateStr1);	
//							
//							value1 = new Date(startDate.getTime());
//					    }
//						
//					    if(con.getValue2() != null && !con.getValue2().equals("") && isValidDate(con.getValue2().toString())){
//							Date temp2 = format1.parse(con.getValue2().toString());
//							String dateStr2 = format2.format(temp2);
//							Date endDate = format2.parse(dateStr2);
//							value2 = new Date(endDate.getTime());
//					    }
//					}catch(Exception e){
//						e.printStackTrace();
//					}
//				}
//				
//				String[] tbls= con.getCol().split(delimiter);
//				int i =0;
//				String curentAlias = alias;
//				for( i = 0; i < tbls.length - 1 ; i++){
//					if(i ==0){
//						if(!aliasList.contains(tbls[i])){
//							criteria.createCriteria(alias+ "." +tbls[i], tbls[i]);
//							aliasList.add(tbls[i]);
//						}
//					} else {
//						if(!aliasList.contains(tbls[i])){
//							criteria.createCriteria(tbls[i-1] + "." +tbls[i], tbls[i]);
//							aliasList.add(tbls[i]);
//						}
//					}
//					curentAlias = tbls[i];
//				}
//				
//				String property ="";
//				if(tbls.length  > 1) property =  tbls[i];
//				else property =  con.getCol();
//
//				if(con.getOperator().equals("eq")){
//					criteria.add(Restrictions.eq(curentAlias + "." +property, value1));
//				}
//				
//				else if(con.getOperator().equals("like")){
//					criteria.add(Restrictions.like(curentAlias + "." +property, value1));
//				}
//
//				else if(con.getOperator().equals("ge")){
//					criteria.add(Restrictions.ge(curentAlias + "." +property, value1));
//				}//great than or equal
//				
//				else if(con.getOperator().equals("gt")){
//					criteria.add(Restrictions.gt(curentAlias + "." +property, value1));
//				}//great than
//				
//				else if(con.getOperator().equals("le")){
//					criteria.add(Restrictions.le(curentAlias + "." +property, value1));
//				}//less or equal
//				
//				else if(con.getOperator().equals("lt")){
//					criteria.add(Restrictions.lt(curentAlias + "." +property, value1));
//				}//less than
//				
//				else if(con.getOperator().equals("between")){
//					criteria.add(Restrictions.between(curentAlias + "." +property, value1, value2));
//					 
//				}//between
//				
//				
//				else if(con.getOperator().equals("in")){
//					String[] temp = value1.toString().split(";");
//					
//					if(con.getType() != null){
//						if(con.getType().equals("String")){
//							criteria.add(Restrictions.in(curentAlias + "." +property, temp));
//							
//						}else if (con.getType().equals("Long")){
//							
//							Long[] ids = new Long[temp.length];
//							for(int ii =0; ii < temp.length ; ii++){
//								try{
//									if(!temp[ii].equals(""))
//										ids[ii] = new Long(temp[ii]);
//								}catch (Exception e) {
//									// TODO: handle exception
//									e.printStackTrace();
//								}
//							}
//							criteria.add(Restrictions.in(curentAlias + "." +property, ids));
//							
//						}else if (con.getType().equals("Double")){
//							
//							Double[] ids = new Double[temp.length];
//							for(int ii =0; ii < temp.length ; ii++){
//								try{
//									if(!temp[ii].equals(""))
//										ids[ii] = new Double(temp[ii]);
//								}catch (Exception e) {
//									// TODO: handle exception
//									e.printStackTrace();
//								}
//							}
//							criteria.add(Restrictions.in(curentAlias + "." +property, ids));
//							
//						}
//					}
////					Object[] ids = new Object[temp.length];
////					for(int ii =0; ii < temp.length ; ii++){
////						try{
////							if(!temp[ii].equals(""))
////								ids[ii] = new Object(temp[ii]);
////						}catch (Exception e) {
////							// TODO: handle exception
////							e.printStackTrace();
////						}
////					}
////					
////					criteria.add(Restrictions.in(curentAlias + "." +property, ids));
//
//				}//in list
//				
//				else if(con.getOperator().equals("ne")){
//					criteria.add(Restrictions.ne(curentAlias + "." +property, value1));
//
//				}//notEqual
//				
//				else if(con.getOperator().equals("isNull")){
//					criteria.add(Restrictions.isNull(curentAlias + "." +property));
//
//				}//isNull
//				
//				else if(con.getOperator().equals("isNotNull")){
//					criteria.add(Restrictions.isNotNull(curentAlias + "." +property));
//
//				}//isNotNull
//				
//				else if(con.getOperator().equals("max")){
//					DetachedCriteria maxQuery = DetachedCriteria.forClass( cclass, "maxRow" );
//					maxQuery.setProjection( Projections.max(property) );
//					
//					criteria.add(Subqueries.propertyEq(curentAlias + "." +property, maxQuery));
//
//				}//max
//				
//				else if(con.getOperator().equals("min")){
//					DetachedCriteria minQuery = DetachedCriteria.forClass( cclass, "minRow" );
//					minQuery.setProjection( Projections.min(property) );
//					
//					criteria.add(Subqueries.propertyEq(curentAlias + "." +property, minQuery));
//				}//max
//				
//			}//for
//
//			for(ConditionReport con : cons){
//				String[] tbls= con.getCol().split(delimiter);
//
//				int i =0;
//				String curentAlias = alias;
//				for( i = 0; i < tbls.length - 1 ; i++){
//					if(i ==0){
//						if(!aliasList.contains(tbls[i])){
//							criteria.createCriteria(alias+ "." +tbls[i], tbls[i]);
//							aliasList.add(tbls[i]);
//						}
//					} else {
//						if(!aliasList.contains(tbls[i])){
//							criteria.createCriteria(tbls[i-1] + "." +tbls[i], tbls[i]);
//							aliasList.add(tbls[i]);
//						}
//					}
//					curentAlias = tbls[i];
//				}
//				
//				String property ="";
//				if(tbls.length  > 1)
//					property =  tbls[i];
//				else
//					property =  con.getCol();
//
//				if(con.getOperator().equals("order")){
//					if(con.getValue1().equals("asc"))
//						criteria.addOrder( Order.asc(curentAlias + "." +property));
//					else if(con.getValue1().equals("desc"))
//						criteria.addOrder( Order.desc(curentAlias + "." +property));
//				}
//			}//for
//		}//if
//		 ProjectionList proList = Projections.projectionList();
//		 for(String column : columns){
//			  proList.add(Projections.property(column));
//		 }
//		  criteria.setProjection(proList);
//		if(pageSize == 0)
//			return criteria.list();
//		
//		return criteria.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();

	}


	@SuppressWarnings("unchecked")
	public final Integer  countByCondition(Class cclass,List<ConditionReport> cons){
		String delimiter = "\\.";
	    
	    List<String> aliasList = new ArrayList<String>();
	    
	    String alias = "a";
	    
		Criteria criteria = getSession().createCriteria(cclass, alias);
		aliasList.add(alias);
		
		if(cons != null){
			for(ConditionReport con : cons){
				Object value1= con.getValue1();
				Object value2= con.getValue2();				
				if(con.getType() != null && con.getType().equals("date")){
					try{
						
					    DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
					    DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
					    
					    if(con.getValue1() != null && !con.getValue1().equals("") && isValidDate(con.getValue1().toString())){
						    Date temp1 = format1.parse(con.getValue1().toString());
							String dateStr1 = format2.format(temp1);
							Date startDate = format2.parse(dateStr1);	
							
							value1 = new Date(startDate.getTime());
					    }
						
					    if(con.getValue2() != null && !con.getValue2().equals("") && isValidDate(con.getValue2().toString())){
							Date temp2 = format1.parse(con.getValue2().toString());
							String dateStr2 = format2.format(temp2);
							Date endDate = format2.parse(dateStr2);
							value2 = new Date(endDate.getTime());
					    }
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
				String[] tbls= con.getCol().split(delimiter);
				int i =0;
				String curentAlias = alias;
				for( i = 0; i < tbls.length - 1 ; i++){
					if(i ==0){
						if(!aliasList.contains(tbls[i])){
							criteria.createCriteria(alias+ "." +tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					} else {
						if(!aliasList.contains(tbls[i])){
							criteria.createCriteria(tbls[i-1] + "." +tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					}
					curentAlias = tbls[i];
				}
				
				String property ="";
				if(tbls.length  > 1) property =  tbls[i];
				else property =  con.getCol();

				if(con.getOperator().equals("eq")){
					criteria.add(Restrictions.eq(curentAlias + "." +property, value1));
				}
				
				else if(con.getOperator().equals("like")){
					criteria.add(Restrictions.like(curentAlias + "." +property, value1));
				}

				else if(con.getOperator().equals("ge")){
					criteria.add(Restrictions.ge(curentAlias + "." +property, value1));
				}//great than or equal
				
				else if(con.getOperator().equals("gt")){
					criteria.add(Restrictions.gt(curentAlias + "." +property, value1));
				}//great than
				
				else if(con.getOperator().equals("le")){
					criteria.add(Restrictions.le(curentAlias + "." +property, value1));
				}//less or equal
				
				else if(con.getOperator().equals("lt")){
					criteria.add(Restrictions.lt(curentAlias + "." +property, value1));
				}//less than
				
				else if(con.getOperator().equals("between")){
					criteria.add(Restrictions.between(curentAlias + "." +property, value1, value2));

				}//between
				
//				else if(con.getOperator().equals("in")){
//					criteria.add(Restrictions.in(curentAlias + "." +property, value1));
//
//				}//notEqual
				
				else if(con.getOperator().equals("ne")){
					criteria.add(Restrictions.ne(curentAlias + "." +property, value1));

				}//notEqual
				
				else if(con.getOperator().equals("isNull")){
					criteria.add(Restrictions.isNull(curentAlias + "." +property));

				}//isNull
				
				else if(con.getOperator().equals("isNotNull")){
					criteria.add(Restrictions.isNotNull(curentAlias + "." +property));

				}//isNotNull
				
				else if(con.getOperator().equals("max")){
					DetachedCriteria maxQuery = DetachedCriteria.forClass( cclass, "maxRow" );
					maxQuery.setProjection( Projections.max(property) );
					
					criteria.add(Subqueries.propertyEq(curentAlias + "." +property, maxQuery));

				}//max
				
				else if(con.getOperator().equals("min")){
					DetachedCriteria minQuery = DetachedCriteria.forClass( cclass, "minRow" );
					minQuery.setProjection( Projections.min(property) );
					
					criteria.add(Subqueries.propertyEq(curentAlias + "." +property, minQuery));
				}//max
				
			}//for

		}//if

		criteria.setProjection(Projections.rowCount());
		
		Long result = new Long(criteria.uniqueResult().toString());
		if(result != null)
			return  result.intValue();
		else
			return 0;

	}
	
	
/*
 * cac ham chuc nang chua xai toi
 */
/*
	@SuppressWarnings("unchecked")
	public final Boolean  checkByCondition(Class cclass,List<ConditionReport> cons){
		String delimiter = "\\.";
	    
	    List<String> aliasList = new ArrayList<String>();
	    
	    String alias = "a";
	    
		Criteria criteria = getSession().createCriteria(cclass, alias);
		aliasList.add(alias);
		
		if(cons != null){
			for(ConditionReport con : cons){
				Object value1= con.getValue1();
				Object value2= con.getValue2();				
				if(con.getType() != null && con.getType().equals("date")){
					try{
						
					    DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
					    DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
					    
					    if(con.getValue1() != null && !con.getValue1().equals("") && isValidDate(con.getValue1().toString())){
						    Date temp1 = format1.parse(con.getValue1().toString());
							String dateStr1 = format2.format(temp1);
							Date startDate = format2.parse(dateStr1);	
							
							value1 = new Date(startDate.getTime());
					    }
						
					    if(con.getValue2() != null && !con.getValue2().equals("") && isValidDate(con.getValue2().toString())){
							Date temp2 = format1.parse(con.getValue2().toString());
							String dateStr2 = format2.format(temp2);
							Date endDate = format2.parse(dateStr2);
							value2 = new Date(endDate.getTime());
					    }
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
				String[] tbls= con.getCol().split(delimiter);
				int i =0;
				String curentAlias = alias;
				for( i = 0; i < tbls.length - 1 ; i++){
					if(i ==0){
						if(!aliasList.contains(tbls[i])){
							criteria.createCriteria(alias+ "." +tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					} else {
						if(!aliasList.contains(tbls[i])){
							criteria.createCriteria(tbls[i-1] + "." +tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					}
					curentAlias = tbls[i];
				}
				
				String property ="";
				if(tbls.length  > 1) property =  tbls[i];
				else property =  con.getCol();

				if(con.getOperator().equals("eq")){
					criteria.add(Restrictions.eq(curentAlias + "." +property, value1));
				}
				
				else if(con.getOperator().equals("like")){
					criteria.add(Restrictions.like(curentAlias + "." +property, value1));
				}

				else if(con.getOperator().equals("ge")){
					criteria.add(Restrictions.ge(curentAlias + "." +property, value1));
				}//great than or equal
				
				else if(con.getOperator().equals("gt")){
					criteria.add(Restrictions.gt(curentAlias + "." +property, value1));
				}//great than
				
				else if(con.getOperator().equals("le")){
					criteria.add(Restrictions.le(curentAlias + "." +property, value1));
				}//less or equal
				
				else if(con.getOperator().equals("lt")){
					criteria.add(Restrictions.lt(curentAlias + "." +property, value1));
				}//less than
				
				else if(con.getOperator().equals("between")){
					criteria.add(Restrictions.between(curentAlias + "." +property, value1, value2));

				}//between
				
//				else if(con.getOperator().equals("in")){
//					criteria.add(Restrictions.in(curentAlias + "." +property, value1));
//
//				}//notEqual
				
				else if(con.getOperator().equals("ne")){
					criteria.add(Restrictions.ne(curentAlias + "." +property, value1));

				}//notEqual
				
				else if(con.getOperator().equals("isNull")){
					criteria.add(Restrictions.isNull(curentAlias + "." +property));

				}//isNull
				
				else if(con.getOperator().equals("isNotNull")){
					criteria.add(Restrictions.isNotNull(curentAlias + "." +property));

				}//isNotNull
				
				else if(con.getOperator().equals("max")){
					DetachedCriteria maxQuery = DetachedCriteria.forClass( cclass, "maxRow" );
					maxQuery.setProjection( Projections.max(property) );
					
					criteria.add(Subqueries.propertyEq(curentAlias + "." +property, maxQuery));

				}//max
				
				else if(con.getOperator().equals("min")){
					DetachedCriteria minQuery = DetachedCriteria.forClass( cclass, "minRow" );
					minQuery.setProjection( Projections.min(property) );
					
					criteria.add(Subqueries.propertyEq(curentAlias + "." +property, minQuery));
				}//max
				
			}//for

		}//if

		criteria.setProjection(Projections.rowCount());
		
		int result = (Integer) criteria.uniqueResult();
		return result > 0 ? true: false;

	}
*/		
	
	
/*
	@SuppressWarnings("unchecked")
	public final Double  sumByCondition(Class cclass,List<ConditionReport> cons, String column){
		String delimiter = "\\.";
	    
	    List<String> aliasList = new ArrayList<String>();
	    
	    String alias = "a";
	    
		Criteria criteria = getSession().createCriteria(cclass, alias);
		aliasList.add(alias);
		
		if(cons != null){
			for(ConditionReport con : cons){
				Object value1= con.getValue1();
				Object value2= con.getValue2();				
				if(con.getType() != null && con.getType().equals("date")){
					try{
						
					    DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
					    DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
					    
					    if(con.getValue1() != null && !con.getValue1().equals("") && isValidDate(con.getValue1().toString())){
						    Date temp1 = format1.parse(con.getValue1().toString());
							String dateStr1 = format2.format(temp1);
							Date startDate = format2.parse(dateStr1);	
							
							value1 = new Date(startDate.getTime());
					    }
						
					    if(con.getValue2() != null && !con.getValue2().equals("") && isValidDate(con.getValue2().toString())){
							Date temp2 = format1.parse(con.getValue2().toString());
							String dateStr2 = format2.format(temp2);
							Date endDate = format2.parse(dateStr2);
							value2 = new Date(endDate.getTime());
					    }
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				
				String[] tbls= con.getCol().split(delimiter);
				int i =0;
				String curentAlias = alias;
				for( i = 0; i < tbls.length - 1 ; i++){
					if(i ==0){
						if(!aliasList.contains(tbls[i])){
							criteria.createCriteria(alias+ "." +tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					} else {
						if(!aliasList.contains(tbls[i])){
							criteria.createCriteria(tbls[i-1] + "." +tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					}
					curentAlias = tbls[i];
				}
				
				String property ="";
				if(tbls.length  > 1) property =  tbls[i];
				else property =  con.getCol();

				if(con.getOperator().equals("eq")){
					criteria.add(Restrictions.eq(curentAlias + "." +property, value1));
				}
				
				else if(con.getOperator().equals("like")){
					criteria.add(Restrictions.like(curentAlias + "." +property, value1));
				}

				else if(con.getOperator().equals("ge")){
					criteria.add(Restrictions.ge(curentAlias + "." +property, value1));
				}//great than or equal
				
				else if(con.getOperator().equals("gt")){
					criteria.add(Restrictions.gt(curentAlias + "." +property, value1));
				}//great than
				
				else if(con.getOperator().equals("le")){
					criteria.add(Restrictions.le(curentAlias + "." +property, value1));
				}//less or equal
				
				else if(con.getOperator().equals("lt")){
					criteria.add(Restrictions.lt(curentAlias + "." +property, value1));
				}//less than
				
				else if(con.getOperator().equals("between")){
					criteria.add(Restrictions.between(curentAlias + "." +property, value1, value2));

				}//between
				
//				else if(con.getOperator().equals("in")){
//					criteria.add(Restrictions.in(curentAlias + "." +property, value1));
//
//				}//notEqual
				
				else if(con.getOperator().equals("ne")){
					criteria.add(Restrictions.ne(curentAlias + "." +property, value1));

				}//notEqual
				
				else if(con.getOperator().equals("isNull")){
					criteria.add(Restrictions.isNull(curentAlias + "." +property));

				}//isNull
				
				else if(con.getOperator().equals("isNotNull")){
					criteria.add(Restrictions.isNotNull(curentAlias + "." +property));

				}//isNotNull
				
				else if(con.getOperator().equals("max")){
					DetachedCriteria maxQuery = DetachedCriteria.forClass( cclass, "maxRow" );
					maxQuery.setProjection( Projections.max(property) );
					
					criteria.add(Subqueries.propertyEq(curentAlias + "." +property, maxQuery));

				}//max
				
				else if(con.getOperator().equals("min")){
					DetachedCriteria minQuery = DetachedCriteria.forClass( cclass, "minRow" );
					minQuery.setProjection( Projections.min(property) );
					
					criteria.add(Subqueries.propertyEq(curentAlias + "." +property, minQuery));
				}//max
				
			}//for

		}//if

		criteria.setProjection(Projections.sum(column));
		
		return (Double) criteria.uniqueResult();

	}
	
*/
	
	
	
}