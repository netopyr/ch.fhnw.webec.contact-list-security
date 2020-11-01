package ch.fhnw.webec.contactlistsecurity.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;

    @ElementCollection
    private final List<String> emails = new ArrayList<>();

    private String jobTitle;
    private String company;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACT_ID")
    private final List<Phone> phones = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getEmails() {
        return emails;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        return new EqualsBuilder()
                .append(id, contact.id)
                .append(firstName, contact.firstName)
                .append(lastName, contact.lastName)
                .append(emails, contact.emails)
                .append(jobTitle, contact.jobTitle)
                .append(company, contact.company)
                .append(phones, contact.phones)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(firstName)
                .append(lastName)
                .append(emails)
                .append(jobTitle)
                .append(company)
                .append(phones)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("emails", emails)
                .append("jobTitle", jobTitle)
                .append("company", company)
                .append("phones", phones)
                .toString();
    }
}
