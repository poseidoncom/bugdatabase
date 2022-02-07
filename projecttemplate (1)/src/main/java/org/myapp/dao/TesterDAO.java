package org.myapp.dao;

import io.ebean.*;
import io.ebean.DB;
import java.util.*;
import org.myapp.ApplicationException;
import org.myapp.model.Tester;

public class TesterDAO {

  public void addTester(Tester tester) throws ApplicationException {
    try {
      tester.save();
    } catch (Exception e) {
      e.printStackTrace();
      throw (new ApplicationException("Saving the tester failed"));
    }
  }

  /**
   * List<Order> list = DB.find(Order.class) .fetch("customer") .orderBy("id")
   * .findList();
   */

  public List<Tester> getTesters() {
    return DB.find(Tester.class).orderBy("usr_name").findList();
  }

  public Tester getTesterById(Long id) throws ApplicationException {
    try {
      return DB.find(Tester.class).where(Expr.eq("id", id)).findOne();
    } catch (Exception e) {
      System.out.println("Getting tester by id failed: " + e.getMessage());
      throw (new ApplicationException("Getting tester " + id + " failed."));
    }
  }

}