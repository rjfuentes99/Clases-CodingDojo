import java.util.HashMap;
import java.util.Set;

public class Hashmatique{

    public static void main(String[] args) {

        HashMap<String,String> map = new HashMap<>();
        map.put("song1","Lyrics somthing1");
        map.put("song2","Lyrics somthing2");
        map.put("song3","Lyrics somthing3");
        map.put("song4","Lyrics somthing4");
        
        System.out.println(map.get("song4"));

        Set<String> set = map.keySet();
        for(String song : set){
            System.out.println("Song title "+song);
            System.out.println("Song Lyrics "+map.get(song));
        }

    }
}