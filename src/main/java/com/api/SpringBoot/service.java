package com.api.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class service {

    @Autowired
    private MenuDao menudao;

    //    List<Menu> list = new ArrayList<>();
    public service() {
//        list.add(new Menu(1, "Pizza", 250));
//        list.add(new Menu(2, "Burger", 100));
//        list.add(new Menu(3, "Coke", 50));
    }

    public List<Menu> make_list() {

        return menudao.findAll();
    }

    public Menu get_menu(int sno) {
//        Menu m = null;
//        for (Menu i : list){
//            if (i.getSno() == sno){
//                m = i;
//                break;
//            }
//        }
        return menudao.findById(sno).get();
    }

    public Menu add_menu(Menu menu) {
//        list.add(menu);
        menudao.save(menu);
        return menu;
    }

    public Menu update_menu(Menu menu) {
//        list.forEach(e->{
//            if (e.getSno() == menu.getSno()){
//                e.setName(menu.getName());
//                e.setCost(menu.getCost());
//            }
//        });
        menudao.save(menu);
        return menu;
    }

    public void delete_menu(int sno) {
//        list.remove(sno - 1);  // for arraylist
        Menu m = menudao.getReferenceById(sno);
        menudao.delete(m);
    }
}
