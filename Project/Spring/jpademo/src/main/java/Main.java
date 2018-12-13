import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        entityManagerFactory.close();

        System.out.println("hello world");
    }
}
