package dyf.mycompany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;


import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.vaadin.data.hbnutil.ApplicationLogger;

public class DatabaseUtil
{
	private final static ApplicationLogger logger = new ApplicationLogger(DatabaseUtil.class);
	private final static SessionFactory sessionFactory;

	static
	{
		try
		{
			logger.trace("Initializing DatabaseUtil");

			final Configuration configuration = new Configuration();
			configuration.configure();

			final ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder();

			final ServiceRegistry serviceRegistry = serviceRegistryBuilder
					.applySettings(configuration.getProperties())
					.buildServiceRegistry();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch (Throwable e)
		{
			logger.error(e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory()
	{
		logger.executionTrace();
		
		if (!sessionFactory.getCurrentSession().getTransaction().isActive())
			sessionFactory.getCurrentSession().beginTransaction();
		
		return sessionFactory;
	}
}