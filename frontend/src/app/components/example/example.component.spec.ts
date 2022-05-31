import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { FsaApiServiceService } from 'src/app/services/fsa-api-service.service';
import { ExampleComponent } from './example.component';


describe('ExampleComponent', () => {
  let component: ExampleComponent;
  let fixture: ComponentFixture<ExampleComponent>;
  const stubCities = [{"cityName": "Powell River"}];
  let getCitiesSpy;

  beforeEach(() => {

    // Service stub
    const fsaApiService = jasmine.createSpyObj('FsaApiServiceService', ['getCities']);
    getCitiesSpy = fsaApiService.getCities.and.returnValue(of(stubCities));

    TestBed.configureTestingModule({
      declarations: [ ExampleComponent ],
      providers: [ { provide: FsaApiServiceService, useValue: fsaApiService } ]
    })

  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExampleComponent);
    component = fixture.componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should get cities after component initialized', () => {
    fixture.detectChanges();  // onInit()
  
    // sync spy result shows testQuote immediately after init
    expect(getCitiesSpy.calls.any())
      .withContext('getCities called')
      .toBe(true);
  });
});
