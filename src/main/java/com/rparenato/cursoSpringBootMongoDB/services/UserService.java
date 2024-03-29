package com.rparenato.cursoSpringBootMongoDB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rparenato.cursoSpringBootMongoDB.domain.User;
import com.rparenato.cursoSpringBootMongoDB.dto.UserDTO;
import com.rparenato.cursoSpringBootMongoDB.repository.UserRepository;
import com.rparenato.cursoSpringBootMongoDB.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return userRepository.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

	public User update(User newObj) {
		User userOld = findById(newObj.getId());
		updateData(userOld, newObj);
		return userRepository.save(userOld);
	}

	private void updateData(User userOld, User newObj) {
		userOld.setName(newObj.getName());
		userOld.setEmail(newObj.getEmail());
	}

	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}

}
