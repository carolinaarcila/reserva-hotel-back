package git.utp.primerproyecto.primerproyecto.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DeleteResponse {
    private String message;
    private  boolean status;
}
