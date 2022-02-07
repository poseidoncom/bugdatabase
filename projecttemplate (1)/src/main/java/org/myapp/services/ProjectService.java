package org.myapp.services;

import java.util.*;
import org.myapp.model.Project;
import org.myapp.dao.ProjectDAO;
import org.myapp.ApplicationException;

public class ProjectService {

  private ProjectDAO projectDAO = new ProjectDAO();

  /**
   * Function list customers with their id-(primary key) values, so that id can be
   * used to loan a book.
   **/

  public void listProjects() {
    try {
      List<Project> projects = projectDAO.getProjects();
      System.out.println("---------------------------------\n");
      for (Project project : projects) {
        System.out.println("Project no\t" + project.getId() + "\nProject name\t" + project.getProjectName());
        System.out.println("---------------------------------\n");
      }
    } catch (Exception e) {
      System.out.println("listing projects failed");
    }
  }

  public void addProject(String projectName) throws ApplicationException {
    if (projectName == null) {
      throw new ApplicationException("All project fields are required");
    }
    Project project = new Project();
    project.setProjectName(projectName);

    // We have to convert text presentation to number. SQLite uses here long
    // value for date, so that date comparison is possible but conversion is needed
    // first.
    projectDAO.addProject(project);
  }

}
