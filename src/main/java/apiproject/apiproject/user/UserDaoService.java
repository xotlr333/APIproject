package apiproject.apiproject.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int count = 3;

    static { //DB에 데이터가 있다고 가정
        users.add(new User(1, "taesic", new Date()));
        users.add(new User(2, "gildong", new Date()));
        users.add(new User(3, "joy", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if(user.getId() == null){
            user.setId(++count);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
