package com.upc.ShowTimeBD.Controller;

import com.upc.ShowTimeBD.Models.ShowTimeModel;
import com.upc.ShowTimeBD.Service.ShowTimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/TuCine/v1/showtime/")
public class ShowTimeController {

    private final ShowTimeService showTimeService;

    public ShowTimeController(ShowTimeService showTimeService) {
        this.showTimeService = showTimeService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ShowTimeModel>> findAllShowTime(){
        try {
            List<ShowTimeModel> showTime = showTimeService.getAll();
            return new ResponseEntity<>(showTime, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShowTimeModel> updateShowTime(@PathVariable("id") Long id, @RequestBody ShowTimeModel showTimeModel){
        try {
            if(id.equals(showTimeModel.getId())){
                Optional<ShowTimeModel> showTime = showTimeService.getById(id);
                if(showTime.isPresent()){
                    ShowTimeModel showTimeModelUpdate = showTimeService.save(showTimeModel);
                    return new ResponseEntity<>(showTimeModelUpdate, HttpStatus.OK);
                }
                else
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShowTimeModel> newShowTime(@RequestBody ShowTimeModel showTimeModel){
        try {
            ShowTimeModel newShowTime = showTimeService.save(showTimeModel);
            if(newShowTime != null)
                return new ResponseEntity<>(newShowTime, HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShowTimeModel> deleteShowTime(@PathVariable("id") Long id){
        try {
            Optional<ShowTimeModel> showTime = showTimeService.getById(id);
            if(showTime.isPresent()){
                showTimeService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
    @PutMapping(value = "/{id}/capacity/{capacity}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateCapacity(@PathVariable("id") Long id, @PathVariable("capacity") int capacity){
        try {
            int updateCapacity = showTimeService.updateCapacity(id,capacity);
            if(updateCapacity != 0)
                return new ResponseEntity<>(updateCapacity, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     */
}
