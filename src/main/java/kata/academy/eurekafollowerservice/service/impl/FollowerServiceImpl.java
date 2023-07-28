package kata.academy.eurekafollowerservice.service.impl;

import kata.academy.eurekafollowerservice.feign.NotificationServiceFeignClient;
import kata.academy.eurekafollowerservice.model.entity.Follower;
import kata.academy.eurekafollowerservice.repository.FollowerRepository;
import kata.academy.eurekafollowerservice.service.FollowerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FollowerServiceImpl implements FollowerService {

    private FollowerRepository followerRepository;
    private NotificationServiceFeignClient notificationServiceFeignClient;


    @Override
    public void addFollower(Follower follower) {
        followerRepository.save(follower);
    }

    @Override
    public boolean existsByFollowerIdAndUserId(Long followerId, Long userId) {
        notificationServiceFeignClient.addNotification(String.format("User %d подписался на вас!", followerId), userId);
        return followerRepository.existsByFollowerIdAndUserId(followerId, userId);
    }
}
