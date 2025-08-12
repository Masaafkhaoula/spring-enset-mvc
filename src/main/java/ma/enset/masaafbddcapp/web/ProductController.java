package ma.masaaf.masaafbddcapp.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import ma.masaaf.masaafbddcapp.entities.Product;
import ma.masaaf.masaafbddcapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/user/index")
    public String index(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("productList",products);
        return "products";
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/user/index";
    }
    @PostMapping("/admin/delete")
    public String delete(@RequestParam(name="id") Long id){
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }
    @GetMapping("/admin/add")
    public String add(Model model){
        model.addAttribute("product",new Product());
        return "newProduct";
    }
    @PostMapping("/admin/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors())
            return "newProduct";
        productRepository.save(product);
        return "redirect:/user/index";
    }
    @GetMapping("/notAuthorized")
    public String notAuthorized(){
        return "notAuthorized";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "logout";
    }

    @GetMapping("/user/search")
    public String searchProducts(@RequestParam("keyword") String keyword, Model model) {
        List<Product> products = productRepository.findByNameContainsIgnoreCase(keyword);
        model.addAttribute("productList", products);
        return "products";
    }
    @PostMapping("/admin/updateProduct")
    public String updateProduct(@Valid Product product, BindingResult result){
        if(result.hasErrors()) return "editProduct";
        productRepository.save(product);
        return "redirect:/user/index";
    }
    @GetMapping("/admin/edit")
    public String editProduct(@RequestParam("id") Long id, Model model){
        Product product = productRepository.findById(id).orElseThrow();
        model.addAttribute("product", product);
        return "editProduct";
    }


}

