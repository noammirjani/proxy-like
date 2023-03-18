package Singleton;

import java.util.HashSet;
import java.util.Set;

public class UrlList {

    // static instance variable to hold the singleton instance
    private static UrlList instance;

    // instance variable to hold the set of URLs
    private Set<String> urlSet;

    // private constructor to prevent instantiation from outside the class
    private UrlList() {
        urlSet = new HashSet<>();
    }

    // static method to get the singleton instance
    public static UrlList getInstance() {
        if (instance == null) {
            instance = new UrlList();
        }
        return instance;
    }

    // getter method to retrieve the set of URLs
    public Set<String> getUrlSet() {
        return urlSet;
    }

    // method to add a URL to the set
    public void addUrl(String url) {
        urlSet.add(url);
    }

    // method to remove a URL from the set
    public void removeUrl(String url) {
        urlSet.remove(url);
    }
}


