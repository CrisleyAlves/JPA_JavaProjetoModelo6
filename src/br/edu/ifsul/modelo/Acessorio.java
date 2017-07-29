package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author crisley
 */
@Entity(name = "Acessorio")
public class Acessorio implements Serializable{

    @Id
    @SequenceGenerator(name = "seq_acessorio", sequenceName = "seq_acessorio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_acessorio", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "descricao")
    @NotNull(message = "A descrição não pode ser nulo")
    @NotBlank(message = "A descrição não pode ficar em branco")
    private String descricao;
    
    
    
}
