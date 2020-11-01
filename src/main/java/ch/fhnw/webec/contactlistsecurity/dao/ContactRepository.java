package ch.fhnw.webec.contactlistsecurity.dao;

import ch.fhnw.webec.contactlistsecurity.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByLastNameContainingOrFirstNameContainingAllIgnoreCase(String lastName, String firstName);

}
