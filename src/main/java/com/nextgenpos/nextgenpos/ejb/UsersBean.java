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

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class UsersBean {
    @Inject
    NotificationsBean notificationsBean;

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
                .map(x -> new UserDto(x.getIdUser(), x.getUsername(), x.getPassword(), x.getPerson(), x.isActive())).collect(Collectors.toList());
        return userDto;
    }

    public boolean createUser(String username, String password, String cnp, String address, Date birthDate, String firstName, String lastName, String phoneNumber, Long adminId, Collection<String> groups) {
        LOG.info("createUser");

        Boolean isUsername = usernameExist(username);

        if(isUsername == true){
            return false;
        }

        Person person = new Person();
        person.setCNP(cnp);
        person.setAddress(address);
        person.setBirthDate(birthDate);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhoneNumber(phoneNumber);

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordBean.convertToSha256(password));
        user.setActive(false);
        user.setPerson(person);

        entityManager.persist(user);
        person.setUser(user);
        entityManager.persist(person);

        User admin = entityManager.find(User.class, adminId);
        UserDto userDto = copyUserToDTO(user);
        UserDto adminDto = copyUserToDTO(admin);
        notificationsBean.createNotification(userDto,adminDto);
        assignGroupsToUser(username, groups);


        return true;
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


    public Long getIdByUsername(String username) {
        try {
            LOG.info("getIdByUsername");
            List<User> users = entityManager
                    .createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getResultList();

            if (users.isEmpty()) {
                return null;
            }
            User user = users.get(0);
            return user.getIdUser();

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private Boolean usernameExist(String username){
        try {
            LOG.info("usernameExist");
            List<User> users = entityManager
                    .createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getResultList();

            if (users.isEmpty()) {
                return false;
            }
            return true;

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private UserDto copyUserToDTO(User user){
        return new UserDto(user.getIdUser(),user.getUsername(),user.getPassword(),user.getPerson(),user.isActive());
    }

}
