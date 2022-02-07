package org.myapp.model;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Project extends Model {

  @Id
  Long id;

  String projectName;
  
  @Version
  Long lastUpdate;

  
  // This value is not stored to database. It is helping
  // conversion between integer type of birthday -column and
  // string-presentation used in function parameters.
  // database column is type of integer, because SQLite does not
  // support date-type of column.


  public Project() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public void setLastUpdate(Long lastUpdate){
    this.lastUpdate=lastUpdate;
  }

  public Long getLastUpdate(){
    return this.lastUpdate;
  }

 

  public String toString() {
    return "Id:\t" + this.id + "\nProject Name:\t" + this.projectName;
  }

}
