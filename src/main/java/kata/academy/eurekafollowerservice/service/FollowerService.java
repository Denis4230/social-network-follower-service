package kata.academy.eurekafollowerservice.service;

import kata.academy.eurekafollowerservice.model.entity.Follower;

public interface FollowerService {

    void addFollower(Follower follower);
    boolean existsByFollowerIdAndUserId(Long followerId, Long userId);

}
