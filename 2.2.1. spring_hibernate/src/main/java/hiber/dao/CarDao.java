package hiber.dao;

import hiber.model.User;

public interface CarDao {
    User getUser(String model, int series);
}
