package splitter;

public class ContProdVo extends SplitVo {
    private String prodId;

    private String prodNm;

    public ContProdVo(String efctStDt, String efctFnsDt, String prodId, String prodNm) {
        super(efctStDt, efctFnsDt);
        this.prodId = prodId;
        this.prodNm = prodNm;
    }

    public String getProdId() {
        return prodId;
    }

    public String getProdNm() {
        return prodNm;
    }

}
