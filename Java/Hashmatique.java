import java.util.HashMap;
import java.util.*;
public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<>();
        trackList.put("Happy Birthday", "Happy birthday to you, etc., etc., the only reason we're here is the cake.");
        trackList.put("Rockabye Baby", "Please just go to sleep, you wailing little monster.");
        trackList.put("Jingle Bells", "What's that? You're not sick of this song yet? Give it a few days.");
        trackList.put("Twinkle Twinkle", "I don't know what to put in here.");
        String lyrics = trackList.get("Twinkle Twinkle");
        System.out.println(lyrics);
        Iterator it = trackList.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove();
        }
    }
}