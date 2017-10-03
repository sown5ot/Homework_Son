package sonhoang.vn.gridview;

/**
 * Created by Son Hoang on 10/3/2017.
 */

public class Image {
    private String imageName;
    private int image;

    public Image(String imageName, int image) {
        this.imageName = imageName;
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public int getImage() {
        return image;
    }
}
