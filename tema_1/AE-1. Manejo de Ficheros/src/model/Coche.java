package model;

public class Coche {
    private int id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;

    public Coche(int id, String modelo, String marca, String color, String matricula) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
    }

    public Coche() {
    }

    @Override
    public String toString() {
        return "model.Coche{" + "id=" + id + ", marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", color='" + color + '\'' + ", matricula='" + matricula + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}