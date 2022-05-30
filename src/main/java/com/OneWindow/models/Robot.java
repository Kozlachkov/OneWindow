package com.OneWindow.models;

public class Robot implements Runnable {
    private String name;
    private Task task;
    private boolean avalable = true; //робот не занят

    public Robot (String name){this.name=name;    }

    //геттеры, сеттеры
    public String getRobotName() {  return name;  }
    public void setRobotName(String name) { this.name = name;   }
    public Task getTask() { return task;   }
    public void setTask(Task task) {  this.task = task;    }
    public boolean isAvalable() {  return avalable;    }
    public void setAvalable(boolean avalable) {  this.avalable = avalable;    }

    public  boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    public void run() {
        try { Thread.sleep(100); }
        catch (InterruptedException e) { e.printStackTrace();  }
        task.setFulfilledTask(getRandomBoolean()); //рандом удачного или неудачного исполнения
        task.setWorkCompleted(true);
        this.avalable = true;
        //System.out.println(getRobotName() + " закончил работу над заданием " + this.task.getTaskId() );
    }

}
