package br.edu.uniacademia.ativcompl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.uniacademia.ativcompl.domain.Address;
import br.edu.uniacademia.ativcompl.repositories.AddressRepository;

@SpringBootApplication
public class AtivcomplApplication implements CommandLineRunner{
	
	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(AtivcomplApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Address addr1 = new Address(null, "Ruas das Angélicas", "20", "N. Sra. das Graças", "Lima Duarte"); 
		Address addr2 = new Address(null, "Ruas Leonides M. Campos", "74", "Centro", "Lima Duarte");
		
		addressRepository.saveAll(Arrays.asList(addr1, addr2));
		
	}

}
