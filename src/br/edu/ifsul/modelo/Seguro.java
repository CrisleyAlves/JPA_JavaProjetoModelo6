package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import br.ifsul.edu.modelo.Sinistro;
import java.util.ArrayList;

/**
 *
 * @author crisley
 */
@Entity(name = "Seguro")
public class Seguro implements Serializable{

    public List<Sinistro> getListaSinistro() {
        return listaSinistro;
    }

    public void setListaSinistro(List<Sinistro> listaSinistro) {
        this.listaSinistro = listaSinistro;
    }

    public List<Cobertura> getListaCoberturas() {
        return listaCoberturas;
    }

    public void setListaCoberturas(List<Cobertura> listaCoberturas) {
        this.listaCoberturas = listaCoberturas;
    }

    @Id
    @SequenceGenerator(name = "seq_seguro", sequenceName = "seq_seguro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_seguro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O data deve ser informada")
    private Calendar data;
    
    @Column(name = "inicioVigencia")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O inicio da vigência deve ser informado")
    private Calendar inicioVigencia;
    
    @Column(name = "fimVigencia")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O fim da vigência deve ser informado")
    private Calendar fimVigencia;
    
    @Column(name = "valor_total", columnDefinition = "numeric(10,2)")
    @NotNull(message = "O valor total deve ser informado")
    private Double valorTotal;
    
    @Column(name = "valor_Fipe", columnDefinition = "numeric(10,2)")
    @NotNull(message = "O valor da fipe deve ser informado")
    private Double valorFipe;
    
    @ManyToOne
    @JoinColumn(name = "carro", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_carro")
    private Carro carro;
    
    @ManyToOne
    @JoinColumn(name = "corretor", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_corretor")
    private Corretor corretor;
    
    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Sinistro> listaSinistro  = new ArrayList<>();
    
    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Cobertura> listaCoberturas  = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Calendar inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Calendar getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Calendar fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(Double valorFipe) {
        this.valorFipe = valorFipe;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Seguro other = (Seguro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public void adicionarSinistro(Sinistro obj){
        obj.setSeguro(this);
        this.getListaSinistro().add(obj);
    }
    
    public void removerSinistro(int index){
        this.getListaSinistro().remove(index);
    }
    
    public void adicionarCobertura(Cobertura obj){
        obj.setSeguro(this);
        this.getListaCoberturas().add(obj);
    }
    
    public void removerCobertura(int index){
        this.getListaCoberturas().remove(index);
    }
    
    
}
