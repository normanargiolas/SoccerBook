package it.namron.soccerbook.dto;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class FieldItemDTO implements Parcelable {

    private int id;
    private String name;
    private String address;
    private Drawable drawerIcon;

    public FieldItemDTO() {
    }

    protected FieldItemDTO(Parcel in) {
        id = in.readInt();
        name = in.readString();
        address = in.readString();
        Bitmap bitmap = (Bitmap) in.readParcelable(getClass().getClassLoader());
        if (bitmap != null) {
            drawerIcon = new BitmapDrawable(Resources.getSystem(), bitmap);
        } else {
            drawerIcon = null;
        }
    }

    public static final Creator<FieldItemDTO> CREATOR = new Creator<FieldItemDTO>() {
        @Override
        public FieldItemDTO createFromParcel(Parcel in) {
            return new FieldItemDTO(in);
        }

        @Override
        public FieldItemDTO[] newArray(int size) {
            return new FieldItemDTO[size];
        }
    };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Drawable getDrawerIcon() {
        return drawerIcon;
    }

    public void setDrawerIcon(Drawable drawerIcon) {
        this.drawerIcon = drawerIcon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(address);

        if (drawerIcon != null) {
            Bitmap bitmap = (Bitmap) ((BitmapDrawable) drawerIcon).getBitmap();
            dest.writeParcelable(bitmap, flags);
        } else {
            dest.writeParcelable(null, flags);
        }
    }
}
