package splitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SplitVo implements Split {
    private LocalDateTime efctStDt;
    private LocalDateTime efctFnsDt;

    public SplitVo(LocalDateTime efctStDt, LocalDateTime efctFnsDt) {
        this.efctStDt = efctStDt;
        this.efctFnsDt = efctFnsDt;
    }

    public SplitVo(String efctStDt, String efctFnsDt) {
        this(LocalDateTime.parse(efctStDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss")),
                LocalDateTime.parse(efctFnsDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
    }

    @Override
    public LocalDateTime getEfctStDt() {
        return efctStDt;
    }

    @Override
    public LocalDateTime getEfctFnsDt() {
        return efctFnsDt;
    }

    @Override
    public void setEfctStDt(LocalDateTime efctStDt) {
        this.efctStDt = efctStDt;
    }

    @Override
    public void setEfctFnsDt(LocalDateTime efctFnsDt) {
        this.efctFnsDt = efctFnsDt;
    }

    @Override
    public int compareTo(Split o) {
        if (o.getEfctStDt().isBefore(efctStDt)) {
            return 1;
        } else if (o.getEfctStDt().isAfter(efctStDt)) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return getEfctStDt() + " ~ " + getEfctFnsDt();
    }

}
