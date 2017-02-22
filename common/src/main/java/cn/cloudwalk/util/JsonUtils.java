package cn.cloudwalk.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.litesuits.android.log.Log;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: JsonUtils <br/>
 * Description: json转换为实体 <br/>
 * date: 2016/11/24 002413:56 <br/>
 *
 * @author 284891377
 * @since JDK 1.7
 */
public class JsonUtils {

    private static Gson mGson = new Gson();

    public static <T> T readJson2Bean(String json, Class<T> clz) {
        return deserialize(json, clz);
    }

    public static <T> List<T> readJson2Beans(String json, Class<T> clz) {
        List<T> beans = new ArrayList<T>();
        try {
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(json).getAsJsonArray();
            for (int i = 1; i < jsonArray.size(); i++) {
                JsonObject jo = jsonArray.get(i).getAsJsonObject();
                T news = JsonUtils.deserialize(jo, clz);
                beans.add(news);
            }
        } catch (Exception e) {
            Log.e("JsonUtils", "readJson2Beans e=" + e.getMessage());
        }
        return beans;
    }

    /**
     * 将对象准换为json字符串
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String serialize(T object) {
        return mGson.toJson(object);
    }

    /**
     * 将json字符串转换为对象
     *
     * @param json
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }

    /**
     * 将json对象转换为实体对象
     *
     * @param json
     * @param clz
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> T deserialize(JsonObject json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }

    /**
     * 将json字符串转换为对象
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Type type) throws JsonSyntaxException {
        return mGson.fromJson(json, type);
    }


}
