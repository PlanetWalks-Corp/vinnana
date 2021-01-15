import { TestBed } from '@angular/core/testing';

import { CityinfoService } from './cityinfo.service';

describe('CityinfoService', () => {
  let service: CityinfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CityinfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
