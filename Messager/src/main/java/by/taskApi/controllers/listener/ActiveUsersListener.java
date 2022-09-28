package by.taskApi.controllers.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class ActiveUsersListener implements HttpSessionListener {

    private static int numberOfUsersOnline;

    public ActiveUsersListener() {
        numberOfUsersOnline = 0;
    }

    public static int getNumberUsersOnline(){
        return numberOfUsersOnline;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

            numberOfUsersOnline++;

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        numberOfUsersOnline--;
    }
}
