package dyf.mycompany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

//import dyf.mycompany.hbnContainer.*;
import com.vaadin.data.hbnutil.HbnContainer;

public class MyManager implements HbnContainer.SessionManager{
//  	 @Autowired
	 	 private SessionFactory sessionFactory;
//	 	 public SessionFactory getSessionFactory() {
//	 	 return sessionFactory;
//	 	 }
//	 	 public void setSessionFactory(SessionFactory sessionFactory) {
//	 	 this.sessionFactory = sessionFactory;
//	 	 }
	public MyManager(SessionFactory sf){
		this.sessionFactory=sf;
	}
		@Override
		//@Transactional(readOnly = true)
		public Session getSession() {
			// TODO Auto-generated method stub
			//sessionFactory.openSession();
			Session currentSession = sessionFactory.getCurrentSession();
			
	        if(!currentSession.getTransaction().isActive()) {
	            currentSession.beginTransaction();
	        }
	        return currentSession;		}
}
