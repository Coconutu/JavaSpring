	package guru.guess.controller;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import guru.guess.model.Numar;


@Controller
public class GuessController {
	
	public int numar_generat;
	
	@GetMapping("/genereaza")
	
	public String genereazaNumar()
	{
	Random rand=new Random();
	numar_generat=rand.nextInt(100);
	
	return "genereaza";
	}
   

	
		
	@GetMapping("/ghiceste")
	
	public String ghicesteForm(Model model)
	{
		model.addAttribute("numar",new Numar());
	
		return "ghiceste";
	}
	
   
	
	@PostMapping("/ghiceste")
	
	public String verificareNumar(@ModelAttribute Numar numar,Model model)
	{		
			String rezultat="";
		
			model.addAttribute("numar",numar);
			
			if (numar_generat==numar.getNumar_incercat())
					{
				rezultat="atighicit";
					}
			else if (numar_generat>numar.getNumar_incercat()) 
			{
				
				rezultat="preamic";
			}
			else if (numar_generat<numar.getNumar_incercat()) 
			{
				
				
				rezultat="preamare";
			}
			
			
			
			return rezultat;
	}
	
}
