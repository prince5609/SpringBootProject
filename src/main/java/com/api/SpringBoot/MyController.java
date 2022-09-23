package com.api.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @GetMapping("/home")
    public String home(){
        return "Welcome To our Restaurant";
    }
    @Autowired
    private service service;
    @GetMapping("/menu")
    public List<Menu> getMenu(){
        return this.service.make_list();
    }

    @GetMapping("/menu/{sno}")
    public Menu get_menu(@PathVariable int sno){
        return this.service.get_menu(sno);
    }

    @PostMapping(path = "/addmenu", consumes = "application/json") // if we don't write this then also it will work
    public Menu add_menu(@RequestBody Menu menu){
        return this.service.add_menu(menu);
    }

    @PutMapping("/update/{sno}")
    public Menu update_Menu(@RequestBody Menu menu){
        return this.service.update_menu(menu);
    }

    @DeleteMapping("/delete/{sno}")
    public ResponseEntity<HttpStatus> delete_menu(@PathVariable int sno){
        try{
            this.service.delete_menu(sno);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
