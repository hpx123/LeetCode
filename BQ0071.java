import java.util.Stack;

/**
 * 1.此题主要考察的是栈,所以定义一个辅助栈;
 2.先把字符串以"/"为分隔符分割成数组,此时数组有"路径"、""、"."、".."这四种情况;
 3.遍历数组,当s[i].equals("..")并且栈不空时pop,当!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."),即s[i]是路径入栈;
 4.栈空,返回"/",栈非空,用StringBuffer做一个连接返回即可;
 **/
public class BQ0071 {
    public static String simplifyPath(String path) {
        String[] road = path.split("/");
        Stack<String> rightPath = new Stack<>();
        for(int i = 0; i < road.length; i++){
            String temp = road[i];
            if(temp.equals("..") && !rightPath.isEmpty()){
                rightPath.pop();
            }else if(!temp.equals("") && !temp.equals(".") && !temp.equals("..")){
                rightPath.push(temp);
            }
        }
        StringBuffer buffer = new StringBuffer();
        if(rightPath.isEmpty()){
            buffer.append("/");
        }else {
           for(int i = 0; i < rightPath.size(); i++) {
                buffer.append("/" + rightPath.get(i));
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String s = "//////////a/./../";
        System.out.println(simplifyPath(s));
    }

}
