package bot.second.botSecond.db.crud;



import bot.second.botSecond.Entity.Master;
import bot.second.botSecond.Entity.MyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.*;



import java.util.List;

import static bot.second.botSecond.db.HibernateSessionFactory.getSessionFactory;

public class Crud_Impl implements CrudEntity{

    private static Session session;

    @Override
    public void createEntity(MyEntity entity) {
        SessionFactory sessionFactory = getSessionFactory();

        session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(entity);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List readEntity(MyEntity entity) {
        SessionFactory sessionFactory = getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from "+ entity.getClass().getSimpleName());
        List listEntities = query.list();

        session.getTransaction().commit();
        session.close();
        return listEntities;


    }

    @Override
    public void updateEntity(MyEntity entity) {

    }

    @Override
    public void deleteEntity(Master entity) {
        SessionFactory sessionFactory = getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();

        Master master = session.load(Master.class, entity.getId());
        session.delete(master);

        session.getTransaction().commit();
        session.close();
    }


}
