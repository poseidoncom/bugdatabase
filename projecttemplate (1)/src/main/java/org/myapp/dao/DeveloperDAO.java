package org.myapp.dao;

import io.ebean.*;
import io.ebean.DB;
import java.util.*;
import org.myapp.ApplicationException;
import org.myapp.model.Developer;

public class DeveloperDAO {

  public void addDeveloper(Developer developer) throws ApplicationException {
    try {
      developer.save();
    } catch (Exception e) {
      e.printStackTrace();
      throw (new ApplicationException("Saving the developer failed"));
    }
  }

  /**
   * List<Order> list = DB.find(Order.class) .fetch("customer") .orderBy("id")
   * .findList();
   */

  public List<Developer> getDevelopers() {
    return DB.find(Developer.class).orderBy("usr_name").findList();
  }

  public Developer getDeveloperById(Long id) throws ApplicationException {
    try {
      return DB.find(Developer.class).where(Expr.eq("id", id)).findOne();
    } catch (Exception e) {
      System.out.println("Getting developer by id failed: " + e.getMessage());
      throw (new ApplicationException("Getting developer " + id + " failed."));
    }
  }

}