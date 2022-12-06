package by.mk_jd2_92_22.pizzeria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManager entityManager;

    public EntityManagerUtil() {
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzeriaHibernate");

            return emf.createEntityManager();
        }
        return entityManager;
    }
}



//    private static final EntityManagerFactory emf;
//
//    static {
//        emf = Persistence.createEntityManagerFactory("PizzeriaHibernate");
//    }
//
//    public static EntityManager getEntityManager(){
//        return emf.createEntityManager();
//    }
//
//    public static void close(){
//        emf.close();
//    }
//}
