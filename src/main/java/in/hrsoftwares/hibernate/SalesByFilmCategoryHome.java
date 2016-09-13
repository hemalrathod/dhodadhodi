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
 * Home object for domain model class SalesByFilmCategory.
 * @see in.hrsoftwares.hibernate.SalesByFilmCategory
 * @author Hibernate Tools
 */
public class SalesByFilmCategoryHome {

	private static final Log log = LogFactory.getLog(SalesByFilmCategoryHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(SalesByFilmCategory transientInstance) {
		log.debug("persisting SalesByFilmCategory instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SalesByFilmCategory instance) {
		log.debug("attaching dirty SalesByFilmCategory instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SalesByFilmCategory instance) {
		log.debug("attaching clean SalesByFilmCategory instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SalesByFilmCategory persistentInstance) {
		log.debug("deleting SalesByFilmCategory instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SalesByFilmCategory merge(SalesByFilmCategory detachedInstance) {
		log.debug("merging SalesByFilmCategory instance");
		try {
			SalesByFilmCategory result = (SalesByFilmCategory) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SalesByFilmCategory findById(in.hrsoftwares.hibernate.SalesByFilmCategoryId id) {
		log.debug("getting SalesByFilmCategory instance with id: " + id);
		try {
			SalesByFilmCategory instance = (SalesByFilmCategory) sessionFactory.getCurrentSession()
					.get("in.hrsoftwares.hibernate.SalesByFilmCategory", id);
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

	public List<SalesByFilmCategory> findByExample(SalesByFilmCategory instance) {
		log.debug("finding SalesByFilmCategory instance by example");
		try {
			List<SalesByFilmCategory> results = (List<SalesByFilmCategory>) sessionFactory.getCurrentSession()
					.createCriteria("in.hrsoftwares.hibernate.SalesByFilmCategory").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
