package com.pms;

import com.pms.controllers.ParkingLotController;
import com.pms.controllers.TicketController;
import com.pms.dtos.CreateParkingLotRequestDto;
import com.pms.dtos.CreateParkingLotResponseDto;
import com.pms.dtos.ResponseDto;
import com.pms.dtos.ResponseStatusDto;
import com.pms.factories.ParkingSpotAssigningStrategyFactory;
import com.pms.repositories.ParkingLotRepository;
import com.pms.repositories.TicketRepository;
import com.pms.services.ParkingLotService;
import com.pms.services.TicketService;
import com.pms.strategies.spotassignmentstrategy.ParkingSpotAssigningStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingLotManagementSystemApplication.class, args);

//        ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();
//        ParkingLotService parkingLotService = ParkingLotService.getInstance(parkingLotRepository);
//        ParkingLotController parkingLotController = ParkingLotController.getInstance(parkingLotService);
//
//
//        System.out.println(parkingLotController.createParkingLot(new CreateParkingLotRequestDto("123 Main St, Springfield")));


        ParkingSpotAssigningStrategy parkingSpotAssigningStrategy = ParkingSpotAssigningStrategyFactory.getSpotAssignmentStrategy("random");

        ObjectRegistry.registerObject("parkingLotRepository",
                ParkingLotRepository.getInstance());

        ObjectRegistry.registerObject("parkingLotService",
                ParkingLotService.getInstance(
                        (ParkingLotRepository) ObjectRegistry.getObject("parkingLotRepository")
                ));

        ObjectRegistry.registerObject("parkingLotController",
                ParkingLotController.getInstance(
                        (ParkingLotService) ObjectRegistry.getObject("parkingLotService")
                ));

        ObjectRegistry.registerObject("ticketRepository",
                TicketRepository.getInstance());

        ObjectRegistry.registerObject("parkingSpotAssigningStrategy",
                parkingSpotAssigningStrategy);
        ObjectRegistry.registerObject("ticketService",
                TicketService.getInstance(
                        (ParkingLotRepository) ObjectRegistry.getObject("parkingLotRepository"),
                        (TicketRepository) ObjectRegistry.getObject("ticketRepository"),
                        (ParkingSpotAssigningStrategy) ObjectRegistry.getObject("parkingSpotAssigningStrategy")
                ));
        ObjectRegistry.registerObject("ticketController",
                TicketController.getInstance(
                        (TicketService) ObjectRegistry.getObject("ticketService"))
        );

        ParkingLotController parkingLotController = (ParkingLotController) ObjectRegistry.getObject("parkingLotController");
        CreateParkingLotRequestDto request = new CreateParkingLotRequestDto("Delhi Airport", 5);

        ResponseDto<CreateParkingLotResponseDto> response = parkingLotController.createParkingLot(request);

        if (response.getStatus().equals(ResponseStatusDto.FAILURE)) {
            System.out.println("Something is wrong");
        } else {
            System.out.println(response.getData().getParkingLot());
        }

//        UpdateParkingLotRequestDto updateParkingLotRequest = new UpdateParkingLotRequestDto();
//        updateParkingLotRequest.setParkingLotId(1L);
//        updateParkingLotRequest.setAddress("Noida");
//
//        UpdateParkingLotResponseDto responseDto = parkingLotController.updateAddress(updateParkingLotRequest);
//
//        System.out.println(responseDto);
    }

}
