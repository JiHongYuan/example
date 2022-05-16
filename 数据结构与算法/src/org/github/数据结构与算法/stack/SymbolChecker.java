package org.github.数据结构与算法.stack;

import java.util.Stack;

/**
 * @author JiHongYuan
 * @date 2021/6/14 13:33
 */
public class SymbolChecker {

    public static final String TEST = "public class SymbolCheckerTest {" +
            "    void f() {" +
            "    }}";

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        for (char c : TEST.toCharArray()) {

            if(c == '{'){
                stack.push('}');
            }

            if(c == '}' && (stack.isEmpty() || c != stack.pop())){
                printfError();
            }
        }

        if(!stack.isEmpty()){
            printfError();
        }
    }

    static void printfError(){
        System.out.println("Error");
    }
}
