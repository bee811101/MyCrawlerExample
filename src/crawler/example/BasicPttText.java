package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.select.Elements;


/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
//爬PTT文 只有內文
public class BasicPttText {
	// commit test test
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1504404040.A.387.html";

		Elements elem=CrawlerPack.start().addCookie("over18","1").getFromHtml(uri)
				.select("div.push:contains(推) >.f3.hl.push-userid");

		elem.select("div").remove();
		System.out.println(elem.text());
	}
}
