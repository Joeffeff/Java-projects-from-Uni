package com.example.LdEx.Controllers;


import com.example.LdEx.Model.facility.DormRoom;
import com.example.LdEx.Repository.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    @Autowired private RoomService roomService;
    @GetMapping public String listRooms(Model model){
        List<DormRoom> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "room/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("room",new DormRoom());
        return "room/add";
    }
    @PostMapping("/add")
    public String addRoom(@ModelAttribute("room") DormRoom room){
        if (room.getAvailable() == null) {
            room.setAvailable(false); // Default to false if not checked
        }
        roomService.saveRoom(room);
        return "redirect:/rooms";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model)
    {
        DormRoom room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "room/edit";
    }
    @PostMapping("/edit/{id}")
    public String
    editRoom(@PathVariable Long id, @ModelAttribute("room") DormRoom room)
    {
        if (room.getAvailable() == null) {
            room.setAvailable(false); // Default to false if not checked
        }
        roomService.saveRoom(room);
        return "redirect:/rooms";
    }
    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id)
    {
        roomService.deleteRoom(id);
        return "redirect:/rooms";
    }

    @GetMapping("/search")
    public String searchRooms(@RequestParam("roomNumber") String roomNumber, Model model) {
        List<DormRoom> rooms = roomService.searchByRoomNumber(roomNumber); // Call the service
        model.addAttribute("rooms", rooms); // Pass results to the view
        model.addAttribute("searchQuery", roomNumber); // Retain the search input in the form
        return "room/list"; // Reuse the same list.html template
    }
    @GetMapping("/showAvailable")
    public String showAvailable(Model model) {
        List<DormRoom> availableRooms = roomService.getAvailableRooms();
        model.addAttribute("rooms", availableRooms);
        return "room/list"; // Return the filtered list of available rooms
    }

    @GetMapping("/sortByArea")
    public String sortByArea(Model model) {
        List<DormRoom> rooms = roomService.findAllSortedByArea();
        model.addAttribute("rooms", rooms);
        return "room/list";
    }
}
