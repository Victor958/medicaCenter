package med.center.api.Paciente;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionPaciente(
		@NotNull
        Long id,
        String nombre,
        String email,
        String telefono) {

}
