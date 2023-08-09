package git.utp.primerproyecto.primerproyecto.service.implementations;

import git.utp.primerproyecto.primerproyecto.model.entities.ReservationEntity;
import git.utp.primerproyecto.primerproyecto.model.entities.ReservationPk;
import git.utp.primerproyecto.primerproyecto.model.repository.ReservationRepository;
import git.utp.primerproyecto.primerproyecto.service.interfaces.ReservationService;
import git.utp.primerproyecto.primerproyecto.web.dto.ReservationDTO;
import git.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;
import git.utp.primerproyecto.primerproyecto.web.exceptions.types.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        ReservationEntity reservationEntity = modelMapper.map(reservationDTO, ReservationEntity.class);
        reservationEntity = reservationRepository.save(reservationEntity);
        return modelMapper.map(reservationEntity, ReservationDTO.class);
    }


    @Override
    public List<ReservationDTO> getAllReservation() {
        List<ReservationEntity> reservationEntities = reservationRepository.findAll();
        return reservationEntities.stream().map(reservationEntity -> modelMapper.map(reservationEntity, ReservationDTO.class)
        ).collect(Collectors.toList());
    }

    public ReservationDTO getReservation(ReservationPk id) {
        ReservationEntity reservationEntity = reservationRepository.findById(id).orElse(null);
        return modelMapper.map(reservationEntity, ReservationDTO.class);
    }

    @Override
    public ReservationDTO updateReservation(ReservationPk id, ReservationDTO reservationDTO) {
       ReservationEntity existingReservation = reservationRepository.findById(id).orElseThrow(() -> new NotFoundException("La reservacion con el id: " + id + "no se encuentra"));

       modelMapper.map(reservationDTO, existingReservation);
       ReservationEntity updatedReservationEntity = reservationRepository.save(existingReservation);
       return modelMapper.map(updatedReservationEntity, ReservationDTO.class);
    }

    @Override
    public DeleteResponse deleteReservation(ReservationPk id) {
        try {
            reservationRepository.deleteById(id);
            return DeleteResponse.builder()
                    .message("La reservacion con el id: " + id + "ha sido eliminada")
                    .status(Boolean.TRUE)
                    .build();
        } catch (Exception e){
            throw new NotFoundException("La reservacion con el id: " + id + "no se encuentra");
        }

    }


}
