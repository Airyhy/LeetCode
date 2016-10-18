package VFacebookTemp;

import java.util.ArrayList;
import java.util.List;

/**
 Given a string that contains only digits 0-9 and a target value,
 return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

 Examples:
 "123", 6 -> ["1+2+3", "1*2*3"]
 "232", 8 -> ["2*3+2", "2+3*2"]
 "105", 5 -> ["1*0+5","10-5"]
 "00", 0 -> ["0+0", "0-0", "0*0"]
 "3456237490", 9191 -> []
 */

/**
 * overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
 0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
 a little trick is that we should save the value that is to be multiplied in the next recursion.
 */
public class ExpressionAddOperators {



    /**
     * BFS
     */
    List<String> result =new ArrayList<String>();
    public List<String> addOperators1(String num, int target) {
        for(int i=1;i<=num.length();i++){
            if(i>=2 && num.charAt(0)=='0') continue;
            bfs(num.substring(i),num.substring(0,i),target,0,Long.parseLong(num.substring(0,i)),true);
        }
        return result;
    }

    public void bfs(String s,String trace,int target,long pre,long current,boolean sign){
        long sum = sign? pre+current:pre-current;
        if(s.length()==0){
            if(sum==(long) target) result.add(trace);
            return;
        }
        for(int i=1;i<=s.length();i++){
            if(i>=2 && s.charAt(0)=='0') continue;
            int number = Integer.parseInt(s.substring(0,i));
            bfs(s.substring(i),trace+"+"+number,target,sum,number,true);
            bfs(s.substring(i),trace+"-"+number,target,sum,number,false);
            bfs(s.substring(i),trace+"*"+number,target,pre,current*number,sign);
        }
    }


    /**
     * dfs
     */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num, 0, target, 0, 0);
        return res;
    }


    public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) {
        if(pos == num.length()) {
            if(target == prev) res.add(sb.toString());
            return;
        }
        for(int i = pos; i < num.length(); i++) {
            if(num.charAt(pos) == '0' && i != pos) break;
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if(pos == 0) {
                dfs(res, sb.append(curr), num, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr);
                sb.setLength(len);
                dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr);
                sb.setLength(len);
                dfs(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr);
                sb.setLength(len);
            }
        }
    }


}
