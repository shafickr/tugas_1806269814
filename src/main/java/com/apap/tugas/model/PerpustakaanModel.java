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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "perpustakaan")
public class PerpustakaanModel implements Serializable {
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
	@Column(name = "lokasi", nullable = true)
	private String lokasi;

	public String getLokasi() {
		return this.lokasi;
	}

	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
	}

	@OneToMany(mappedBy = "perpustakaan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
		PerpustakaanModel other = (PerpustakaanModel) obj;
		if (id != other.id)
			return false;
		return true;
	}
}