package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.addUser(new User("User1", "Lastname1", "user1@mail.ru"
                , new Car("Car1", 10)));
        userService.addUser(new User("User2", "Lastname2", "user2@mail.ru"
                , new Car("Car2", 20)));
        User foundUser = userService.getUserByModelAndSeries("Car2", 20);
        System.out.println("Id = "+foundUser.getId());
        System.out.println("First Name = "+foundUser.getFirstName());
        System.out.println("Last Name = "+foundUser.getLastName());
        System.out.println("Email = "+foundUser.getEmail());
        System.out.println();

        List<User> users = userService.getUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+user.getEmail());
            System.out.println();
        }

        context.close();
    }
}