package com.internship.adb.busses.controller;

import com.internship.adb.busses.model.BusModel;
import com.internship.adb.busses.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/busses")
    @ResponseBody
    public ResponseEntity<Iterable<BusModel>> getBusses() {
        return new ResponseEntity<>(busService.getBusses(), HttpStatus.OK);
    }

    @GetMapping("/busses/{id}")
    @ResponseBody
    public ResponseEntity<BusModel> getBus(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(busService.getBus(id), HttpStatus.OK);
    }

    @GetMapping(params = "engine", value = "/busses")
    @ResponseBody
    public ResponseEntity<Iterable<BusModel>> getByEngineType(@RequestParam String engine) {
        return new ResponseEntity<>(busService.getByEngineType(engine), HttpStatus.OK);
    }

    @PostMapping("/busses")
    @ResponseBody
    public ResponseEntity<BusModel> addBus(@RequestBody BusModel busModel) {
        busService.addBus(busModel);
        return new ResponseEntity<>(busModel, HttpStatus.CREATED);
    }

    @PutMapping("/busses/{id}")
    @ResponseBody
    public ResponseEntity<BusModel> updateBus(@PathVariable(value = "id") String id,
                                              @RequestBody BusModel modifiedBusModel) {
        BusModel busModel = busService.updateBus(id, modifiedBusModel);
        return new ResponseEntity<>(busModel, HttpStatus.OK);
    }

    @DeleteMapping("/busses/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteBus(@PathVariable(value = "id") String id) {
        busService.deleteBus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}