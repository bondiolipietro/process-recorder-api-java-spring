package br.com.pietrobondioli.processstorageapi.services;

import br.com.pietrobondioli.processstorageapi.domain.User;
import br.com.pietrobondioli.processstorageapi.exceptions.PsAuthException;
import br.com.pietrobondioli.processstorageapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws PsAuthException {
        if(email != null) {
            email = email.toLowerCase();
        };
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws PsAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) {
            email = email.toLowerCase();
        };
        if(!pattern.matcher(email).matches()) {
            throw new PsAuthException("Invalid email format");
        }
        Integer count = userRepository.getCountByEmail(email);
        if(count > 0) {
            throw new PsAuthException("Email already in use");
        }
        Integer userId = userRepository.create(firstName, lastName, email, password);
        return userRepository.findById(userId);
    }
}
