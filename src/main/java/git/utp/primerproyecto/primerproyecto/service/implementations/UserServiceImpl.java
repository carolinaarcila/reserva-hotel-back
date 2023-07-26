package git.utp.primerproyecto.primerproyecto.service.implementations;

import git.utp.primerproyecto.primerproyecto.model.entities.UserEntity;
import git.utp.primerproyecto.primerproyecto.model.entities.UserPK;
import git.utp.primerproyecto.primerproyecto.model.repository.UserRepository;
import git.utp.primerproyecto.primerproyecto.service.interfaces.UserService;
import git.utp.primerproyecto.primerproyecto.web.dto.UserDTO;
import git.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;
import git.utp.primerproyecto.primerproyecto.web.exceptions.types.BadRequestException;
import git.utp.primerproyecto.primerproyecto.web.exceptions.types.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        userDTO.setRolId(2L);
        UserEntity getUser = userRepository.findById(userDTO.getId()).orElse(null);
        UserEntity userEmail = userRepository.findByEmail(userDTO.getEmail());

        if (userEmail != null) {
            throw new BadRequestException("El usuario con email " + userDTO.getEmail() +  " ya existe");
        }
        if(getUser ==null) {
            UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
            userEntity = userRepository.save(userEntity);
            return modelMapper.map(userEntity, UserDTO.class);
        }
        throw new BadRequestException("El usuario con documento " + userDTO.getId().getDocumentNumber() + "ya existe");
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(
                userEntity -> modelMapper.map(userEntity, UserDTO.class)
        ).collect(Collectors.toList());

    }

    @Override
    public UserDTO getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return modelMapper.map(userEntity, UserDTO.class);
    }


    @Override
    public UserDTO getUser(UserPK userPK) {
        UserEntity userEntity = userRepository.findById(userPK).orElse(null);
        return modelMapper.map(userEntity, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserPK id, UserDTO userDTO) {
        userDTO.setRolId(2L);
        UserEntity getUser = userRepository.findById(userDTO.getId()).orElse(null);

        if(getUser != null){
            UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
            userEntity = userRepository.save(userEntity);
            return modelMapper.map(userEntity, UserDTO.class);
        }
        throw new BadRequestException("El usuario con documento " + userDTO.getId().getDocumentNumber() +  " no existe");
    }

    @Override
    public DeleteResponse deleteUser(UserPK userPK) {
        try {
            userRepository.deleteById(userPK);

            return DeleteResponse.builder()
                    .message("El Usuario fue borrado con exito")
                    .status(true)
                    .build();

        }
        catch (EmptyResultDataAccessException ex) {
            throw new NotFoundException("El Usuario con el documento " + userPK.getDocumentNumber() +  " no se encuentra");
        }
    }

}
