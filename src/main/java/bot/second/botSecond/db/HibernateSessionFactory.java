package bot.second.botSecond.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Objects;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (Objects.isNull(sessionFactory)) {
            final StandardServiceRegistry standardServiceRegistry =
                    new StandardServiceRegistryBuilder().configure().build();
            try {
                sessionFactory = new MetadataSources(standardServiceRegistry)
                        .buildMetadata()
                        .buildSessionFactory();
            } catch (Exception exception) {
                StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
                throw exception;
            }
        }
        return sessionFactory;
    }
}
