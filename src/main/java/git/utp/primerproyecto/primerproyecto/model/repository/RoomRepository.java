package git.utp.primerproyecto.primerproyecto.model.repository;

import git.utp.primerproyecto.primerproyecto.model.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository  extends JpaRepository<RoomEntity, Long> {
    RoomEntity findByRoomNumber(Long roomNumber);

    @Query("SELECT r.id, r.beadsNumber, r.price, r.roomNumber, r.roomType, h.name  " +
            "FROM RoomEntity r" +
            "JOIN r.hotel h")
    List<Object[]> getRoomsWhitHotelName();
}
