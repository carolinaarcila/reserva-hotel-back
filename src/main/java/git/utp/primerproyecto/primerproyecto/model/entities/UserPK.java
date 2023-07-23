package git.utp.primerproyecto.primerproyecto.model.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Embeddable
public class UserPK implements Serializable{

    private  String documentType;
    private Integer documentNumber;
}
