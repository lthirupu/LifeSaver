package edu.depaul.csc472.lifesaver;

/**
 * Created by lavanyathirupur on 11/4/15.
 */
public class PatientInfo {
enum Type {PatientPic};
    String name;
    Type type;
    String longDescription;
    String shortDescription;
    public PatientInfo(String name, Type type, String shortDescription, String longDescription) {
        this.name = name;
        this.type = type;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        return name;
    }

    public static int getIconResource(PatientInfo.Type type){
        switch (type){
            case PatientPic: return R.drawable.icon;

        }
        return -1;
    }
}


