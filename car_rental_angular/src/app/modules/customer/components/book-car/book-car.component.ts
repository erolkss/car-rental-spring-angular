import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-car',
  templateUrl: './book-car.component.html',
  styleUrl: './book-car.component.scss'
})
export class BookCarComponent {

  carId: number = this.activateRoute.snapshot.params['id'];
  car: any;
  processedImage:any;

  constructor(
    private customerService: CustomerService,
    private activateRoute: ActivatedRoute
  ){}

  ngOnInit(){
    this.getCarById();
  }
  getCarById() {
    this.customerService.getCarById(this.carId).subscribe((res) => {
      console.log(res);
      this.processedImage = 'data:image/jpeg;base64,' + res.returnedImage;
      this.car = res;
    })
  }

}
