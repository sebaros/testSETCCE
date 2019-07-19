
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class App {
    public static void main(String[] args) {
        Log log1 = new Log(new Date(), "prvi log");
        Log log2 = new Log(new Date(), "drugi log");
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(log1);
            session.save(log2);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List < Log > logs = session.createQuery("from Log", Log.class).list();
            logs.forEach(l -> System.out.println(l.toString()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}