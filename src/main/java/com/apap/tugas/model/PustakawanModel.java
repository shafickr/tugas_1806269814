package com.apap.tugas.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pustakawan")
public class PustakawanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotNull
	@Size(min = 13, max = 13)
	@Column(name = "nip", nullable = false, unique = true)
	private String nip;

	public String getNip() {
		return this.nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
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

	@Size(max = 100)
	@Column(name = "tempat_lahir", nullable = true)
	private String tempat_lahir;

	public String getTempat_lahir() {
		return this.tempat_lahir;
	}

	public void setTempat_lahir(String tempat_lahir) {
		this.tempat_lahir = tempat_lahir;
	}

	@NotNull
	@Column(name = "tanggal_lahir", nullable = false)
	private Date tanggal_lahir;

	public Date getTanggal_lahir() {
		return this.tanggal_lahir;
	}

	public void setTanggal_lahir(Date tanggal_lahir) {
		this.tanggal_lahir = tanggal_lahir;
	}

	@NotNull
	@Column(name = "jenis_kelamin", nullable = false)
	private int jenis_kelamin;

	public int getJenis_kelamin() {
		return this.jenis_kelamin;
	}

	public void setJenis_kelamin(int jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "spesialisasi_pustakawan", joinColumns = {
			@JoinColumn(name = "pustakawan_id") }, inverseJoinColumns = { @JoinColumn(name = "spesialisasi_id") })
	private Set<SpesialisasiModel> daftarSpesialisasi = new HashSet<>();

	public Set<SpesialisasiModel> getDaftarSpesialisasi() {
		return this.daftarSpesialisasi;
	}

	public void setDaftarSpesialisasi(Set<SpesialisasiModel> daftarSpesialisasi) {
		this.daftarSpesialisasi = daftarSpesialisasi;
	}

	@OneToMany(mappedBy = "pustakawan", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<PustakawanPlacementModel> pustakawanPlacement = new HashSet<>();

	public Set<PustakawanPlacementModel> getPustakawanPlacement() {
		return this.pustakawanPlacement;
	}

	public void setPustakawanPlacement(Set<PustakawanPlacementModel> pustakawanPlacement) {
		this.pustakawanPlacement = pustakawanPlacement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PustakawanModel other = (PustakawanModel) obj;
		if (id != other.id)
			return false;
		return true;
	}
}