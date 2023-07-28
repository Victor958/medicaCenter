package med.center.api.Medico;

public record DatosListaMedicos(
		Long id,
		String nombre,
		String email,
		String documento,
		Especialidad especialidad) {
	
	public DatosListaMedicos(Medico medico) {
		this(medico.getId(), medico.getNombre(), medico.getEmail(), medico.getDocumento(), medico.getEspecialidad());
	}

}
