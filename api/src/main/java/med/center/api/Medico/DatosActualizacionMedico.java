package med.center.api.Medico;

import jakarta.validation.constraints.NotNull;
import med.center.api.Direccion.DatosDireccion;

public record DatosActualizacionMedico(
		@NotNull
        Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion) {

}
