package com.springbootapp.niceprice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootapp.niceprice.dto.ProductDTO;
import com.springbootapp.niceprice.dto.ProductDataIngestDTO;
import com.springbootapp.niceprice.dto.ShelfDTO;
import com.springbootapp.niceprice.dto.ShelfDataIngestDTO;
import com.springbootapp.niceprice.dto.UserDTO;
import com.springbootapp.niceprice.entity.Shelf;
import com.springbootapp.niceprice.entity.ShelfId;
import com.springbootapp.niceprice.mapper.ShelfMapper;
import com.springbootapp.niceprice.repo.ProductRepo;
import com.springbootapp.niceprice.repo.ShelfRepo;
import com.springbootapp.niceprice.repo.UserRepo;

import jakarta.validation.Valid;

@Service
public class ShelfService {
	
	ShelfRepo shelfRepo;

	ShelfService(ShelfRepo shelfRepo) {
		this.shelfRepo = shelfRepo;
	}

//	public ResponseEntity<ShelfDTO> fetchShelfById(String id) {
//		Optional<Shelf> shelf = shelfRepo.findByUserId(id);
//		if (shelf.isPresent()) {
//			return new ResponseEntity<ShelfDTO>(ShelfMapper.INSTANCE.mapShelftoShelfDTO(shelf.get()), HttpStatus.OK);
//		}
//		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//	}

//	public ShelfDTO createShelf(ShelfDTO shelfDTO) throws ShelfAlreadyExistsException {
//		Shelf addedShelf = ShelfMapper.INSTANCE.mapShelfDTOtoShelf(shelfDTO);
//		Shelf checkedShelf = shelfRepo.findFirstByShelfId(addedShelf.getShelfId()).orElse(null);
//		
//		if(checkedShelf != null){
//	        throw new ShelfAlreadyExistsException("Shelf already exists with the given Shelf ID.");
//	    }
//        return ShelfMapper.INSTANCE.mapShelftoShelfDTO(shelfRepo.save(addedShelf));
//	}

	public List<ShelfDTO> addBulkProductsToShelf(List<ShelfDataIngestDTO> shelfDIDTOList) {

//		List<Shelf> shelfList = shelfDTOList.stream().map(ShelfMapper.INSTANCE::mapShelfDTOtoShelf).collect(Collectors.toList());
		Map<String, List<ShelfDataIngestDTO>> map = shelfDIDTOList.stream()
				.collect(Collectors.groupingBy(item -> item.getShopperId()));
//		Map<String, List<ProductDataIngestDTO>> flatmap = map.entrySet().stream().flatMap(e->e.getValue()).collect(Collectors.asList()));
		List<ShelfDTO> shelfDTOList = new ArrayList<>();
//				
		for (Map.Entry<String, List<ShelfDataIngestDTO>> m : map.entrySet()) {
			String shopperId = m.getKey();
			List<ProductDataIngestDTO> productList = m.getValue().stream().flatMap(item -> item.getShelf().stream())
					.collect(Collectors.toList());
			for (ProductDataIngestDTO shelfItem : productList) {
				ProductDTO productDTO = ProductService.fetchProductById(shelfItem.getProductId());
				UserDTO userDTO = UserService.fetchUserById(shopperId);

				if (productDTO != null && userDTO != null) {
					ShelfDTO newShelfDTO = new ShelfDTO(new ShelfId(shelfItem.getProductId(), shopperId), productDTO,
							userDTO, shelfItem.getRelevancyScore());
					shelfDTOList.add(newShelfDTO);
				}
			}
		}

//		.map(e->ShelfDTO(userId = e.getKey(),productId = e.getValue().getProductId,relevancyScore = e.getValue().getRelevancyScore()))
//		.collect(Collectors.asList());
		System.out.println(
				shelfDTOList.stream().map(ShelfMapper.INSTANCE::mapShelfDTOtoShelf).collect(Collectors.toList()));
//		List<ShelfDTO> shelfList1 = new ArrayList<>();
		List<Shelf> shelfList = shelfDTOList.stream().map(ShelfMapper.INSTANCE::mapShelfDTOtoShelf)
				.collect(Collectors.toList());
	
		
		Shelf savedList =shelfRepo.save(shelfList.get(0));
		System.out.println(savedList);
//		shelfRepo.saveAll(shelfList).stream().map(ShelfMapper.INSTANCE::mapShelftoShelfDTO)
//		.collect(Collectors.toList())
		return new ArrayList<ShelfDTO>();
	}

}
