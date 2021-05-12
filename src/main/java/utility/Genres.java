package utility;

public enum Genres {
    ACTION("action"),
    COMEDY("comedy"),
    DRAMA("drama"),
    FAMILY("family"),
    FANTASY("fantasy"),
    HORROR("horror"),
    MYSTERY("mystery"),
    SCIFI("sci-fi"),
    WAR("war"),
    ADVENTURE("adventure"),
    CRIME("crime"),
    ROMANCE("romance"),
    THRILLER("thriller"),
    WESTERN("western");

    public final String lable;

    Genres(String lable) {
        this.lable = lable;
    }

    public String getLable() {
        return lable;
    }

    @Override
    public String toString() {
        return lable;
    }
}
