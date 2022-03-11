package security.spring.security.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.spring.security.Modul.User;
import security.spring.security.Modul.UserType;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final List<User> userList;

    public UserController() {
        this.userList = List.of(
                new User(1, "Ali", UserType.Admin),
                new User(2, "Sardor", UserType.Student),
                new User(3, "Mariam", UserType.Student)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id")Integer id){
        return ResponseEntity.ok(userList.stream().filter(user -> user.getId().equals(id)));
    }
}
