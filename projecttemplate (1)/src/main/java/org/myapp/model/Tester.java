package org.myapp.model;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class Tester extends Model {

  @Id
  Long id;

  String usrName;
  String usrEmail;
  String usrPassword;
  
  @Version
  Long lastUpdate;

 

  // This value is not stored to database. It is helping
  // conversion between integer type of birthday -column and
  // string-presentation used in function parameters.
  // database column is type of integer, because SQLite does not
  // support date-type of column.


  public Tester() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return usrName;
  }

  public void setUserName(String usrName) {
    this.usrName = usrName;
  }

  public String getEmail() {
    return usrEmail;
  }

  public void setEmail(String usrEmail) {
    this.usrEmail = usrEmail;
  }
  public String getPassword() {
    return usrPassword;
  }

  public void setPassword(String usrPassword) {
    this.usrPassword = usrPassword;
  }

  public void setLastUpdate(Long lastUpdate){
    this.lastUpdate=lastUpdate;
  }

  public Long getLastUpdate(){
    return this.lastUpdate;
  }


  public String toString() {
    return "Id:\t" + this.id + "\nName:\t" + this.usrName + "\nEmail:\t" + this.usrEmail;
  }

}
