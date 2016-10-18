package Design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haoyangyuan on 10/1/16.
 */
class User {
    private String name;
    public void pressButton(int toFloor) {
        Request req = new Request( toFloor);
        RequestProcessCenter  center = RequestProcessCenter.getInstance();
        center.addRequest(req);
    }
}


class Request {
    private int toFloor;
    public Request(int _toFloor) {
        toFloor = _toFloor;
    }
    public int getToFloor() {
        return toFloor;
    }
}

public class Elevator {
    public static Elevator instance = null;
    private int currentFloor;
    public static void Elevator( ) {
        if (instance == null) {
            synchronized (Elevator.class) {// late loading and eager loading
                if (instance == null) {
                    instance = new Elevator();
                }
            }
        }
    }

    public static Elevator getInstance() {
        if (instance == null) {
            synchronized (Elevator.class) {
                instance = new Elevator();
            }
        }
        return instance;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveToTargetFloor(int toFloor) {
        currentFloor = toFloor;
    }

    public void moveUp(){

    }
    public void moveDown(){

    }
}

class RequestProcessCenter implements Runnable {
    public static RequestProcessCenter instance = null;
    public static LinkedList<Request> queue;

    public RequestProcessCenter( ) {
        queue = new LinkedList<Request>( );
    }

    public static RequestProcessCenter getInstance() {
        if (instance == null) {
            synchronized (RequestProcessCenter.class){
                if (instance == null) {
                    instance = new RequestProcessCenter();
                }
            }
        }
        return instance;
    }

    public void run() {
       while ( true ) {
            processRequest( );
        }
    }

    public synchronized void addRequest(Request request) {
        queue.add(request);
    }

    public void removeRequest(Request request) {
       queue.remove(request);
    }

    public Request getNextRequest( ) {
        Request shortestReq = null;
        int shortest = Integer.MAX_VALUE;

        //maybe the farthest person can never get on the elevator
        int curFloor = Elevator.getInstance( ).getCurrentFloor( );
        for (Request item : queue) {
          int distance = Math.abs(curFloor - item.getToFloor( ) );
            if (distance < shortest) {
                shortest = distance;
                shortestReq = item;
            }
        }
        return shortestReq;
    }

    public synchronized void processRequest( ) {
        Request req = getNextRequest( );
        if (req != null) {
            int toFloor = req.getToFloor( );
            Elevator.getInstance().moveToTargetFloor( toFloor);
            queue.remove(req);
        }

    }
}

