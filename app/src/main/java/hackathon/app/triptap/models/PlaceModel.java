package hackathon.app.triptap.models;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */

public class PlaceModel {
    private String name;
    private String desc;
    private String image;
    private double lat;
    private double lon;
    private String location;
    private float rating;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage() {
        return image;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getLocation() {
        return location;
    }

    public float getRating() {
        return rating;
    }
}
