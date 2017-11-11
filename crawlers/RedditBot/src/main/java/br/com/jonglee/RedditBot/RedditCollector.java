package br.com.jonglee.RedditBot;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * Class responsible for collect reddit data
 * @author Jong.Lee
 * @version 1.0
 * @since 2017-11-11
 */
public class RedditCollector {

	public void collectData() {
		try (final WebClient webClient = new WebClient()) {
			final HtmlPage page = webClient.getPage("https://www.reddit.com/r/brasil/");
			webClient.waitForBackgroundJavaScript(10 * 1000);
			
			RedditCollector data = new RedditCollector();
			
			// get all threads in Subreddits
			int divLen = page.getByXPath("//div[@data-score]").size();
			for (int i = 0; i < divLen; i++) {
				if (5000 < Integer.parseInt(
						((HtmlDivision) page.getByXPath("//div[@data-score]").get(i)).getAttribute("data-score"))) {
					System.out.println(
							((HtmlDivision) page.getByXPath("//div[@data-score]").get(i)).getAttribute("data-score"));
					System.out.println(((HtmlDivision) page.getByXPath("//div[@data-score]").get(i))
							.getAttribute("data-subreddit"));
					System.out.println(((HtmlAnchor) page.getByXPath("//a[contains(@class, 'title may-blank')]").get(i))
							.getTextContent());
					System.out.println(((HtmlDivision) page.getByXPath("//div[@data-score]").get(i))
							.getAttribute("data-permalink"));
					System.out.println(
							((HtmlDivision) page.getByXPath("//div[@data-score]").get(i)).getAttribute("data-url"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
