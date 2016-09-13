package in.hrsoftwares.hibernate;
// Generated 27 Aug, 2016 4:54:05 PM by Hibernate Tools 5.1.0.Beta1

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Actor.
 * @see in.hrsoftwares.hibernate.Actor
 * @author Hibernate Tools
 */
public class ActorHome {

	private static final Log log = LogFactory.getLog(ActorHome.class);

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session s = sessionFactory.openSession();
	Transaction tx=null;

	

	public void persist(Actor transientInstance) {
		tx = s.beginTransaction();
		log.debug("persisting Actor instance");
		try {
			s.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Actor instance) {
		log.debug("attaching dirty Actor instance");
		try {
			s.saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Actor instance) {
		log.debug("attaching clean Actor instance");
		try {
			s.lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Actor persistentInstance) {
		log.debug("deleting Actor instance");
		try {
			s.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Actor merge(Actor detachedInstance) {
		tx=s.beginTransaction();
		log.debug("merging Actor instance");
		try {
			Actor result = (Actor) s.merge(detachedInstance);
			log.debug("merge successful");
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	public void update(Actor detachedInstance) {
		tx=s.beginTransaction();
		log.debug("updating Actor instance");
		try {
			s.update(detachedInstance);
			log.debug("merge successful");
			tx.commit();
			
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	public Actor findById(java.lang.Short id) {
		log.debug("getting Actor instance with id: " + id);
		try {
			Actor instance = (Actor) s.get("in.hrsoftwares.hibernate.Actor", id);
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

	public List<Actor> findByExample(Actor instance) {
		tx=s.beginTransaction();
		log.debug("finding Actor instance by example");
		try {
			List<Actor> results = (List<Actor>) s
					.createCriteria("in.hrsoftwares.hibernate.Actor").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
		finally{
			s.close();
		}
	}
	public List<Actor> findAll() {
		tx=s.beginTransaction();
		log.debug("finding Actor All");
		try {
			List<Actor> results = (List<Actor>) s.createCriteria(Actor.class).list();
					
			log.debug("find by example successful, result size: " + results.size());
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
		finally{
			s.close();
		}
	}
}
