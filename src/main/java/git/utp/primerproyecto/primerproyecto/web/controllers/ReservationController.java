package git.utp.primerproyecto.primerproyecto.web.controllers;


import git.utp.primerproyecto.primerproyecto.service.interfaces.ReservationService;
import git.utp.primerproyecto.primerproyecto.web.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin({"*"})
@RestController
@RequestMapping("v1/reservation")
public class ReservationController {

 @Autowired  ReservationService reservationService;


    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO){
        return new  ResponseEntity<>(reservationService.createReservation(reservationDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ReservationDTO>> getAllReservation(){
        return new ResponseEntity<>(reservationService.getAllReservation(), HttpStatus.OK);
    }






}
