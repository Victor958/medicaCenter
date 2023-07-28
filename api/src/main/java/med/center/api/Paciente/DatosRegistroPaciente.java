package med.center.api.Paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.center.api.Direccion.DatosDireccion;

public record DatosRegistroPaciente(
		@NotBlank
		String nombre,
		@NotBlank
		@Email
		String email, 
		@NotBlank
		String telefono,
		@NotNull
		@Valid
		DatosDireccion direccion) {

}
