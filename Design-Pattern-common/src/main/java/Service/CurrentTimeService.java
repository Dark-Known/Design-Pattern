package Service;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CurrentTimeService {

    private final Clock clock;

    // Default constructor (uses system time)
    public CurrentTimeService() {
        this.clock = Clock.systemDefaultZone();
    }

    // Constructor for testing (inject mock clock)
    public CurrentTimeService(Clock clock) {
        this.clock = clock;
    }

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String getTimeStamp() {
        LocalDateTime now = LocalDateTime.now(clock);
        return now.format(FORMATTER);
    }

    public String getDate() {
        LocalDateTime now = LocalDateTime.now(clock);
        return now.toLocalDate().toString();
    }
}