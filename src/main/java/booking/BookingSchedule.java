package booking;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "BOOKING_SCHEDULE")
public class BookingSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKING_SCHEDULE_ID")
    private Integer bookingScheduleId;

    @Column(name = "SITTER_ID")
    private Integer sitterId;

    @Column(name = "DATE")
    private LocalDate date;

    
    @Column(name = "BOOKING_STATUS", length = 48)
    private String bookingStatus;

    
    @ManyToOne
    @JoinColumn(name = "BOOKING_ORDER_ID")
    private BookingOrder bookingOrder;

    public Integer getSitterId() {
        return sitterId;
    }

    public void setSitterId(Integer sitterId) {
        this.sitterId = sitterId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public BookingOrder getBookingOrder() {
        return bookingOrder;
    }

    public void setBookingOrder(BookingOrder bookingOrder) {
        this.bookingOrder = bookingOrder;
    }

}

