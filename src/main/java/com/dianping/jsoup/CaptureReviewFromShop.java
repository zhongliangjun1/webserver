package com.dianping.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 商户页review抓取
 * @author liangjun.zhong
 * @version 创建时间：Jan 27, 2013 1:57:54 AM
 */
public class CaptureReviewFromShop {

	public void capture(String url){
		try {
			//Document doc = Jsoup.connect(url).get();
			Document doc = Jsoup.connect(url)
					  .data("query", "Java")
					  .userAgent("Mozilla")
					  .cookie("auth", "token")
					  .timeout(3000)
					  .post();
			//Elements reviews = doc.select("div#..."); //div id="review_38788186_summary"  id正则匹配，木有？
			Elements reviews = doc.select("div.comment-entry div");
			for (Element e : reviews){
				String review = e.text();
				System.out.println(review);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		CaptureReviewFromShop cap = new CaptureReviewFromShop();
        cap.capture("http://www.dianping.com/shop/5492464");
	}

}
