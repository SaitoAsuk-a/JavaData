package dataStructure.list;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {

        String expstr="1+3*(9-2)+90";
        String postfix = toPostfix(expstr);
        System.out.println("��׺���ʽ->expstr=  "+expstr);
        System.out.println("��׺���ʽ->postfix= "+postfix);
        System.out.println("������->value= "+calculatePostfixValue(postfix));

    }


    /**
     * ��׺ת��׺
     *
     * @param expstr ��׺���ʽ�ַ���
     * @return
     */
    public static String toPostfix(String expstr) {
        //����ջ,���ڴ洢�����
        Stack<String> stack = new Stack<>();

        String postfix = "";//�洢��׺���ʽ���ַ���
        int i = 0;
        while (i < expstr.length()) {
            char ch = expstr.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    //��ջ��Ϊ�ջ���ջ��Ԫ�ز���������ʱ,ֱ�ӳ�ջ,��˴�ʱֻ�п�����*/+-���������(���ݹ���4),������ջ
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix += stack.pop();
                    }
                    //��ջ
                    stack.push(ch + "");
                    i++;
                    break;
                case '*':
                case '/':
                    //���������*/
                    while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        postfix += stack.pop();
                    }
                    stack.push(ch + "");
                    i++;
                    break;
                case '(':
                    //������ֱ����ջ
                    stack.push(ch + "");
                    i++;
                    break;
                case ')':
                    //����������(����3)
                    String out = stack.pop();
                    while (out != null && !out.equals("(")) {
                        postfix += out;
                        out = stack.pop();
                    }
                    i++;
                    break;
                default:
                    //������ֱ����ջ
                    while (ch >= '0' && ch <= '9') {
                        postfix += ch;
                        i++;
                        if (i < expstr.length())
                            ch = expstr.charAt(i);
                        else
                            ch = '=';
                    }
                    //�ָ���
                    postfix += " ";
                    break;
            }
        }
        //���������������ջ(����5)
        while (!stack.isEmpty())
            postfix += stack.pop();
        return postfix;
    }

    /**
     * �����׺���ʽ��ֵ
     * @param postfix �����׺���ʽ
     * @return
     */
    public static int calculatePostfixValue(String postfix)
    {
        //ջ���ڴ洢������,Э������
        Stack<Integer> stack = new Stack<>();
        int i=0, result=0;
        while (i<postfix.length())
        {
            char ch=postfix.charAt(i);
            if (ch>='0' && ch<='9')
            {
                result=0;
                while (ch!=' ')
                {
                    //�������ַ�תΪ����ֵch=90
                    result = result*10 + Integer.parseInt(ch+"");
                    i++;
                    ch = postfix.charAt(i);
                }
                i++;
                stack.push(result);//��������ջ
            }
            else
            {  //ch �������,��ջջ����ǰ����Ԫ��
                int y= stack.pop();
                int x= stack.pop();
                switch (ch)
                {   //����������м���
                    case '+': result=x+y; break;
                    case '-': result=x-y; break;
                    case '*': result=x*y; break;
                    case '/': result=x/y; break;   //ע�����ﲢûȥ�жϳ����Ƿ�Ϊ0�����
                }
                //����������ջ
                stack.push(result);
                i++;
            }
        }
        //�����Ľ����ջ������
        return stack.pop();
    }
}
