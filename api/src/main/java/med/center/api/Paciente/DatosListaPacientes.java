package med.center.api.Paciente;

public record DatosListaPacientes(
		Long id,
		String nombre,
		String email,
		String telefono) {
	
	public DatosListaPacientes(Paciente paciente) {
		this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getTelefono());
	}

}
