package entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "articulo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;
    private String denominacion;
    private int precio;

}
