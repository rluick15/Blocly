package io.bloc.android.blocly.api.model;

/**
 * Created by Rich on 1/12/2015.
 */
public class RssItem {
    private String guid;
    private String title;
    private String description;
    private String url;
    private String imageUrl;
    private long datePublished;
    private boolean read;
    private boolean favorite;
    private boolean archived;

    public RssItem(String guid, String title, String description, String url, String imageUrl,
                   long datePublished, boolean read, boolean favorite, boolean archived) {
        this.guid = guid;
        this.title = title;
        this.description = description;
        this.url = url;
        this.imageUrl = imageUrl;
        this.datePublished = datePublished;
        this.read = read;
        this.favorite = favorite;
        this.archived = archived;
    }

    public String getGuid() {
        return guid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getDatePublished() {
        return datePublished;
    }

    public boolean isRead() {
        return read;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public boolean isArchived() {
        return archived;
    }
}
