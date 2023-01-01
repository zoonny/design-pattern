package splitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class SplitSet {
    private SortedSet<LocalDateTime> splitTimes;
    private SplitInfo splitInfo;
    private List<SplitVo> splitVos;
    private LocalDateTime basStDt;
    private LocalDateTime basFnsDt;

    public SplitSet(String basStDt, String basFnsDt) {
        this.basStDt = LocalDateTime.parse(basStDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        this.basFnsDt = LocalDateTime.parse(basFnsDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        this.splitTimes = new TreeSet<>();
        this.splitInfo = new SplitInfo();
    }

    public void addAll(List<Split> splits) {
        if (!verify(splits)) {
            throw new IllegalArgumentException();
        }
        splits.stream().forEach(split -> {
            if (filter(split)) {
                splitTimes.add(split.getEfctStDt().isBefore(basStDt) ? basStDt : split.getEfctStDt());
                splitTimes.add(split.getEfctFnsDt().isAfter(basFnsDt) ? basFnsDt : split.getEfctFnsDt());
                splitInfo.put(split);
            }
        });
    }

    public void build() {
        this.splitVos = new ArrayList<>();
        SplitVo prev = null;
        for (LocalDateTime splitTime : splitTimes) {
            if (prev != null) {
                prev.setEfctFnsDt(splitTime);
            }
            if (splitTime.isEqual(basFnsDt) || splitTime.isAfter(basFnsDt)) {
                break;
            }
            SplitVo splitVo = new SplitVo(splitTime);
            this.splitVos.add(splitVo);
            prev = splitVo;
        }
        this.splitVos.stream().forEach(splitVo -> {
            splitInfo.findAll(splitVo).stream().forEach(split -> {
                splitVo.add(split);
            });
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(getBasStDt()).append(" ~ ").append(getBasFnsDt()).append("]")
                .append(System.lineSeparator()).append(System.lineSeparator());
        splitVos.stream().forEach(i -> {
            sb.append(i).append(System.lineSeparator());
        });
        // splitTimes.stream().forEach(i -> {
        // sb.append(i).append(System.lineSeparator());
        // });
        return sb.toString();
    }

    public LocalDateTime getBasStDt() {
        return basStDt;
    }

    public LocalDateTime getBasFnsDt() {
        return basFnsDt;
    }

    public boolean filter(Split split) {
        if (split.getEfctFnsDt().isBefore(basStDt)) {
            return false;
        }
        if (split.getEfctStDt().isAfter(basFnsDt)) {
            return false;
        }
        return true;
    }

    public boolean verify(List<Split> splits) {
        boolean verify = true;
        Split prev = null;
        for (Split split : splits) {
            if (prev != null && !prev.getEfctFnsDt().isEqual(split.getEfctStDt())) {
                System.out.println(prev.getEfctFnsDt().toString() + " != " + split.getEfctStDt());
                verify = !verify;
                break;
            }
            prev = split;
        }
        return verify;
    }

}
