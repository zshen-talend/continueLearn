package fnlpTest.tc;

import java.util.ArrayList;

import org.fnlp.ml.types.Instance;
import org.fnlp.nlp.pipe.Pipe;

public class Strings2StringArray extends Pipe {

    public Strings2StringArray() {
    }

    @Override
    public void addThruPipe(Instance inst) {
        String[] data = (String[]) inst.getData();
        ArrayList<String> newdata = new ArrayList<String>();
        for (String element : data) {
            newdata.add(element);
        }
        inst.setData(newdata);
    }
}