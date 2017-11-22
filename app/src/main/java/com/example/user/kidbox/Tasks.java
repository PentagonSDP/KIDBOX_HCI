package com.example.user.kidbox;

/**
 * Created by hosneara on 11/21/17.
 */

public class Tasks {
    private String task_name;
    private int isDone;
    private int points;
    private String image_path;
    private int ID;
    private int isDaily;

    Tasks()
    {

    }

    Tasks(int ID, String task_name, int task_type, int points, int isDone, String image_path)
    {
        this.ID = ID;
        this.task_name = task_name;
        this.isDaily = task_type;
        this.isDone = isDone;
        this.points = points;
        this.image_path = image_path;
    }

    public int getID()
    {
        return  this.ID;
    }
    public String getTask_name()
    {
        return this.task_name;
    }
    public int getIsDaily(){ return this.isDaily; }
    public int getIsDone()
    {
        return this.isDone;
    }
    public int getPoints()
    {
        return this.points;
    }
    public String getImage_path()
    {
        return this.image_path;
    }
    public void setTask_name(String task_name)
    {
        this.task_name = task_name;
    }
    public void setIsDaily(int isDaily){ this.isDaily = isDaily; }
    public void setIsDone(int isDone)
    {
        this.isDone = isDone;
    }
    public void setPoints(int points)
    {
        this.points = points;
    }
    public void setImage_path(String image_path)
    {
        this.image_path = image_path;
    }
    public void setID(int ID)
    {
        this.ID = ID;
    }
}
