package com.example.aldebaran.web.controller;

import com.example.aldebaran.persistence.entity.PizzaEntity;
import com.example.aldebaran.service.PizzaService;
import com.example.aldebaran.service.dto.updatePizzaPriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<Page<PizzaEntity>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int elements) {
        return ResponseEntity.ok(this.pizzaService.getAll(page, elements));
    }

    @GetMapping("/getAllAvailable")
    public ResponseEntity<Page<PizzaEntity>> getAllAvailable(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "8") int elements, @RequestParam(defaultValue = "price") String sortBy, @RequestParam(defaultValue = "price") String sortDirection){
        return ResponseEntity.ok(this.pizzaService.getAllAvailable(page, elements, sortBy, sortDirection));
    }

    @GetMapping("/getAvailable")
    public ResponseEntity<List<PizzaEntity>> getAvailable() {
        return ResponseEntity.ok(this.pizzaService.getByAvailableOrderByPrice());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PizzaEntity> getByName(@PathVariable String name){
        return ResponseEntity.ok(this.pizzaService.getByName(name));
    }

    @GetMapping("/ingredient/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getByIngredient(@PathVariable String ingredient){
        return ResponseEntity.ok(this.pizzaService.getByIngredient(ingredient));
    }

    @GetMapping("/notIngredient/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getByNotIngredient(@PathVariable String ingredient){
        return ResponseEntity.ok(this.pizzaService.getByNotIngredient(ingredient));
    }

    @GetMapping("/allJdbc")
    public ResponseEntity<List<PizzaEntity>> getAllJdbc() {
        return ResponseEntity.ok(this.pizzaService.getAllJdbc());
    }

    @GetMapping("/{pizzaId}")
    public ResponseEntity<PizzaEntity> getPizza(@PathVariable int pizzaId){
        return ResponseEntity.ok(this.pizzaService.get(pizzaId));
    }

    @GetMapping("/vegansCount")
    public ResponseEntity<?> getVeganCount(){
        return ResponseEntity.ok(this.pizzaService.countVeganPizzas());
    }

    @GetMapping("/lessPrice/{price}")
    public ResponseEntity<List<PizzaEntity>> getLessThanPrice(@PathVariable Double price){
        return ResponseEntity.ok(this.pizzaService.getPizzaLessThan(price));
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizza){
        if(pizza.getIdPizza() == null || !this.pizzaService.exists(pizza.getIdPizza())){
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizza){
        if(pizza.getIdPizza() != null && this.pizzaService.exists(pizza.getIdPizza())){
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/price")
    public ResponseEntity<Void> updatePrice(@RequestBody updatePizzaPriceDTO dto){
        if(this.pizzaService.exists(dto.getPizzaId())){
            this.pizzaService.updatePrice(dto);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> delete(@PathVariable int idPizza){
        if(this.pizzaService.exists(idPizza)){
            this.pizzaService.delete(idPizza);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }


}
