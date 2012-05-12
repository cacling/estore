package com.google.code.estore.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.code.estore.domain.shared.RepositoryFactory;
import com.google.code.estore.interfaces.portal.DisplayProductItemDTO;
import com.google.code.estore.interfaces.portal.DisplayProductItemDTOAssembler;

@Component
public class ProductManageService {
	
	public List<DisplayProductItemDTO> get4BestSellingProducts() {
		int quantity = 4;
		return DisplayProductItemDTOAssembler.toDTOs(RepositoryFactory.getProductRepository().findTopXOrderedProducts(quantity));
	}
	
	public List<DisplayProductItemDTO> get4LatestProducts() {
		int quantity = 4;
		return DisplayProductItemDTOAssembler.toDTOs(RepositoryFactory.getProductRepository().findTopXLastCreatedProducts(quantity));
	}
	
	public List<DisplayProductItemDTO> get4BestPriceProducts() {
		int quantity = 4;
		return DisplayProductItemDTOAssembler.toDTOs(RepositoryFactory.getProductRepository().findTopXDiscountMostProducts(quantity));
	}
	
	public List<DisplayProductItemDTO> get10RecommendProducts() {
		int quantity = 10;
		return DisplayProductItemDTOAssembler.toDTOs(RepositoryFactory.getProductRepository().findTopXRecommendProducts(quantity));
	}
	
}
