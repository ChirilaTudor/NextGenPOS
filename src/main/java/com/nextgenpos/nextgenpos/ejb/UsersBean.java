package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.common.UserDto;
import com.nextgenpos.nextgenpos.entities.Person;
import com.nextgenpos.nextgenpos.entities.User;
import com.nextgenpos.nextgenpos.entities.UserGroup;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Bool;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class UsersBean {
    @Inject
    PasswordBean passwordBean;
    private static final Logger LOG = Logger.getLogger(UsersBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public  void disableUser(Long userId) {
        try{
            LOG.info("disableUser " + userId);
            User user = entityManager.find(User.class, userId);
            user.setActive(false);
        }
        catch (Exception ex)
        {throw new EJBException(ex);}
    }
    public  void enableUser(Long userId) {
        try{
            LOG.info("enableUser " + userId);
            User user = entityManager.find(User.class, userId);
            user.setActive(true);
        }
        catch (Exception ex)
        {throw new EJBException(ex);}
    }

    public List<UserDto> findAllUsers() {
        try {
            LOG.info("findAllUsers");
            TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<UserDto> copyUsersToDto(List<User> users) {
        List<UserDto> userDto;
        userDto = users
                .stream()
                .map(x -> new UserDto(x.getIdUser(), x.getUsername(), x.getPassword(), x.getPerson(), x.getTypeEmployee(), x.isActive())).collect(Collectors.toList());
        return userDto;
    }

    public void createUser(Long idUser,String username, String password, Long personId , String typeEmployee, Boolean isActive,Collection<String> groups) {
        LOG.info("createUser");

        User newUser = new User();
        newUser.setIdUser(idUser);
        newUser.setUsername(username);
        newUser.setPassword(passwordBean.convertToSha256(password));

        Person person = entityManager.find(Person.class, personId);
        newUser.setPerson(person);

        newUser.setTypeEmployee(typeEmployee);
        newUser.setActive(isActive);
        entityManager.persist(newUser);

//        assignGroupsToUser(username, groups);
    }

    private void assignGroupsToUser(String username, Collection<String> groups) {
        LOG.info("assignGroupsToUser");

        for (String group : groups) {
            UserGroup userGroup = new UserGroup();
            userGroup.setUsername(username);
            userGroup.setUserGroup(group);
            entityManager.persist(userGroup);
        }
    }
    public Collection<String> findUsernamesByUserIds(Collection<Long> userIds){
        List<String> usernames =
                entityManager.createQuery("SELECT u.username FROM User u WHERE u.idUser IN :userIds", String.class)
                        .setParameter("userIds", userIds)
                        .getResultList();
        return usernames;
    }
    public void deleteUsersByIds(List<Long> userIds) {
        LOG.info("deletePersonsByIds");

        for(Long userId : userIds){
            User user = entityManager.find(User.class, userId);
            entityManager.remove(user);
        }
    }


}
