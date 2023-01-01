package splitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SplitVo implements Comparable<SplitVo> {
    private LocalDateTime efctStDt;
    private LocalDateTime efctFnsDt;
    private List<Split> splits;

    public SplitVo(LocalDateTime efctStDt, LocalDateTime efctFnsDt) {
        this.efctStDt = efctStDt;
        this.efctFnsDt = efctFnsDt;
        this.splits = new ArrayList<>();
    }

    public SplitVo(String efctStDt, String efctFnsDt) {
        this(LocalDateTime.parse(efctStDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss")),
                LocalDateTime.parse(efctFnsDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
    }

    public LocalDateTime getEfctStDt() {
        return efctStDt;
    }

    public LocalDateTime getEfctFnsDt() {
        return efctFnsDt;
    }

    public void setEfctStDt(LocalDateTime efctStDt) {
        this.efctStDt = efctStDt;
    }

    public void setEfctFnsDt(LocalDateTime efctFnsDt) {
        this.efctFnsDt = efctFnsDt;
    }

    public void add(Split split) {
        splits.add(split);
    }

    @Override
    public int compareTo(SplitVo o) {
        if (o.getEfctStDt().isBefore(efctStDt)) {
            return 1;
        } else if (o.getEfctStDt().isAfter(efctStDt)) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return getEfctStDt() + " ~ " + getEfctFnsDt() + " : " + splits;
    }

}
