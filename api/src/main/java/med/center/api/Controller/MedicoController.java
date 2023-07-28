package med.center.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import med.center.api.Medico.DatosRegistroMedico;
import med.center.api.Medico.Medico;
import med.center.api.Medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@PostMapping
	@Transactional
	public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosMedico) {
		medicoRepository.save(new Medico(datosMedico));
	}
	
	@GetMapping
    public Page<DatosListaMedicos> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {
        return medicoRepository.findAllByActivoTrue(paginacion).map(DatosListaMedicos::new);
    }
	
    @PutMapping
    @Transactional
    public void actualizar(@RequestBody @Valid DatosActualizacionMedico datos) {
        var medico = medicoRepository.getReferenceById(datos.id());
        medico.actualizarInformacion(datos);
    }
    
	@DeleteMapping("/{id}")
	@Transactional
	public void eliminarMedico(@PathVariable Long id) {
		var medico = medicoRepository.getReferenceById(id);
		medico.eliminar();
	}
}
