package kata.academy.eurekafollowerservice.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "followers", uniqueConstraints = {@UniqueConstraint(columnNames = {"followerId", "userId"})})
public class Follower {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Column(nullable = false)
    Long userId;

    @NotNull
    @Column(nullable = false)
    Long followerId;

    public Follower(Long followerId, Long userId) {
        this.userId = userId;
        this.followerId = followerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Follower follower)) return false;
        return id.equals(follower.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
