package VFacebookTemp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * main 0 start
 * a 1 start
 * b 3 start
 * b 5 end
 * a 6 end
 * main 7 end
 *
 * main -> 2
 * a -> 3
 * b -> 2
 *
 */
public class ThreadTaskTimeCount {


    public Map<String,Integer> countThreadTime(List<entry> list){
        Map<String, Integer> rst = new HashMap<>();
        Stack<String> store = new Stack<>();
        int pretime = 0;
        String pretask = null;

        for(entry e: list){
            String task = e.task;
            int time = e.time;
            if(e.isStart){
                if(pretask!=null){
                    store.push(pretask);
                    rst.put(pretask,rst.getOrDefault(pretask,0)+time-pretime);
                } else {
                    rst.put(task,pretime);
                }
                pretask = task;
            } else{
                rst.put(task,rst.getOrDefault(pretask,0)+time-pretime);
                if(store.isEmpty()){
                    pretask = null;
                } else{
                    pretask = store.pop();
                }
            }
            pretime = time;
        }

        return rst;
    }

    class entry{
        String task;
        int time;
        boolean isStart;

        public entry(String t, int ti, boolean i){
            task = t;
            time = ti;
            isStart = i;
        }
    }
}
