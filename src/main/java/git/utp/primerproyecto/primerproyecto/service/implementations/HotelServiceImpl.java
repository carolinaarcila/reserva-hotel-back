package git.utp.primerproyecto.primerproyecto.service.implementations;

import git.utp.primerproyecto.primerproyecto.model.entities.HotelEntity;
import git.utp.primerproyecto.primerproyecto.model.repository.HotelRepository;
import git.utp.primerproyecto.primerproyecto.service.interfaces.HotelService;
import git.utp.primerproyecto.primerproyecto.web.dto.HotelDTO;
import git.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;
import git.utp.primerproyecto.primerproyecto.web.exceptions.types.BadRequestException;
import git.utp.primerproyecto.primerproyecto.web.exceptions.types.NotFoundException;
import git.utp.primerproyecto.primerproyecto.web.exceptions.types.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
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
        validateHotelDTO(hotelDTO);


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
                .orElseThrow(() -> new NotFoundException("El Hotel con el id: " + id + "no se encuentra"));
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }

    @Override
    public HotelDTO updateHotel(Integer id, HotelDTO hotelDTO) {
        HotelEntity existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("El Hotel con el id: " + id + " no se encuentra"));

        modelMapper.map(hotelDTO, existingHotel);
        HotelEntity updatedHotelEntity = hotelRepository.save(existingHotel);
        return modelMapper.map(updatedHotelEntity, HotelDTO.class);
    }

    @Override
    public DeleteResponse deleteHotel(Integer id) {
        try {
            hotelRepository.deleteById(id);

            return DeleteResponse.builder()
                    .message("El hotel fue borrado con exito")
                    .status(true)
                    .build();

        } catch (EmptyResultDataAccessException ex) {
            throw new NotFoundException("El Hotel con el id " + id +  " no se encuentra");
        }
    }


    private void validateHotelDTO(HotelDTO hotelDTO) {
        if (Objects.isNull(hotelDTO.getName()) || hotelDTO.getName().isEmpty()) {
            throw new ValidationException("El nombre del Hotel es requerido");
        }
        if (Objects.isNull(hotelDTO.getPhoneNumber()) || hotelDTO.getPhoneNumber().isEmpty()) {
            throw new ValidationException("El número de teléfono del Hotel es requerido");
        }
        if (Objects.isNull(hotelDTO.getAddress()) || hotelDTO.getAddress().isEmpty()) {
            throw new ValidationException("El número de teléfono del Hotel es requerido");
        }
        if (Objects.isNull(hotelDTO.getAddress()) || hotelDTO.getAddress().isEmpty()) {
            throw new ValidationException("La direccion del Hotel es requerida");
        }
        if (Objects.isNull(hotelDTO.getEmail()) || hotelDTO.getEmail().isEmpty()) {
            throw new ValidationException("El correo del Hotel es requerido");
        }
        if (Objects.isNull(hotelDTO.getTotalRooms()) || hotelDTO.getTotalRooms().toString().isEmpty()) {
            throw new ValidationException("El total de habitaciones del Hotel es requerido");
        }
        if (Objects.isNull(hotelDTO.getReserveCapacity()) || hotelDTO.getReserveCapacity().toString().isEmpty()) {
            throw new ValidationException("La capacidad del Hotel es requerida");
        }
    }


}
