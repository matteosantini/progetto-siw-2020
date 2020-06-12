package it.uniroma3.progetto2020.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.progetto2020.model.Tag;
import it.uniroma3.progetto2020.repository.TagRepository;

@Service
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagRepository tagRepository;

	@Override
	public Tag getTagById(Long id) {
		return this.tagRepository.findById(id).get();
	}

	@Override
	public Tag getTagByNome(String nome) {
		return this.tagRepository.findByNome(nome);
	}

	@Override
	@Transactional
	public void saveTag(Tag tag) {
		this.tagRepository.save(tag);

	}

	@Override
	public Iterable<Tag> getAllTags() {
		return this.tagRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteTag(Tag tag) {
		this.tagRepository.delete(tag);
	}
	
	

}
