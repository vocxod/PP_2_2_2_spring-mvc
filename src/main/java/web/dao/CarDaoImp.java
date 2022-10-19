package web.dao;

import web.model.Car;
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
  public void add(Car user) {
    sessionFactory.getCurrentSession().save(user);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Car> listCars() {
    TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
    return query.getResultList();
  }

}
