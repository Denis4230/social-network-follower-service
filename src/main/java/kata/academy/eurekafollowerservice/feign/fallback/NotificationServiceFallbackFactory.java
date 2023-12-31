package kata.academy.eurekafollowerservice.feign.fallback;

import kata.academy.eurekafollowerservice.feign.NotificationServiceFeignClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class NotificationServiceFallbackFactory implements FallbackFactory<NotificationServiceFeignClient> {
    @Override
    public NotificationServiceFeignClient create(Throwable cause) {
        return new NotificationServiceFallback(cause);
    }
}
