package med.center.api.Paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import med.center.api.Direccion.Direccion;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Entity;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@EqualsAndHashCode(of = "id")
public class Paciente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String email;
	private String telefono;
	@Embedded
	private Direccion direccion;
	
	private Boolean activo;
	
	public Paciente() {}
	
	public Paciente(DatosRegistroPaciente datosPaciente) {
		this.nombre = datosPaciente.nombre();
		this.email = datosPaciente.email();
		this.telefono = datosPaciente.telefono();
		this.direccion = new Direccion(datosPaciente.direccion());
		this.activo = true;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}
	public void actualizarInformacion(DatosActualizacionPaciente datos) {
		if (datos.nombre() != null) {
			this.nombre = datos.nombre();
		}
		if (datos.email() != null) {
			this.email = datos.email();
		}
		if (datos.telefono() != null) {
			this.telefono = datos.telefono();
		}
	}
	public void eliminar() {
		this.activo = false;
	}
}

