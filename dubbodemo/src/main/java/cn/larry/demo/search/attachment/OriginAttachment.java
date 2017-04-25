package cn.larry.demo.search.attachment;

/**
 * Created by fugz on 2016/4/21.
 */
public class OriginAttachment {
    private String AttachID;
    private String DataID;
    private String Source;
    private String AttachType;
    private String AttachPath;
    private String AttachSize;
    private String AttachName;
    private String EmployeeID;
    private String FeedType;
    private String CreateTime;
    private String IsPublic;
    private String Height;
    private String Width;
    private String OriginalHeight;
    private String OriginalWidth;
    private String IsLocationPic;
    private String Tags;
    private String EI;
    private String SubType;

    public OriginAttachment(String[] data){
        AttachID = data[0];
        DataID = data[1];
        Source = data[2];
        AttachType = data[3];
        AttachPath = data[4];
        AttachSize = data[5];
        AttachName = data[6];
        EmployeeID = data[7];
        FeedType = data[8];
        CreateTime = data[9];
        IsPublic = data[10];
        Height = data[11];
        Width = data[12];
        OriginalHeight = data[13];
        OriginalWidth = data[14];
        IsLocationPic = data[15];
        Tags = data[16];
        EI = data[17];
        SubType = data[18];
    }

    public String getAttachID() {
        return AttachID;
    }

    public void setAttachID(String attachID) {
        AttachID = attachID;
    }

    public String getDataID() {
        return DataID;
    }

    public void setDataID(String dataID) {
        DataID = dataID;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getAttachType() {
        return AttachType;
    }

    public void setAttachType(String attachType) {
        AttachType = attachType;
    }

    public String getAttachPath() {
        return AttachPath;
    }

    public void setAttachPath(String attachPath) {
        AttachPath = attachPath;
    }

    public String getAttachSize() {
        return AttachSize;
    }

    public void setAttachSize(String attachSize) {
        AttachSize = attachSize;
    }

    public String getAttachName() {
        return AttachName;
    }

    public void setAttachName(String attachName) {
        AttachName = attachName;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getFeedType() {
        return FeedType;
    }

    public void setFeedType(String feedType) {
        FeedType = feedType;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getIsPublic() {
        return IsPublic;
    }

    public void setIsPublic(String isPublic) {
        IsPublic = isPublic;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getWidth() {
        return Width;
    }

    public void setWidth(String width) {
        Width = width;
    }

    public String getOriginalHeight() {
        return OriginalHeight;
    }

    public void setOriginalHeight(String originalHeight) {
        OriginalHeight = originalHeight;
    }

    public String getOriginalWidth() {
        return OriginalWidth;
    }

    public void setOriginalWidth(String originalWidth) {
        OriginalWidth = originalWidth;
    }

    public String getIsLocationPic() {
        return IsLocationPic;
    }

    public void setIsLocationPic(String isLocationPic) {
        IsLocationPic = isLocationPic;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public String getEI() {
        return EI;
    }

    public void setEI(String EI) {
        this.EI = EI;
    }

    public String getSubType() {
        return SubType;
    }

    public void setSubType(String subType) {
        SubType = subType;
    }
}
