package model;
public class PhongBan {
    public int pbId;
    public String pbName;
    public String description;
    public PhongBan(int pbId, String pbName, String description) {
        this.pbId = pbId;
        this.pbName = pbName;
        this.description = description;
    }
    public int getPbId() {
        return pbId;
    }
    public void setPbId(int pbId) {
        this.pbId = pbId;
    }
    public String getPbName() {
        return pbName;
    }
    public void setPbName(String pbName) {
        this.pbName = pbName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
