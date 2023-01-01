package splitter;

import java.time.LocalDateTime;

public interface Split extends Comparable<Split> {
    LocalDateTime getEfctStDt();

    LocalDateTime getEfctFnsDt();

    void setEfctStDt(LocalDateTime efctStDt);

    void setEfctFnsDt(LocalDateTime efctFnsDt);
}
