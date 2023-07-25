package git.utp.primerproyecto.primerproyecto.model.repository;

import git.utp.primerproyecto.primerproyecto.model.entities.UserEntity;
import git.utp.primerproyecto.primerproyecto.model.entities.UserPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, UserPK> {
    UserEntity findByEmail(String email);

}
