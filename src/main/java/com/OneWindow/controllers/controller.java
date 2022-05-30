package com.OneWindow.controllers;

import com.OneWindow.models.OutPutInfo;
import com.OneWindow.models.Task;
import com.OneWindow.models.TaskManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class controller {
    private TaskManager taskManager = new TaskManager(3); //кол-во роботов-операторов

    @PostMapping()
    public String indexStart(ModelMap modelMap) throws InterruptedException {
        List<Task> listOfTasks = taskManager.addToQueue(7); // кол-во задач
        for (Task task1 : listOfTasks){ //обнуление для повторного использования
            task1.setFulfilledTask(false);
            task1.setWorkCompleted(false);
        }
        List<OutPutInfo> outPutInfos = taskManager.setTaskToRobots(listOfTasks);
        modelMap.addAttribute("outPutInfos", outPutInfos);
        return("/index");
    }

    @GetMapping()
    public String index (){
        return("/index");
    }

}
