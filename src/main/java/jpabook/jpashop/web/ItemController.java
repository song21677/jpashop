package jpabook.jpashop.web;

import jpabook.jpashop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

//    @RequestMapping(value = "/items", method = RequestMethod.GET)
//    public String list(Model model) {
//    }
}
