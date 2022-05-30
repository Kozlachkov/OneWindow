package com.OneWindow.models;

public class Task implements Comparable<Task> {
    private String id;
    private int priority;
    private boolean fulfilledTask = false; //удачное или неудачное выполнение
    private boolean workCompleted = false; //задание пройдено

    public Task(String id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public String getTaskId() {  return this.id;}
    public void setTaskId(String id) {  this.id = id; }
    public int getTaskPriority() { return this.priority; }
    public void setTaskPriority(int priority) {  this.priority = priority;  }
    public boolean isFulfilledTask() {  return this.fulfilledTask;   }
    public void setFulfilledTask(boolean fulfilledTask) { this.fulfilledTask = fulfilledTask;  }
    public boolean isWorkCompleted() {  return workCompleted; }
    public void setWorkCompleted(boolean workCompleted) {  this.workCompleted = workCompleted;  }

    @Override
    public int compareTo(Task task) {
        return (this.priority - task.priority);
    }

}

