package idv.hsiehpinghan.hibernateassistant.service;

import idv.hsiehpinghan.hibernateassistant.entity.TablePerClassInheritance_2_A_Entity;
import idv.hsiehpinghan.hibernateassistant.repository.TablePerClassInheritance_2_A_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TablePerClassInheritance_2_A_Service {
	@Autowired
	private TablePerClassInheritance_2_A_Repository repository;

	public void save(TablePerClassInheritance_2_A_Entity entity) {
		repository.save(entity);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public TablePerClassInheritance_2_A_Entity findOne(int id) {
		TablePerClassInheritance_2_A_Entity entity = repository.findOne(id);
		return entity;
	}
}
