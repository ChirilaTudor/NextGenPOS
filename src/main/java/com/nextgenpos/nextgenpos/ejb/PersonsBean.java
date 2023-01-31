package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.common.PersonDto;
import com.nextgenpos.nextgenpos.common.UserDto;
import com.nextgenpos.nextgenpos.entities.Person;
import com.nextgenpos.nextgenpos.entities.Product;
import com.nextgenpos.nextgenpos.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Collection;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class PersonsBean {

    private static final Logger LOG = Logger.getLogger(ProductsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<PersonDto> findAllPersons() {
        try {
            LOG.info("findAllPersons");
            TypedQuery<Person> typedQuery = entityManager.createQuery("SELECT p FROM Person p", Person.class);
            List<Person> persons = typedQuery.getResultList();
            return copyPersonsToDto(persons);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    private List<PersonDto> copyPersonsToDto(List<Person> persons) {

        List<PersonDto> personDto;
        personDto = persons
                .stream()
                .map(x -> new PersonDto(x.getIdPerson(), x.getFirstName(), x.getLastName(), x.getAddress(), x.getCNP(), x.getBirthDate(),x.getPhoneNumber())).collect(Collectors.toList());
        return personDto;
    }
    public void deletePersonsByIds(List<Long> personsIds) {
        LOG.info("deletePersonsByIds");

        for(Long personId : personsIds){
            Person person = entityManager.find(Person.class, personId);
            entityManager.remove(person);
        }
    }

    public void createPerson(Long personId, String firstName, String lastName, String address, String cnp, Date date, Integer phoneNumber) {
        LOG.info("createPerson");

        Person person = entityManager.find(Person.class, personId);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAddress(address);
        person.setCNP(cnp);
        person.setBirthDate(date);
        person.setPhoneNumber(phoneNumber);

        entityManager.persist(person);

    }
}
