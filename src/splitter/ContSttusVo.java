package splitter;

public class ContSttusVo extends SplitVo {
    private String contSttus;

    public ContSttusVo(String efctStDt, String efctFnsDt, String contSttus) {
        super(efctStDt, efctFnsDt);
        this.contSttus = contSttus;
    }

    public String getContSttus() {
        return contSttus;
    }

    @Override
    public String toString() {
        return super.toString() + " : " + getContSttus();
    }

}
