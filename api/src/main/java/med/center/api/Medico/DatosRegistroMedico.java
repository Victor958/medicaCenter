package med.center.api.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.center.api.Direccion.DatosDireccion;

public record DatosRegistroMedico(
		@NotBlank
		String nombre,
		@NotBlank
		@Email
		String email, 
		@NotBlank
		String documento,
		@NotBlank
		String telefono,
		@NotNull
		Especialidad especialidad,
		@NotNull
		@Valid
		DatosDireccion direccion) {


}
