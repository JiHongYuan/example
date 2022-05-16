package org.github.数据结构与算法.stack;


import java.math.BigDecimal;
import java.util.Stack;

/**
 * @author JiHongYuan
 * @date 2021/7/14 9:56
 */
public class StackCalc {

    public static void main(String[] args) {
        String expression = "3 + 2 * 6 - 2";

        Stack<BigDecimal> operandStack = new Stack<>();
        Stack<InfixConvertSuffixCalc.SymbolEnum> symbolStack = new Stack<>();

        for (String s : expression.split(InfixConvertSuffixCalc.SymbolEnum.NONE.symbol)) {
            InfixConvertSuffixCalc.SymbolEnum symbol = InfixConvertSuffixCalc.SymbolEnum.getSymbolEnumByString(s);
            if (symbol == InfixConvertSuffixCalc.SymbolEnum.NONE) {
                operandStack.push(new BigDecimal(s));
            } else {
                if (symbolStack.isEmpty()) {
                    symbolStack.push(symbol);
                } else if (symbolStack.peek().priority > symbol.priority) {
                    symbolStack.push(symbol);
                } else {
                    BigDecimal i1 = operandStack.pop();
                    BigDecimal i2 = operandStack.pop();
                    InfixConvertSuffixCalc.SymbolEnum symbolEnum = symbolStack.pop();

                    BigDecimal result;
                    switch (symbol) {
                        case ADD:
                        case MUL:
                            result = InfixConvertSuffixCalc.calc(i1, i2, symbolEnum);
                            break;
                        case SUB:
                        case DIV:
                            result = InfixConvertSuffixCalc.calc(i2, i1, symbolEnum);
                            break;
                        default:
                            result = new BigDecimal("0.00");
                    }
                    operandStack.push(result);
                    symbolStack.push(symbol);
                }
            }
        }

        while (!symbolStack.isEmpty()){
            BigDecimal i1 = operandStack.pop();
            BigDecimal i2 = operandStack.pop();
            InfixConvertSuffixCalc.SymbolEnum symbolEnum = symbolStack.pop();

            BigDecimal result;
            switch (symbolEnum) {
                case ADD:
                case MUL:
                    result = InfixConvertSuffixCalc.calc(i1, i2, symbolEnum);
                    break;
                case SUB:
                case DIV:
                    result = InfixConvertSuffixCalc.calc(i2, i1, symbolEnum);
                    break;
                default:
                    result = new BigDecimal("0.00");
            }
            operandStack.push(result);
        }
        System.out.println(operandStack.peek());
    }
}
