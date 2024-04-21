import { Component } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { throws } from 'assert';

@Component({
  selector: 'app-update-car',
  templateUrl: './update-car.component.html',
  styleUrl: './update-car.component.scss'
})
export class UpdateCarComponent {

  isSpinning: boolean = false;
  carId: any = this.activateRoute.snapshot.params['id'];
  existingImage: string | null = null;
  updateForm!: FormGroup;

  listOfOption: Array<{label: string; value: string}> = [];
  listOfBrands = ["BMW", "AUDI", "FERRARI", "TESLA", "VOLVO", "TOYOTA", "HONDA", "FORD", "NISSAN", "HYUNDAI", "LEXUS", "KIA"]
  listOfType = ["Petrol", "Hybrid", "Diesel", "Electric", "CNG"];
  listOfColor = ["Red", "White", "Blue", "Black", "Orange", "Grey", "Silver"];
  listOfTransmission = ["Manual", "Automatic"];

  constructor(
    private adminService: AdminService,
    private activateRoute: ActivatedRoute,
    private fb: FormBuilder,
  ){}

  ngOnInit(){
    this.updateForm = this.fb.group({
      name: [null, Validators.required],
      brand: [null, Validators.required],
      type: [null, Validators.required],
      color: [null, Validators.required],
      transmission: [null, Validators.required],
      price: [null, Validators.required],
      description: [null, Validators.required],
      year: [null, Validators.required],
    })
    this.getCarById();
  }
  getCarById() {
    this.isSpinning = true;
    this.adminService.getCarById(this.carId).subscribe((res) => {
      this.isSpinning = false;
      const carDto = res;
      this.existingImage = 'data:image/jpeg;base64,' + res.returnedImage;
      this.updateForm.patchValue(carDto);

    })
  }

}
