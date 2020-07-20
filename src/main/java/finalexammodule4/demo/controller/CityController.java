package finalexammodule4.demo.controller;

import finalexammodule4.demo.model.City;
import finalexammodule4.demo.model.Country;
import finalexammodule4.demo.service.CityService;
import finalexammodule4.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.net.BindException;
import java.util.List;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/")
    public ModelAndView indexPage(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<City> cityList = (List<City>) cityService.findAll();
        modelAndView.addObject("cityList",cityList);
        return modelAndView;
     }
    @GetMapping("/create-city")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("createForm");
        List<Country> countryList = (List<Country>) countryService.findAll();
        modelAndView.addObject("city", new City());
        modelAndView.addObject("countryList",countryList);
        return modelAndView;
    }
    @PostMapping("/create-city")
    public ModelAndView createCity(@Valid @ModelAttribute City city, BindingResult bindingResult){
            ModelAndView modelAndView = new ModelAndView("createForm");
        List<Country> countryList = (List<Country>) countryService.findAll();
        modelAndView.addObject("countryList",countryList);
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        }
        else {
            cityService.save(city);
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message","Done!");

        }

        return modelAndView;
    }
    @GetMapping("/city/{id}")
    public ModelAndView showCity(@PathVariable Long id){
        City city = cityService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("showCity");
        modelAndView.addObject("city", city);
        return modelAndView;
    }
    @GetMapping("/city/edit/{id}")
    public ModelAndView editCity(@PathVariable Long id){
        City city = cityService.findById(id).get();
        List<Country> countryList = (List<Country>) countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("editForm");
        modelAndView.addObject("countryList",countryList);
        modelAndView.addObject("city", city);
        return modelAndView;
    }
    @PostMapping("/city/edit/{id}")
    public ModelAndView updateCity(@ModelAttribute City city1){
        City city = cityService.save(city1);

        List<Country> countryList = (List<Country>) countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("editForm");
        modelAndView.addObject("message","Done!");
        modelAndView.addObject("countryList",countryList);
        modelAndView.addObject("city", city);
        return modelAndView;
    }
    @GetMapping("/city/delete/{id}")
    public ModelAndView deleteCity(@PathVariable Long id){
        cityService.delete(id);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message","Removed!");
        List<City> cityList = (List<City>) cityService.findAll();
        modelAndView.addObject("cityList",cityList);
        return modelAndView;
    }

}
