package example.springswagger.controller;

import example.springswagger.model.Car;
import example.springswagger.repository.CarRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
//Define uma Tag para essa controller, que será apresentada na UI do Swagger
@Tag(name = "Carros", description = "Controller de carros")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    //Descreve a funcionalidade do método em questão, junto a UI do Swagger
    @Operation(summary = "Buscar todos os carros", description = "Retorna uma lista de todos os carros cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<Car>> getCars() {
        return ResponseEntity.ok(carRepository.findAll());
    }

    @Operation(summary = "Buscar um único carro", description = "Retorna um único carro, através de seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida"),
            @ApiResponse(responseCode = "404", description = "Carro Não Encontrado")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Car> getCar(@PathVariable long id) {
        return this.carRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public ResponseEntity<Car> createCar(@RequestBody Car newCarRequest) {
        return new ResponseEntity<>(carRepository.save(newCarRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        return new ResponseEntity<>(carRepository.save(car), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable long id) {
        carRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
