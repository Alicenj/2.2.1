package hiber.service;

import hiber.model.User;

public interface CarService {
    User getUser(String model, int series);
}
