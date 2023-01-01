package splitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContProdVo implements Split {
    private LocalDateTime efctStDt;
    private LocalDateTime efctFnsDt;
    private String prodId;
    private String prodNm;

    public ContProdVo(String efctStDt, String efctFnsDt, String prodId, String prodNm) {
        this.efctStDt = LocalDateTime.parse(efctStDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        this.efctFnsDt = LocalDateTime.parse(efctFnsDt, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        this.prodId = prodId;
        this.prodNm = prodNm;
    }

    public String getProdId() {
        return prodId;
    }

    public String getProdNm() {
        return prodNm;
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
        return getProdId();
    }

}
