package booking;

import java.time.LocalDate;

public class TestBooking {
    public static void main(String[] args) {

        BookingOrderDAO orderDAO = new BookingOrderDAO();
        BookingScheduleDAO scheduleDAO = new BookingScheduleDAO();

        BookingOrder order = new BookingOrder();
        order.setSitterId(1);
        order.setMemId(2);
        order.setPetId(11);
        order.setReservationFee(1200);
        order.setOrderStatus(0);

        orderDAO.insert(order);

        BookingSchedule schedule = new BookingSchedule();
        schedule.setSitterId(1);
        schedule.setDate(LocalDate.of(2025, 1, 10));
        schedule.setBookingStatus("222222222222220000000000111100000000000022222222");
        schedule.setBookingOrder(order);

        scheduleDAO.insert(schedule);
    }
}
