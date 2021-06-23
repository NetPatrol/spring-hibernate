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
      Car one = new Car("Жигули",123456789);
      Car two = new Car("Лада",321654987);
      Car three = new Car("Волга",147258369);
      Car four = new Car("Москвич",963852741);
      Car five = new Car("SUZUKI",963852741);

      userService.add(new User("Валентина", "Матвиенко", "valka@mail.ru", one));
      userService.add(new User("Владимир", "Жириновский", "vovka@mail.ru", two));
      userService.add(new User("Дмитрий", "Песков", "usi@mail.ru", three));
      userService.add(new User("Дмитрий", "Киселев", "sovpadenie@mail.ru", four));
      userService.add(new User("Иван", "Иванов", "ivanich@mail.ru", five));

      userService.getUser("Жигули", 123456789).forEach(p -> {
         System.out.printf("Имя: %s\nФамилия: %s\nemail: %s\n",
         p.getFirstName(),
         p.getLastName(),
         p.getEmail());
      });

//      List<User> users = userService.listUsers();
//      System.out.println("-------<АВТОПАРК>-------");
//      users.forEach(c -> System.out.println("Автомобиль: " + c.getCar()));
//      System.out.println("-------<ВОДИТЕЛИ>-------");
//      users.forEach(u ->  {
//         System.out.printf("Id = %d\nFirst Name = %s\nLast Name = %s\nEmail = %s\nCar: %s",
//         u.getId(),
//         u.getFirstName(),
//         u.getLastName(),
//         u.getEmail(),
//         u.getCar());
//      });

      context.close();
   }
}
