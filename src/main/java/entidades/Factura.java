package entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "factura")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecha;
    private int numero;
}
