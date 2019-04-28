package pl.marzenakaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.marzenakaa.app.User.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
