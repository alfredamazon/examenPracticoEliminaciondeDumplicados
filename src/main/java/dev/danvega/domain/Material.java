package dev.danvega.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Material {
    @Id
    private Long material;
    private String iddepartamento;
    private String idsubdepartamento;
    private String idclase;
    private String idsubclase;
    // Constructor por defecto necesario para la deserialización
    public Material() {
    }

    // Getters y setters

    public Long getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = Long.valueOf(material);
    }

    public String getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(String iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getIdsubdepartamento() {
        return idsubdepartamento;
    }

    public void setIdsubdepartamento(String idsubdepartamento) {
        this.idsubdepartamento = idsubdepartamento;
    }

    public String getIdclase() {
        return idclase;
    }

    public void setIdclase(String idclase) {
        this.idclase = idclase;
    }

    public String getIdsubclase() {
        return idsubclase;
    }

    public void setIdsubclase(String idsubclase) {
        this.idsubclase = idsubclase;
    }

    // Puedes agregar otros métodos según sea necesario
}
