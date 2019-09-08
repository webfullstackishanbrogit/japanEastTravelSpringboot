package net.epic.destinations.service.impl;

import net.epic.destinations.dto.DestinationDTO;
import net.epic.destinations.dto.DestinationImagesDTO;
import net.epic.destinations.dto.DestinationTagsDTO;
import net.epic.destinations.entity.Destination;
import net.epic.destinations.entity.DestinationImages;
import net.epic.destinations.entity.DestinationTags;
import net.epic.destinations.repository.DestinationsRepository;
import net.epic.destinations.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * service class for the Destination service Impl
 *
 * @author uditha
 */
@Service
public class DestinationServiceImpl implements DestinationService {

    private DestinationsRepository destinationsRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DestinationDTO> getAllDestination() {

        List<DestinationDTO> dtoList = new ArrayList<>();
        List<Destination> all = destinationsRepository.findAll();
        if (!all.isEmpty()) {
            dtoList =  addToDtoList(all);
        }
        return dtoList;
    }

    @Override
    public List<DestinationDTO> getRatedDestinationsFour() {

        List<DestinationDTO> dtoList = new ArrayList<>();

        List<Destination> all = destinationsRepository.findTop4ByOrderByRankingDesc();
        if (!all.isEmpty()) {
            dtoList =  addToDtoList(all);
        }
        return dtoList;
    }


    private List<DestinationDTO> addToDtoList(List<Destination> all){
        List<DestinationDTO> dtoList = new ArrayList<>();
        List<DestinationTagsDTO> tagsDTOList ;
        List<DestinationImagesDTO> imagesDTOList;
        DestinationDTO dto;
        DestinationTagsDTO tagsDTO;
        DestinationImagesDTO imagesDTO;

        for (Destination dest : all) {
            dto = new DestinationDTO();
            dto.setAddress(dest.getAddress());
            dto.setCountryId(dest.getCountryId());
            dto.setDescription(dest.getDescription());
            dto.setDestrictId(dest.getDestrictId());
            dto.setIddestination(dest.getIddestination());
            dto.setLatitude(dest.getLatitude());
            dto.setLongitude(dest.getLongitude());
            dto.setTitle(dest.getTitle());
            dto.setRanking(dest.getRanking());

            tagsDTOList = new ArrayList<>();
            if (!dest.getDestinationTagsCollection().isEmpty()) {
                for (DestinationTags obj : dest.getDestinationTagsCollection()) {
                    tagsDTO = new DestinationTagsDTO();
                    tagsDTO.setDestinationId(dest.getIddestination());
                    tagsDTO.setIddestinationTags(obj.getIddestinationTags());
                    tagsDTO.setTag(obj.getTag());
                    tagsDTO.setIsEnable(obj.getIsEnable());
                    tagsDTOList.add(tagsDTO);
                }
            }

            imagesDTOList = new ArrayList<>();
            if (!dest.getDestinationImagesCollection().isEmpty()) {
                for (DestinationImages obj : dest.getDestinationImagesCollection()) {
                    imagesDTO = new DestinationImagesDTO();
                    imagesDTO.setDestinationId(dest.getIddestination());
                    imagesDTO.setIddestinationImages(obj.getIddestinationImages());
                    imagesDTO.setImagePathId(obj.getImagePathId());
                    imagesDTOList.add(imagesDTO);
                }
            }

            dto.setDestinationImagesCollection(imagesDTOList);
            dto.setDestinationTagsCollection(tagsDTOList);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public DestinationDTO addDestination(DestinationDTO reviewDTO) {

        Destination dest = new Destination();
        dest.setAddress(reviewDTO.getAddress());
        dest.setDescription(reviewDTO.getDescription());
        dest.setLatitude(reviewDTO.getLatitude());
        dest.setLongitude(reviewDTO.getLongitude());
        dest.setTitle(reviewDTO.getTitle());
        dest.setRanking(reviewDTO.getRanking());
        dest.setCountryId(reviewDTO.getCountryId());
        dest.setDestrictId(reviewDTO.getDestrictId());

        DestinationImages image;
        DestinationTags tag;
        List<DestinationImages> imagesList = new ArrayList<>();
        List<DestinationTags> tagsList = new ArrayList<>();

        if (!reviewDTO.getDestinationImagesCollection().isEmpty()) {
            for (DestinationImagesDTO dto : reviewDTO.getDestinationImagesCollection()) {
                image = new DestinationImages();
                image.setDestinationId(dest);
                image.setImagePathId(dto.getImagePathId());
                imagesList.add(image);
            }
        }
        if (!reviewDTO.getDestinationTagsCollection().isEmpty()) {
            for (DestinationTagsDTO dto : reviewDTO.getDestinationTagsCollection()) {
                tag = new DestinationTags();
                tag.setDestinationId(dest);
                tag.setIsEnable("YES");
                tag.setTag(dto.getTag());
                tagsList.add(tag);
            }
        }

        dest.setDestinationImagesCollection(imagesList);
        dest.setDestinationTagsCollection(tagsList);

        Destination destination = destinationsRepository.save(dest);
        if (destination != null) {
            return reviewDTO;
        } else {
            return null;
        }
    }

    @Autowired
    public DestinationServiceImpl(DestinationsRepository destinationsRepository) {
        this.destinationsRepository = destinationsRepository;
    }
}
