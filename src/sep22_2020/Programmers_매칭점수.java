/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep22_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*;

public class Programmers_매칭점수 {

//    public static void main(String[] args) {
//        String word = "Blind";
//        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
//
//        String word2 = "Muzi"; 
//        String[] pages2 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"}; 
//
//        solution(word2, pages2);
//
//    }

    public static int solution(String word, String[] pages) {

        word = word.toLowerCase(); 
        Map<String, Integer> address = new HashMap<>(); 
        WebPage[] webPages = new WebPage[pages.length];

        int index = 0;
        for (String page : pages) {
            webPages[index] = new WebPage();
            String[] chunks = page.split("\n");
            ArrayList<String> tokens = new ArrayList<>();
            for (String chunk : chunks) {
                String[] s = chunk.split(" ");
                for (String token : s) {
                    tokens.add(token);
                }
            }

            for (int i = 0; i < tokens.size(); i++) {
                String token = tokens.get(i);

                if (token.startsWith("<")) {
                    String tag = token.substring(1, token.length() - 1);
                    switch (tag) {
                        case "html":
                            continue;
                        case "head":
                            i++;
                            outer:
                            while (i < tokens.size() && !tokens.get(i).startsWith("</head>")) {
                                if (tokens.get(i).startsWith("<meta")) {
                                    i++;
                                    while (i < tokens.size()) {
                                        String s = tokens.get(i);
                                        if (s.startsWith("content=")) {
                                            webPages[index].home = s.substring(9, s.length() - 3);
                                            address.put(webPages[index].home, index); 
                                            break outer;
                                        }
                                       i++;
                                    }
                                }
                                i++;
                            }
                            break;
                        case "body":
                            i ++; 
                            while (i < tokens.size() && !tokens.get(i).startsWith("</body")) {
                                String s = tokens.get(i); 
//                                System.out.println(s); 
                                if (s.toLowerCase().equals(word)) {
                                    webPages[index].primaryScore += 1; 
//                                    System.out.println(webPages[index].primaryScore); 
                                }
                                else if (s.startsWith("<a")) {
                                    i++; 
                                    String ss = tokens.get(i); 
                                    if (ss.startsWith("href=")) {
                                        webPages[index].externalLinks.add(ss.substring(6,ss.length()-2)); 
//                                        System.out.println(ss); 
                                    }
                                }
                                i++; 
                            }
                            break;

                    }
                }
                
            }
                        System.out.println(webPages[index].toString()); 

//            System.out.println("index: " + webPages[index].index); 
//            System.out.println("home: " + webPages[index].home); 
//            System.out.println("externalLinks: " + Arrays.toString(webPages[index].externalLinks.toArray())); 
//            System.out.println(webPages[index].toString()); 
            index++;
        }
        
        for(int i = 0; i < pages.length; i++) {
            WebPage page = webPages[i]; 
            for(String link: page.externalLinks) {
                WebPage linkedPage = webPages[address.get(link)]; 
                linkedPage.linkScore += (double) page.primaryScore / page.externalLinks.size();
            }
        }
        double maxMatchingScore = Double.MIN_VALUE; 
        int maxIdx = 0; 
        for(int i = 0; i < pages.length; i++) {
            WebPage page = webPages[i]; 
            if (maxMatchingScore < page.primaryScore + page.linkScore) {
                maxIdx = i; 
                maxMatchingScore = page.primaryScore + page.linkScore; 
            }
            System.out.println(page.toString()); 
        }
        
//        System.out.println(maxIdx); 
        return maxIdx;
    }

    public static class WebPage {

        String home;
        int primaryScore;
        int externalLinkScore;
        double linkScore;
        double matchingScore;
        ArrayList<String> externalLinks; 
        WebPage() {

            this.home = ""; 
            this.primaryScore = 0; 
            this.externalLinkScore = 0; 
            this.linkScore = 0; 
            this.matchingScore = 0; 
            this.externalLinks = new ArrayList<String>(); 
        }
        
        @Override
        public String toString() {
            
            StringBuilder sb= new StringBuilder(); 
            sb.append("\nexternalLinks: "); 
            sb.append(Arrays.toString(externalLinks.toArray()));
            sb.append("\nprimaryScore: "); 
            sb.append(this.primaryScore);
            sb.append("\nlinkScore: "); 
            sb.append(this.linkScore); 
            sb.append("\nMatchingScore: "); 
            sb.append(this.matchingScore); 
            return sb.toString(); 
        }
    }
}
