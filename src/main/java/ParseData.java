import org.jsoup.Jsoup;
import java.util.HashMap;


public class ParseData {
    private final static String tiger_url = "https://animalsafari.com/9-types-of-tigers-6-endangered-3-extinct/";
    private final static String giraffe_url = "https://en.wikipedia.org/wiki/Giraffe";
    private final static String user_agent = "Mozilla/5.0 (Windows NT 6.1; rv:106.0) Gecko/20100101 Firefox/106.0";

    public static HashMap<String, String> TigerFiller() {
        try {
            var doc = Jsoup.connect(tiger_url)
                    .userAgent(user_agent)
                    .referrer("https://www.google.com")
                    .get();

            var breeds = doc.select(" #post-4663 > div > h2")
                    .eachText()
                    .subList(0, 6)
                    .stream()
                    .map(s -> s.substring(3).replaceAll(" Tiger", ""))
                    .toList();


            var urls = doc.select("#post-4663 > div > p > img").eachAttr("src");

            var breedsAndUrls = new HashMap<String, String>();

            for (var i = 0; i < breeds.size(); i++) {
                breedsAndUrls.put(breeds.get(i), urls.get(i));
            }
            return breedsAndUrls;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HashMap<String, String> GiraffeFiller() {
        try {
            var doc = Jsoup.connect(giraffe_url)
                    .userAgent(user_agent)
                    .referrer("https://www.google.com")
                    .get();

            var data = doc.select("#mw-content-text > div.mw-parser-output > table.wikitable > tbody > tr");
            var breedsAndUrls = new HashMap<String, String>();
            for (int i = 1; i < data.size(); i++) {
                var breed = firstUpperCase(data.get(i)
                        .select("td > a")
                        .get(0)
                        .text()
                        .replaceAll(" giraffe", ""));
                var url = "https:" + data.get(i)
                        .select("td")
                        .get(1)
                        .select("img")
                        .attr("src");
                breedsAndUrls.put(breed, url);
            }
            return breedsAndUrls;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String firstUpperCase(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
