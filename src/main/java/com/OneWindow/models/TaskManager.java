package com.OneWindow.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TaskManager {
    private int N; //количество роботов

    public TaskManager(int N) {
        this.N = N;
    }

    public List<Task> addToQueue(int numberOfTasks) {
        List<Task> tasks = new ArrayList<>();
        String[] forNumber = {"a", "b", "c"};
        int priority; //рандомно даем приоритеты
        int limit1=0; // для рандомного выбора из массива букв
        int limit2=forNumber.length;
        //создаем список заданий
        for (int i = 1; i < numberOfTasks + 1; i++) {
            priority = (int) (Math.random() * 10);
            tasks.add(new Task(forNumber[limit1 + (int) (Math.random() * limit2)] + i, priority));
        }
        //сортировка заданий по приоритетам
        Collections.sort(tasks);
        Collections.reverse(tasks);
        return tasks;
    }
    //Проверка окончания работы всех роботов - НЕ СДЕЛАНО
    public int calculateTasksFinished( List<Task> tasks) throws InterruptedException {
        int finishedCount = 0;
        for (int i=0; i<tasks.size(); i++){
            if (tasks.get(i).isWorkCompleted()) {
                finishedCount = finishedCount + 1;
            }
        }
        return finishedCount;
    }

    //распределяем задания по роботам
    public List<OutPutInfo> setTaskToRobots (List<Task> tasks) throws InterruptedException {
        //создаем роботов
        List<Robot> robots = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            Robot robot = new Robot("Robot_" + i);
            robots.add(robot);
        }
        //распределяем задания
        int active_task=0;
        List<OutPutInfo> outPutInfos = new ArrayList<>();
        ExecutorService es = Executors.newCachedThreadPool();
        while (calculateTasksFinished(tasks)!=tasks.size()) {
            for (int i = 0; i < robots.size(); i++) {
                if (robots.get(i).isAvalable() && active_task<tasks.size()) {
                    robots.get(i).setAvalable(false);//робот в работе
                    robots.get(i).setTask(tasks.get(active_task)); //роботу присвоено задание
                    outPutInfos.add(new OutPutInfo(robots.get(i), robots.get(i).getTask()));
                    es.submit(robots.get(i));
                    ++active_task;
                }
            }
        }
        return outPutInfos;
    }

}
