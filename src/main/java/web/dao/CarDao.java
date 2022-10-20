package web.dao;

import web.model.Car;

import java.util.List;

public interface CarDao {

  List<Car> getCars();

  List<Car> getCars(int count);

  public void saveCar(Car car);

  public Car getCar(long carId);

  public void deleteCar(long carId);

}
