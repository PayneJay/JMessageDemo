package jack.jmessage.message.models;

/**
 * ================================================
 * description:
 * ================================================
 * package_name: jack.jmessage.entity
 * author: PayneJay
 * date: 2018/7/20.
 */

public class MsgItemBean {
    private String nickName;
    private String timeStamp;
    private String message;
    private String avatarUrl;
    private int unRead;

    public String getNickName() {
        return this.nickName == null ? "" : this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTimeStamp() {
        return this.timeStamp == null ? "" : this.timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return this.message == null ? "" : this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAvatarUrl() {
        return this.avatarUrl == null ? "" : this.avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getUnRead() {
        return this.unRead;
    }

    public void setUnRead(int unRead) {
        this.unRead = unRead;
    }
}
