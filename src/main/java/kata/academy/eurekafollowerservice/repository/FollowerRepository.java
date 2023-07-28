package kata.academy.eurekafollowerservice.repository;

import kata.academy.eurekafollowerservice.model.entity.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {

    boolean existsByFollowerIdAndUserId(Long followerId, Long userId);
}
