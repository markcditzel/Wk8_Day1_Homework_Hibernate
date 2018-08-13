import dB.DBCar;
import models.Car;

import java.util.List;

public class Runner {

    // Method does not return anything, but accepts everything???
    public static void main(String[] args) {

        Car car1 = new Car("Morris Minor", 5);
        Car car2 = new Car("Austin Allegro", 5);

        List<Car> cars = DBCar.getAll();


    }

}