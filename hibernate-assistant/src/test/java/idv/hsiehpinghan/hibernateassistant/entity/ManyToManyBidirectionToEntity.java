package idv.hsiehpinghan.hibernateassistant.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ManyToManyBidirectionToEntity {
	@Id
	private Integer id;

	@ManyToMany(mappedBy = "tos")
	private Collection<ManyToManyBidirectionFromEntity> froms;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<ManyToManyBidirectionFromEntity> getFroms() {
		return froms;
	}

	public void setFroms(Collection<ManyToManyBidirectionFromEntity> froms) {
		this.froms = froms;
	}

	public void addFrom(ManyToManyBidirectionFromEntity from) {
		if (this.froms == null) {
			this.froms = new ArrayList<ManyToManyBidirectionFromEntity>();
		}
		this.froms.add(from);
	}

}
