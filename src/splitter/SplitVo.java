package splitter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SplitVo implements Comparable<SplitVo> {
    private LocalDateTime efctStDt;
    private LocalDateTime efctFnsDt;
    private List<Split> splits;

    public SplitVo(LocalDateTime efctStDt) {
        this.efctStDt = efctStDt;
        this.splits = new ArrayList<>();
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

    // 시작일 동일 || 이전 && 종료일 동일 || 이후
    // no split
    @Deprecated
    public boolean isCase1(Split split) {
        return (split.getEfctStDt().isEqual(getEfctStDt())
                || split.getEfctStDt().isBefore(getEfctStDt()))
                && (split.getEfctFnsDt().isEqual(getEfctFnsDt()) || split.getEfctFnsDt().isAfter(getEfctFnsDt()));
    }

    // 시작일 이후 && 종료일 이전
    // 3 split before and after
    @Deprecated
    public boolean isCase2(Split split) {
        return split.getEfctStDt().isAfter(getEfctStDt()) && split.getEfctFnsDt().isBefore(getEfctFnsDt());
    }

    // 시작일 동일 || 이전 && 종료일 이전
    // 2 split after
    @Deprecated
    public boolean isCase3(Split split) {
        return (split.getEfctStDt().isEqual(getEfctStDt())
                || split.getEfctStDt().isBefore(getEfctStDt())) && split.getEfctFnsDt().isBefore(getEfctFnsDt());
    }

    // 시작일 이후 && 종료일 동일 || 이후
    // 2 split before
    @Deprecated
    public boolean isCase4(Split split) {
        return split.getEfctStDt().isAfter(getEfctStDt())
                && (split.getEfctFnsDt().isEqual(getEfctFnsDt()) || split.getEfctFnsDt().isAfter(getEfctFnsDt()));
    }

}
