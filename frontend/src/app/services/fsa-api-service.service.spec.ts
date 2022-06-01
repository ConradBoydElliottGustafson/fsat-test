import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';
import { CityResponse, FsaApiServiceService } from './fsa-api-service.service';


describe('FsaApiServiceService', () => {
  let httpClientSpy: jasmine.SpyObj<HttpClient>;
  let service: FsaApiServiceService;

  beforeEach(() => {
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    service = new FsaApiServiceService(httpClientSpy);
  });

  it('Should return expected cities (HttpClient called once)', (done: DoneFn) => {
    const expectedCities: CityResponse[] = [{"cityName":"Powell River"},{"cityName":"Victoria"}];
    httpClientSpy.get.and.returnValue(of(expectedCities));
  
    service.getCities().subscribe({
      next: cities => {
        expect(cities)
          .withContext('expected cities')
          .toEqual(expectedCities);
        done();
      },
      error: done.fail
    });
    expect(httpClientSpy.get.calls.count())
      .withContext('one call')
      .toBe(1);
  });
});

