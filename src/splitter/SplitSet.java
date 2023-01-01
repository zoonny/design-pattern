package splitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SplitSet {
    private List<Split> splits = new LinkedList<>();
    private LocalDateTime basStDt;
    private LocalDateTime basFnsDt;

    public SplitSet(String basStDt, String basFnsDt) {
        this.basStDt = LocalDateTime.parse(basStDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        this.basFnsDt = LocalDateTime.parse(basFnsDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        this.splits = new LinkedList<>();
    }

    public void addAll(List<Split> splits) {
        splits.stream().forEach(split -> {
            add(split);
        });
    }

    public void add(Split split) {
        if (filter(split)) {
            splits.add(split);
        }
    }

    public void sort() {
        Collections.sort(splits);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(getBasStDt()).append(" ~ ").append(getBasFnsDt()).append("]")
                .append(System.lineSeparator()).append(System.lineSeparator());
        splits.stream().forEach(i -> {
            sb.append(i).append(System.lineSeparator());
        });
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
        if (split.getEfctStDt().isBefore(basStDt)) {
            split.setEfctStDt(basStDt);
        }
        if (split.getEfctFnsDt().isAfter(basFnsDt)) {
            split.setEfctFnsDt(basFnsDt);
        }
        return true;
    }

    public boolean verify() {
        sort();
        int size = splits.size();
        int index = 0;
        while (index < size) {
            if (index == 0) {
                // TODO
            } else if (index == size - 1) {
                // TODO
            } else {
                // TODO
            }
        }
        return true;
    }

}
