package git.utp.primerproyecto.primerproyecto.service.implementations;

import git.utp.primerproyecto.primerproyecto.model.entities.HotelEntity;
import git.utp.primerproyecto.primerproyecto.model.repository.HotelRepository;
import git.utp.primerproyecto.primerproyecto.service.interfaces.HotelService;
import git.utp.primerproyecto.primerproyecto.web.dto.HotelDTO;
import git.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;
import git.utp.primerproyecto.primerproyecto.web.exceptions.types.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Builder
@NoArgsConstructor
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        if(hotelDTO.getName().isEmpty()) throw new BadRequestException("El nombre del hotel es requerido");
        if(hotelDTO.getPhoneNumber().isEmpty()) throw new BadRequestException("El numero de telefono del hotel es requerido");
        if(hotelDTO.getAddress().isEmpty()) throw new BadRequestException("La direccion del hotel es requerida");
        if(hotelDTO.getEmail().isEmpty()) throw new BadRequestException("El correo del hotel es requerido");
        if(hotelDTO.getTotalRooms().toString().isEmpty()) throw new BadRequestException("El total de habitaciones del hotel es requerido");
        if(hotelDTO.getReserveCapacity().toString().isEmpty()) throw new BadRequestException("La capacidad de resrva del hotel es requerido");


        HotelEntity hotelEntity = modelMapper.map(hotelDTO, HotelEntity.class);

        hotelEntity = hotelRepository.save(hotelEntity);

        return  modelMapper.map(hotelEntity, HotelDTO.class);

    }
    @Override
    public List<HotelDTO> getAllHotel() {
        List<HotelEntity> hotelEntities = hotelRepository.findAll();

        return hotelEntities.stream().map(hotelEntity -> modelMapper.map(hotelEntity, HotelDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public HotelDTO getHotel(Integer id) {
        HotelEntity hotelEntity = hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("El Hotel con el id: " + id + "no se encuentra"));
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }

    @Override
    public HotelDTO updateHotel(HotelDTO hotelDTO) {
        return null;
    }

    @Override
    public DeleteResponse deleteHotel(Integer id) {
        try {
            HotelEntity hotelEntity = hotelRepository.findById(id).get();
            hotelRepository.deleteById(id);
            return  modelMapper.map(hotelEntity, DeleteResponse.class);
        } catch (EmptyResultDataAccessException exception) {
            throw new EntityNotFoundException("El hotel con el id: " + id + "no se encuentra");
        }
    }


}
