package git.utp.primerproyecto.primerproyecto.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class UserPK implements Serializable{

    private  String documentType;
    @Column(unique = true)
    private Long documentNumber;
}
