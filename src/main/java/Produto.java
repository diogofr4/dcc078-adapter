public class Produto {
    IFiscal fiscal;
    FiscalAdapter persistencia;

    public Produto() {
        fiscal = new FiscalTextoSituacaoTributaria();
        persistencia = new FiscalAdapter(fiscal);
    }

    public void setFiscal(String st){
        fiscal.setSituacaoTributaria(st);
        persistencia.salvarSituacaoTributaria();
    }

    public String getFiscal() { return persistencia.recuperarSituacaoTributaria(); }

    public String getCodigo() { return persistencia.getCodigo(); }
}
