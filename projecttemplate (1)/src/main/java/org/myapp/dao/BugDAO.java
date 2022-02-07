package org.myapp.dao;

import org.myapp.model.Bug;
import io.ebean.*;
import io.ebean.DB;
import java.util.*;
import org.myapp.ApplicationException;

public class BugDAO {

  public void addBug(Bug bug) throws ApplicationException {
    try {
      bug.save();
    } catch (Exception e) {
      e.printStackTrace();
      throw (new ApplicationException("Reporting the bug failed"));
    }
  }

  public Bug getBugById(Long id) throws ApplicationException {
    try {
      return DB.find(Bug.class).where(Expr.eq("id", id)).findOne();
    } catch (Exception e) {
      System.out.println("Getting bug by id failed: " + e.getMessage());
      throw (new ApplicationException("Getting bug " + id + " failed."));
    }
  }

  /**
   * Function returns active loans of the customer. There are too many returned
   * loans and they are not returned, because they do not need any actions
   * anymore.
   **/
  public List<Bug> getBugs() throws ApplicationException {
    try {
      return DB.find(Bug.class)
          .findList();
    } catch (Exception e) {
      System.out.println("Getting assigned bugs failed: " + e.getMessage());
      throw (new ApplicationException("Getting loans failed."));
    }
  }

  //Listaa kehittäjälle osoitetut bugit
  public List<Bug> getAssignedBugs(Long developerId) throws ApplicationException {
    try {
      return DB.find(Bug.class).where(Expr.eq("developer", developerId))
          .findList();
    } catch (Exception e) {
      System.out.println("Getting assigned bugs failed: " + e.getMessage());
      throw (new ApplicationException("Getting loans failed."));
    }
  }

  

  public void updateBug(Bug bug) throws ApplicationException {
    try {
      bug.update();
    } catch (Exception e) {
      // e.printStackTrace();
      throw (new ApplicationException("Saving the bug failed"));
    }
  }
}