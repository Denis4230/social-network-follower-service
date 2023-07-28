package kata.academy.eurekafollowerservice.feign;

import kata.academy.eurekafollowerservice.feign.fallback.ProfileServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.Positive;

@FeignClient(value = "eureka-profile-service", fallbackFactory = ProfileServiceFallbackFactory.class)
public interface ProfileServiceFigenClient {

    @GetMapping("/api/internal/v1/profile/{userId}/exists")
    Boolean existsByUserId(@PathVariable @Positive Long userId);
}
