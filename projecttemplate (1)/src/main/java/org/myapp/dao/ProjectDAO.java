package org.myapp.dao;

import io.ebean.*;
import io.ebean.DB;
import java.util.*;
import org.myapp.ApplicationException;
import org.myapp.model.Project;

public class ProjectDAO {

  public void addProject(Project project) throws ApplicationException {
    try {
      project.save();
    } catch (Exception e) {
      e.printStackTrace();
      throw (new ApplicationException("Saving the project failed"));
    }
  }

  /**
   * List<Order> list = DB.find(Order.class) .fetch("customer") .orderBy("id")
   * .findList();
   */

  public List<Project> getProjects() {
    return DB.find(Project.class).orderBy("project_name").findList();
  }

  public Project getProjectById(Long id) throws ApplicationException {
    try {
      return DB.find(Project.class).where(Expr.eq("id", id)).findOne();
    } catch (Exception e) {
      System.out.println("Getting project by id failed: " + e.getMessage());
      throw (new ApplicationException("Getting project " + id + " failed."));
    }
  }

}