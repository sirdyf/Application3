package dyf.mycompany;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.vaadin.data.hbnutil.HbnContainer;
//import dyf.mycompany.hbnContainer.*;
//import com.vaadin.data.*;

import dyf.mycompany.services.IMyEntityService;

public class testForm
{
	@Autowired
	//public IMyEntityService serviceDYF;
	//@Resource(name="entityService")
	private IMyEntityService serviceDYF2;	//@AutoWired transient IMyEntityService serviceDYF;
    public void setserviceDYF2(IMyEntityService s){
    	this.serviceDYF2=s;
    }
    public IMyEntityService getserviceDYF2(){
    	return serviceDYF2;
    }
//	@Override
//	public Session getSession() {
//		if (serviceDYF2==null){
//			System.err.println("serviceDYF2=null");
//		}else{
//			System.err.println("serviceDYF2=null");			
//		}
//		// TODO Auto-generated method stub
//		Session s=serviceDYF2.getDao().getSessionFactory().getCurrentSession();
//		if (s==null){
//			System.err.println("s=null");
//		}else{
//			System.err.println("s=null");			
//		}
//		return s;
//		//return null;
//	}
}
