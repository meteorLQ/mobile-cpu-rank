package com.lq.rank.util;


import com.lq.rank.entity.Book;
import com.lq.rank.entity.Processor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {

    public static List getBooks() throws IOException {
        String url = "https://search.jd.com/search?keyword=java&ev=packstate_%E5%90%A6%5E";
        Document document = Jsoup.parse(new URL(url), 30000);
        Element jGoodsList = document.getElementById("J_goodsList");
        // System.out.println(jGoodsList.html());
        ArrayList<Book> books = new ArrayList<>();
        Elements li = jGoodsList.getElementsByTag("li");
        for (Element element : li) {
            String img = element.getElementsByTag("img").attr("data-lazy-img");
            String price = element.getElementsByClass("p-price").eq(0).text();
            String name = element.getElementsByClass("p-name").eq(0).text();
            System.out.println("============================================");
            Book book = Book.builder().img(img).name(name).price(price).build();
            books.add(book);
        }
        return books;
    }

    /**
     * 获取骁龙处理器
     *
     * @return
     * @throws IOException
     */
    public static List getSnapdragonCPUInfo() throws IOException {
        String url = "https://www.mydrivers.com/zhuanti/tianti/01/index_gaotong.html";
        Document document = Jsoup.parse(new URL(url), 30000);
        Elements elements = document.getElementsByClass("main");
        Element element = elements.get(0);
        Elements tr = element.getElementsByTag("tr");
        Processor.ProcessorBuilder builder = Processor.builder();
        ArrayList<Processor> processors = new ArrayList<>();
        for (Element e : tr) {

            if (e.hasClass("tr1") || e.hasClass("font_16 font_center font_bold color_blue")) {
                continue;
            } else if (e.hasAttr("style")) {
                //System.out.println("hasAttr style" + e);
                continue;
            }
            Elements td = e.getElementsByTag("td");
            if (td.hasAttr("colspan") || td.hasAttr("align") || td.hasAttr("style")) {
                // System.out.println(td);
                continue;
            }
            Processor processor = builder.build();
            // 处理器型号
            Element element0 = td.get(0);
            processor.setType(element0.text());
            // 制造工艺
            Element element1 = td.get(1);
            processor.setMadeCraft(element1.text());
            // CPU架构
            Element element2 = td.get(2);
            processor.setCpuFrame(element2.text());
            // 核心频率
            Element element3 = td.get(3);
            processor.setCoreFrequency(element3.text());
            // GPU
            Element element4 = td.get(4);
            processor.setGpu(element4.text());
            // 内存
            Element element5 = td.get(5);
            processor.setRam(element5.text());
            // 基带
            Element element6 = td.get(6);
            processor.setBaseBand(element6.text());
            // 出货时间
            Element element7 = td.get(7);
            processor.setDeliveryTime(element7.text());
            // 代表机型
            Element element8 = td.get(8);
            processor.setDeputyPhone(element8.text());
            System.out.println(processor);
            processors.add(processor);
        }
        return processors;
    }

    /**
     * 获取其他处理器
     *
     * @return
     * @throws IOException
     */
    public static List getOtherCPUInfo() throws IOException {
        String url = "https://www.mydrivers.com/zhuanti/tianti/01/index_other.html";
        Document document = Jsoup.parse(new URL(url), 30000);
        Elements elements = document.getElementsByClass("main");
        Element element = elements.get(0);
        Elements tr = element.getElementsByTag("tr");
        Processor.ProcessorBuilder builder = Processor.builder();
        ArrayList<Processor> processors = new ArrayList<>();
        for (Element e : tr) {

            if (e.hasClass("tr1") || e.hasClass("font_16 font_center font_bold color_blue")) {
                continue;
            } else if (e.hasAttr("style")) {
                //System.out.println("hasAttr style" + e);
                continue;
            }
            Elements td = e.getElementsByTag("td");
            if (td.hasAttr("colspan") || td.hasAttr("align") || td.hasAttr("style")) {
                // System.out.println(td);
                continue;
            }
            Processor processor = builder.build();
            // 处理器型号
            Element element0 = td.get(0);
            processor.setType(element0.text());
            // 制造工艺
            Element element1 = td.get(1);
            processor.setMadeCraft(element1.text());
            // CPU架构
            Element element2 = td.get(2);
            processor.setCpuFrame(element2.text());
            // 核心频率
            Element element3 = td.get(3);
            processor.setCoreFrequency(element3.text());
            // GPU
            Element element4 = td.get(4);
            processor.setGpu(element4.text());
            // 内存
            Element element5 = td.get(5);
            processor.setRam(element5.text());
            // 基带
            Element element6 = td.get(6);
            processor.setBaseBand(element6.text());
            // 出货时间
            Element element7 = td.get(7);
            processor.setDeliveryTime(element7.text());
            // 代表机型
            Element element8 = td.get(8);
            processor.setDeputyPhone(element8.text());
            System.out.println(processor);
            processors.add(processor);
        }
        return processors;
    }

    public static void main(String[] args) throws IOException {
//        getSnapdragonCPUInfo();
        getOtherCPUInfo();
    }
}
