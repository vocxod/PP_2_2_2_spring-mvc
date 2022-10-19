package web.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "model")
  private String model;

  @Column(name = "series")
  private Integer series;

  @Column(name = "color")
  private String color;

  public Car() {
  }

  public Car(String model, Integer series) {
    this.model = model;
    this.series = series;
  }

  public Car(Long id, String model, Integer series) {
    this.setId(id);
    this.model = model;
    this.series = series;
  }

  public Car(Long id, String model, Integer series, String color) {
    this.setId(id);
    this.model = model;
    this.series = series;
    this.color = color;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getSeries() {
    return series;
  }

  public void setSeries(Integer series) {
    this.series = series;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String toString() {
    return "Model:" + this.model + " series:" + this.series + " color:" + this.color;
  }

}
