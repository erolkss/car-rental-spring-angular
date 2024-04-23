import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StorageService } from '../../../../auth/services/storage/storage.service';
import { NzMessageService } from 'ng-zorro-antd/message';

@Component({
  selector: 'app-book-car',
  templateUrl: './book-car.component.html',
  styleUrl: './book-car.component.scss'
})
export class BookCarComponent {

  carId: number = this.activateRoute.snapshot.params['id'];
  car: any;
  processedImage:any;
  validateForm!: FormGroup;
  isSpinning: boolean = false;
  dateFormat: "DD-MM-YYYY";

  constructor(
    private customerService: CustomerService,
    private activateRoute: ActivatedRoute,
    private fb: FormBuilder,
    private message: NzMessageService,
    private router: Router
  ){}

  ngOnInit(){
    this.getCarById();
    this.validateForm = this.fb.group({
      toDate: [null, Validators.required],
      fromDate: [null, Validators.required],
    })
  }
  getCarById() {
    this.customerService.getCarById(this.carId).subscribe((res) => {
      console.log(res);
      this.processedImage = 'data:image/jpeg;base64,' + res.returnedImage;
      this.car = res;
    })
  }

  bookACar(data: any){
    console.log(data);
    this.isSpinning = true;
    let bookACarDto = {
      toDate: data.toDate,
      fromDate: data.fromDate,
      userId: StorageService.getUserId(),
      carId: this.carId
    }
    this.customerService.bookACar(bookACarDto).subscribe((res) => {
      console.log(res);
      this.message.success("Book request submitted successfully", { nzDuration: 5000});
      this.router.navigateByUrl("/customer/dashboard")
    }, error => {
      this.message.error("Something went wrong", {nzDuration: 5000});
    })
  }

}
