package booking;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "BOOKING_ORDER")
public class BookingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKING_ORDER_ID")
    private Integer bookingOrderId;

    @Column(name = "SITTER_ID")
    private Integer sitterId;

    @Column(name = "MEM_ID")
    private Integer memId;

    @Column(name = "PET_ID")
    private Integer petId;

    @Column(name = "RESERVATION_FEE")
    private Integer reservationFee;

    @Column(name = "START_TIME")
    private LocalDateTime startTime;

    @Column(name = "END_TIME")
    private LocalDateTime endTime;

    // 0待執行 1執行中 2完成 3取消
    @Column(name = "ORDER_STATUS")
    private Integer orderStatus;

    @Column(name = "SITTER_RATING")
    private Integer sitterRating;

    @Column(name = "SITTER_REVIEW")
    private String sitterReview;

   
    @OneToMany(mappedBy = "bookingOrder", cascade = CascadeType.ALL)
    private List<BookingSchedule> schedules;

    public Integer getSitterId() {
        return sitterId;
    }

    public void setSitterId(Integer sitterId) {
        this.sitterId = sitterId;
    }

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getReservationFee() {
        return reservationFee;
    }

    public void setReservationFee(Integer reservationFee) {
        this.reservationFee = reservationFee;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

}

