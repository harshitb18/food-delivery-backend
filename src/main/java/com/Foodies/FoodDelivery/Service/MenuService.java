package com.Foodies.FoodDelivery.Service;

import com.Foodies.FoodDelivery.Entity.Menu;
import com.Foodies.FoodDelivery.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(int id) {
        return menuRepository.findById(id).orElse(null);
    }

    public void deleteMenu(int id) {
        menuRepository.deleteById(id);
    }
}
