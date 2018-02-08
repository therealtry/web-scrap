package sample;

import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by abdul on 10/2/2016.
 */
@Controller
@Path("/hello")
public class Endpoint {

	@Autowired
	private Cservice service;

	@GET
	@Path("/msg")
	@Produces("application/json")
	public Response message() {
		Map<Object, Object> apiResponse = new HashMap<Object, Object>();
		apiResponse.put("apiresponse", this.service.message());
		return Response.ok(apiResponse).build();

	}

	@GET
	@Path("/data")
	@Produces("application/json")
	public Response urlData() throws IOException {
		Map<Object, Object> apiResponse = new HashMap<Object, Object>();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Object> finalList = new ArrayList<Object>();

		Document dc = Jsoup.connect("https://www.businessregistry.gr/publicity/index").data("afm", "094263358")
				.timeout(6000).post();
		Elements links = dc.select("a[id^=a_]");
		for (Element link : links) {
			System.out.println(link);
			Document newForm = Jsoup.connect("https://www.businessregistry.gr/publicity/show/" + "123").timeout(6000).post();
		}
		Elements element = dc.select("a[href]");
		for (Element el : element) {
			String linkText = el.select("span.mp-listing-priority-product").text();
			if (!linkText.equals("Dagtopper")) {
				String url = el.select(".listing-title-description .heading>a").attr("href");
				list.add(url);

			}
		}
		for (String url : list) {
			finalList.add(this.retData(url));
			// break;
		}
		apiResponse.put("data", finalList);
		// apiResponse.put("data1",el1);

		return Response.ok(apiResponse).build();

	}

	public Object retData(String url) throws IOException {
		Map<Object, Object> resultData = new HashMap<Object, Object>();
		Document dc = Jsoup.connect(url).get();
		String viewCount = dc.select("#view-count").text();
		String title = dc.select("#title").text();
		String phone = dc.select(".phone-link.alternative").text();
		resultData.put("view_count", viewCount);
		resultData.put("title", title);
		resultData.put("phone", phone);

		return resultData;

	}

}
