import java.io.Serializable;

public class SanPham implements Serializable {
    private int ID;
    private String name;
    private String brandName;
    private long price;

    public SanPham(int ID, String name, String brandName, long price) {
        this.ID = ID;
        this.name = name;
        this.brandName = brandName;
        this.price = price;
    }

    public SanPham() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

}
