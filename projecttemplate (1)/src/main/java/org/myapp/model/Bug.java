package org.myapp.model;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.ManyToOne;


@Entity
public class Bug extends Model {

  @Id
  Long id;

  Long date;
  String version;
  String description;
  String criticality;
  String state;
  Integer votes = 1;

  @ManyToOne
  Developer developer;

  @ManyToOne
  Tester tester;

  @ManyToOne
  Project project;

  @Version
  Long lastUpdate;
 

  public Bug() {
  }


  //setterit ja getterit
  public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
  public Integer getVotes() {
		return votes;
	}
	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCriticality() {
		return criticality;
	}
	public void setCriticality(String criticality) {
		this.criticality = criticality;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

  public Long getDate(){
    return date;
  }

  public void setDate(Long date){
    this.date = date;
  }

  public void setLastUpdate(Long lastUpdate){
    this.lastUpdate=lastUpdate;
  }

  public Long getLastUpdate(){
    return this.lastUpdate;
  }



  //oliot
  public Developer getDeveloper(){
    return developer;
  }

  public void setDeveloper(Developer developer) {
    this.developer = developer;
  }

  public Tester getTester(){
    return tester;
  }

  public void setTester(Tester tester) {
    this.tester = tester;
  }

  public Project getProject(){
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }
  
  

  
 

}
