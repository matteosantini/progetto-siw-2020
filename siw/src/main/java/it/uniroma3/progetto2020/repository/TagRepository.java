package it.uniroma3.progetto2020.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.progetto2020.model.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	
	public Tag findByNome(String nome);

}
