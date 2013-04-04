package dyf.mycompany.services;

import dyf.mycompany.DAO.IEntityDao;
import dyf.mycompany.entity.MyEntity;

public interface IMyEntityService {
	public void saveEntity(MyEntity entity);
	public IEntityDao getDao();
	
}
