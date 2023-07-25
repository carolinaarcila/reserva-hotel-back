package git.utp.primerproyecto.primerproyecto.web.dto;

import git.utp.primerproyecto.primerproyecto.model.entities.UserPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.IdClass;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class UserDTO {
    private UserPK id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
}
