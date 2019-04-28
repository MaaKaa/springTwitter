package pl.marzenakaa.app.User;

import org.hibernate.validator.constraints.Email;
import pl.marzenakaa.app.Tweet.Tweet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;

    @Column(unique = true)
    @NotNull
    @Email
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Tweet> tweets = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
}
