package com.example.item.api;

import com.example.item.domain.Item;
import com.example.item.dto.ItemDataMapper;
import com.example.item.dto.ItemDto;
import com.example.item.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@AllArgsConstructor
@Path("{item}")
public class ItemResourceApi {
    private final ItemService itemService;
    private final ItemDataMapper itemDataMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Item createItem(ItemDto item) {
        return itemService.createItem(itemDataMapper.toEntity(item));
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Item updateItem(@PathParam("id") Long id, ItemDto itemDto) {
        return itemService.updateItem(id, itemDataMapper.toEntity(itemDto));
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> getAllUser() {
        return itemService.getAllUsers();
    }

}
