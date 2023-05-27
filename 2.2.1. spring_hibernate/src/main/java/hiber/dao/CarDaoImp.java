package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImp implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String model, int series) {
        return (User) sessionFactory.getCurrentSession().createQuery(
                "from User where userCar.model = '" + model + "' and userCar.series = '" + series + "'").getSingleResult();
    }
}