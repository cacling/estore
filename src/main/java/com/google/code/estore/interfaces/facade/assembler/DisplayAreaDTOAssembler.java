package com.google.code.estore.interfaces.facade.assembler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.code.estore.domain.model.product.Product;
import com.google.code.estore.interfaces.facade.dto.DisplayItemDTO;

public class DisplayAreaDTOAssembler {
	
	public static DisplayItemDTO toDisplayItemDTO(Product product){
		DisplayItemDTO displayItemDTO = new DisplayItemDTO();
		displayItemDTO.setProdId(product.getId());
		displayItemDTO.setName(product.getName());
		displayItemDTO.setDescription(product.getDescription());
		displayItemDTO.setImage(product.getImage());
		//TODO handle price problem
		displayItemDTO.setSalePrice(new DecimalFormat("#").format(product.getSalePrice()));
		displayItemDTO.setDiscount(product.getDiscount());
		return displayItemDTO;
	}
	
	public static List<DisplayItemDTO> toDisplayItemDTOs(List<Product> products){
		List<DisplayItemDTO> displayItems = new ArrayList<DisplayItemDTO>();
		for (Product product : products) {
			DisplayItemDTO displayItemDTO = DisplayAreaDTOAssembler.toDisplayItemDTO(product);
			displayItems.add(displayItemDTO);
		}
		return displayItems;
	}
	
}
