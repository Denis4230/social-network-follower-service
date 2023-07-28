package kata.academy.eurekafollowerservice.feign.fallback;

import kata.academy.eurekafollowerservice.feign.ProfileServiceFigenClient;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;

public record ProfileServiceFallback(Throwable cause) implements ProfileServiceFigenClient {
    @Override
    public Boolean existsByUserId(Long userId) {
        throw new NoFallbackAvailableException("Сервис временно недоступен. Причина -> %s"
                .formatted(cause.getMessage()), cause);
    }
}
