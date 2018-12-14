package com.hankcs.hanlp.seg.common;

import com.hankcs.hanlp.corpus.document.sentence.Sentence;
import com.hankcs.hanlp.model.perceptron.PerceptronLexicalAnalyzer;
import com.hankcs.hanlp.model.perceptron.PerceptronSegmenter;
import junit.framework.TestCase;

public class CWSEvaluatorTest extends TestCase
{
    public void testGetPRF() throws Exception
    {
        CWSEvaluator evaluator = new CWSEvaluator();
        evaluator.compare("结婚 的 和 尚未 结婚 的", "结婚 的 和尚 未结婚 的");
        CWSEvaluator.Result prf = evaluator.getResult(false);
        assertEquals(0.6f, prf.P);
        assertEquals(0.5f, prf.R);
    }


    public void testCWS() throws Exception
    {
        PerceptronSegmenter segmenter = new PerceptronSegmenter("F:\\code\\HanLP\\data\\test\\perceptron\\cws.bin");
        System.out.println(segmenter.segment("事实上，视语料与任务的不同，迭代数、压缩比和线程数都可以自由调整，以保证最佳结果:"));
    }


    public static final String SENTENCE = "香港特别行政区的张朝阳说商品和服务是三原县鲁桥食品厂的主营业务";
    public void testCWSandPOSandNER() throws Exception
    {
        String cws_file = "F:\\code\\HanLP\\data\\test\\perceptron\\cws.bin";
        String pos_file = "F:\\code\\HanLP\\data\\test\\perceptron\\pos.bin";
        String ner_file = "F:\\code\\HanLP\\data\\test\\perceptron\\ner.bin";
        PerceptronLexicalAnalyzer segmenter = new PerceptronLexicalAnalyzer(cws_file, pos_file, ner_file);
        Sentence sentence = segmenter.analyze(SENTENCE);
        System.out.println(sentence);
    }

}