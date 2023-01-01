package splitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        ContSttusVo[] contSttusVos = {
                new ContSttusVo("20221101000000", "20221103000000", "S"),
                new ContSttusVo("20221103000000", "20221205120000", "A"),
                new ContSttusVo("20221205120000", "20221212000000", "S"),
                new ContSttusVo("20221212000000", "20230103000000", "A"),
                new ContSttusVo("20230103000000", "99991231235959", "S"),
        };

        SplitSet splitSet = new SplitSet("20221201000000", "20221231235959");
        splitSet.addAll(Arrays.stream(contSttusVos).collect(Collectors.toList()));
        splitSet.sort();
        System.out.println(splitSet.toString());
    }
}
