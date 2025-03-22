package model;

import javax.persistence.*;

@Entity
@Table(name = "motivo_fatura")
public class MotivoFatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMotivoFatura")
    private Integer idMotivoFatura;

    @Column(name = "descricaoMotivo", length = 255)
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