public class FiscalAdapter extends FiscalCodigoSituacaoTributaria{
    private IFiscal fiscalTextoSituacaoTributaria;

    public FiscalAdapter(IFiscal fiscalTextoSituacaoTributaria){
        this.fiscalTextoSituacaoTributaria = fiscalTextoSituacaoTributaria;
    }

    public String recuperarSituacaoTributaria(){
        int firstDigit = Integer.parseInt(this.getCodigo().substring(0, 1));
        String codigo = this.getCodigo();
        String lastTwoDigits = codigo.substring(codigo.length() - 2);
        String st;
        if(firstDigit == 0 || (firstDigit >= 3 && firstDigit <=5))
            st = "Nacional";
        else
            st = "Estrangeiro";
        switch (lastTwoDigits){
            case "00":
                st = st + " Tributada integralmente";
                break;
            case "10":
                st = st + " Tributada e com cobrança do ICMS por substituição tributária";
                break;
            case "20":
                st = st + " Com redução da BC";
                break;
            case "30":
                st = st + " Isenta / não tributada e com cobrança do ICMS por substituição tributária";
                break;
            case "40":
                st = st + " Isenta";
                break;
            case "41":
                st = st + " Não tributada";
                break;
            case "50":
                st = st + " Com suspensão";
                break;
            case "51":
                st = st + " Com diferimento";
                break;
            case "60":
                st = st + " ICMS cobrado anteriormente por substituição tributária";
                break;
            case "70":
                st = st + " Com redução da BC e cobrança do ICMS por substituição tributária";
                break;
            case "90":
                st = st + " Outras";
                break;
        }

        fiscalTextoSituacaoTributaria.setSituacaoTributaria(st);

        return fiscalTextoSituacaoTributaria.getSituacaoTributaria();
    }

    public void salvarSituacaoTributaria(){
        String st = fiscalTextoSituacaoTributaria.getSituacaoTributaria();
        String firstWord = st.substring(0, st.indexOf(" "));
        String withoutFirstWord = st.replace(firstWord + " ", "");
        String codigo;
        if(firstWord.equals("Nacional"))
            codigo = "0";
        else
            codigo = "1";
        switch (withoutFirstWord){
            case "Tributada integralmente":
                codigo = codigo + "00";
                break;
            case "Tributada e com cobrança do ICMS por substituição tributária":
                codigo = codigo + "10";
                break;
            case "Com redução da BC":
                codigo = codigo + "20";
                break;
            case "Isenta / não tributada e com cobrança do ICMS por substituição tributária":
                codigo = codigo + "30";
                break;
            case "Isenta":
                codigo = codigo + "40";
                break;
            case "Não tributada":
                codigo = codigo + "41";
                break;
            case "Com suspensão":
                codigo = codigo + "50";
                break;
            case "Com diferimento":
                codigo = codigo + "51";
                break;
            case "ICMS cobrado anteriormente por substituição tributária":
                codigo = codigo + "60";
                break;
            case "Com redução da BC e cobrança do ICMS por substituição tributária":
                codigo = codigo + "70";
                break;
            case "Outras":
                codigo = codigo + "90";
                break;
        }

        this.setCodigo(codigo);
    }
}
