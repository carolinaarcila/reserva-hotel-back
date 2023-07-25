package git.utp.primerproyecto.primerproyecto.web.controllers;

import git.utp.primerproyecto.primerproyecto.model.entities.UserPK;
import git.utp.primerproyecto.primerproyecto.service.interfaces.UserService;
import git.utp.primerproyecto.primerproyecto.web.dto.UserDTO;
import git.utp.primerproyecto.primerproyecto.web.dto.response.DeleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/user")
public class UserController {

   // private final UserService userService;

    @Autowired
    private UserService userService;

    //public  UserController(UserService userService){
   //     this.userService = userService;
    //}

    @PostMapping()
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email){
        UserDTO userDTO = userService.getUserByEmail(email);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/{tipo}/{numero}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String tipo, @PathVariable Long numero){
        UserPK userPK = new UserPK(tipo, numero);
        UserDTO userDTO = userService.getUser(userPK);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{tipo}/{numero}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable String tipo, @PathVariable Long numero, @RequestBody UserDTO userDTO){
        UserPK userPK = new UserPK(tipo, numero);
        return new ResponseEntity<>(userService.updateUser(userPK, userDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{tipo}/{numero}")
    public  ResponseEntity<DeleteResponse> deleteUser(@PathVariable String tipo, @PathVariable Long numero){
        UserPK userPK = new UserPK(tipo, numero);
        DeleteResponse deleteResponse = userService.deleteUser(userPK);
        return new ResponseEntity<>(deleteResponse,HttpStatus.ACCEPTED);
    }
}
