package git.utp.primerproyecto.primerproyecto.service.interfaces;

import git.utp.primerproyecto.primerproyecto.model.entities.ReservationPk;
import git.utp.primerproyecto.primerproyecto.web.dto.ReservationDTO;
import git.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;

import java.util.List;

public interface ReservationService {
    ReservationDTO createReservation(ReservationDTO reservationDTO);

    List<ReservationDTO> getAllReservation();

    ReservationDTO getReservation(ReservationPk id);

    ReservationDTO updateReservation(ReservationPk id, ReservationDTO reservationDTO);

    DeleteResponse deleteReservation(ReservationPk id);



}
