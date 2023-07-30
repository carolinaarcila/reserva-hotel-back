package git.utp.primerproyecto.primerproyecto.web.controllers;

import git.utp.primerproyecto.primerproyecto.service.interfaces.RoomService;
import git.utp.primerproyecto.primerproyecto.web.dto.RoomDTO;
import git.utp.primerproyecto.primerproyecto.web.dto.UserDTO;
import git.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin({"*"})
@RestController
@RequestMapping("v1/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping()
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO){

        return new ResponseEntity<>(roomService.createRoom(roomDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<RoomDTO>> getAllRooms(){
        return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id){
        return new ResponseEntity<>(roomService.getRoomById(id), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDTO> updateRoom(@PathVariable Long id, @RequestBody RoomDTO roomDTO){
        return new ResponseEntity<>(roomService.updateRoom(id, roomDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<DeleteResponse> deleteRoom(@PathVariable Long id){
        DeleteResponse deleteResponse = roomService.deleteRoom(id);
        return new ResponseEntity<>(deleteResponse,HttpStatus.ACCEPTED);
    }


}
