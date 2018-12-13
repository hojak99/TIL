import Entity.Member;
import Entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        // EntityManagerFactory 는 딱 하나만 생성.
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        // 쓰레드끼리 서로 공유하면 안됨.
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Team team = new Team();
            team.setName("asd");

            entityManager.persist(team);

            Member member = new Member();
            member.setName("호장권");
            member.setTempId(team.getId());

            entityManager.persist(member);

            Member findMember = entityManager.find(Member.class, member.getId());
            Long teamId = findMember.getTempId();

            Team findTeam = entityManager.find(Team.class, teamId);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManagerFactory.close();
        }
    }
}
