package com.apap.tugas.tugas_1806269801.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tempat_pustakawan")
public class TempatPustakawanModel implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "pustakawan_id")
	private PustakawanModel pustakawan;

	public void setPustakawan(PustakawanModel pustakawan) {
		this.pustakawan = pustakawan;
    }
    
    public PustakawanModel getPustakawan() {
		return pustakawan;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "perpustakaan_id")
	private PerpustakaanModel perpustakaan;

	public void setPerpustakaan(PerpustakaanModel perpustakaan) {
		this.perpustakaan = perpustakaan;
    }
    
    public PerpustakaanModel getPerpustakaan() {
		return perpustakaan;
	}

	@NotNull
	@Size(max = 50)
	@Column(name = "hari", nullable = false)
	private String hari;

	public void setHari(String hari) {
		this.hari = hari;
    }
    
    public String getHari() {
		return this.hari;
	}
}