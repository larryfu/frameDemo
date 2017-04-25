package cn.larry.Dao;


import cn.larry.entity.Projects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gzfu
 */

public class HibernateDaoUtil implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static SessionFactory sessionFactory;

    static {

        try {

            // Create the SessionFactory from hibernate.cfg.xml

            sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {

            // Make sure you log the exception, as it might be swallowed

            System.err.println("Initial SessionFactory creation failed." + ex);

            throw new ExceptionInInitializerError(ex);

        }

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    static Logger logger = LogManager.getLogger();

    public <E> E excute(DBTask<E> task) {
        E obj = null;
        Session ss = sessionFactory.openSession();
        //logger.debug("query session gotten");
        Transaction ts = ss.beginTransaction();
        //logger.debug("query transaction began");
        try {
            obj = task.excute(ss);
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
            //throw new QueryException();
        } finally {
            ss.close();
        }
        return obj;
    }

    public <E> List<E> excuteQueryStandby(QueryTask<E> task) {
        //logger.debug("query data in hibernatedaoutil start");
        List<E> obj = new ArrayList<>();
        Session ss = sessionFactory.openSession();
        //logger.debug("query session gotten");
        Transaction ts = ss.beginTransaction();
        //logger.debug("query transaction began");
        try {
            obj = task.excute(ss);
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
            //throw new QueryException();
        } finally {
            ss.close();
        }

        //logger.debug("query data in hibernatedaoutil complete");
        return obj;
    }

    public void excuteUpdateStandby(UpdateTask task) {
        Session ss = sessionFactory.openSession();
        Transaction ts = ss.beginTransaction();
        try {
            task.excute(ss);
            ss.flush();
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
            //throw new UpdateException();
        } finally {
            ss.close();
        }
    }

    private <E> List<E> excuteQuery(QueryTask<E> task) {
        //logger.debug("query data in hibernatedaoutil start");
        Session ss = sessionFactory.getCurrentSession();
        List<E> obj = task.excute(ss);
        return obj;
    }

    private void excuteUpdate(UpdateTask task) {
        Session ss = sessionFactory.getCurrentSession();
        task.excute(ss);
    }

    public <E> List<E> find(final String hql) {
        logger.debug("in hibernateDaoUtil find " + LocalTime.now());
        return excuteQueryStandby((ss) -> {
            logger.debug("in session execute  " + LocalTime.now());
            List<E> e = ss.createQuery(hql).list();
            logger.debug("finish session execute  " + LocalTime.now());
            return e;
        });
    }

    public <E> List<E> pageSearch(Class clas,int start,int amount){
        return excuteQueryStandby((ss)->{
            Criteria criteria =ss.createCriteria(clas);
            criteria.setFirstResult(start);
            criteria.setMaxResults(amount);
            return (List<E>)criteria.list();
        });
    }

    public void save(final Object obj) {
        excuteUpdate((ss) -> ss.save(obj));
    }

    public void update(final Object obj) {
        excuteUpdate((ss) -> ss.update(obj));
    }
    public void update(final String hql) {
        excuteUpdate((ss) -> ss.createQuery(hql).executeUpdate());
    }

    public void delete(final Object obj) {
        excuteUpdate((ss) -> ss.delete(obj));
    }

    public <E> List<E> SQLQuery(final String sql) {
        return excuteQuery((ss) -> ss.createSQLQuery(sql).list());
    }

    public void SQLUpdate(final String sql) {
        excuteUpdate(new UpdateTask() {
            @Override
            public void excute(Session ss) {
                ss.createSQLQuery(sql).executeUpdate();
            }
        });
    }
}
