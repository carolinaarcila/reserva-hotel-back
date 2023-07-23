package git.utp.primerproyecto.primerproyecto.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {

    @EmbeddedId
    private UserPK id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private  RolEntity rol;
}
