package com.nextgenpos.nextgenpos.ejb;

import com.nextgenpos.nextgenpos.common.NotifyDto;
import com.nextgenpos.nextgenpos.common.UserDto;
import com.nextgenpos.nextgenpos.entities.Notify;
import com.nextgenpos.nextgenpos.entities.Product;
import com.nextgenpos.nextgenpos.entities.User;
import jakarta.ejb.EJBException;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NotifyBean {
    private static final Logger LOG = Logger.getLogger(ProductsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void createNotify(UserDto userDto){
        try {
            LOG.info("createNotify");

            Notify notify = new Notify();

            String notificationContent = "Hello! A new user has been added. You can enable it from the following link: ";
            notify.setContent(notificationContent);
            String notificationTitle = " New notification for enable user: " + userDto.getUsername() + " ("+userDto.getPerson().getFirstName() + " " + userDto.getPerson().getLastName()+")" ;
            notify.setTitle(notificationTitle);
            String relativePath = "/EnableUser?id=" + userDto.getIdUser().toString();
            notify.setRelativePath(relativePath);

            entityManager.persist(notify);
            entityManager.flush();
        }catch(Exception ex) {
        throw new EJBException(ex);
        }
    }

    public List<NotifyDto> getAllNotifies(){
        try{
            LOG.info("getAllNotifies");
            TypedQuery<Notify> typedQuery = entityManager.createQuery("SELECT n FROM Notify n", Notify.class);
            List<Notify> notifiesList= typedQuery.getResultList();

            return notifiesList
                    .stream()
                    .map(n->new NotifyDto(n.getId(),n.getTitle(),n.getContent(),n.getRelativePath()))
                    .collect(Collectors.toList());
        }
        catch(Exception ex)
        { throw new EJBException(ex);}
    }
}
