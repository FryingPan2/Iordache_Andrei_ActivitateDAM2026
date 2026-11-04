package com.example.lab_04;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
public class Avion implements Parcelable {

    String Model;
    String Id;
    String Manufacturer;
    Integer FlightHours;
    Float Value;

    private boolean disponibil;
    private String tipAvion;
    private String categorie;
    private float stareTehnica;
    private boolean inServiciu;
    public Avion() {
    }

    public Avion(String model, String id, String manufacturer, Integer flightHours, Float value) {
        Model = model;
        Id = id;
        Manufacturer = manufacturer;
        FlightHours = flightHours;
        Value = value;
    }
    public Avion(String model, String id, String manufacturer,
                 Integer flightHours, Float value,
                 boolean disponibil, String tipAvion,
                 String categorie, float stareTehnica,
                 boolean inServiciu) {

        this.Model = model;
        this.Id = id;
        this.Manufacturer = manufacturer;
        this.FlightHours = flightHours;
        this.Value = value;

        this.disponibil = disponibil;
        this.tipAvion = tipAvion;
        this.categorie = categorie;
        this.stareTehnica = stareTehnica;
        this.inServiciu = inServiciu;
    }

    protected Avion(Parcel in) {
        Model = in.readString();
        Id = in.readString();
        Manufacturer = in.readString();
        if (in.readByte() == 0) {
            FlightHours = null;
        } else {
            FlightHours = in.readInt();
        }
        if (in.readByte() == 0) {
            Value = null;
        } else {
            Value = in.readFloat();
        }
        disponibil = in.readByte() != 0;
        tipAvion = in.readString();
        categorie = in.readString();
        stareTehnica = in.readFloat();
        inServiciu = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Model);
        dest.writeString(Id);
        dest.writeString(Manufacturer);
        if (FlightHours == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(FlightHours);
        }
        if (Value == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(Value);
        }
        dest.writeByte((byte) (disponibil ? 1 : 0));
        dest.writeString(tipAvion);
        dest.writeString(categorie);
        dest.writeFloat(stareTehnica);
        dest.writeByte((byte) (inServiciu ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Avion> CREATOR = new Creator<Avion>() {
        @Override
        public Avion createFromParcel(Parcel in) {
            return new Avion(in);
        }

        @Override
        public Avion[] newArray(int size) {
            return new Avion[size];
        }
    };

    public boolean isDisponibil() {
        return disponibil;
    }

    public void setDisponibil(boolean disponibil) {
        this.disponibil = disponibil;
    }

    public String getTipAvion() {
        return tipAvion;
    }

    public void setTipAvion(String tipAvion) {
        this.tipAvion = tipAvion;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getStareTehnica() {
        return stareTehnica;
    }

    public void setStareTehnica(float stareTehnica) {
        this.stareTehnica = stareTehnica;
    }

    public boolean isInServiciu() {
        return inServiciu;
    }

    public void setInServiciu(boolean inServiciu) {
        this.inServiciu = inServiciu;
    }
    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public Integer getFlightHours() {
        return FlightHours;
    }

    public void setFlightHours(Integer flightHours) {
        FlightHours = flightHours;
    }

    public Float getValue() {
        return Value;
    }

    public void setValue(Float value) {
        Value = value;
    }

    @Override
    public String toString() {
        return "Model: " + Model +
                "\nID: " + Id +
                "\nProducator: " + Manufacturer +
                "\nOre de zbor: " + FlightHours +
                "\nValoare: " + Value +
                "\nDisponibil: " + disponibil +
                "\nTip avion: " + tipAvion +
                "\nCategorie: " + categorie +
                "\nStare tehnica: " + stareTehnica + "/5" +
                "\nIn serviciu: " + inServiciu;
    }
}
