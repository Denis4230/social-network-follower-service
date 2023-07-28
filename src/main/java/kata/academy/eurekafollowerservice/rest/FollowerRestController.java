package kata.academy.eurekafollowerservice.rest;

import kata.academy.eurekafollowerservice.api.Response;
import kata.academy.eurekafollowerservice.feign.ProfileServiceFigenClient;
import kata.academy.eurekafollowerservice.model.entity.Follower;
import kata.academy.eurekafollowerservice.service.FollowerService;
import kata.academy.eurekafollowerservice.util.ApiValidationUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class FollowerRestController {

    private FollowerService followerService;
    private ProfileServiceFigenClient profileServiceFigenClient;



    @PostMapping("/{followingId}")
    public Response<Void> follow(@PathVariable @Positive Long followingId,
                                 @RequestParam @Positive Long userId){
        ApiValidationUtil.requireTrue(profileServiceFigenClient.existsByUserId(userId), String.format("Пользователя с userId %d нет в базе", userId));
        ApiValidationUtil.requireTrue(followerService.existsByFollowerIdAndUserId(followingId, userId), String.format("Пользователь с followingId %d уже подписан на пользователя с userId %d", followingId, userId));
        followerService.addFollower(new Follower(followingId, userId));
        return Response.ok();
    }
}
