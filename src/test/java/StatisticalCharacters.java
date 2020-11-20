import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatisticalCharacters {

    public static void main(String[] args) throws FileNotFoundException {
        String name = "D:/file.txt";
        int num = 0;      //数字数
        int letter = 0;    //字母数
        int space = 0;  //空格数
        int word= 0;  //汉字数
        int danci = 0;
        try{
            File file=new File(name);
            BufferedReader br= new BufferedReader(new FileReader(file));
            String str = null;
            while((str=br.readLine())!=null){
                num += countNumber(str);
                letter += countLetter(str);
                word += countChinese(str);
                space += countSpace(str);
                danci += countWord(str);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("数字数："+num);
        System.out.println("字母数"+letter);
        System.out.println("汉字数"+word);
        System.out.println("空格数"+space);
        System.out.println("单词数"+danci);
        System.out.println();
    }
    public static int countNumber(String str) {
        int count = 0;
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }
    public static int countLetter(String str) {
        int count = 0;
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }
    public static int countChinese(String str) {
        int count = 0;
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }
    public static int countSpace(String str) {
        int count = 0;
        Pattern p = Pattern.compile("\\s");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }

    //返回str中代表的单词个数
     public static int countWord(String str){
                 int count = 0;
                 boolean isWhiteSpace = true;//标记当前是否处在"空格"模式
                 for(int i = 0; i < str.length(); i++)
                     {
                         char c = str.charAt(i);
                         if(c == ' ' || c == '\t' || c == '\n')//如果碰到的是分隔符,else语句不会执行
                                 isWhiteSpace = true;
                         else if(isWhiteSpace)//当碰到非分隔符,刚好且 处在 "空格"模式时,单词计数加1
                             {
                                 count++;
                                 isWhiteSpace = false;
                             }
                     }
                 return count;
             }


}