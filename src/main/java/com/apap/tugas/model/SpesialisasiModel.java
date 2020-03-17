package com.apap.tugas.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "spesialisasi")
public class SpesialisasiModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@NotNull
	@Size(max = 50)
	@Column(name = "nama", nullable = false)
	private String nama;

	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@NotNull
	@Size(max = 500)
	@Column(name = "deskripsi", nullable = true)
	private String deskripsi;

	public String getDeskripsi() {
		return this.deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	@ManyToMany(mappedBy = "spesialisasiPustakawan", fetch = FetchType.LAZY)
	private List<PustakawanModel> daftarPustakawan;

	public List<PustakawanModel> getDaftarPustakawan() {
		return this.daftarPustakawan;
	}

	public void setDaftarPustakawan(List<PustakawanModel> daftarPustakawan) {
		this.daftarPustakawan = daftarPustakawan;
	}

}