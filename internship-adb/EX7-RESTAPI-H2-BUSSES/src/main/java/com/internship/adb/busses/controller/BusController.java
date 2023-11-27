package com.internship.adb.busses.controller;

import com.internship.adb.busses.model.BusModel;
import com.internship.adb.busses.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BusController {

    private final BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping("/busses")
    public ResponseEntity<Iterable<BusModel>> getBusses(@RequestParam(required = false)
                                                        String engine) {
        if (engine == null) return new ResponseEntity<>(busService.getBusses(), HttpStatus.OK);
        return new ResponseEntity<>(busService.getByEngineType(engine), HttpStatus.OK);
    }

    @GetMapping("/busses/{id}")
    public ResponseEntity<BusModel> getBus(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(busService.getBus(id), HttpStatus.OK);
    }

    @PostMapping("/busses")
    public ResponseEntity<BusModel> addBus(@RequestBody BusModel busModel) {
        busService.addBus(busModel);
        return new ResponseEntity<>(busModel, HttpStatus.CREATED);
    }

    @PutMapping("/busses/{id}")
    public ResponseEntity<BusModel> updateBus(@PathVariable(value = "id") String id,
                                              @RequestBody BusModel modifiedBusModel) {
        BusModel busModel = busService.updateBus(id, modifiedBusModel);
        return new ResponseEntity<>(busModel, HttpStatus.OK);
    }

    @DeleteMapping("/busses/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable(value = "id") String id) {
        busService.deleteBus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}