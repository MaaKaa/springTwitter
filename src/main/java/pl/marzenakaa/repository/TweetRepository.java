package pl.marzenakaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.marzenakaa.app.Tweet.Tweet;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    //Metoda, która wczyta wszystkie Tweety stworzone przez zadanego użytkownika:
    @Query(value = "select * from tweets where user_id=?1", nativeQuery = true)
    List<Tweet> findByUserId(Long id);

    @Query(value = "SELECT * FROM tweets ORDER BY created DESC", nativeQuery = true)
    List<Tweet> findAllLatest();
}
