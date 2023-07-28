package kata.academy.eurekafollowerservice.feign.fallback;

import kata.academy.eurekafollowerservice.feign.ProfileServiceFigenClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProfileServiceFallbackFactory implements FallbackFactory<ProfileServiceFigenClient> {

    @Override
    public ProfileServiceFigenClient create(Throwable cause) {
        return new ProfileServiceFallback(cause);
    }
}
