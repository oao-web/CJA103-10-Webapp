package booking;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class BookingScheduleDAO {

    public void insert(BookingSchedule schedule) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(schedule);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("新增排程失敗", e);
        }
    }

    public List<BookingSchedule> findBySitter(Integer sitterId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                "FROM BookingSchedule WHERE sitterId = :sid",
                BookingSchedule.class
            ).setParameter("sid", sitterId).list();
        }
    }
}

