package git.utp.primerproyecto.primerproyecto.model.repository;

import git.utp.primerproyecto.primerproyecto.model.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

}
