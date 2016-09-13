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
 * Home object for domain model class FilmCategory.
 * @see in.hrsoftwares.hibernate.FilmCategory
 * @author Hibernate Tools
 */
public class FilmCategoryHome {

	private static final Log log = LogFactory.getLog(FilmCategoryHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(FilmCategory transientInstance) {
		log.debug("persisting FilmCategory instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FilmCategory instance) {
		log.debug("attaching dirty FilmCategory instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FilmCategory instance) {
		log.debug("attaching clean FilmCategory instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FilmCategory persistentInstance) {
		log.debug("deleting FilmCategory instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FilmCategory merge(FilmCategory detachedInstance) {
		log.debug("merging FilmCategory instance");
		try {
			FilmCategory result = (FilmCategory) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FilmCategory findById(in.hrsoftwares.hibernate.FilmCategoryId id) {
		log.debug("getting FilmCategory instance with id: " + id);
		try {
			FilmCategory instance = (FilmCategory) sessionFactory.getCurrentSession()
					.get("in.hrsoftwares.hibernate.FilmCategory", id);
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

	public List<FilmCategory> findByExample(FilmCategory instance) {
		log.debug("finding FilmCategory instance by example");
		try {
			List<FilmCategory> results = (List<FilmCategory>) sessionFactory.getCurrentSession()
					.createCriteria("in.hrsoftwares.hibernate.FilmCategory").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
