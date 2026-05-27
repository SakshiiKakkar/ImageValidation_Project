
package models;

public class Image {

    private int id;

    private String title;

    private String url;
  
    public Image() {}
  
    public Image(String title,String url ) {
        this.title = title;
        this.url = url;
    }
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
