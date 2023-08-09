package git.utp.primerproyecto.primerproyecto.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Integer holderDni;
    private Date reservationDate;
    private Date startDate;
    private Date endDate;
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
