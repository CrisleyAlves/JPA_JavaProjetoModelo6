package br.ifsul.edu.modelo;

import br.edu.ifsul.modelo.Seguro;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author crisley
 */
@Entity(name = "Sinistro")
public class Sinistro implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_sinistro", sequenceName = "seq_sinistro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_sinistro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "descricao")
    @NotNull(message = "A descrição não pode ser nulo")
    @NotBlank(message = "A descrição não pode ser em branco")
    private String nome;
    
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informado")
    private Calendar data;
    
    @Column(name = "cidade", columnDefinition = "text")
    @NotNull(message = "A cidade não pode ser nula")
    @NotBlank(message = "A cidade não ficar em branco")
    private String cidade;
    
    @Column(name = "estado")
    @NotNull(message = "O estado não pode ser nulo")
    @NotBlank(message = "O estado não ficar em branco")
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "seguro", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_seguro")
    private Seguro seguro;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sinistro other = (Sinistro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
