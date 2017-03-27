import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import org.sql2o.*;

public class Task {
  private String description;
  private boolean completed;
  private LocalDateTime createdAt;
  //private static ArrayList<Task> instances = new ArrayList<Task>();
  private int id;

  public Task(String description) {
    this.description = description;
    completed = false;
    createdAt = LocalDateTime.now();
    // instances.add(this);
    // mId = instances.size();
  }

  public static List<Task> all() {
    String sql = "SELECT id, description FROM tasks";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Task.class);
    }
  }

  public String getDescription() {
    return description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  // public static ArrayList<Task> all() {
  //   return instances;
  // }

  // public static void clear() {
  //   instances.clear();
  // }

  public int getId() {
    return id;
  }

  public static Task find(int id) {
  //return instances.get(id - 1);
  }

  @Override
  public boolean equals(Object otherTask) {
    if (!(otherTask instanceof Task)) {
      return false;
    } else {
      Task newTask = (Task) otherTask;
      return this.getDescription().equals(newTask.getDescription());
    }
  }

}
