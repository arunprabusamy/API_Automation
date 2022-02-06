package com.qa.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class jsonParser {

    /**
     *
     * @param jsonObj
     * @param pathToKey - path to the key in JSON (Array with 0 as start index)
     */
    public static String getValueFromJson(JSONObject jsonObj, String pathToKey){
        Object value = new Object();
        String[] keyPath = pathToKey.split("\\\\");

        for(int i=0; i < keyPath.length; i++){
            if (keyPath[i].contains("[")){
                String[] arrayKey = keyPath[i].split("\\[");
//                String arrayKey = keyPath[i].replaceAll("[\\]\\[0-9]","");
                JSONArray arrValues = jsonObj.getJSONArray(arrayKey[0]);
//              get index of array
                int arrayIndex = Integer.parseInt(arrayKey[1].replace("]",""));

                value = arrValues.get(arrayIndex);
                System.out.println(value.toString());
            }
            else {
                value = jsonObj.get(keyPath[i]);
                System.out.println(value.toString());
            }

            if (i < keyPath.length-1) {
                jsonObj = (JSONObject) value;
            }
        }
        return value.toString();
    }


    public static String getValueFromJson_simple(JSONObject jsonresponse, String pathToKey){
        Object obj = jsonresponse;

        for(String s:pathToKey.split("\\\\")){
            if(!(s.contains("]")||s.contains("["))){
                obj = ((JSONObject) obj).get(s);
            }
            else {
                obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]","")));
            }
        }
        return obj.toString();
    }
}




