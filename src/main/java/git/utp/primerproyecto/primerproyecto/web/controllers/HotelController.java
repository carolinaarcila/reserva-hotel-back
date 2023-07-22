package git.utp.primerproyecto.primerproyecto.web.controllers;

import git.utp.primerproyecto.primerproyecto.service.interfaces.HotelService;
import git.utp.primerproyecto.primerproyecto.web.dto.HotelDTO;
import git.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/hotel")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @PostMapping("/")
    public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO){

        return new ResponseEntity<>(hotelService.createHotel(hotelDTO), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<HotelDTO> getHotel(@PathVariable Integer id){
        return new ResponseEntity<>(hotelService.getHotel(id), HttpStatus.FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<List<HotelDTO>> getAllHotel(){
        return new ResponseEntity<>(hotelService.getAllHotel(), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public HotelDTO updateHotel(@RequestParam Integer id, @RequestBody HotelDTO hotelDTO) { return null; }

    @DeleteMapping("/{id}")
    public  ResponseEntity<DeleteResponse> deleteHotel(@PathVariable Integer id){
        DeleteResponse deleted =hotelService.deleteHotel(id);

        return new ResponseEntity<>(hotelService.deleteHotel(id), HttpStatus.NO_CONTENT);

    }

}
