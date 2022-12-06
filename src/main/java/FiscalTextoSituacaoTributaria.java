public class FiscalTextoSituacaoTributaria implements IFiscal{
    private String situacaoTributaria;

    @Override
    public String getSituacaoTributaria() {
        return situacaoTributaria;
    }

    @Override
    public void setSituacaoTributaria(String st) {
        this.situacaoTributaria = st;
    }
}
