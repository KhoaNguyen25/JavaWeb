/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class Book {
    private int id;
    private String tenSach;
    private String loaiSach;
    private float giaSach;

    public Book() {
    }

    public Book(int id, String tenSach, String loaiSach, float giaSach) {
        this.id = id;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.giaSach = giaSach;
    }

    public Book(String tenSach, String loaiSach, float giaSach) {
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.giaSach = giaSach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public float getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(float giaSach) {
        this.giaSach = giaSach;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", tenSach=" + tenSach + ", loaiSach=" + loaiSach + ", giaSach=" + giaSach + '}';
    }

   
   
}
