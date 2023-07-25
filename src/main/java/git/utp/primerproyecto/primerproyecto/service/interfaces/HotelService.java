package git.utp.primerproyecto.primerproyecto.service.interfaces;

import git.utp.primerproyecto.primerproyecto.web.dto.HotelDTO;
import git.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;

import java.util.List;

public interface HotelService {

    HotelDTO createHotel(HotelDTO hotelDTO);

    HotelDTO getHotel(Long id);

    HotelDTO updateHotel(Long id, HotelDTO hotelDTO);

    List<HotelDTO> getAllHotel();

    DeleteResponse deleteHotel(Long  id);

}
