package hiber.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hiber.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserByCarModelAndSeries(String model, int series) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("SELECT u FROM User u JOIN FETCH u.userCar c WHERE c.model=:model AND c.series=:series", User.class)
                .setParameter("model", model)
                .setParameter("series", series);
        return query.getSingleResult();
    }
}

