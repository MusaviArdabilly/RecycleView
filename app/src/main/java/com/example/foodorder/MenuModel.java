package com.example.foodorder;

public class MenuModel {

    private String nama, detail, harga;

    public MenuModel(String nama, String detail, String harga){
        this.nama = nama;
        this.detail = detail;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getDetail() {
        return detail;
    }

    public String getHarga() {
        return harga;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
