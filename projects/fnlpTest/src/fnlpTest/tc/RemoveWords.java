package fnlpTest.tc;

import org.fnlp.ml.types.Instance;
import org.fnlp.nlp.pipe.Pipe;

public class RemoveWords extends Pipe {

    String[] list = new String[] { "&nbsp;", "&nbsp" };

    @Override
    public void addThruPipe(Instance inst) {
        String data = (String) inst.getData();
        for (String str : list) {
            data = data.replace(str, "");
        }
        inst.setData(data);
    }
}
