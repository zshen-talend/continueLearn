// ============================================================================
//
// Copyright (C) 2006-2019 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package talend.shenzetestJMH;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.talend.dataquality.record.linkage.constant.RecordMatcherType;
import org.talend.dataquality.record.linkage.grouping.AbstractRecordGrouping;
import org.talend.dataquality.record.linkage.grouping.TSwooshGrouping;
import org.talend.dataquality.record.linkage.grouping.swoosh.AnalysisSwooshMatchRecordGrouping;
import org.talend.dataquality.record.linkage.grouping.swoosh.ComponentSwooshMatchRecordGrouping;
import org.talend.dataquality.record.linkage.grouping.swoosh.SurvivorShipAlgorithmParams;
import org.talend.dataquality.record.linkage.grouping.swoosh.SurvivorshipUtils;
import org.talend.dataquality.record.linkage.record.RecordMatcherFactory;

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class TSwooshGroupingJMHTest {

    TSwooshGrouping<Object> tSwooshGrouping = null;

    SurvivorShipAlgorithmParams survivorShipAlgorithmParams_tMatchGroup_1 = null;

    String[][] inputData = null;

    // { { "0", "beijing", "DQ" }, { "1", "beihaiwang", "DQ" }, { "2", "najing", "DQ" },
    // { "3", "nahaiwang", "DQ" }, { "4", "jinzhou", "DQ" }, { "5", "jinyang", "DQ" },
    // { "6", "shanhaichuan", "DQ" }, { "7", "shanhaijiang", "DQ" }, { "8", "shanhaiguan", "DQ" },
    // { "9", "shanhaijing", "DQ" } };

    @Setup
    public void initData() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException,
            InterruptedException {
        inputData = getTableValue("/jmhData.csv", 10, 3, true);
        List<java.util.Map<String, String>> defaultSurvivorshipRules_tMatchGroup_1 = new ArrayList<>();
        List<java.util.Map<String, String>> particularSurvivorshipRules_tMatchGroup_1 = new ArrayList<>();
        Map<String, String> columnWithType_tMatchGroup_1 = initColumnType();
        Map<String, String> columnWithIndex_tMatchGroup_1 = initColumnIndex();
        List<List<Map<String, String>>> matchingRulesAll_tMatchGroup_1 = new ArrayList<>();
        AbstractRecordGrouping<Object> recordGroupImp_tMatchGroup_1;
        recordGroupImp_tMatchGroup_1 = initRecordGrouping(matchingRulesAll_tMatchGroup_1);

        survivorShipAlgorithmParams_tMatchGroup_1 =
                SurvivorshipUtils.createSurvivorShipAlgorithmParams(
                        (AnalysisSwooshMatchRecordGrouping) recordGroupImp_tMatchGroup_1,
                        matchingRulesAll_tMatchGroup_1, defaultSurvivorshipRules_tMatchGroup_1,
                        particularSurvivorshipRules_tMatchGroup_1, columnWithType_tMatchGroup_1,
                        columnWithIndex_tMatchGroup_1);
        ((AnalysisSwooshMatchRecordGrouping) recordGroupImp_tMatchGroup_1)
                .setSurvivorShipAlgorithmParams(survivorShipAlgorithmParams_tMatchGroup_1);
        recordGroupImp_tMatchGroup_1.setColumnDelimiter(";"); //$NON-NLS-1$
        recordGroupImp_tMatchGroup_1.setIsOutputDistDetails(false);

        recordGroupImp_tMatchGroup_1.setAcceptableThreshold(Float.valueOf(0.85 + "")); //$NON-NLS-1$
        recordGroupImp_tMatchGroup_1.setIsLinkToPrevious(false);
        recordGroupImp_tMatchGroup_1.setIsDisplayAttLabels(false);
        recordGroupImp_tMatchGroup_1.setIsGIDStringType(true);
        recordGroupImp_tMatchGroup_1.setIsPassOriginalValue(false);
        recordGroupImp_tMatchGroup_1.setIsStoreOndisk(false);

        initInputData(recordGroupImp_tMatchGroup_1);

        tSwooshGrouping = recordGroupImp_tMatchGroup_1.getSwooshGrouping();
    }

    @Benchmark
    public void execute() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException,
            InterruptedException {

        tSwooshGrouping.swooshMatch(RecordMatcherFactory.createCombinedRecordMatcher(),
                survivorShipAlgorithmParams_tMatchGroup_1);
    }

    @TearDown(Level.Iteration)
    public void check() {
        assert inputData.length > 999999 : "The data is not enough";
    }

    private void initInputData(AbstractRecordGrouping<Object> recordGroupImp_tMatchGroup_1) throws IOException,
            InterruptedException {
        for (Object[] inputTexts : inputData) {
            recordGroupImp_tMatchGroup_1.doGroup(inputTexts);
        }

    }

    private AbstractRecordGrouping<Object> initRecordGrouping(
            List<List<Map<String, String>>> matchingRulesAll_tMatchGroup_1) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        List<java.util.Map<String, String>> matcherList_tMatchGroup_1 = new ArrayList<>();
        Map<String, String> columnDatePattern_tMatchGroup_1 = new HashMap<>();
        Map<String, String> tmpMap_tMatchGroup_1 = new HashMap<>();
        tmpMap_tMatchGroup_1.put("MATCHING_TYPE", "Levenshtein"); //$NON-NLS-1$//$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("REFERENCE_COLUMN", "id"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("REFERENCE_COLUMN_IDX", "0"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("RECORD_MATCH_THRESHOLD", 0.6 + ""); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("ATTRIBUTE_NAME", "city"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("SURVIVORSHIP_FUNCTION", "MostCommon"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("HANDLE_NULL", "nullMatchNull"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("ATTRIBUTE_THRESHOLD", 1 + ""); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("COLUMN_IDX", "1"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("CONFIDENCE_WEIGHT", 1 + ""); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("MATCHING_ALGORITHM", //$NON-NLS-1$
                "TSWOOSH_MATCHER"); //$NON-NLS-1$
        tmpMap_tMatchGroup_1.put("TOKENIZATION_TYPE", "No"); //$NON-NLS-1$ //$NON-NLS-2$
        matcherList_tMatchGroup_1.add(tmpMap_tMatchGroup_1);
        tmpMap_tMatchGroup_1 = new java.util.HashMap<>();
        tmpMap_tMatchGroup_1.put("REFERENCE_COLUMN_IDX", "0"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("REFERENCE_COLUMN", "id"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("MATCHING_TYPE", "dummy"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("ATTRIBUTE_NAME", "id"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("COLUMN_IDX", "0"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("CONFIDENCE_WEIGHT", 0 + ""); //$NON-NLS-1$ //$NON-NLS-2$
        matcherList_tMatchGroup_1.add(tmpMap_tMatchGroup_1);
        tmpMap_tMatchGroup_1 = new java.util.HashMap<>();
        tmpMap_tMatchGroup_1.put("REFERENCE_COLUMN_IDX", "2"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("REFERENCE_COLUMN", "groupName"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("MATCHING_TYPE", "dummy"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("ATTRIBUTE_NAME", "groupName"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("COLUMN_IDX", "2"); //$NON-NLS-1$ //$NON-NLS-2$
        tmpMap_tMatchGroup_1.put("CONFIDENCE_WEIGHT", 0 + ""); //$NON-NLS-1$ //$NON-NLS-2$
        matcherList_tMatchGroup_1.add(tmpMap_tMatchGroup_1);
        java.util.Collections.sort(matcherList_tMatchGroup_1, new Comparator<java.util.Map<String, String>>() {

            @Override
            public int compare(Map<String, String> map1, Map<String, String> map2) {

                return Integer.valueOf(map1.get("COLUMN_IDX")) //$NON-NLS-1$
                        .compareTo(Integer.valueOf(map2.get("COLUMN_IDX"))); //$NON-NLS-1$
            }

        });
        matchingRulesAll_tMatchGroup_1.add(matcherList_tMatchGroup_1);

        AbstractRecordGrouping<Object> recordGroupImp_tMatchGroup_1;
        recordGroupImp_tMatchGroup_1 = new ComponentSwooshMatchRecordGrouping() {

            @Override
            protected void outputRow(Object[] row) {

            }

            @Override
            protected boolean isMaster(Object col) {
                return String.valueOf(col).equals("true"); //$NON-NLS-1$
            }
        };

        recordGroupImp_tMatchGroup_1.setOrginalInputColumnSize(3);
        recordGroupImp_tMatchGroup_1.setRecordLinkAlgorithm(RecordMatcherType.T_SwooshAlgorithm);

        for (List<Map<String, String>> matcherList : matchingRulesAll_tMatchGroup_1) {
            recordGroupImp_tMatchGroup_1.addMatchRule(matcherList);
        }
        recordGroupImp_tMatchGroup_1.initialize();
        recordGroupImp_tMatchGroup_1.setColumnDatePatternMap(columnDatePattern_tMatchGroup_1);
        return recordGroupImp_tMatchGroup_1;
    }

    private Map<String, String> initColumnIndex() {
        Map<String, String> columnWithIndex_tMatchGroup_1 = new HashMap<>();
        columnWithIndex_tMatchGroup_1.put("id", "0"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithIndex_tMatchGroup_1.put("city", "1"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithIndex_tMatchGroup_1.put("groupName", "2"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithIndex_tMatchGroup_1.put("GID", "3"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithIndex_tMatchGroup_1.put("GRP_SIZE", "4"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithIndex_tMatchGroup_1.put("MASTER", "5"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithIndex_tMatchGroup_1.put("SCORE", "6"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithIndex_tMatchGroup_1.put("GRP_QUALITY", "7"); //$NON-NLS-1$ //$NON-NLS-2$
        return columnWithIndex_tMatchGroup_1;
    }

    private Map<String, String> initColumnType() {
        Map<String, String> columnWithType_tMatchGroup_1 = new HashMap<>();
        columnWithType_tMatchGroup_1.put("id", "id_String"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithType_tMatchGroup_1.put("city", "id_String"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithType_tMatchGroup_1.put("groupName", "id_String"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithType_tMatchGroup_1.put("GID", "id_String"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithType_tMatchGroup_1.put("GRP_SIZE", "id_Integer"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithType_tMatchGroup_1.put("MASTER", "id_Boolean"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithType_tMatchGroup_1.put("SCORE", "id_Double"); //$NON-NLS-1$ //$NON-NLS-2$
        columnWithType_tMatchGroup_1.put("GRP_QUALITY", "id_Double"); //$NON-NLS-1$ //$NON-NLS-2$
        return columnWithType_tMatchGroup_1;
    }

    public static void main(String[] args) throws RunnerException, InstantiationException, IllegalAccessException,
            ClassNotFoundException, IOException, InterruptedException {
        Options opt =
                new OptionsBuilder()
                        .include(TSwooshGroupingJMHTest.class.getSimpleName())
                        .forks(1)
                        .warmupIterations(3)
                        .measurementIterations(5)
                        .build();

        new Runner(opt).run();
        // TSwooshGroupingJMHTest tSwooshGroupingJMHTest = new TSwooshGroupingJMHTest();
        // tSwooshGroupingJMHTest.execute();
    }

    /**
     * 
     * Get input data from special csv file
     * 
     * @param file the file full path
     * @return array of input data
     */
    protected String[][] getTableValue(String file, int rowNum, int colNum, boolean withHeader) {

        String pathString = ""; //$NON-NLS-1$
        try {
            pathString = this.getClass().getResource("/jmhData.csv").toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        BufferedReader br = null;
        String line = ""; //$NON-NLS-1$
        String cvsSplitBy = ";"; //$NON-NLS-1$

        String[][] result = new String[rowNum][colNum];
        try {
            br = new BufferedReader(new FileReader(pathString));
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                if (withHeader && index == 0) {
                    index++;
                    // skip header
                    continue;
                }

                int y = 0;
                for (String readArray : items) {
                    if (readArray.toString().equals("null")) { //$NON-NLS-1$
                        readArray = null;
                    }
                    result[index][y] = readArray;
                    y++;
                }
                index++;
                if (index >= rowNum) {
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                // no need to be implements
            }
        }

        return result;

    }
}
