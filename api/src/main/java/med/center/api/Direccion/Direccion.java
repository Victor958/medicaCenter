package med.center.api.Direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
	public Direccion() {
		
	}
	public Direccion(DatosDireccion direccion) {
		this.calle = direccion.calle();
		this.numero = direccion.numero();
		this.complemento = direccion.complemento();
		this.distrito = direccion.distrito();
		this.ciudad = direccion.ciudad();
	}
	
	private String calle;
	private String numero;
	private String complemento;
	private String distrito;
	private String ciudad;
	
	public void actualizarDireccion(DatosDireccion direccion) {
		if (direccion.calle() != null) {
			this.calle = direccion.calle();
		}
		if (direccion.numero() != null) {
			this.numero = direccion.numero();
		}
		if (direccion.complemento() != null) {
			this.complemento = direccion.complemento();
		}
		if (direccion.distrito() != null) {
			this.distrito = direccion.distrito();
		}
		if (direccion.ciudad() != null) {
			this.ciudad = direccion.ciudad();
		}
	}
}
