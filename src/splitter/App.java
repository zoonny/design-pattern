package splitter;

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

        ContProdVo[] contProdVo = {
                new ContProdVo("20221101000000", "20221130000000", "P1", "P1"),
                new ContProdVo("20221130000000", "20221207000000", "P2", "P2"),
                new ContProdVo("20221207000000", "20221225000000", "P3", "P3"),
                new ContProdVo("20221225000000", "99991231235959", "P1", "P1"),
        };

        SplitSet splitSet = new SplitSet("20221201000000", "20221231235959");
        splitSet.addAll(Arrays.stream(contSttusVos).collect(Collectors.toList()));
        splitSet.addAll(Arrays.stream(contProdVo).collect(Collectors.toList()));
        splitSet.build();
        System.out.println(splitSet.toString());
    }
}
