package br.com.pietrobondioli.processstorageapi.repositories;

import br.com.pietrobondioli.processstorageapi.domain.User;
import br.com.pietrobondioli.processstorageapi.exceptions.PsAuthException;

public interface UserRepository {

    Integer create(String firstName, String lastName, String email, String password) throws PsAuthException;

    User findByEmailAndPassword(String email, String password) throws PsAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);

}
