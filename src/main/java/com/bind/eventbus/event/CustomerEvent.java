package com.bind.eventbus.event;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerEvent {
    private  Object o = new Object();
    private Logger logger =  LoggerFactory.getLogger(CustomerEvent.class);
    private String filePath;
    private String userid;
    private String taskid;

    public CustomerEvent(String filePath, String taskid, String userid,int count) {
        this.filePath = filePath;
        this.userid = userid;
        this.taskid = taskid;
    }
    public void Excute() {
        synchronized(o){
            int i=100;
            while (i>0){
                System.out.println(Thread.currentThread().getName()+"执行任务");
                i--;
                try{
                    Thread.sleep(50L);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }



      /*  try{
            new Thread(new Runnable() {
                @Override
                public void run() {
                   int i=100;
                   while (i>0){
                       System.out.println(Thread.currentThread().getName()+"执行任务");
                        i--;
                      try{
                          Thread.sleep(50L);
                      }catch (Exception e){
                          e.printStackTrace();
                      }
                   }
                }
            }).start();
        }catch(Exception e){
            e.printStackTrace();
        }*/
    }
}