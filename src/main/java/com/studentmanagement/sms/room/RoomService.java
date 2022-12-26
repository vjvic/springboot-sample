package com.studentmanagement.sms.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    //Create room
    public Room createRoom(Room room){
        return roomRepository.save(room);
    }
    //Get room
    public List<Room> getRoom(){
        return roomRepository.findAll();
    }
    //Delete room
    public void deleteRoom(Long id){
        roomRepository.deleteById(id);
    }
    //update room
    public Room updateRoom(Long id, Room room){
        Room r = roomRepository.findById(id).get();
        r.setRoom(room.getRoom());

        return roomRepository.save(r);
    }
}
