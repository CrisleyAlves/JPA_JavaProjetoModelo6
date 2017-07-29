package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author crisley
 */
@Entity(name = "Carro")
public class Carro implements Serializable{

    @Id
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_carro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "placa")
    @NotNull(message = "A placa não pode ser nulo")
    @NotBlank(message = "A placa não pode ficar em branco")
    private String placa;
    
    @Column(name = "renavam")
    @NotNull(message = "O renavam não pode ser nulo")
    @NotBlank(message = "O renavam não pode ficar em branco")
    private String renavam;
    
    @Column(name = "modelo")
    @NotNull(message = "O modelo não pode ser nulo")
    @NotBlank(message = "O modelo não pode ficar em branco")
    private String modelo;
    
    @Column(name = "fabricante")
    @NotNull(message = "O fabricante não pode ser nulo")
    @NotBlank(message = "O fabricante não pode ficar em branco")
    private String fabricante;
    
    @Column(name = "anoFabricacao")
    @NotNull(message = "O ano não pode ser nulo")
    private Integer anoFabricao;
    
    @Column(name = "anoModelo")
    @NotNull(message = "O modelo não pode ser nulo")
    private Integer anoModelo;
    
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_pessoa")
    private Pessoa pessoa;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "carro_acessorio", 
            joinColumns = @JoinColumn(
                    name = "carro", 
                    referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = @JoinColumn(
                    name = "acessorio", 
                    referencedColumnName = "id", 
                    nullable = false)
    )
    private List<Acessorio> acessorios = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAnoFabricao() {
        return anoFabricao;
    }

    public void setAnoFabricao(Integer anoFabricao) {
        this.anoFabricao = anoFabricao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
    
}
