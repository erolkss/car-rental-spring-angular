import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-search-car',
  templateUrl: './search-car.component.html',
  styleUrl: './search-car.component.scss'
})
export class SearchCarComponent {
  searchCarForm!: FormGroup;
  isSpinning: boolean = false;


  cars: any = [];

  listOfOption: Array<{label: string; value: string}> = [];
  listOfBrands = ["BMW", "AUDI", "FERRARI", "TESLA", "VOLVO", "TOYOTA", "HONDA", "FORD", "NISSAN", "HYUNDAI", "LEXUS", "KIA"]
  listOfType = ["Petrol", "Hybrid", "Diesel", "Electric", "CNG"];
  listOfColor = ["Red", "White", "Blue", "Black", "Orange", "Grey", "Silver"];
  listOfTransmission = ["Manual", "Automatic"];

  constructor(
    private fb: FormBuilder,
    private customerService: CustomerService
  ){
    this.searchCarForm = this.fb.group ({
      brand: [null],
      type: [null],
      transmission: [null],
      color: [null],
    })
  }


  searchCar(){
    this.isSpinning = true;
    this.customerService.searchCar(this.searchCarForm.value).subscribe((res) => {
      console.log(res);
      res.carDtoList.forEach(element => {
        element.processedImg = 'data:image/jpeg;base64,' + element.returnedImage;
        this.cars.push(element);
      })
      this.isSpinning = false;
    })
  }

}

