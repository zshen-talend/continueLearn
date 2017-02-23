package regexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    public void namedCapturingGroup() {
        String url = "http://www.example.org/uid/alex/docid/1/title/My+First+Blog";
        Pattern pattern = Pattern.compile("^.*/uid/(?<uid>.*)/docid/(?<docid>.*)/title/(?<title>.*)");
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches()) {
            String uid = matcher.group("uid");
            String docId = matcher.group("docid");
            String title = matcher.group("title");
            System.out.println("分组uid的内容是：" + uid);
            System.out.println("分组docId的内容是：" + docId);
            System.out.println("分组title的内容是：" + title);
        }
    }

    // 后向引用，捕获重复数字
    public void repeatPattern() {
        String str = "123-123-12-456-456";
        Pattern pattern = Pattern.compile("(?<num>\\d+)-\\k<num>");
        Matcher matcher = pattern.matcher(str);
        System.out.println("开始数字分组输出：");
        while (matcher.find()) {
            String repeat = matcher.group("num");
            System.out.println(repeat);
        }
    }

    public void useUnicodeCharacterClass() {
        String str = "100１００";
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String digit = matcher.group(1); // 值为100
            System.out.println("一般结果为：" + digit);
        }
        pattern = Pattern.compile("(\\d+)", Pattern.UNICODE_CHARACTER_CLASS);
        matcher = pattern.matcher(str);
        if (matcher.find()) {
            String digit = matcher.group(1);// 值为100１００
            System.out.println("指定unicode字符集后的结果为：" + digit);
        }
    }

    public void matchScript() {
        String str = "abc你好123";
        Pattern pattern = Pattern.compile("(\\p{script=Han}+)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String hans = matcher.group(1);
            System.out.println(hans);
        }
    }

    public static void main(String[] args) {
        RegExp re = new RegExp();
        re.namedCapturingGroup();
        re.repeatPattern();
        re.useUnicodeCharacterClass();
        re.matchScript();
    }

}
