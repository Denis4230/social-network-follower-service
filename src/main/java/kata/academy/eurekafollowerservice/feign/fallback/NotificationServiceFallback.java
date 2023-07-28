package kata.academy.eurekafollowerservice.feign.fallback;

import kata.academy.eurekafollowerservice.feign.NotificationServiceFeignClient;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.http.ResponseEntity;

public record NotificationServiceFallback(Throwable cause) implements NotificationServiceFeignClient {

    @Override
    public ResponseEntity<Void> addNotification(String text, Long recipientId) {
        throw new NoFallbackAvailableException("Сервис временно недоступен. Причина -> %s"
                .formatted(cause.getMessage()), cause);
    }

}
