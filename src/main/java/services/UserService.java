package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.User;
import repositories.UserRepository;

@Service
public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User insert(User user);
    void delete(Long id);
    User update(User user);
}

public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		//return null;
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User insert(User user) {
		// TODO Auto-generated method stub
		//return null;
		return userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		//return null;
		return userRepository.save(user);
	}
}