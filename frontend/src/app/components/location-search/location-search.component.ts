import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FsaApiServiceService } from 'src/app/services/fsa-api-service.service';
/**
 * This Location Search component take input search text location (city) from 
 * user and delicates to service for search.
 */
@Component({
  selector: 'app-location-search',
  templateUrl: './location-search.component.html',
  styleUrls: ['./location-search.component.scss']
})
export class LocationSearchComponent implements OnInit {

  model: any = {city: null};

  constructor(private fsaApiService: FsaApiServiceService) { }

  ngOnInit(): void {
  }

  search(searchForm: NgForm) {
    if (searchForm.invalid) {
      return;
    }
    // TODO
    // this.fsaApiService.newCityToSearch(this.model.city);
  }
}
