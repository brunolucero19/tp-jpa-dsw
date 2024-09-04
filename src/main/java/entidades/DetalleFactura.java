package entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detalle_factura")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DetalleFactura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;
    private int subtotal;

}
