package git.utp.primerproyecto.primerproyecto.web.dto;

import git.utp.primerproyecto.primerproyecto.model.entities.ReservationPk;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDTO {


    private ReservationPk id;
    private Long holderDni;
    private LocalDateTime reservationDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer numberOfRooms;

}
