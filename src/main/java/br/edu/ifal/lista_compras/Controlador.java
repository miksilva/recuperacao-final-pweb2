package br.edu.ifal.lista_compras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador{

    @Autowired
    ListaRepo listaRepo;

    Item item = new Item();

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/cadastrar")
    public ModelAndView cadastrar(Item item) {
        
        ModelAndView model = new ModelAndView("redirect:/lista");
        listaRepo.save(item);
        return model;
    }
    
    @RequestMapping("/lista")
    public ModelAndView listar() {
        ModelAndView model = new ModelAndView("lista.html");
        model.addObject("itens", listaRepo.findAll());
        model.addObject(new Item());
        return model;  
    }

    @RequestMapping("/deletar/{id}")
    public ModelAndView DeletarItem(@PathVariable(name = "id") Long id){
        listaRepo.deleteById(id);
        return new ModelAndView("redirect:/lista");
    }
   
}