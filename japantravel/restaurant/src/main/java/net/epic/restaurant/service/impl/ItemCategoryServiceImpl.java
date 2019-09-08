package net.epic.restaurant.service.impl;

import net.epic.restaurant.dto.ItemCategoryDTO;
import net.epic.restaurant.entity.ItemCategory;
import net.epic.restaurant.repository.ItemCategoryRepository;
import net.epic.restaurant.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public ItemCategoryDTO addItemCategory(ItemCategoryDTO dto) {
        ItemCategory category = new ItemCategory();
        category.setIsEnable(true);
        category.setItemCategoryName(dto.getItemCategoryName());

        itemCategoryRepository.save(category);
        return dto;
    }

    @Override
    public List<ItemCategoryDTO> getAllItemCategory() {
        List<ItemCategoryDTO> dtoList = new ArrayList<>();
        ItemCategoryDTO dto;
        List<ItemCategory> all = itemCategoryRepository.findAll();
        if (!all.isEmpty()) {
            for (ItemCategory category : all) {
                dto = new ItemCategoryDTO();
                dto.setIditemCategory(category.getIditemCategory());
                dto.setIsEnable(category.getIsEnable());
                dto.setItemCategoryName(category.getItemCategoryName());
                dtoList.add(dto);
            }
        }

        return dtoList;
    }

    @Autowired
    public ItemCategoryServiceImpl(ItemCategoryRepository itemCategoryRepository) {
        this.itemCategoryRepository = itemCategoryRepository;
    }
}
