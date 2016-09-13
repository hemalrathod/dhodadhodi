package in.hrsoftwares.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.hrsoftwares.hibernate.Actor;
import in.hrsoftwares.hibernate.ActorHome;

@Controller
@RequestMapping("/Actor")
public class ActorController {

	@RequestMapping(method=RequestMethod.GET)
	public String Index(HttpSession s,ModelMap m){
//		if(s.getAttribute("LOGINSTATUS")==null){
//			return "redirect:/";
//		}
		ActorHome obj = new ActorHome();
		
		List<Actor> lstActor=obj.findAll();
		m.addAttribute("ACTORS",lstActor);
		
		return "Actor/Index";
	}
//	@RequestMapping(method=RequestMethod.GET)
//	public ModelAndView Index(HttpSession s){
////		if(s.getAttribute("LOGINSTATUS")==null){
////			return "redirect:/";
////		}
//		ActorHome obj = new ActorHome();
//		
//		List<Actor> lstActor=obj.findAll();
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("ACTORS",lstActor);
//		mv.setViewName("Actor/Index");
//		//m.addAttribute("ACTORS",lstActor);
//		
//		//return "Actor/Index";
//		return mv;
//	}
	@RequestMapping(value="Edit/{actorId}",method=RequestMethod.GET)
	public String Edit(HttpSession s,Model m,@PathVariable short actorId){
		ActorHome obj = new ActorHome();
		Actor actor=obj.findById(actorId);
		m.addAttribute("ACTOR",actor);
		
		return "Actor/Edit";
	}
	@RequestMapping(value="Update",method=RequestMethod.POST)
	public String Update(HttpSession s,@ModelAttribute("ACTOR") Actor actor){
		
		Actor obj = new Actor();
		obj.setFirstName(actor.getFirstName());
		obj.setLastName(actor.getLastName());
		obj.setActorId(actor.getActorId());
		Date dt = new Date();
		obj.setLastUpdate(dt);
		
		ActorHome actorHome=new ActorHome();
		actorHome.update(obj);
		return "redirect:/Actor/";
	}
}
