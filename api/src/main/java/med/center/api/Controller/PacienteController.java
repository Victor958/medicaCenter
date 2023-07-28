package med.center.api.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.center.api.Medico.DatosActualizacionMedico;
import med.center.api.Medico.DatosListaMedicos;
import med.center.api.Paciente.DatosActualizacionPaciente;
import med.center.api.Paciente.DatosListaPacientes;
import med.center.api.Paciente.DatosRegistroPaciente;
import med.center.api.Paciente.Paciente;
import med.center.api.Paciente.PacienteRepository;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    
	@PostMapping
	@Transactional
	public void registrarPaciente(@RequestBody @Valid DatosRegistroPaciente datosPaciente) {
		pacienteRepository.save(new Paciente(datosPaciente));
	}
	
	@GetMapping
    public Page<DatosListaPacientes> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {
        return pacienteRepository.findAllByActivoTrue(paginacion).map(DatosListaPacientes::new);
    }
	
    @PutMapping
    @Transactional
    public void actualizar(@RequestBody @Valid DatosActualizacionPaciente datos) {
        var paciente = pacienteRepository.getReferenceById(datos.id());
        paciente.actualizarInformacion(datos);
    }
    
	@DeleteMapping("/{id}")
	@Transactional
	public void eliminarPaciente(@PathVariable Long id) {
		var paciente = pacienteRepository.getReferenceById(id);
		paciente.eliminar();
	}
}
