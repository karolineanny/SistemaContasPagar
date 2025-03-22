package model;

public class MotivoFatura {

    private Integer idMotivoFatura;

    private String descricaoMotivo;

    public MotivoFatura() {
    }

    public MotivoFatura(String descricaoMotivo) {
        this.descricaoMotivo = descricaoMotivo;
    }

    public Integer getIdMotivoFatura() {
        return idMotivoFatura;
    }

    public void setIdMotivoFatura(Integer idMotivoFatura) {
        this.idMotivoFatura = idMotivoFatura;
    }

    public String getDescricaoMotivo() {
        return descricaoMotivo;
    }

    public void setDescricaoMotivo(String descricaoMotivo) {
        this.descricaoMotivo = descricaoMotivo;
    }

    @Override
    public String toString() {
        return "MotivoFatura{" +
                "idMotivoFatura=" + idMotivoFatura +
                ", descricaoMotivo='" + descricaoMotivo + '\'' +
                '}';
    }
}