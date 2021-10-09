package com.xfc.basealgorithm.divide;

import java.util.ArrayList;
import java.util.List;

/**
 * 分治
 * <p>
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +,-以及*。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 * <p>
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xf.chen
 * @date 2021/9/14 14:46
 * @since 1.0.0
 */
public class DiffWaysToCompute {

    public List<Integer> diffWaysToCompute(String expression) {
        System.out.println("expression = " + expression);
        if(expression == null || expression == ""){
            return new ArrayList();
        }
        List<Integer> result = new ArrayList();
        // 转换为字符数组
        char[] chars = expression.toCharArray();
        // 遍历
        for(int i = 0;i<chars.length;i++){
            char c = chars[i];
            if(c == '-' || c=='+' || c == '*'){
                List<Integer> lefts = diffWaysToCompute(expression.substring(0,i));
                List<Integer> rights = diffWaysToCompute(expression.substring(i+1));
                for(Integer l : lefts){
                    for(Integer r: rights){
                        if(c == '-'){
                            result.add(l - r);
                        }else if(c == '+'){
                            result.add(l + r);
                        }else{
                            result.add(l * r);
                        }
                    }

                }

            }
        }
        if (result.isEmpty()) {
            result.add(Integer.valueOf(expression));
        }
        return result;

    }

    private ArrayList<Integer> t1(String input) {
        if (input == null || input.length() <= 0) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> curRes = new ArrayList<Integer>();
        int length = input.length();
        char[] charArray = input.toCharArray();


        for (int i = 0; i < length; i++) {
            char aChar = charArray[i];
            // 当前字符为 操作符
            if (aChar == '+' || aChar == '-' || aChar == '*') {
                List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(input.substring(i + 1));
                for (int leftNum : leftList) {
                    for (int rightNum : rightList) {
                        if (aChar == '+') {
                            curRes.add(leftNum + rightNum);
                        } else if (aChar == '-') {
                            curRes.add(leftNum - rightNum);
                        } else {
                            curRes.add(leftNum * rightNum);
                        }
                    }
                }

            }
        }

        if (curRes.isEmpty()) {
            curRes.add(Integer.valueOf(input));
        }
        return curRes;
    }
}
