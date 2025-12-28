package booking;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookingOrderDAO {

    /* 新增 */
    public void insert(BookingOrder order) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(order);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("新增訂單失敗", e);
        }
    }

    /* 修改 */
    public void update(BookingOrder order) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(order);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("修改訂單失敗", e);
        }
    }

    /* 查詢 */
    public BookingOrder findById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(BookingOrder.class, id);
        } catch (Exception e) {
            throw new RuntimeException("查詢訂單失敗", e);
        }
    }
}

