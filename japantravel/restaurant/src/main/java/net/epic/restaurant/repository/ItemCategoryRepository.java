package net.epic.restaurant.repository;

import net.epic.restaurant.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Integer> {
}
