package git.utp.primerproyecto.primerproyecto.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Embeddable
@Table(name = "reservation")
public class ReservationEntity {

    @EmbeddedId
    private ReservationPk id;
    private Long holderDni;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reservationDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;
    private Integer numberOfRooms;


    @MapsId("idHotel")
    @OneToOne
    private HotelEntity hotel;

    @MapsId("idUser")
    @OneToOne
    private UserEntity user;

    @ManyToOne
    private HotelEntity habilitationCode;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<RoomEntity> rooms;

}
