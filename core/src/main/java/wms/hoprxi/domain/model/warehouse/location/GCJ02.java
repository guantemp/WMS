package wms.hoprxi.domain.model.warehouse.location;

/***
 * @author <a href="www.hoprxi.com/authors/guan xiangHuan">guan xiangHuan</a>
 * @since JDK8.0
 * @version 0.0.1 2018-11-16
 */
public class GCJ02 {
    private double latitude;
    private double longitude;

    /**
     * @param longitude
     * @param latitude
     */
    public GCJ02(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double latitude() {
        return latitude;
    }

    public double longitude() {
        return longitude;
    }
}
