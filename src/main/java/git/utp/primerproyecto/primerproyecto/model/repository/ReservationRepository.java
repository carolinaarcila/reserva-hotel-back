package git.utp.primerproyecto.primerproyecto.model.repository;

import git.utp.primerproyecto.primerproyecto.model.entities.ReservationEntity;
import git.utp.primerproyecto.primerproyecto.model.entities.ReservationPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, ReservationPk>{

}
