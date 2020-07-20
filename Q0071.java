import java.util.Stack;

public class Q0071 {

    public static String simplifyPath(String path) {
        Stack<Character> rightPath = new Stack();
        rightPath.push('/');

        for(int i = 0; i < path.length(); i++){
            char temp = path.charAt(i);
            char m = rightPath.peek();
            int count = 0;
           if(temp == '.'){
                count++;
                if((m == '.' && i == path.length() - 1 )|| (m == '/' && i == path.length() - 1)){
                    while(rightPath.peek() != '/') {
                        rightPath.pop();
                        count++;
                    }
                }else {
                    rightPath.push(temp);
                }
            }
           else if(temp == '/'){
                if(m == '/'){
                    continue;
                }else if(m == '.'){
                    while(rightPath.peek() != '/') {
                        rightPath.pop();
                        count++;
                    }
                }else {
                    rightPath.push(temp);
                }
            }else {
               rightPath.push(temp);
           }

           if(count == 2){
               if(rightPath.toString().length() > 3){
                    rightPath.pop();
                    while(rightPath.peek() != '/'){
                        rightPath.pop();
                    }
               }
           }
            if(count > 2){
                for(int j = 0; j < count; j++){
                    rightPath.push('.');
                }
            }
        }
        if(rightPath.peek() == '/' && rightPath.toString().length() >3){
            rightPath.pop();
        }
        StringBuffer buffer = new StringBuffer();
        while (!rightPath.isEmpty()){
            buffer.append(rightPath.pop());
        }

        return buffer.reverse().toString();
    }
    public static void main(String[] args) {
        String path = "/a..../sdf+s";
        System.out.println(simplifyPath(path));
    }
}

