package br.com.fiap.cp4.cp4_java.controller;

import br.com.fiap.cp4.cp4_java.entity.ProdutosEntity;
import br.com.fiap.cp4.cp4_java.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("product", productRepository.findAll());
        return "list";
    }

    @GetMapping("/new")
    public String newProductsForm(Model model) {
        model.addAttribute("product", new ProdutosEntity());
        return "form";
    }

    @PostMapping
    public String saveProduct(ProdutosEntity produto) {
        productRepository.save(produto);
        return "redirect:/produtos";
    }


}
