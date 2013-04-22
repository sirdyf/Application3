/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package dyf.mycompany;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dyf.mycompany.DAO.EntityDao;
import dyf.mycompany.entity.MyEntity;
import dyf.mycompany.services.IMyEntityService;
import dyf.mycompany.services.MyEntityService;
import dyf.mycompany.util.ApplicationHelper;
import dyf.mycompany.util.BaseApplication;
//import org.springframework.context.ApplicationContext;
import com.vaadin.data.hbnutil.HbnContainer;
//import dyf.mycompany.hbnContainer.*;
import com.vaadin.service.ApplicationContext;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;
import com.vaadin.ui.Label;

/**
 * Hello world!
 */
@SuppressWarnings("serial")
@Configurable ( preConstruction = true  )
@org.springframework.stereotype.Component ( value = "app" )
public class App extends BaseApplication 
{

//	public IMyEntityService getIMyEntityService(){
//		return this.serviceDYF;
//	}
//	public void setIMyEntityService(IMyEntityService _serv){
//		this.serviceDYF=_serv;
//	}

    /** hibernate 4.1.1.Final
     * @see com.vaadin.Application#init()
     */
	
	Table table;
	MyEntity entity;
	//HbnContainer.
	//EntityDao myDao;
	@Autowired
	private testForm myForm;
	HbnContainer<MyEntity> c;//=new HbnContainer(MyEntity.class,null);
//	void setmyForm(dyfForm df){
//		myForm=df;
//	}
//	dyfForm getmyForm(){
//		return myForm;
//	}
	
	private MyManager myManager;


	@Override
    public void init() {
    	myManager=new MyManager(myForm.getserviceDYF2().getDao().getSessionFactory());
        entity = new MyEntity();
        //myDao=new EntityDao(); 
        entity.setName("Dima4");
        myForm.getserviceDYF2().saveEntity(entity);
    	table=new Table("my table");
    	if (myForm==null) {
    		System.err.println("myForm=null");
    	}else{
    		System.err.println("myForm ok");
    		
    	}
    	//c= new HbnContainer(null,null);
    	/* Define the names and data types of columns.
    	 * The "default value" parameter is meaningless here. */
//    	table.addContainerProperty("First Name", String.class,  null);
//    	table.addContainerProperty("Last Name",  String.class,  null);
//    	table.addContainerProperty("Year",       Integer.class, null);
//
//    	/* Add a few items in the table. */
//    	table.addItem(new Object[] {
//    	    "Nicolaus","Copernicus",new Integer(1473)}, new Integer(1));
//    	table.addItem(new Object[] {
//    	    "Tycho",   "Brahe",     new Integer(1546)}, new Integer(2));
//    	table.addItem(new Object[] {
//    	    "Giordano","Bruno",     new Integer(1548)}, new Integer(3));
//    	table.addItem(new Object[] {
//    	    "Galileo", "Galilei",   new Integer(1564)}, new Integer(4));
//    	table.addItem(new Object[] {
//    	    "Johannes","Kepler",    new Integer(1571)}, new Integer(5));
//    	table.addItem(new Object[] {
//    	    "Isaac",   "Newton",    new Integer(1643)}, new Integer(6));
//    	HbnContainer<MyEntity> c=new HbnContainer<MyEntity>(MyEntity.class,myForm);
    	
    	//myForm.getserviceDYF2().saveEntity(entity);
    	c=new HbnContainer<MyEntity>(MyEntity.class,myManager);
    	if (c==null) {
    		System.err.println("container=null");
    	}else{
    		System.err.println("container ok");
    		
    	}
table.setContainerDataSource(c);//serviceDYF.getDao().getSessionFactory().getCurrentSession()));
    	
    	setMainWindow( new Window( "Vaadin application" ) );
        getMainWindow().addComponent( new Label("Hello World!"));
        getMainWindow().addComponent(table);
        
        //ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");//applicationContext.xml");
        //IMyEntityService serviceDYF = (IMyEntityService) ctx.getBean("entityService");
        
        //IMyEntityService 
        //serviceDYF = (IMyEntityService)
        	//ApplicationHelper.getApplicationContext().getBean("entityService",MyEntityService.class);
              
//if (serviceDYF2!=null){
//        serviceDYF2.saveEntity(entity);
//       }else{
//    	   System.err.println("serviceDYF error");
//       }
    }

}
