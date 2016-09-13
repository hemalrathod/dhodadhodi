package in.hrsoftwares.hibernate;
// Generated 27 Aug, 2016 4:54:05 PM by Hibernate Tools 5.1.0.Beta1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class SalesByStore.
 * @see in.hrsoftwares.hibernate.SalesByStore
 * @author Hibernate Tools
 */
public class SalesByStoreHome {

	private static final Log log = LogFactory.getLog(SalesByStoreHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(SalesByStore transientInstance) {
		log.debug("persisting SalesByStore instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SalesByStore instance) {
		log.debug("attaching dirty SalesByStore instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SalesByStore instance) {
		log.debug("attaching clean SalesByStore instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SalesByStore persistentInstance) {
		log.debug("deleting SalesByStore instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SalesByStore merge(SalesByStore detachedInstance) {
		log.debug("merging SalesByStore instance");
		try {
			SalesByStore result = (SalesByStore) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SalesByStore findById(in.hrsoftwares.hibernate.SalesByStoreId id) {
		log.debug("getting SalesByStore instance with id: " + id);
		try {
			SalesByStore instance = (SalesByStore) sessionFactory.getCurrentSession()
					.get("in.hrsoftwares.hibernate.SalesByStore", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<SalesByStore> findByExample(SalesByStore instance) {
		log.debug("finding SalesByStore instance by example");
		try {
			List<SalesByStore> results = (List<SalesByStore>) sessionFactory.getCurrentSession()
					.createCriteria("in.hrsoftwares.hibernate.SalesByStore").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
