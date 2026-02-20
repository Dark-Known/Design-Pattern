package Utils;

import java.time.Instant;

public interface TimeSource {

    public Instant now();
}
