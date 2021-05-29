package br.edu.uniacademia.ativcompl.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uniacademia.ativcompl.domain.Address;

@RestController
@RequestMapping(value="/address")
public class AddressResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Address> listar() {
		
		Address ad1 = new Address((long) 1, "Ruas das Angélicas", "20", "N. Sra. das Graças", "Lima Duarte");
		Address ad2 = new Address((long)2, "Ruas Leonides M. Campos", "74", "Centro", "Lima Duarte");
		
		List<Address> lista = new ArrayList<>();
		lista.add(ad1);
		lista.add(ad2);
		return lista;
	}
}
