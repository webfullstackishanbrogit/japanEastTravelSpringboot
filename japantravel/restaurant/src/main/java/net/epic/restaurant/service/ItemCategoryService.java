package net.epic.restaurant.service;

import net.epic.restaurant.dto.ItemCategoryDTO;

import java.util.List;

public interface ItemCategoryService {

    ItemCategoryDTO addItemCategory(ItemCategoryDTO dto);
    List<ItemCategoryDTO> getAllItemCategory() ;

}
