package dyf.mycompany.DAO;

import org.hibernate.SessionFactory;

import dyf.mycompany.entity.MyEntity;

public interface IEntityDao{
	public void save(MyEntity entity);
	public SessionFactory getSessionFactory();
}
