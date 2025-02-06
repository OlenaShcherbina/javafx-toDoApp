package sample.todoapp.model;

public class Task {
  private long dateCreated;
  private String description;
  private String task;


  public Task(){}
  public Task(long dateCreated, String description, String task) {
    this.dateCreated = dateCreated;
    this.description = description;
    this.task = task;
  }

  public long getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(long dateCreated) {
    this.dateCreated = dateCreated;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }
}
