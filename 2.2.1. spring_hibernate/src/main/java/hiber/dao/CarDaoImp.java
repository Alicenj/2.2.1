package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImp implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserByCar(String model, int series) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select u from User u join fetch u.userCar c where c.model=:model and c.series=:series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        List<User> userList = query.setMaxResults(1).getResultList();
        return userList.isEmpty() ? null : userList.get(0);
    }
}