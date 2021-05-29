package br.edu.uniacademia.ativcompl.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/address")
public class AddressResource {

	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "Rest está funcionando";
	}
}
