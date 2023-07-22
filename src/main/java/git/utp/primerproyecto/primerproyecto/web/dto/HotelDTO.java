package git.utp.primerproyecto.primerproyecto.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class HotelDTO {
    private Integer id;
    private String name;
    private String phoneNumber;
    private  String address;
    private  String email;
    private  Integer totalRooms;
    private  Integer reserveCapacity;
}
