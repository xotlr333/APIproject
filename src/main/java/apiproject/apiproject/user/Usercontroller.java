package apiproject.apiproject.user;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class Usercontroller {
    private UserDaoService service;

    //스프링 bean에 의존성주입하는 방법
    public Usercontroller(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrievellUsers(){
        return service.findAll();
    }

    // get 방식으로 pathvarible를 받으면 기본적으로 String 으로 반환한다.
    // 하지만 매개변수를 int로 할 경우 자동으로 형변환된다
    @GetMapping("/users/{id}")
    public User retrievelUser(@PathVariable int id){
        User user = service.findOne(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return user;

    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest() //현재 request
                .path("/{id}") //경로에 /{id} 추가
                .buildAndExpand(savedUser.getId()) //위에 선언한 변수의 값 지정
                .toUri(); //uri로 반환

        return ResponseEntity.created(location).build();
    }

}
