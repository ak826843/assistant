package idv.hsiehpinghan.springdatajpaassistatnt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OneToManyBidirectionManyEntity_1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private OneToManyBidirectionOneEntity one;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OneToManyBidirectionOneEntity getOne() {
		return one;
	}

	public void setOne(OneToManyBidirectionOneEntity one) {
		this.one = one;
	}

}