package com.systemdesign.machinecoding.cache.storage;

import java.util.Map;

public class Value {
    Map<String, Object> values;

    void add(String attr, Object attrVal){
//        if(valToTypeMapping.containsKey(attr)){
//            if(!attrVal.getClass().toString().equals(valToTypeMapping.get(attr))){
//                throw new DataTypeError();
//            }
//        }
//        else {
//            valToTypeMapping.put(attr, attrVal.getClass().toString());
//        }
        values.put(attr, attrVal);
    }

    public String toString(){
        StringBuilder strRep = new StringBuilder();
        for(Map.Entry<String, Object> value: values.entrySet()){
            strRep.append(value.getKey()+":"+value.getValue());
        }
        return strRep.toString();
    }
}