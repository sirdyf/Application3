package dyf.mycompany.services;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import dyf.mycompany.DAO.IEntityDao;
import dyf.mycompany.entity.MyEntity;

@Transactional(readOnly = false)
//@Component("test")
public class MyEntityService implements IMyEntityService
{
    private IEntityDao dao;
    public void setDao(IEntityDao dao)
    {
        this.dao = dao;
    }
    @Override
    public IEntityDao getDao(){
		if (dao==null){
			System.err.println("dao=null");
		}else{
			System.err.println("dao=ok");			
		}
    	return this.dao;
    }
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveEntity(MyEntity entity)
    {
        dao.save(entity);
    }
}