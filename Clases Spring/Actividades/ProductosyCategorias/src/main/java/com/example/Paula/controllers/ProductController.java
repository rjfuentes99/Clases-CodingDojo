package com.example.Paula.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Paula.models.Category;
import com.example.Paula.models.CategoryProduct;
import com.example.Paula.models.Product;
import com.example.Paula.services.ProdCatServ;

@Controller
public class ProductController {
	private final ProdCatServ prodCatServ;
	
	public ProductController(ProdCatServ prodCatServ) {
		this.prodCatServ = prodCatServ;
	}
	
	@GetMapping("/products/new")
	public String newProdPage(@ModelAttribute("productObject") Product product) {
		return "ProductsAndCategories/newproduct.jsp";
	}
	
	@PostMapping("/addproduct")
	public String addProduct(@Valid @ModelAttribute("productObject") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "ProductsAndCategories/newproduct.jsp";
		}
		else {
			prodCatServ.addProd(product);
			return "redirect:/products/new";
		}
	}
	
	@GetMapping("products/{prodid}")
	public String showProduct(@PathVariable("prodid") Long prodid, @ModelAttribute("categoryProductObj") CategoryProduct categoryProduct, Model model) {
		Product product = prodCatServ.singleProd(prodid);
		model.addAttribute("product", product);
		model.addAttribute("categories", prodCatServ.availableCategoriesForProduct(product));
		return "ProductsAndCategories/showproduct.jsp";
	}
	
	@PostMapping("/attachcategory")
	public String attachCategory(@ModelAttribute("categoryProductObj") CategoryProduct categoryProduct) {
		System.out.println(categoryProduct.getCategory().getName());
		System.out.println(categoryProduct.getProduct().getName());
		prodCatServ.addCatToProduct(categoryProduct);
		return "redirect:/products/" + categoryProduct.getProduct().getId();
	}
	
	@GetMapping("categories/{catid}")
	public String showCategory(@PathVariable("catid") Long catid, @ModelAttribute("categoryProductObj") CategoryProduct categoryProduct, Model model) {
		Category category = prodCatServ.singleCat(catid);
		model.addAttribute("category", category);
		model.addAttribute("products", prodCatServ.availableProductsForCategory(category));
		return "ProductsAndCategories/showcategory.jsp";
	}
	
	@PostMapping("/attachproduct")
	public String attachProduct(@ModelAttribute("categoryProductObj") CategoryProduct categoryProduct) {
		System.out.println(categoryProduct.getCategory().getName());
		System.out.println(categoryProduct.getProduct().getName());
		prodCatServ.addProdToCategory(categoryProduct);
		return "redirect:/categories/" + categoryProduct.getCategory().getId();
	}
}