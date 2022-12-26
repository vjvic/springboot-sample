package com.studentmanagement.sms.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    //Create room - POST
    @PostMapping
    public Room createRoom(@RequestBody Room room){
        return roomService.createRoom(room);
    }
    //Get rooms - GET
    @GetMapping
    public List<Room>getRooms(){
        return roomService.getRoom();
    }

    //DELETE room - DELETE
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable  Long id){
        roomService.deleteRoom(id);
    }
    //Update Room - PUT
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room room){
        return roomService.updateRoom(id,room);
    }
}
