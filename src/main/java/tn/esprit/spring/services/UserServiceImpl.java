package tn.esprit.spring.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	// TODO Logger à ajouter  
	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		//try {
	
			// TODO Log à ajouter en début de la méthode 
			L.info("In Method retrieveAllUsers :");
			users = (List<User>) userRepository.findAll();  
			L.debug("connexion à la BD Ok :");
			for (User user : users) {
				// TODO Log à ajouter pour affiher chaque user dans les logs   
				L.debug("user :" + user.getLastName());
			} 
			// TODO Log à ajouter à la fin de la méthode 
			L.info("Out of Method retrieveAllUsers with Success");
		/*}catch (Exception e) {
			// TODO Log à ajouter pour gérer les erreurs 
			L.error("Out Of Method retrieveAllUsers with Errors :" + e);
		}*/

		return users;
	}


	@Override
	public User addUser(User u) {
		// TODO Log à ajouter en début de la méthode 
		L.info("In Method addUser :");
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		L.info("Out of Method addUser :");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		// TODO Log à ajouter en début de la méthode 
		L.info("In Method updateUser :");
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		L.info("Out of Method updateUser :");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		userRepository.deleteById(Long.parseLong(id)); 
		// TODO Log à ajouter à la fin de la méthode 
	}

	@Override
	public User retrieveUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		// TODO Log à ajouter à la fin de la méthode 
		return u; 
	}

}