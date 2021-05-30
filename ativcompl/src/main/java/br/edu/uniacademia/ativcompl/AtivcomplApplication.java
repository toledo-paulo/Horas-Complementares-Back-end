package br.edu.uniacademia.ativcompl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.uniacademia.ativcompl.domain.Address;
import br.edu.uniacademia.ativcompl.domain.User;
import br.edu.uniacademia.ativcompl.repositories.AddressRepository;
import br.edu.uniacademia.ativcompl.repositories.UserRepository;

@SpringBootApplication
public class AtivcomplApplication implements CommandLineRunner{
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AtivcomplApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "abc001", "Paulão da Regulagem", "paulao@mail.com", "12345");
		User user2 = new User(null, "abc002", "Josiclayde da Regulagem", "josiclayd@mail.com", "54321");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		Address addr1 = new Address(null, "Ruas das Angélicas", "20", "N. Sra. das Graças", "Lima Duarte", user1); 
		Address addr2 = new Address(null, "Ruas Leonides M. Campos", "74", "Centro", "Lima Duarte", user2);
		
		addressRepository.saveAll(Arrays.asList(addr1, addr2));
		
	}

}
