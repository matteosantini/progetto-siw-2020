package it.uniroma3.progetto2020.controller;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.progetto2020.model.Tag;
import it.uniroma3.progetto2020.service.TagService;

@Controller
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	@RequestMapping("/tags")
	public String getAllTags(Model model) {
		model.addAttribute("tags", this.tagService.getAllTags());
		return "tags";
	}
	
	@RequestMapping(value="/tags/add",method=RequestMethod.GET)
	public String addTag(Model model) {
		model.addAttribute("tag",new Tag());
		return "addTag";
	}
	
	@RequestMapping(value="/tags/add",method=RequestMethod.POST)
	public String processAddTag(@ModelAttribute("tag") Tag tag) {
		this.tagService.saveTag(tag);
		return "redirect:/tags";
	}
	
	@RequestMapping(value="tags/update/{id}",method=RequestMethod.GET)
	public String updateTag(Model model,@PathVariable("id") Long id) {
		model.addAttribute("updateTag",this.tagService.getTagById(id) );
		return "updateTag";
	}
	
	@RequestMapping(value="tags/update",method=RequestMethod.POST)
	public String processUpdateTag(@ModelAttribute("updateTag") Tag tag) {
		this.tagService.saveTag(tag);
		return "redirect:/tags";
	}
	
	@RequestMapping(value="tags/delete/{id}",method=RequestMethod.GET)
	public String delete(Model model,@PathVariable("id") Long id) {
		model.addAttribute("deleteTag", this.tagService.getTagById(id));
		return "deleteTag";
	}
	
	@RequestMapping(value="tags/delete",method=RequestMethod.POST)
	public String processDelete(@ModelAttribute("deleteTag") Tag tag) {
		this.tagService.deleteTag(tag);
		return "redirect:/tags";
	}
	
	

}
