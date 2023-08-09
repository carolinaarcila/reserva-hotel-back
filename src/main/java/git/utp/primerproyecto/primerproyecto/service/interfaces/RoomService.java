package git.utp.primerproyecto.primerproyecto.service.interfaces;

import git.utp.primerproyecto.primerproyecto.web.dto.RoomDTO;
import git.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;

import java.util.List;

public interface RoomService {

    RoomDTO createRoom(RoomDTO roomDTO);

    List<RoomDTO> getAllRooms();

    List<Object[]> getRoomsWhitHotelName();

    RoomDTO getRoomById(Long id);

    RoomDTO updateRoom(Long id, RoomDTO roomDTO);

    DeleteResponse deleteRoom(Long id);


}
