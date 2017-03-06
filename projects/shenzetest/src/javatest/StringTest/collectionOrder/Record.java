package javatest.StringTest.collectionOrder;

import java.util.HashMap;
import java.util.Map;

public class Record {
 Map<Integer,String> colum=new HashMap<>();
 
 public void putKey(Integer colName,String value){
	 colum.put(colName, value);
 }
}
