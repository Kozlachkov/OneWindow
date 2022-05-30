package com.OneWindow.models;

public class OutPutInfo {
    private Robot robot;
    private Task task;

    public OutPutInfo(Robot robot, Task task) {
        this.robot = robot;
        this.task = task;
    }

    public Robot getRobot() { return robot;  }
    public void setRobot(Robot robot) {  this.robot = robot;    }
    public Task getTask() {  return task;  }
    public void setTask(Task task) { this.task = task;    }

}
