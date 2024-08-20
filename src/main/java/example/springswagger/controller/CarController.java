package example.springswagger.controller;

import example.springswagger.model.Car;
import example.springswagger.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<Car>> getCars() {
        return ResponseEntity.ok(carRepository.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Car> getCar(@PathVariable long id) {
        return this.carRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public ResponseEntity<Car> createCar(@RequestBody Car newCarRequest) {
        return new ResponseEntity<>(carRepository.save(newCarRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        return new ResponseEntity<>(carRepository.save(car), HttpStatus.ACCEPTED);
    }
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable long id) {
        carRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
