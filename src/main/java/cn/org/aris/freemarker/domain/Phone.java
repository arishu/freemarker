package cn.org.aris.freemarker.domain;

public class Phone {

    private String imei;
    private String ownerName;
    private String phoneNum;

    public Phone(String imei, String ownerName, String phoneNum) {
        this.imei = imei;
        this.ownerName = ownerName;
        this.phoneNum = phoneNum;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((imei == null) ? 0 : imei.hashCode());
        result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
        result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Phone other = (Phone) obj;
        if (imei == null) {
            if (other.imei != null) {
                return false;
            }
        } else if (!imei.equals(other.imei)) {
            return false;
        }
        if (ownerName == null) {
            if (other.ownerName != null) {
                return false;
            }
        } else if (!ownerName.equals(other.ownerName)) {
            return false;
        }
        if (phoneNum == null) {
            if (other.phoneNum != null) {
                return false;
            }
        } else if (!phoneNum.equals(other.phoneNum)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Phone [imei=" + imei + ", ownerName=" + ownerName + ", phoneNum=" + phoneNum + "]";
    }
}
