package com.mapna.mapnaapp.models;

/**
 * Created by variani_h on 2/12/2017.
 */

public class News {
    private String NewsId;
    private String Title;
    private String HtmlContect;
    private String Creator;
    private String CreatDateTime;
    private String PersianCreatDate;
    private String NewsLink;

    public News(String newsId, String title, String htmlContect, String creator, String creatDateTime, String persianCreatDate, String newsLink) {
        NewsId = newsId;
        Title = title;
        HtmlContect = htmlContect;
        Creator = creator;
        CreatDateTime = creatDateTime;
        PersianCreatDate = persianCreatDate;
        NewsLink = newsLink;
    }

    @Override
    public String toString() {
        return "News{" +
                "NewsId='" + NewsId + '\'' +
                ", Title='" + Title + '\'' +
                ", HtmlContect='" + HtmlContect + '\'' +
                ", Creator='" + Creator + '\'' +
                ", CreatDateTime='" + CreatDateTime + '\'' +
                ", PersianCreatDate='" + PersianCreatDate + '\'' +
                ", NewsLink='" + NewsLink + '\'' +
                '}';
    }

    public String getNewsId() {
        return NewsId;
    }

    public void setNewsId(String newsId) {
        NewsId = newsId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getHtmlContect() {
        return HtmlContect;
    }

    public void setHtmlContect(String htmlContect) {
        HtmlContect = htmlContect;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public String getCreatDateTime() {
        return CreatDateTime;
    }

    public void setCreatDateTime(String creatDateTime) {
        CreatDateTime = creatDateTime;
    }

    public String getPersianCreatDate() {
        return PersianCreatDate;
    }

    public void setPersianCreatDate(String persianCreatDate) {
        PersianCreatDate = persianCreatDate;
    }

    public String getNewsLink() {
        return NewsLink;
    }

    public void setNewsLink(String newsLink) {
        NewsLink = newsLink;
    }
}
