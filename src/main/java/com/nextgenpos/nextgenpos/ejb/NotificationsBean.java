package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.common.NotificationDto;
import com.nextgenpos.nextgenpos.common.UserDto;
import com.nextgenpos.nextgenpos.entities.Notification;
import com.nextgenpos.nextgenpos.entities.Reports;
import com.nextgenpos.nextgenpos.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class NotificationsBean {
    private static final Logger LOG = Logger.getLogger(Reports.class.getName());
    @Inject
    UsersBean usersBean;
    @PersistenceContext
    EntityManager entityManager;

    public void createNotification(UserDto user, UserDto admin){
        try{
            LOG.info("createNotification");
            Notification notification = new Notification();
            Date today = new Date();
            String notificationText = "A new user("+user.getPerson().getFirstName() +" "+ user.getPerson().getLastName() + ") with the username: "+  user.getUsername() + "  has been added into the database. In order to enable it's access, please click this link:";
            String notificationLink="/EnableUser=" + user.getIdUser().toString();
            User adminUser = entityManager.find(User.class, admin.getIdUser());
            notification.setAdmin(adminUser);
            notification.setDate(today);
            notification.setContent(notificationText);
            notification.setLink(notificationLink);
            notification.setRead(false);

            entityManager.persist(notification);
            adminUser.addNotification(notification);
        }   catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<NotificationDto> findALlNotifications(){
        try{
            LOG.info("findALlNotifications");
            TypedQuery<Notification> typedQuery = entityManager.createQuery("SELECT n from Notification n",Notification.class);
            List<Notification> notifications = typedQuery.getResultList();
            return  notifications.stream().map(n->new NotificationDto(n.getIdNotification(),n.getDate(),n.getRead(),n.getContent(),n.getLink(),n.getAdmin())).collect(Collectors.toList());
        }   catch (Exception ex) {
            throw new EJBException(ex);
        }
    }


}
