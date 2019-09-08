package net.epic.events.service.impl;

import net.epic.events.dto.SpecialeventsDTO;
import net.epic.events.dto.SpecialeventsImagesDTO;
import net.epic.events.dto.SpecialeventsTagsDTO;
import net.epic.events.entity.Specialevents;
import net.epic.events.entity.SpecialeventsImages;
import net.epic.events.entity.SpecialeventsTags;
import net.epic.events.repository.SpecialeventsRepository;
import net.epic.events.service.SpecialeventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Service Implement class for the SpecialeventsService
 * @author uditha
 */
@Service
public class SpecialeventsServiceImpl implements SpecialeventsService {
    private SpecialeventsRepository specialeventsRepository;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Service method for the getAllSpecialEvents
     * @return  List of SpecialeventsDTO
     */
    @Override
    @Transactional(readOnly = true)
    public List<SpecialeventsDTO> getAllSpecialEvents() {
        List<Specialevents> all = specialeventsRepository.findAllByOrderByEventDateAsc();
        List<SpecialeventsDTO> dtoList = new ArrayList<>();
        List<SpecialeventsTagsDTO> tagsDTOList = new ArrayList<>();
        List<SpecialeventsImagesDTO> imagesDTOList = new ArrayList<>();
        SpecialeventsDTO dto ;
        SpecialeventsTagsDTO tagsDTO;
        SpecialeventsImagesDTO imagesDTO;

        for (Specialevents sp : all) {
                  dto = new SpecialeventsDTO();
                  dto.setAddress(sp.getAddress());
                  dto.setDescription(sp.getDescription());
                  dto.setIdspecialevents(sp.getIdspecialevents());
                  dto.setLatitude(sp.getLatitude());
                  dto.setLocationId(sp.getLocationId());
                  dto.setLongitude(sp.getLongitude());
                  dto.setRanking(sp.getRanking());
                  dto.setTitle(sp.getTitle());
                  dto.setEventDate(sdf.format(sp.getEventDate()));

            if (!sp.getSpecialeventsTagsCollection().isEmpty()) {

                for (SpecialeventsTags obj : sp.getSpecialeventsTagsCollection()) {
                    tagsDTO = new SpecialeventsTagsDTO();
                    tagsDTO.setSpecialeventsId(sp.getIdspecialevents());
                    tagsDTO.setIdspecialeventsTags(obj.getIdspecialeventsTags());
                    tagsDTO.setTag(obj.getTag());
                    tagsDTO.setEnable(obj.isEnable());

                    tagsDTOList.add(tagsDTO);
                }
            }
            if (!sp.getSpecialeventsImagesCollection().isEmpty()) {
                for (SpecialeventsImages obj : sp.getSpecialeventsImagesCollection()) {
                    imagesDTO = new SpecialeventsImagesDTO();
                    imagesDTO.setSpecialeventId(sp.getIdspecialevents());
                    imagesDTO.setIdspecialeventsImages(obj.getIdspecialeventsImages());
                    imagesDTO.setImagePathId(obj.getImagePathId());
                    imagesDTOList.add(imagesDTO);
                }
            }
            dto.setSpecialeventsImagesCollection(imagesDTOList);
            dto.setSpecialeventsTagsCollection(tagsDTOList);
            dtoList.add(dto);

        }

        return dtoList;
    }

    /**
     * service method for the save new special events
     * @param reviewDTO   SpecialeventsDTO
     * @return  SpecialeventsDTO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public SpecialeventsDTO addSpecialEvents(SpecialeventsDTO reviewDTO) {

         try {

             Specialevents dest = new Specialevents();
             dest.setAddress(reviewDTO.getAddress());
             dest.setDescription(reviewDTO.getDescription());
             dest.setLatitude(reviewDTO.getLatitude());
             dest.setLongitude(reviewDTO.getLongitude());
             dest.setTitle(reviewDTO.getTitle());
             dest.setRanking(reviewDTO.getRanking());
             dest.setLocationId(reviewDTO.getLocationId());
             dest.setEventDate(sdf.parse(reviewDTO.getEventDate()));

             SpecialeventsImages image;
             SpecialeventsTags tag;
             List<SpecialeventsImages> imagesList = new ArrayList<>();
             List<SpecialeventsTags> tagsList = new ArrayList<>();

             if (!reviewDTO.getSpecialeventsImagesCollection().isEmpty()) {
                 for (SpecialeventsImagesDTO dto : reviewDTO.getSpecialeventsImagesCollection()) {
                     image = new SpecialeventsImages();
                     image.setSpecialeventId(dest);
                     image.setImagePathId(dto.getImagePathId());
                     imagesList.add(image);
                 }
             }
             if (!reviewDTO.getSpecialeventsTagsCollection().isEmpty()) {
                 for (SpecialeventsTagsDTO dto : reviewDTO.getSpecialeventsTagsCollection()) {
                     tag = new SpecialeventsTags();
                     tag.setSpecialeventsId(dest);
                     tag.setEnable(dto.isEnable());
                     tag.setTag(dto.getTag());
                     tagsList.add(tag);
                 }
             }

             dest.setSpecialeventsImagesCollection(imagesList);
             dest.setSpecialeventsTagsCollection(tagsList);

             Specialevents specialevents= specialeventsRepository.save(dest);
             if (specialevents != null) {
                 return reviewDTO;
             } else {
                 return null;
             }
         }catch (Exception e){
             return null;
         }

    }

    /**
     * default constructor
     * @param specialeventsRepository autowired defendence
     */
    @Autowired
    public SpecialeventsServiceImpl(SpecialeventsRepository specialeventsRepository) {
        this.specialeventsRepository = specialeventsRepository;
    }
}
