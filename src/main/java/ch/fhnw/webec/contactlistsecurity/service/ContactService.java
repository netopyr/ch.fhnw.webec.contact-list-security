package ch.fhnw.webec.contactlistsecurity.service;

import ch.fhnw.webec.contactlistsecurity.dao.ContactRepository;
import ch.fhnw.webec.contactlistsecurity.model.Contact;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private static final String JSON_FILE = "contacts.json";

    private final ContactRepository repository;
    private final ObjectMapper mapper;

    @Autowired
    public ContactService(ContactRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @PostConstruct
    public void init() throws IOException {
        mapper.readValue(ContactService.class.getResource(JSON_FILE), new TypeReference<List<Contact>>() {})
                .forEach(contact -> {
                    contact.setId(0L);
                    repository.save(contact);
                });
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public Optional<Contact> findContact(long id) {
        return repository.findById(id);
    }

    public List<Contact> findByName(String name) {
        return repository.findByLastNameContainingOrFirstNameContainingAllIgnoreCase(name, name);
    }

    public Contact createContact(Contact newContact) {
        return repository.save(newContact);
    }

    public Contact updateContact(Contact updatedContact) {
        if (! repository.findById(updatedContact.getId()).isPresent()) {
            throw new IndexOutOfBoundsException();
        }
        return repository.save(updatedContact);
    }

    public void deleteContact(long id) {
        if (! repository.findById(id).isPresent()) {
            throw new IndexOutOfBoundsException();
        }
        repository.deleteById(id);
    }
}
