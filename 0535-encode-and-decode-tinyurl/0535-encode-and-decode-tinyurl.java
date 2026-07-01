public class Codec {
 private HashMap<String,String> map = new HashMap<>();
 private int id  = 0;
 private final String BASE_URL = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = BASE_URL + id++;
        map.put(shortUrl,longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));