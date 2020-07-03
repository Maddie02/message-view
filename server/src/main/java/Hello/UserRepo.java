package Hello;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    public User findByUsername(String username);
}
