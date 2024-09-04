package entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "domicilio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCalle;
    private int numero;
}
