/*
fomula_E => T (+T)*
fomula_T => F (*F)*
fomula_F => i | (E)
*/
import java.util.ArrayList;


public class Test9 {
    public static void main(String[] args) {
        Test9 test9 = new Test9();
        Formula formula = new Formula();
        formula.expression = "1+(5-2)*3";
        formula.word_initialize();

        int val = test9.E(formula);
        System.out.println("val=" + val);
    }

    int E(Formula formula) {
        int val;
        int val3;
        String op;

        val = T(formula);
		System.out.println("E--val(T-return):" + val);
		
        while ((formula.cur_pos < formula.word.size()) &&
                (formula.curWord().equals("+") ||
                formula.curWord().equals("-"))) {
            op = formula.curWord();
			System.out.println("E--op:" + op);
            formula.cur_pos++;
            val3 = T(formula);
			System.out.println("E--val3(T-return):" + val3);
			
            if (op.equals("+")) {
                val += val3;
            } else {
                val -= val3;
            }
        }
		System.out.println("E--return val:" + val);
        return val;
    }

    int T(Formula formula) {
        int val;
        int val3;
        String op;

        val = F(formula);
		System.out.println("T--val(F-return):" + val);
		
        while (((formula.cur_pos < formula.word.size()) &&
                formula.curWord().equals("*")) ||
                formula.curWord().equals("/")) {
            op = formula.curWord();
            formula.cur_pos++;
            val3 = F(formula);
			System.out.println("T--val3:" + val3);
			
            if (op.equals("*")) {
                val *= val3;
            } else {
                val /= val3;
            }
        }
		System.out.println("T--return val:" + val);
        return val;
    }

    int F(Formula formula) {
		
        int val;
        int val3;
        String op;
        String curWord = formula.curWord();
		System.out.println("F--curword:" + curWord);
		
        if (!(formula.curWord().equals("+") || formula.curWord().equals("-") ||
                formula.curWord().equals("*") || formula.curWord().equals("/") ||
                formula.curWord().equals("(") || formula.curWord().equals(")"))) {
            formula.cur_pos++;

            return Integer.valueOf(curWord);
        } else if (formula.curWord().equals("(")) {
            formula.cur_pos++;
            val = E(formula);
			System.out.println("F--val:" + val);
			
            if ((formula.cur_pos >= formula.word.size()) ||
                    !formula.curWord().equals(")")) {
                formula.err = 1;
                formula.err_Msg = "expression ERROR,missed )";

                return 0;
            }

            formula.cur_pos++;

            return val;
        } else {
            formula.err = 1;
            formula.err_Msg = "expression ERROR )";

            return 0;
        }
    }
}


class Formula {
    String expression;
    ArrayList<String> word = new ArrayList<String>();
    int cur_pos = 0;
    int err = 0;
    String err_Msg;

    void word_initialize() {
		//将expression中每个字符存入到List列表word中
        int pos = 0;
        char cur_Char;

        while (pos < expression.length()) {
            cur_Char = expression.charAt(pos);

            if ((cur_Char == '(') || (cur_Char == ')') || (cur_Char == '+') ||
                    (cur_Char == '-') || (cur_Char == '*') ||
                    (cur_Char == '/')) {
                word.add("" + cur_Char);
				System.out.println(word);
            } else if ((cur_Char >= '0') && (cur_Char <= '9')) {
                word.add("" + cur_Char);
				System.out.println(word);
            }

            pos++;
        }
    }

    String curWord() {
		//从word中取单个元素
        if (cur_pos >= word.size()) {
            return "";
        }

        return word.get(cur_pos);
    }
}
