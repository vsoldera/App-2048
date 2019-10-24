package org.tensorflow.lite.examples.detection;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonGenerator {


    public JSONObject JsonGenerator(String posicao){
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        try {
            jsonObject.put("posicao", "cima");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;

    }
    public void JsonGenerator(){

    }

    public JSONObject CriaObjeto(String pos){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("posicao", pos);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;

    }


}
