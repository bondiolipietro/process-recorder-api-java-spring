package br.com.pietrobondioli.processstorageapi.services;

import br.com.pietrobondioli.processstorageapi.domain.User;
import br.com.pietrobondioli.processstorageapi.exceptions.PsAuthException;

public interface UserService {

    User validateUser(String email, String password) throws PsAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws PsAuthException;

}
