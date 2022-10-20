package web.service;

import web.dao.CarDao;
import web.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

  @Autowired
  private CarDao carDao;

  @Transactional(readOnly = true)
  @Override
  public List<Car> getCars() {
    return carDao.getCars();
  }

  @Transactional(readOnly = true)
  @Override
  public List<Car> getCars(int count) {
    return carDao.getCars(count);
  }

}
