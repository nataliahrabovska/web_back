package ua.web.labs.laptopback;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LaptopService {
    private Map<Long, Laptop> laptops = new HashMap<Long, Laptop>();

    {
        laptops.put(1L, new Laptop(1L, "HP", "Victus", "15-dw1015ua Silver", 850, 15));
        laptops.put(2L, new Laptop(2L, "HP", "Victus", "Inspiron 3530", 870, 12));
        laptops.put(3L, new Laptop(3L, "Dell", "Inspiron", "Air 13 256GB Space Gray", 1200, 13));
        laptops.put(4L, new Laptop(4L, "HP", "Pavilion", "TUF Gaming F15", 1000, 15));
        laptops.put(5L, new Laptop(5L, "Dell", "Latitude", "15-dw1015ua (2F3G3EA) Silver", 900, 16));
        laptops.put(6L, new Laptop(6L, "Dell", "Inspiron", "Inspiron 3530", 670, 16));
        laptops.put(7L, new Laptop(7L, "HP", "Pavilion", "Air 13 256GB Space Gray", 1100, 13));
        laptops.put(8L, new Laptop(8L, "Dell", "Latitude", "TUF Gaming F15", 1100, 12));
    }

    private static Long nextIdValue = 1L;

    public List<Laptop> getAll() {
        return new ArrayList<>(laptops.values());
    }

    public Laptop getById(Long id) {
        return laptops.get(id);
    }

    public List<Laptop> getSortedLaptops(Integer price, String company, Integer screenSize) {
        List<Laptop> arrayList = new ArrayList<>(laptops.values());

        if (price != null) {
            arrayList = arrayList.stream().filter(laptop -> Objects.equals(laptop.getPrice(), price)).collect(Collectors.toList());
        }

        if (company != null) {
            arrayList = arrayList.stream().filter(laptop -> laptop.getCompany().equals(company)).collect(Collectors.toList());
        }

        if (screenSize != null) {
            arrayList = arrayList.stream().filter(laptop -> laptop.getScreenSize().equals(screenSize)).collect(Collectors.toList());
        }
        System.out.println(arrayList);
        return arrayList;
    }
}
