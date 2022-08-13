package utp.misiontic2022.model.vo;

public class CompraPorProveedorVo {

    private Integer idCompra;
    private String constructora;
    private String banco;

    public CompraPorProveedorVo() {
    }

    public CompraPorProveedorVo(Integer idCompra, String constructora, String banco) {
        this.idCompra = idCompra;
        this.constructora = constructora;
        this.banco = banco;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

}
