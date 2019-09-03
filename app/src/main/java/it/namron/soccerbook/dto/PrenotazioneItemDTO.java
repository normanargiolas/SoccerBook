package it.namron.soccerbook.dto;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class PrenotazioneItemDTO implements Parcelable {

    private int id;
    private String name;
    private String address;
    private String data;
    private String hour;
    private Drawable drawerIcon;

    public PrenotazioneItemDTO() {
    }

    protected PrenotazioneItemDTO(Parcel in) {
        id = in.readInt();
        name = in.readString();
        address = in.readString();
        data = in.readString();
        hour = in.readString();

        Bitmap bitmap = (Bitmap) in.readParcelable(getClass().getClassLoader());
        if (bitmap != null) {
            drawerIcon = new BitmapDrawable(Resources.getSystem(), bitmap);
        } else {
            drawerIcon = null;
        }
    }

    public static final Creator<PrenotazioneItemDTO> CREATOR = new Creator<PrenotazioneItemDTO>() {
        @Override
        public PrenotazioneItemDTO createFromParcel(Parcel in) {
            return new PrenotazioneItemDTO(in);
        }

        @Override
        public PrenotazioneItemDTO[] newArray(int size) {
            return new PrenotazioneItemDTO[size];
        }
    };

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public static Creator<PrenotazioneItemDTO> getCREATOR() {
        return CREATOR;
    }


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
        dest.writeString(data);
        dest.writeString(hour);

        if (drawerIcon != null) {
            Bitmap bitmap = (Bitmap) ((BitmapDrawable) drawerIcon).getBitmap();
            dest.writeParcelable(bitmap, flags);
        } else {
            dest.writeParcelable(null, flags);
        }
    }
}
