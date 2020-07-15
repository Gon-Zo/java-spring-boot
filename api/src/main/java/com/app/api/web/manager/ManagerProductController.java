package com.app.api.web.manager;

import com.app.api.domain.product.Product;
import com.app.api.service.product.ProductService;
import com.app.api.web.dto.ChartData;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.ProductResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/manager/product")
@AllArgsConstructor
public class ManagerProductController {

    private ProductService service;

    @PostMapping("")
    public void makeProduct(@RequestBody ProductResponseDto dto) {
        service.createProduct(dto);
    }

    @PutMapping("/{seq}")
    public void updateInfo(@PathVariable long seq , @RequestBody ProductResponseDto dto){
        service.updateProduct(seq, dto);
    }

    @DeleteMapping("/{seq}")
    public void removeProd(@PathVariable long seq){
        service.removeProduct(seq);
    }

    @GetMapping("/{seq}")
    public Product showProd(@PathVariable long seq) {
        return service.getProduct(seq);
    }

    @GetMapping("")
    public Page<Product> showProds(PageableDto dto) {
        return service.getProducts(dto, Boolean.FALSE);
    }

    @GetMapping("/chart")
    public List<ChartData> showChartData() {
        return service.getChartData();
    }

}
