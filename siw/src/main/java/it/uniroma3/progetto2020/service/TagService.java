package it.uniroma3.progetto2020.service;

import it.uniroma3.progetto2020.model.Tag;

public interface TagService {
	//aa
	public Tag getTagById(Long id);
	public Tag getTagByNome(String nome);
	public void saveTag(Tag tag);
	public Iterable<Tag> getAllTags();
	public void deleteTag(Tag tag);

}
