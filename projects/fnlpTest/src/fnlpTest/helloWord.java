// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package fnlpTest;

import java.util.HashMap;

import org.fnlp.nlp.cn.CNFactory;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class helloWord {

    public static void main(String[] args) throws Exception {
        // CWSTagger.main(args);
        // 创建中文处理工厂对象，并使用“models”目录下的模型文件初始化
        CNFactory factory = CNFactory.getInstance("models");

        // 使用分词器对中文句子进行分词，得到分词结果
        String[] words = factory.seg("关注自然语言处理、语音识别、深度学习等方向的前沿技术和业界动态。");

        // 打印分词结果
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();

        // 使用标注器对中文句子进行标注，得到标注结果
        String result = factory.tag2String("关注自然语言处理、语音识别、深度学习等方向的前沿技术和业界动态。");

        // 显示标注结果
        System.out.println(result);

        // 使用标注器对包含实体名的句子进行标注，得到结果
        HashMap<String, String> resultMap = factory.ner("詹姆斯·默多克和丽贝卡·布鲁克斯 鲁珀特·默多克旗下的美国小报《纽约邮报》的职员被公司律师告知，保存任何也许与电话窃听及贿赂有关的文件。");

        // 显示标注结果
        System.out.println(resultMap);

    }
}
