package web.dao;

import web.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @SuppressWarnings("unchecked")
  public List<Car> getCars() {
    TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
    return query.getResultList();
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Car> getCars(int count) {
    TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
    query.setFirstResult(0);
    query.setMaxResults(count);
    return query.getResultList();
  }

  @Override
  public void saveCar(Car car) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(car);
  }

  @Override
  public Car getCar(long carId) {
    Session session = sessionFactory.getCurrentSession();
    Car car = session.byId(Car.class).load(carId);
    return car;
  }

  @Override
  public void deleteCar(long carId) {
    Session session = sessionFactory.getCurrentSession();
    Car car = session.byId(Car.class).load(carId);
    session.delete(car);
  }

}
