/*
* $$Id$$
*/
package dyf.mycompany.DAO;

//import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

//import com.vaadin.data.hbnutil.HbnContainer;
//import dyf.mycompany.hbnContainer.*;
import com.vaadin.data.hbnutil.HbnContainer;

import dyf.mycompany.entity.MyEntity;

/**
* <p>Created 17.06.2009
* @author psamolisov extends HibernateDaoSupport
*/
public class EntityDao extends HibernateDaoSupport implements IEntityDao{

//public class EntityDao  implements IEntityDao//,HbnContainer.SessionManager
//{
//	 @Autowired
//	 	 private SessionFactory sessionFactory;
//	 	 @Override
//	 	 public SessionFactory getSessionFactory() {
//	 	 return sessionFactory;
//	 	 }
//	 	
//	 	 
//	 	 public void setSessionFactory(SessionFactory sessionFactory) {
//	 	 this.sessionFactory = sessionFactory;
//	 	 }
	 @Override
	 @Transactional(readOnly = false)
    public void save(MyEntity entity)
    {
//			if (sessionFactory==null){
//				System.err.println("sessionFactory=null");
//			}else{
//				System.err.println("sessionFactory=ok");			
//			}

			//sessionFactory.getCurrentSession().saveOrUpdate(entity);
		 //HbnContainer<MyEntity> c=new HbnContainer<MyEntity>(MyEntity.class,this);
        getHibernateTemplate().save(entity);
		 
    }


//	@Override
//	public Session getSession() {
//		// TODO Auto-generated method stub
//		if (sessionFactory==null){
//			System.err.println("sessionFactory=null");
//		}else{
//			System.err.println("sessionFactory=ok");			
//		}
//		return sessionFactory.getCurrentSession();
//	}



}