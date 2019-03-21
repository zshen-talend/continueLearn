/**
 * @Description: 分词技术demo
 */
package luceneTest;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class AnalyzerStudy {

    public static void main(String[] args) throws Exception {
        // 需要处理的测试字符串
        String str = "～ないで";
        Analyzer analyzer = null;
        // //标准分词器，如果用来处理中文，和ChineseAnalyzer有一样的效果，这也许就是之后的版本弃用ChineseAnalyzer的一个原因
        // analyzer = new StandardAnalyzer(Version.LUCENE_43);
        // //第三方中文分词器，有下面2中构造方法。
        // analyzer = new IKAnalyzer();
        // analyzer = new IKAnalyzer(false);
        // analyzer = new IKAnalyzer(true);
        // //空格分词器，对字符串不做如何处理
        // analyzer = new WhitespaceAnalyzer(Version.LUCENE_43);
        // //简单分词器，一段一段话进行分词
        // analyzer = new SimpleAnalyzer(Version.LUCENE_43);
        // 二分法分词器，这个分词方式是正向退一分词(二分法分词)，同一个字会和它的左边和右边组合成一个次，每个人出现两次，除了首字和末字
        analyzer = new CJKAnalyzer();
        // //关键字分词器，把处理的字符串当作一个整体
        // analyzer = new KeywordAnalyzer();
        // //被忽略的词分词器
        // analyzer = new StopAnalyzer(Version.LUCENE_43);

        // 使用分词器处理测试字符串
        StringReader reader = new StringReader(str);
        TokenStream tokenStream = analyzer.tokenStream("", reader);
        tokenStream.reset();
        CharTermAttribute term = tokenStream.getAttribute(CharTermAttribute.class);
        int l = 0;
        // 输出分词器和处理结果
        System.out.println(analyzer.getClass());
        while (tokenStream.incrementToken()) {
            System.out.print(term.toString() + "|");
            l += term.toString().length();
            // 如果一行输出的字数大于30，就换行输出
            if (l > 30) {
                System.out.println();
                l = 0;
            }
        }
    }
}
