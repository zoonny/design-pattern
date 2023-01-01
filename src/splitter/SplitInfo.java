package splitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class SplitInfo {
    private Map<String, List<Split>> infoMap;

    public SplitInfo() {
        this.infoMap = new HashMap<>();
    }

    public void put(Split split) {
        if (!infoMap.containsKey(split.getClass().getSimpleName())) {
            infoMap.put(split.getClass().getSimpleName(), new ArrayList<Split>());
        }
        infoMap.get(split.getClass().getSimpleName()).add(split);
    }

    public List<Split> findAll(SplitVo splitVo) {
        List<Split> splits = new ArrayList<>();
        infoMap.keySet().stream().forEach(key -> {
            infoMap.get(key).stream()
                    .filter(split -> (splitVo.getEfctStDt()
                            .isEqual(split.getEfctStDt()) || splitVo.getEfctStDt().isAfter(split.getEfctStDt()))
                            && (splitVo.getEfctFnsDt().isEqual(split.getEfctFnsDt())
                                    || splitVo.getEfctFnsDt().isBefore(split.getEfctFnsDt())))
                    .findFirst().ifPresent(i -> {
                        splits.add(i);
                    });
        });
        return splits;
    }
}
