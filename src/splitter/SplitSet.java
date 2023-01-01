package splitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplitSet {
    private List<SplitVo> splitVos;
    private LocalDateTime basStDt;
    private LocalDateTime basFnsDt;

    public SplitSet(String basStDt, String basFnsDt) {
        this.basStDt = LocalDateTime.parse(basStDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        this.basFnsDt = LocalDateTime.parse(basFnsDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        this.splitVos = new ArrayList<>();
    }

    public void addAll(List<Split> splits) {
        if (!verify(splits)) {
            throw new IllegalArgumentException();
        }
        splits.stream().forEach(split -> {
            add(split);
        });
    }

    public void add(Split split) {
        if (filter(split)) {
            addOrSplit(split);
        }
    }

    public void addOrSplit(Split split) {
        // Optional<SplitVo> start = splitVos.stream().filter(splitVo ->
        // split.getEfctStDt().isEqual(splitVo.getEfctStDt())
        // || split.getEfctStDt().isAfter(splitVo.getEfctStDt())).findFirst();

        // Optional<SplitVo> end = splitVos.stream().filter(splitVo ->
        // split.getEfctFnsDt().isEqual(splitVo.getEfctFnsDt())
        // || split.getEfctFnsDt().isBefore(splitVo.getEfctFnsDt())).findFirst();

        List<SplitVo> list = splitVos.stream().filter(splitVo -> split.getEfctStDt().isBefore(splitVo.getEfctStDt()))
                .toList();

        System.out.println(list);

        if (list.isEmpty()) {
            SplitVo splitVo = new SplitVo(split.getEfctStDt(), split.getEfctFnsDt());
            splitVo.add(split);
            if (splitVo.getEfctStDt().isBefore(basStDt)) {
                splitVo.setEfctStDt(basStDt);
            }
            if (splitVo.getEfctFnsDt().isAfter(basFnsDt)) {
                splitVo.setEfctFnsDt(basFnsDt);
            }
            splitVos.add(splitVo);
        } else {

        }
    }

    public void sort() {
        Collections.sort(splitVos);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(getBasStDt()).append(" ~ ").append(getBasFnsDt()).append("]")
                .append(System.lineSeparator()).append(System.lineSeparator());
        splitVos.stream().forEach(i -> {
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
