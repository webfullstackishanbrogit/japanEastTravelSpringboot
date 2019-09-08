package net.epic.restaurant.controller;

import net.epic.restaurant.dto.ItemCategoryDTO;
import net.epic.restaurant.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-category")
public class ItemCategoryController {
      private ItemCategoryService itemCategoryService;

    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public ItemCategoryDTO addItemCategory(@RequestBody ItemCategoryDTO dto) {
        return itemCategoryService.addItemCategory(dto);
    }

    @CrossOrigin("*")
    @GetMapping(value = "/all")
    public ResponseEntity<List<ItemCategoryDTO>> getAllItemCategory() {
        List<ItemCategoryDTO> allUsers = itemCategoryService.getAllItemCategory();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @Autowired
    public ItemCategoryController(ItemCategoryService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }
}
