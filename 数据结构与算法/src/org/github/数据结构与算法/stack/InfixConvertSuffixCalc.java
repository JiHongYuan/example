package org.github.数据结构与算法.stack;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author JiHongYuan
 * @date 2021/6/14 13:45
 */
public class InfixConvertSuffixCalc {

    public static void main(String[] args) {
        String expression = "3 + 2 * 6 - 2";
        List<String> suffixList = infixTransformSuffix(expression);

        System.out.println(suffixList);
        Stack<BigDecimal> stack = new Stack<>();
        for (String s : suffixList) {
            SymbolEnum symbol = SymbolEnum.getSymbolEnumByString(s);
            if (symbol == SymbolEnum.NONE) {
                stack.push(new BigDecimal(s));
            } else {
                BigDecimal i1 = stack.pop();
                BigDecimal i2 = stack.pop();

                BigDecimal result;
                switch (symbol) {
                    case ADD:
                    case MUL:
                        result = calc(i1, i2, symbol);
                        break;
                    case SUB:
                    case DIV:
                        result = calc(i2, i1, symbol);
                        break;
                    default:
                        result = new BigDecimal("0.00");
                }
                stack.push(result);
            }
        }

        System.out.println(stack.pop());
    }

    /**
     * 中缀表达式转换成后缀表达式
     *
     * @param expression 中缀表达式
     * @return 后缀表达式
     */
    public static List<String> infixTransformSuffix(String expression) {
        List<String> suffixList = new ArrayList<>();

        Stack<SymbolEnum> stack = new Stack<>();
        for (String s : expression.split(SymbolEnum.NONE.symbol)) {
            SymbolEnum symbol = SymbolEnum.getSymbolEnumByString(s);
            if (symbol == SymbolEnum.NONE) {
                suffixList.add(s);
            } else {
                if (symbol == SymbolEnum.RIGHT_PARENTHESIS) {
                    suffixFiller(stack, suffixList, SymbolEnum.RIGHT_PARENTHESIS);
                } else if (stack.isEmpty() || stack.peek().priority > symbol.priority) {
                    stack.push(symbol);
                } else {
                    suffixFiller(stack, suffixList, SymbolEnum.NONE);
                    stack.push(symbol);
                }
            }
        }
        suffixFiller(stack, suffixList, SymbolEnum.NONE);
        return suffixList;
    }

    /**
     * 后缀表达式填充
     *
     * @param stack      数据源栈
     * @param suffixList 填充目标列表
     * @param symbol     当前表达式
     */
    public static void suffixFiller(Stack<SymbolEnum> stack, List<String> suffixList, SymbolEnum symbol) {
        while (!stack.isEmpty()) {
            SymbolEnum top = stack.peek();
            if (SymbolEnum.LEFT_PARENTHESIS == top) {
                if (symbol == SymbolEnum.RIGHT_PARENTHESIS) stack.pop();
                return;
            }
            suffixList.add(stack.pop().symbol);
        }
    }

    public static BigDecimal calc(BigDecimal i1, BigDecimal i2, SymbolEnum symbol) {
        BigDecimal result;
        switch (symbol) {
            case ADD:
                result = i1.add(i2);
                break;
            case SUB:
                result = i1.subtract(i2);
                break;
            case MUL:
                result = i1.multiply(i2);
                break;
            case DIV:
                result = i1.divide(i2);
                break;
            default:
                result = new BigDecimal("0.00");
        }
        return result;
    }

    public enum SymbolEnum {
        /**
         *
         */
        ADD("+", 4),
        SUB("-", 4),
        MUL("*", 3),
        DIV("/", 3),
        LEFT_PARENTHESIS("(", 1),
        RIGHT_PARENTHESIS(")", 1),
        NONE(" ", -1);
        String symbol;
        int priority;

        SymbolEnum(String symbol, int priority) {
            this.symbol = symbol;
            this.priority = priority;
        }

        public static SymbolEnum getSymbolEnumByString(String s) {
            for (SymbolEnum value : SymbolEnum.values()) {
                if (s.equals(value.symbol)) {
                    return value;
                }
            }
            return NONE;
        }
    }

}
