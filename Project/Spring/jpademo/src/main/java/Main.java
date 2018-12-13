import Entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("호장권");

            entityManager.persist(member);

            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            entityManagerFactory.close();
        }

        System.out.println("hello world");
    }
}
