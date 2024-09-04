package entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;
    private String apellido;

    @Column(unique = true)
    private int dni;


}
