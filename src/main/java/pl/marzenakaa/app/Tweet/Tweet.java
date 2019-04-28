package pl.marzenakaa.app.Tweet;

import pl.marzenakaa.app.User.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name="tweets")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 160)
    private String text;

    private LocalDateTime created;

    @PrePersist
    public void prePersist(){
        created = LocalDateTime.now();
    }

    @ManyToOne
    private User user;

    public Tweet() {
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    //DO SPRAWDZENIA, czy dobrze działa
    public void setUser(User user) {
        this.user = user;
        user.getTweets().add(this);
    }
}
