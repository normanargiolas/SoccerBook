package it.namron.soccerbook.dto;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class TeamItemDTO implements Parcelable {

    private int id;
    private String teamName;
    private String teamInfo;
    private Drawable drawerIcon;

    public TeamItemDTO() {
    }

    protected TeamItemDTO(Parcel in) {
        id = in.readInt();
        teamName = in.readString();
        teamInfo = in.readString();

        Bitmap bitmap = (Bitmap) in.readParcelable(getClass().getClassLoader());
        if (bitmap != null) {
            drawerIcon = new BitmapDrawable(Resources.getSystem(), bitmap);
        } else {
            drawerIcon = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TeamItemDTO> CREATOR = new Creator<TeamItemDTO>() {
        @Override
        public TeamItemDTO createFromParcel(Parcel in) {
            return new TeamItemDTO(in);
        }

        @Override
        public TeamItemDTO[] newArray(int size) {
            return new TeamItemDTO[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(String teamInfo) {
        this.teamInfo = teamInfo;
    }

    public Drawable getDrawerIcon() {
        return drawerIcon;
    }

    public void setDrawerIcon(Drawable drawerIcon) {
        this.drawerIcon = drawerIcon;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeString(teamName);
        dest.writeString(teamInfo);

        if (drawerIcon != null) {
            Bitmap bitmap = (Bitmap) ((BitmapDrawable) drawerIcon).getBitmap();
            dest.writeParcelable(bitmap, flags);
        } else {
            dest.writeParcelable(null, flags);
        }

    }

}
