package br.edu.uniacademia.ativcompl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.uniacademia.ativcompl.domain.Address;
import br.edu.uniacademia.ativcompl.domain.User;
import br.edu.uniacademia.ativcompl.domain.UserType;
import br.edu.uniacademia.ativcompl.repositories.AddressRepository;
import br.edu.uniacademia.ativcompl.repositories.UserRepository;
import br.edu.uniacademia.ativcompl.repositories.UserTypeRepository;

@SpringBootApplication
public class AtivcomplApplication implements CommandLineRunner{
	
	@Autowired 	private AddressRepository addressRepository;
	@Autowired 	private UserRepository userRepository;
	@Autowired  private UserTypeRepository userTypeRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(AtivcomplApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Address addr1 = new Address(null, "Ruas das Angélicas", "20", "N. Sra. das Graças", "Lima Duarte"); 
		Address addr2 = new Address(null, "Ruas Leonides M. Campos", "74", "Centro", "Lima Duarte");
		
		
		User user1 = new User(null, "abc001", "Paulão da Regulagem", "paulao@mail.com", "12345", addr1);
		User user2 = new User(null, "abc002", "Josiclayde da Regulagem", "josiclayd@mail.com", "54321", addr2);

		UserType ut1 = new UserType(null, "Coordenador");
		UserType ut2 = new UserType(null, "Supervisor");
		UserType ut3 = new UserType(null, "Administrador");
		UserType ut4 = new UserType(null, "Aluno");
		
		user1.getUsersTypes().addAll(Arrays.asList(ut3, ut4));
		user2.getUsersTypes().addAll(Arrays.asList(ut1, ut2));
		
		ut1.getUsers().addAll(Arrays.asList(user2));
		ut2.getUsers().addAll(Arrays.asList(user2));
		ut3.getUsers().addAll(Arrays.asList(user1));
		ut4.getUsers().addAll(Arrays.asList(user1));
		
		addressRepository.saveAll(Arrays.asList(addr1, addr2));
		userRepository.saveAll(Arrays.asList(user1, user2));
		userTypeRepository.saveAll(Arrays.asList(ut1, ut2, ut3, ut4));
		
	}

}
