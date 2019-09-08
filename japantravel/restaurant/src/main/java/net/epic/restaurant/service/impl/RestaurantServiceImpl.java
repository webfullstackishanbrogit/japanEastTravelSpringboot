package net.epic.restaurant.service.impl;

import net.epic.restaurant.dto.ItemCategoryDTO;
import net.epic.restaurant.dto.RestaurantItemImagesDTO;
import net.epic.restaurant.dto.RestaurantItemsDTO;
import net.epic.restaurant.dto.RestaurantsDTO;
import net.epic.restaurant.entity.RestaurantItemImages;
import net.epic.restaurant.entity.RestaurantItems;
import net.epic.restaurant.entity.Restaurants;
import net.epic.restaurant.repository.ItemCategoryRepository;
import net.epic.restaurant.repository.RestaurantItemsRepository;
import net.epic.restaurant.repository.RestaurantsRepository;
import net.epic.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantsRepository restaurantsRepository;
    private ItemCategoryRepository itemCategoryRepository;
    private RestaurantItemsRepository restaurantItemsRepository;

    @Override
    public RestaurantsDTO addRestaurant(RestaurantsDTO dto) {

        Restaurants rest = new Restaurants();
        rest.setCountryId(dto.getCountryId());
        rest.setDescription(dto.getDescription());
        rest.setDistrictId(dto.getDistrictId());
        rest.setLatitude(dto.getLatitude());
        rest.setLongitude(dto.getLongitude());
        rest.setRanking(dto.getRanking());
        rest.setRestaurantsName(dto.getRestaurantsName());

        restaurantsRepository.save(rest);
        return dto;
    }

    @Override
    public RestaurantItemsDTO addRestaurantItem(RestaurantItemsDTO dto) {

        RestaurantItems restaurantItems = new RestaurantItems();
        restaurantItems.setDescription(dto.getDescription());
        restaurantItems.setIntroduction(dto.getIntroduction());
        restaurantItems.setItemCategoryId(itemCategoryRepository.getOne(dto.getItemCategoryId().getIditemCategory()));
        restaurantItems.setItemName(dto.getItemName());
        restaurantItems.setPrice(dto.getPrice());
        restaurantItems.setRanking(dto.getRanking());
        restaurantItems.setRestaurantId(restaurantsRepository.getOne(dto.getRestaurantId().getIdrestaurants()));

        List<RestaurantItemImages> imagesList = new ArrayList<>();
        RestaurantItemImages images;
        if (!dto.getRestaurantItemImagesCollection().isEmpty()) {
            for (RestaurantItemImagesDTO imagesDTO : dto.getRestaurantItemImagesCollection()) {
                images = new RestaurantItemImages();
                images.setImagePath(imagesDTO.getImagePath());
                images.setRestaurantItemsId(restaurantItems);
                imagesList.add(images);
            }
        }
        restaurantItems.setRestaurantItemImagesCollection(imagesList);
        restaurantItemsRepository.save(restaurantItems);

        return dto;
    }

    @Override
    public List<RestaurantItemsDTO> getAllItems() {
        List<RestaurantItems> all = restaurantItemsRepository.findAllByOrderByRankingDesc();
        List<RestaurantItemsDTO> dtoList = new ArrayList<>();
        RestaurantItemsDTO dto;
        ItemCategoryDTO categoryDTO;
        RestaurantItemImagesDTO imagesDTO;
        RestaurantsDTO restaurantsDTO;
        List<RestaurantItemImagesDTO> imagesDTOList = new ArrayList<>();
        if (!all.isEmpty()) {
            for (RestaurantItems items : all) {
                dto = new RestaurantItemsDTO();
                dto.setDescription(items.getDescription());
                dto.setIdrestaurantItems(items.getIdrestaurantItems());
                dto.setIntroduction(items.getIntroduction());
                if (items.getItemCategoryId() != null) {
                    categoryDTO = new ItemCategoryDTO();
                    categoryDTO.setItemCategoryName(items.getItemCategoryId().getItemCategoryName());
                    categoryDTO.setIsEnable(items.getItemCategoryId().getIsEnable());
                    categoryDTO.setIditemCategory(items.getItemCategoryId().getIditemCategory());
                    dto.setItemCategoryId(categoryDTO);
                }

                dto.setItemName(items.getItemName());
                dto.setPrice(items.getPrice());
                if (!items.getRestaurantItemImagesCollection().isEmpty()) {
                    for (RestaurantItemImages images : items.getRestaurantItemImagesCollection()) {
                        imagesDTO = new RestaurantItemImagesDTO();
                        imagesDTO.setIdrestaurantItemImages(images.getIdrestaurantItemImages());
                        imagesDTO.setImagePath(images.getImagePath());
                        imagesDTOList.add(imagesDTO);

                    }

                    dto.setRestaurantItemImagesCollection(imagesDTOList);
                }

                dto.setRanking(items.getRanking());
                if (items.getRestaurantId() != null) {
                    restaurantsDTO = new RestaurantsDTO();

                    restaurantsDTO.setRestaurantsName(items.getRestaurantId().getRestaurantsName());
                    restaurantsDTO.setCountryId(items.getRestaurantId().getCountryId());
                    restaurantsDTO.setDescription(items.getRestaurantId().getDescription());
                    restaurantsDTO.setDistrictId(items.getRestaurantId().getDistrictId());
                    restaurantsDTO.setIdrestaurants(items.getRestaurantId().getIdrestaurants());
                    restaurantsDTO.setLatitude(items.getRestaurantId().getLatitude());
                    restaurantsDTO.setLongitude(items.getRestaurantId().getLongitude());
                    restaurantsDTO.setRanking(items.getRestaurantId().getRanking());

                    dto.setRestaurantId(restaurantsDTO);
                }

                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    @Autowired
    public RestaurantServiceImpl(RestaurantsRepository restaurantsRepository,
                                 ItemCategoryRepository itemCategoryRepository,
                                 RestaurantItemsRepository restaurantItemsRepository) {
        this.restaurantsRepository = restaurantsRepository;
        this.itemCategoryRepository = itemCategoryRepository;
        this.restaurantItemsRepository = restaurantItemsRepository;
    }
}