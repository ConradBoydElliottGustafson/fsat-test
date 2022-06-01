import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import { FsaApiServiceService } from 'src/app/services/fsa-api-service.service';

@Component({
  selector: 'app-example',
  templateUrl: './example.component.html',
  styleUrls: ['./example.component.scss']
})
export class ExampleComponent implements OnInit, OnDestroy {

  private ngUnsubscribe: Subject<boolean> = new Subject<boolean>();

  cities: [];

  constructor(private fsaApiService: FsaApiServiceService) { }

  ngOnInit(): void {
    this.getAllCities();
   }

  getAllCities() {
    this.fsaApiService.getCities()
      .subscribe((result => this.cities = result));
  }

  ngOnDestroy() {
    this.ngUnsubscribe.next(null);
    this.ngUnsubscribe.complete();
  }
}
