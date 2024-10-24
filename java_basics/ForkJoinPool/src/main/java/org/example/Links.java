package org.example;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.RecursiveTask;
@Getter
@Setter
public class Links extends RecursiveTask<String> {
    private final String url;
    private final List<String> linkList;
    private long start;

    public Links(String url, List<String> linkList, long start) {
        this.url = url;
        this.linkList = linkList;
        this.start = start;
    }

    public Links(String url, long start) {
        this.url = url;
        this.linkList = new ArrayList<>();
        this.start = start;
    }

    @Override
    protected String compute() {
        StringBuilder builder = new StringBuilder(tabulate() + url + "\n");
        TreeSet<Links> listTask = new TreeSet<>(Comparator.comparing(o -> o.url));

        try {
            Thread.sleep(150);
            Document document = Jsoup.connect(url).ignoreContentType(true).maxBodySize(0).get();
            Elements elements = document.select("a[href]");

            for (Element element : elements) {
                String attribute = element.absUrl("href");

                if (attribute.startsWith(url)
                        && !attribute.contains("#")
                        && !linkList.contains(attribute)) {
                    Links links = new Links(attribute, linkList, start);
                    links.fork();
                    listTask.add(links);
                    linkList.add(attribute);
                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        for (Links link : listTask) {
            builder.append(link.join());
        }

        System.out.println(Thread.currentThread().getName() +
                " Время на парсинг ссылки затрачено: " +
                url + " - " + (System.currentTimeMillis() - start) + " мс.");
        return builder.toString();
    }

    public String tabulate() {
        return StringUtils.repeat("\t", url.lastIndexOf("/") != url.length() - 1
                ? StringUtils.countMatches(url, "/") - 2
                : StringUtils.countMatches(url, "/") - 3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Links links = (Links) o;
        return Objects.equals(linkList, links.linkList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkList);
    }
}