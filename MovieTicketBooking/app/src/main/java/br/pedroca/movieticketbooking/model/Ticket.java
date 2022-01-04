package br.pedroca.movieticketbooking.model;

public class Ticket extends BaseEntity {
    private String title;
    private double price;
    private double rating;
    private String sessionDate;     //todo: change to Date type?
    private String sessionTime;     //todo: change to Time type?
    private String bannerImage;

    public Ticket(int id, String title, double price, double rating, String sessionDate, String sessionTime, String bannerImage) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
        this.bannerImage = bannerImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", sessionDate='" + sessionDate + '\'' +
                ", sessionTime='" + sessionTime + '\'' +
                ", bannerImage='" + bannerImage + '\'' +
                '}';
    }
}
