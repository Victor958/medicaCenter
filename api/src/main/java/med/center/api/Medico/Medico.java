package med.center.api.Medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import med.center.api.Direccion.Direccion;

@Table(name="medicos")
@Entity(name="Medico")
@EqualsAndHashCode(of = "id")
public class Medico {
	public Medico() {
		
	}
	public Medico(DatosRegistroMedico datosMedico) {
		this.nombre = datosMedico.nombre();
		this.email = datosMedico.email();
		this.documento =  datosMedico.documento();
		this.telefono = datosMedico.telefono();
		this.especialidad = datosMedico.especialidad();
		this.direccion = new Direccion(datosMedico.direccion());
		this.activo = true;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String email;
	private String documento;
	private String telefono;
	@Enumerated(EnumType.STRING)
	private Especialidad especialidad;
	@Embedded
	private Direccion direccion;
	private Boolean activo;
	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getEmail() {
		return email;
	}
	public String getDocumento() {
		return documento;
	}
	public String getTelefono() {
		return telefono;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	
	public void actualizarInformacion(DatosActualizacionMedico datos) {
		if (datos.nombre() != null) {
			this.nombre = datos.nombre();
		}
		if (datos.telefono() != null) {
			this.telefono = datos.telefono();
		}
		if (datos.direccion() != null) {
			this.direccion.actualizarDireccion(datos.direccion());
		}
	}
	
	public void eliminar() {
		this.activo = false;
	}
	
	
	
}
