import java.util.HashMap;
import java.util.Map;

public class collection {
    public static Map<String, String> map = new HashMap<String, String>();
    public static int step;
    private static boolean isInit = false;
    public static void init(){
        if(!isInit) {
            map.put("1", "1");
            map.put("2", "2");
            map.put("2", "2");
            map.put("qwe", "qwe");
            map.put("asd", "asd");
            map.put("zxc", "zxc");
            isInit = true;
        }
    }

    public static String getMapHtml(){
        final StringBuilder result = new StringBuilder();
        map.forEach((k,v) -> result.append("<tr><td>"+k+"</td><td>"+v+"</td></tr>"));
        return result.toString();
    }
}
