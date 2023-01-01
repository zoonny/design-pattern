package splitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContSttusVo implements Split {
    private LocalDateTime efctStDt;
    private LocalDateTime efctFnsDt;
    private String contSttus;

    public ContSttusVo(String efctStDt, String efctFnsDt, String contSttus) {
        this.efctStDt = LocalDateTime.parse(efctStDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        this.efctFnsDt = LocalDateTime.parse(efctFnsDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        this.contSttus = contSttus;
    }

    public String getContSttus() {
        return contSttus;
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
    public String toString() {
        return getContSttus();
    }

}
