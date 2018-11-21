package Framework;

public class Capabilities {

    private String BROWSER_NAME;
    private String VERSION;
    private String deviceName;
    private String udid;
    private String platformName;
    private String appPackage;
    private String appActivity;
    private String autoGrantPermissions;

    public String getBROWSER_NAME() {
        return BROWSER_NAME;
    }

    public void setBROWSER_NAME(String BROWSER_NAME) {
        this.BROWSER_NAME = BROWSER_NAME;
    }

    public String getVERSION() {
        return VERSION;
    }

    public void setVERSION(String VERSION) {
        this.VERSION = VERSION;
    }

    public String getDevicename() {
        return deviceName;
    }

    public void setDevicename(String devicename) {
        this.deviceName = devicename;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    public String getAutoGrantPermissions() {
        return autoGrantPermissions;
    }

    public void setAutoGrantPermissions(String autoGrantPermissions) {
        this.autoGrantPermissions = autoGrantPermissions;
    }
}