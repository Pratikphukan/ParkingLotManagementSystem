package com.pms;

import com.pms.controllers.ParkingLotController;
import com.pms.controllers.TicketController;
import com.pms.dtos.*;
import com.pms.models.GateType;
import com.pms.models.Operator;
import com.pms.models.parkinglot.Gate;
import com.pms.models.vehicle.Vehicle;
import com.pms.models.vehicle.VehicleType;
import com.pms.repositories.ParkingLotRepository;
import com.pms.repositories.TicketRepository;
import com.pms.services.ParkingLotService;
import com.pms.services.TicketService;
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

        ObjectRegistry.registerObject("parkingLotController",
                ParkingLotController.getInstance());

        String spotAssignmentStrategy = "random"; // or "nearest", "priority"
        ObjectRegistry.registerObject("ticketController",
                TicketController.getInstance(spotAssignmentStrategy));

        ParkingLotController parkingLotController = (ParkingLotController) ObjectRegistry.getObject("parkingLotController");

        CreateParkingLotRequestDto request = new CreateParkingLotRequestDto("Delhi Airport", 5);
        ResponseDto<CreateParkingLotResponseDto> response1 = parkingLotController.createParkingLot(request);
        System.out.println(response1);

        UpdateParkingLotRequestDto updateParkingLotRequest = new UpdateParkingLotRequestDto(1L, "Noida");
        ResponseDto<UpdateParkingLotResponseDto> response2 = parkingLotController.updateParkingLot(updateParkingLotRequest);
        System.out.println(response2);

        Gate entryGate = new Gate();
        entryGate.setGateNumber(4);
        entryGate.setGateType(GateType.ENTRY);
        entryGate.setOperator(new Operator("Pratik"));
        Vehicle vehicle = new Vehicle("DL-1C-1234", VehicleType.MEDIUM);
        GenerateTicketRequestDto generateTicketRequest = new GenerateTicketRequestDto(vehicle, entryGate, 1L);
        TicketController ticketController = (TicketController) ObjectRegistry.getObject("ticketController");
        ResponseDto<GenerateTicketResponseDto> response3 = ticketController.generateTicket(generateTicketRequest);
        System.out.println(response3);
    }

}
