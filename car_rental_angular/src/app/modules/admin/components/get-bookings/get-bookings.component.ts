import { Component } from '@angular/core';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-get-bookings',
  templateUrl: './get-bookings.component.html',
  styleUrl: './get-bookings.component.scss'
})
export class GetBookingsComponent {

  bookings: any;
  isSpinning: boolean = false;

  constructor(
    private adminService: AdminService
  ){
    this.getBookings();
  }

  getBookings(){
    this.isSpinning= true;
    this.adminService.getCarBookings().subscribe((res) => {
      this.isSpinning= false;
      this.bookings = res;
    })
  }

}
