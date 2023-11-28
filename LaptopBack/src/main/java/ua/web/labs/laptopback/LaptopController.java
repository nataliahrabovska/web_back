package ua.web.labs.laptopback;

import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/laptops")
public class LaptopController {
    private final LaptopService laptopService;

    @GetMapping
    public ResponseEntity<List<Laptop>> getAll() {
        return ResponseEntity.ok(laptopService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getById(@PathVariable Long id) {
        return ResponseEntity.ok(laptopService.getById(id));
    }

    @GetMapping("/filter")
    public List<Laptop> getSortedBookByCost(
            @RequestParam(value = "price", required = false) Integer price,
            @RequestParam(value = "company", required = false) String company,
            @RequestParam(value = "screenSize", required = false) Integer screenSize) {
        return laptopService.getSortedLaptops(price, company, screenSize);
    }
}
