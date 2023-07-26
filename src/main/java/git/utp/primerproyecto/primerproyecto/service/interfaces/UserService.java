package git.utp.primerproyecto.primerproyecto.service.interfaces;

import git.utp.primerproyecto.primerproyecto.model.entities.UserPK;
import git.utp.primerproyecto.primerproyecto.web.dto.UserDTO;
import git.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUserByEmail(String email);

    UserDTO getUser(UserPK userPK);

    UserDTO updateUser(UserPK id, UserDTO userDTO);
    DeleteResponse deleteUser(UserPK userPK);
}
